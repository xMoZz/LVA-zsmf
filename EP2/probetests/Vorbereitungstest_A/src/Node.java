public class Node {
    private Rational value;
    private Node left;
    private Node right;

    public Node(Rational value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Rational getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(Rational value) {
        this.value = value;
    }
}

