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
    // TODO: define missing parts of the class.
    private RatNode root;


    /**
     * Initialises 'this' as an empty set.
     */
    public TreeSetRational() {
        // TODO: implement constructor.


    }

    /**
     * Adds the specified rational number to the set.
     * Returns 'true' if the set did not already contain the specified element
     * and 'false' otherwise.
     *
     * @param r the rational number to add to this set, r != null.
     */
    public boolean add(Rational r) {
        // TODO: implement method.

        if (root == null) {
            root = new RatNode(r);
            return true;
        }

        RatNode current = root;
        while (r.compareTo(current.getValue()) != 0) {
            if (r.compareTo(current.getValue()) == 0) {
                return false;
            } else if (r.compareTo(current.getValue()) == 1) {
                if (current.getRight() == null) {
                    current.setRight(new RatNode(r));
                    return true;
                }
                current = current.getRight();
            } else if (r.compareTo(current.getValue()) == -1) {
                if (current.getLeft() == null) {
                    current.setLeft(new RatNode(r));
                    return true;
                }
                current = current.getLeft();
            }
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
        TreeSetRational result = new TreeSetRational();

        // Add all elements from 'this' tree to the result
        addAllToTree(this.root, result);

        // Add all elements from 'other' tree to the result
        addAllToTree(other.root, result);

        return result;
    }

    /**
     * Helper method to add all elements from a subtree to a TreeSetRational.
     *
     * @param node the root of the subtree.
     * @param tree the TreeSetRational to which elements are added.
     */
    private void addAllToTree(RatNode node, TreeSetRational tree) {
        if (node == null) {
            return;
        }
        tree.add(node.getValue());
        addAllToTree(node.getLeft(), tree);
        addAllToTree(node.getRight(), tree);
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
        return addAllToTreeforSum(root, lowest, highest);
    }

    private int addAllToTreeforSum(RatNode node, Rational lowest, Rational highest) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.getValue().compareTo(lowest) >= 0 && node.getValue().compareTo(highest) <= 0) {
            count = 1;
        }

        count += addAllToTreeforSum(node.getLeft(), lowest, highest);
        count += addAllToTreeforSum(node.getRight(), lowest, highest);

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
            RatNode result = root;
            root = root.getRight();
            return result.getValue();
        }

        RatNode current = root;

        RatNode parent = root;

        while (current.getLeft() != null) {
            parent = current;
            current = current.getLeft();
        }

        Rational result = current.getValue();
        parent.setLeft(current.getRight());

        return result;
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

        StringBuilder sb = new StringBuilder("[");

        // Wenn der Baum nicht leer ist, starten wir mit der Traversierung
        if (root != null) {
            inOrderTraversal(root, sb);

            // Entferne das letzte Komma, das nach dem letzten Wert bleibt
            if (sb.length() > 1) {
                sb.delete(sb.length() - 2, sb.length());
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // In-Order Traversal des Baumes
    private void inOrderTraversal(RatNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        // Traversiere zuerst den linken Teilbaum
        inOrderTraversal(node.getLeft(), sb);

        // Füge den aktuellen Wert hinzu
        sb.append(node.getValue().toString());
        sb.append(", ");  // Trenne mit einem Komma

        // Traversiere dann den rechten Teilbaum
        inOrderTraversal(node.getRight(), sb);
    }


}

// TODO: define further classes, if needed (either here or in a separate file).
