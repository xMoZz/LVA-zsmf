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

    //TODO: additional variables, constructors and methods must be private.

    private Node root;

    /**
     * Initializes 'this' as an empty map.
     */
    public ConstConstTreeMap() {
        //TODO: implement constructor.
        this.root = null;


    }

    /**
     * Initializes this map as a copy of the specified 'map'. This map has the same key-value
     * mappings as 'map'. If 'map' is changed later, it will not affect 'this' and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public ConstConstTreeMap(ConstConstTreeMap map) {
        //TODO: implement constructor.

        if (map == null) return;
        rekursiv_ConstConstTreeMap(map, map.root);
    }

    private void rekursiv_ConstConstTreeMap(ConstConstTreeMap map, Node current) {
        if (current == null) {
            return;
        }
        this.put(current.getDegree(), current.getValue());

        rekursiv_ConstConstTreeMap(map, current.getLeft());
        rekursiv_ConstConstTreeMap(map, current.getRight());
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
        //if (key == null || value == null) return null;

        if (root == null) {
            root = new Node(key, value);
            return null;
        }

        return rek_put(key, value, root);

    }

    private IntConst rek_put(IntConst key, IntConst value, Node current) {

        if (current == null) {
            return null;
        }

        if (key.isEqual(current.getDegree())) {
            IntConst result = current.getValue();
            current.setValue(value);
            return result;
        } else if (key.lessThan(current.getDegree())) {
            if (current.getLeft() == null) {
                current.setLeft(new Node(key, value));
                return null;
            }
            return rek_put(key, value, current.getLeft());
        } else if (current.getDegree().lessThan(key)) {
            if (current.getRight() == null) {
                current.setRight(new Node(key, value));
                return null;
            }
            return rek_put(key, value, current.getRight());
        }
        return null;
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
        if (key == null) {
            return null;
        }
        return getRekursiv(key, root);
    }

    private IntConst getRekursiv(IntConst key, Node current) {
        if (key.isEqual(current.getDegree())) {
            return current.getValue();
        }
        if (key.lessThan(current.getDegree())) {
            if (current.getLeft() == null) {
                return null;
            }
            return getRekursiv(key, current.getLeft());
        } else {
            if (current.getRight() == null) {
                return null;
            }
            return getRekursiv(key, current.getRight());
        }
    }


    /**
     * Adds all keys of this map to the specified queue in the key order of this tree
     * (the smallest key is added first to the queue).
     *
     * @param queue the queue, which is not null.
     */
    public void addAllKeysTo(IntConstQueue queue) {
        add_rek(queue, root);
    }

    private void add_rek(IntConstQueue queue, Node current) {
        if (current == null) {
            return;
        }
        add_rek(queue, current.getLeft());
        queue.add(current.getDegree());
        add_rek(queue, current.getRight());
    }

}

// TODO: define further classes, if needed (either here or in a separate file).
