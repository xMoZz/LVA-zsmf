public class CamelNode {
    private CamelNode next;
    private Camel camel;


    public CamelNode(Camel camel) {
        this.camel = camel;
        this.next = null;
    }

    public void setNext(CamelNode camelNodeThatShouldBeSet) {
        this.next = camelNodeThatShouldBeSet;
    }

    public CamelNode getNext() {
        return next;
    }

    public Camel getCamel() {
        return camel;
    }

    public void setCamel(Camel camel_which_should_be_set) {
        this.camel = camel_which_should_be_set;
    }

    public String toString() {
        return camel.toString();
    }
}
