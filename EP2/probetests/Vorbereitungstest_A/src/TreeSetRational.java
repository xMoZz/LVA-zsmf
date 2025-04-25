import java.beans.PropertyEditorManager;

/**
 * A set of rational numbers implemented as a binary search tree. There are no
 * duplicate entries in this set (no two elements e1 and e2 for which e1.compareTo(e2) == 0). The
 * elements are sorted according to their value (the ordering is given by the method 'compareTo'
 * of class 'Rational').
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree,
//   if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class TreeSetRational {
    Node root;

    /**
     * Initialises 'this' as an empty set.
     */
    public TreeSetRational() {
        this.root = null;
    }

    /**
     * Adds the specified rational number to the set.
     * Returns 'true' if the set did not already contain the specified element
     * and 'false' otherwise.
     *
     * @param r the rational number to add to this set, r != null.
     */
    public boolean add(Rational r) {

        if (root == null) {
            root = new Node(r);
            return true;
        }
        return add_rek(r, root);
    }

    private boolean add_rek(Rational r, Node current) {
        if (current == null) return false;

        if (current.getValue().compareTo(r) == 0) {
            return false;
        }
        if (r.compareTo(current.getValue()) == -1) {
            if (current.getLeft() == null) {
                current.setLeft(new Node(r));
                return true;
            }
            return add_rek(r, current.getLeft());
        }
        if (r.compareTo(current.getValue()) == 1) {
            if (current.getRight() == null) {
                current.setRight(new Node(r));
                return true;
            }
            return add_rek(r, current.getRight());
        }
        return false;
    }


    /**
     * Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
     * 'this' and 'other' are not changed by this method.
     *
     * @param other the second operand != null.
     */
    public TreeSetRational union(TreeSetRational other) {
        // TODO: implement method.
        TreeSetRational result = new TreeSetRational();

        union_rek(result, this.root);
        union_rek(result, other.root);

        return result;
    }

    private void union_rek(TreeSetRational desti, Node current) {

        desti.add(current.getValue());

        if (current.getLeft() != null)
            union_rek(desti, current.getLeft());
        if (current.getRight() != null)
            union_rek(desti, current.getRight());

    }


    /**
     * Returns the number of rational numbers in the set that are within the range defined by
     * the lowest and highest rational number (inclusive). The method exploits the structure of
     * the binary search tree and traverses only relevant parts of the tree.
     *
     * @param highest the upper bound of the range.
     * @param lowest  the lower bound of the range.
     *                The following preconditions hold for 'highest' and 'lowest':
     *                lowest != null && highest != null && lowest.compareTo(highest) <= 0.
     * @return number of rational numbers in the set that are within the specified range.
     */
    public int countWithinRange(Rational lowest, Rational highest) {
        // TODO: implement method.

        int[] sum = new int[]{0};

        count_rek(lowest, highest, root, sum);
        int result = count_rek2(lowest, highest, root);

        return result;
    }

    // ich weiß nicht ob man das so machen dürfte, deshalb noch eien alternative Version drunter.
    private void count_rek(Rational lowest, Rational highest, Node current, int[] sum) {
        if (current == null) return;

        if (lowest.compareTo(current.getValue()) <= 0 && highest.compareTo(current.getValue()) >= 0)
            sum[0]++;

        count_rek(lowest, highest, current.getLeft(), sum);
        count_rek(lowest, highest, current.getRight(), sum);
    }

    private int count_rek2(Rational lowest, Rational highest, Node current) {
        if (current == null) return 0;

        int count = 0;

        if (lowest.compareTo(current.getValue()) <= 0 && highest.compareTo(current.getValue()) >= 0)
            count++;

        count += count_rek2(lowest, highest, current.getLeft());
        count += count_rek2(lowest, highest, current.getRight());
        return count;
    }


    /**
     * Removes the lowest rational number from this set. Returns the rational number that was
     * removed from this set or 'null' if this set is empty.
     * (The corresponding node is removed by replacing it with the subtree of the node that
     * contains entries greater than the minimum.)
     *
     * @return the lowest rational number from this set or 'null' if this set is empty.
     */
    public Rational removeMinimum() {
        // TODO: implement method.

        if (this.root == null) return null;

        if (root.getLeft() == null) {
            Node result = root;
            root = root.getRight();
            return result.getValue();
        }

        Node current = root;
        Node parent = null;
        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }
        Node result = current;
        parent.setLeft(current.getRight());
        return result.getValue();
    }


    /**
     * Returns a string representation of 'this' with all rational objects
     * ordered ascending. The format of the string uses
     * brackets and is as in the following example with a set of four elements:
     * "[-3/4, -2/3, -1/3, 1/2]"
     * Returns "[]" if this set is empty.
     *
     * @return the string representation of 'this'.
     */
    public String toString() {
        // TODO: implement method.
        String string = "[";

        if (this.root == null) {
            string += "]";
        } else {
            string += stringAdd(root);
            string = string.substring(0, string.length() - 2) + "]";
        }

        return string;
    }

    private String stringAdd(Node current) {
        String result = "";

        if (current == null) return result;

        result += stringAdd(current.getLeft());
        result += current.getValue().toString() + ", ";
        result += stringAdd(current.getRight());

        return result;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
