public class Node {
    private Node next;
    private Camel value;

    public Node(Camel value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext(){
        return this.next;
    }
    public Camel getValue(){
        return value;
    }
}
