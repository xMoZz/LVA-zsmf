import java.nio.file.NotDirectoryException;

/**
 * A caravan of camels implemented as a singly linked list with entries of 'Camel'.
 * There are no 'null' entries in the list.
 */
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class Caravan {

    //TODO: declare variables.
    private int length;
    private Node head;
    private Node tail;


    /**
     * Initializes this caravan as an empty list.
     */
    public Caravan() {
        //TODO: define constructor.

        this.length = 0;
        this.head = null;
        this.tail = null;

    }

    /**
     * Adds 'camel' as the last camel to the end of this caravan.
     *
     * @param camel the camel to be added to the end of this caravan, camel != null.
     */
    public void addLast(Camel camel) {
        if (camel == null) return;

        if (length == 0) {
            head = new Node(camel);
            tail = head;

        } else {
            tail.setNext(new Node(camel));
            tail = tail.getNext();
        }
        length++;
    }

    /**
     * Inserts a new camel into this caravan. Seen from the head of the caravan, the camel is
     * inserted just before the first camel in the caravan that has the same strength as the
     * specified 'searchStrength'. If no such camel is found, the new camel is added as the head
     * of the caravan.
     *
     * @param searchStrength the strength of the camel to be found in the caravan.
     * @param camel          the camel to be inserted into the caravan, camel != null.
     */
    public void insertBefore(int searchStrength, Camel camel) {
        Node current = head;

        while (current != tail) {
            if (current.getNext().getValue().getStrength() == searchStrength) {
                Node temp = current.getNext();
                Node newNode = new Node(camel);
                newNode.setNext(temp);
                current.setNext(newNode);
                length++;
                return;
            } else {
                current = current.getNext();
            }
        }
        Node result = new Node(camel);
        result.setNext(head);
        head = result;
        length++;
    }

    /**
     * Removes 'number' camels from the front of the caravan (the first 'number'
     * camels seen from the head of the caravan) and returns them as a new caravan in which they
     * have the same order as they had in 'this' (see examples in 'ApplicationTest1.java'). If this
     * caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
     * Precondition:
     *
     * @param number the number of camels to be removed from the front of this caravan,
     *               number >= 0 && number <= this.size().
     * @return the detached caravan.
     */
    public Caravan detachFront(int number) {

        Node current = head;
        Caravan result = new Caravan();

        for (int i = 0; i < number; i++) {
            result.addLast(current.getValue());
            current = current.getNext();
        }
        head = current;
        length -= number;
        return result;
    }

    /**
     * Returns the number of camels in the caravan.
     *
     * @return the number of camels in the caravan.
     */
    public int size() {
        return length;
    }

    /**
     * Returns a string representation of this caravan with all its camels in brackets
     * in corresponding order with head of the caravan on the left,
     * followed by the pace of the caravan, which corresponds to the pace of
     * the slowest camel in the caravan.
     * Example: [(10-2=8), (5-2=3), (7-3=4), (10-3=7)] pace = 3
     * Returns "[]" if the caravan is empty.
     *
     * @return the string representation of this caravan.
     */
    public String toString() {
        if (length == 0) {
            return "[]";
        }

        String result = "[";
        Node current = head;
        int maxpace = head.getValue().getMaxPace();


        while (current != tail) {
            result += current.getValue().toString() + ", ";
            if (maxpace > current.getValue().getMaxPace()) {
                maxpace = current.getValue().getMaxPace();
            }
            current = current.getNext();
        }

        result += current.getValue().toString();
        if (maxpace > current.getValue().getMaxPace()) {
            maxpace = current.getValue().getMaxPace();
        }
        result += "] pace = " + maxpace;
        return result;
    }

}

// TODO: define further classes, if needed (either here or in a separate file).
