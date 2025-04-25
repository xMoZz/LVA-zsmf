public class Node {
    private IntConst degree;
    private IntConst value;
    private Node left;
    private Node right;

    public Node(IntConst degree, IntConst value) {
        this.degree = degree;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getLeft() {
        return this.left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node getRight() {
        return this.right;
    }

    public IntConst getValue() {
        return value;
    }
    public void setValue(IntConst value) {
        this.value = value;
    }
    public IntConst getDegree() {
        return degree;
    }

}
