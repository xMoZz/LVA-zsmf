 /**
 * A queue for 'IntConst' objects implemented as a singly linked list. The number of elements
 * of the queue is not limited. The queue may also contain entries of 'null'.
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class IntConstQueue {

    private ListNode head;
    private ListNode tail;
    private int size;

    /**
     * Initializes 'this' as an empty list.
     */
    public IntConstQueue() {}

    /**
     * Initializes this queue as an independent copy of 'queue'. Later changes of 'this'
     * will not affect 'queue' and vice versa.
     *
     * @param queue the queue from which the elements are copied to 'this', queue != null.
     */
    public IntConstQueue(IntConstQueue queue) {

        ListNode current = queue.head;
        while(current != null) {
            this.add(current.getElem());
            current = current.getNext();
        }
    }

    /**
     * Adds the specified element 'c' to this queue.
     * @param c the variable that is added ('c' can also be 'null').
     */
    public void add(IntConst c) {

        if (head == null) {
            head = tail = new ListNode(c, null);
        } else {
            tail.setNext(new ListNode(c, null));
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Retrieves and removes an element from this queue. Returns 'null' if the list is empty.
     * @return the next element in this queue, or 'null' if the queue is empty.
     */
    public IntConst poll() {

        if (head == null) {
            return null;
        }
        IntConst toReturn = head.getElem();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return toReturn;
    }

    /**
     * Returns the number of entries in this queue (including 'null' entries).
     * @return the number of entries in this queue (including 'null' entries).
     */
    public int size() {

        return size;
    }

    /**
     * Returns a string representation of this queue, with all elements ordered from
     * the element added first to the one added latest.
     * @return a string representation of this queue.
     */
    public String toString() {

        String result = "[";
        ListNode current = head;
        while (current != null) {
            result += current + (current.getNext() != null ? "," : "");
            current = current.getNext();
        }
        return result + "]";
    }
}

 /**
  * The list node class.
  */
 class ListNode {
    private IntConst elem;
    private ListNode next;

    public ListNode(IntConst b, ListNode next) {
        this.elem = b;
        this.next = next;
    }

    @Override
    public String toString() {
        return elem.toString();
    }

    public IntConst getElem() {
        return elem;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode node) {
        next = node;
    }
}

