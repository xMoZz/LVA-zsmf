/**
 * This data structure maps keys ('IntConst' objects) to values ('IntConst' objects).
 * It is implemented as a binary search tree where keys are ordered according to the order
 * relation of the 'IntConst' class defined by its 'lessThan' and 'isEqual' method.
 * For the keys k1 and k2 of any two mappings in this map the following condition holds:
 * k1.isEqual(k2) == false.
 * There is no limit on the number of key-value mappings stored in the map.
 */
//
// TODO: Complete the methods in 'ConstConstTreeMap'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'ConstConstTreeMap' or any other class.
//
public class ConstConstTreeMap {
    private PolyNode root = null;

    //TODO: additional variables, constructors and methods must be private.

    /**
     * Initializes 'this' as an empty map.
     */
    public ConstConstTreeMap() {

        //TODO: implement constructor.
    }

    /**
     * Initializes this map as a copy of the specified 'map'. This map has the same key-value
     * mappings as 'map'. If 'map' is changed later, it will not affect 'this' and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public ConstConstTreeMap(ConstConstTreeMap map) {
        //TODO: implement constructor.
        this.root = ConstConstTreeMap_rekursiv(map.root);
    }

    private PolyNode ConstConstTreeMap_rekursiv(PolyNode current_root) {
        if (current_root != null) {
            PolyNode right_copy = ConstConstTreeMap_rekursiv(current_root.getRight());
            PolyNode left_copy = ConstConstTreeMap_rekursiv(current_root.getLeft());

            PolyNode result = new PolyNode();
            result.setLeft(left_copy);
            result.setRight(right_copy);
            result.setKey(current_root.getKey());
            result.setValue(current_root.getValue());

            return result;
        } else return null;
    }


    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     *
     * @param key   a variable != null.
     * @param value the constant to be associated with the key (can also be 'null').
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public IntConst put(IntConst key, IntConst value) {
        //TODO: implement method.
        if (key == null) return null;


        if (root == null) {
            root = new PolyNode();
            root.setKey(key);
            root.setValue(value);
            return null;
        }

        return IntConst_rekursiv(key, value, root);
    }

    private IntConst IntConst_rekursiv(IntConst key, IntConst value, PolyNode current) {
        //System.out.println("Current: "+ current.getKey() + " Key: " + key + "\n\n");


        if (current == null) return null;

        if (current.getKey().isEqual(key)) {
            IntConst oldValue = current.getValue();
            current.setValue(value);
            return oldValue;
        }
        else if (key.lessThan(current.getKey())) {
            if (current.getLeft() == null) {
                PolyNode result = new PolyNode();
                result.setKey(key);
                result.setValue(null);
                current.setLeft(result);
            }
            return IntConst_rekursiv(key, value, current.getLeft());
        } else if (current.getKey().lessThan(key)){
            if (current.getRight() == null) {
                PolyNode result = new PolyNode();
                result.setKey(key);
                result.setValue(null);
                current.setRight(result);
            }
            return IntConst_rekursiv(key, value, current.getRight());
        }
        else return null;
    }


    /**
     * Returns the value associated with the specified key. Returns 'null' if the key is not
     * contained in this map.
     *
     * @param key a constant != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public IntConst get(IntConst key) {
        if (key == null) return null;
        return get_rekursiv(key, root);
    }

    private IntConst get_rekursiv(IntConst key, PolyNode current) {
        if (current == null) {
            return null;
        } else if (key.isEqual(current.getKey())) {
            return current.getValue();
        } else if (key.lessThan(current.getKey())) {
            return get_rekursiv(key, current.getLeft());
        } else {
            return get_rekursiv(key, current.getRight());
        }
    }


    /**
     * Adds all keys of this map to the specified queue in the key order of this tree
     * (the smallest key is added first to the queue).
     *
     * @param queue the queue, which is not null.
     */
    public void addAllKeysTo(IntConstQueue queue) {
        //TODO: implement method.
        add_rekursiv(queue, root);
    }

    private void add_rekursiv(IntConstQueue queue, PolyNode current) {
        if (current == null || queue == null)
            return;

        else {
            add_rekursiv(queue, current.getLeft());
            queue.add(current.getKey());
            add_rekursiv(queue, current.getRight());
        }
    }

}

// TODO: define further classes, if needed (either here or in a separate file).
