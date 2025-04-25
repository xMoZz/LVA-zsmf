public class RatNode {
    private RatNode left;
    private RatNode right;
    private Rational value;

    public RatNode(Rational value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public RatNode getLeft() {
        return left;
    }

    public RatNode getRight() {
        return right;
    }

    public void setLeft(RatNode input) {
        left = input;
    }

    public void setRight(RatNode input) {
        right = input;
    }

    public void setValue(Rational input){
        value = input;
    }

    public Rational getValue() {
        return value;
    }

}
