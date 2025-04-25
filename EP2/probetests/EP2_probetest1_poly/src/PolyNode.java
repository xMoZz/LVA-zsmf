public class PolyNode {
    private IntConst value = null;
    private IntConst key = null;
    private PolyNode left = null;
    private PolyNode right = null;


    PolyNode() {

    }

    public void setValue(IntConst input) {
        this.value = input;
    }

    public IntConst getValue() {
        return value;
    }

    public void setKey(IntConst input) {
        this.key = input;
    }

    public IntConst getKey() {
        return key;
    }

    public void setLeft(PolyNode input) {
        this.left = input;
    }

    public PolyNode getLeft() {
        return this.left;
    }

    public void setRight(PolyNode input) {
        this.right = input;
    }

    public PolyNode getRight() {
        return this.right;
    }

}
