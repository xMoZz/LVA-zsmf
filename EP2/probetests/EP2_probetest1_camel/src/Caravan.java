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
    private int camel_num = 0;
    private CamelNode camelNode = null;
    private CamelNode head = null;
    private CamelNode tail = null;

    /**
     * Initializes this caravan as an empty list.
     */
    public Caravan() {
        //TODO: define constructor.
        this.camel_num = 0;
    }

    /**
     * Adds 'camel' as the last camel to the end of this caravan.
     *
     * @param camel the camel to be added to the end of this caravan, camel != null.
     */
    public void addLast(Camel camel) {
        // TODO: implement method.
        if (camel == null) return;

        CamelNode newNode = new CamelNode(camel);

        if (camel_num == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        camel_num++;
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
        // TODO: implement method.
        if (camel == null) {
            return;
        }

        CamelNode newNode = new CamelNode(camel);
        int strenght_found = -1;

        int indx = 0;
        CamelNode currentNode = head;

        while (currentNode != null && strenght_found == -1) {
            if (currentNode.getCamel().getStrength() == searchStrength) {
                strenght_found = indx;
            }
            currentNode = currentNode.getNext();
            indx++;
        }

        if (strenght_found != -1) {
            currentNode = head;
            for (int i = 0; i < strenght_found - 1; i++) {
                currentNode = currentNode.getNext();
            }
            CamelNode tempNode = currentNode.getNext();
            currentNode.setNext(newNode);
            newNode.setNext(tempNode);

        } else {
            if (camel_num == 0) {
                head = newNode;
                tail = head;
            } else {
                CamelNode temp = head;
                head = newNode;
                head.setNext(temp);
            }
        }
        camel_num++;
    }

    /**
     * Removes 'number' camels from the front of the caravan (the first 'number'
     * camels seen from the head of the caravan) and returns them as a new caravan in which they
     * have the same order as they had in 'this' (see examples in 'ApplicationTest1.java'). If this
     * caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
     * Precondition:
     *               number >= 0 && number <= this.size().
     *
     * @param number the number of camels to be removed from the front of this caravan,
     * @return the detached caravan.
     */
    public Caravan detachFront(int number) {
        // TODO: implement method.
        if (number < 0 || number > camel_num) {
            return null;
        }

        Caravan result = new Caravan();

        CamelNode current = head;

        for (int i = 0; i < number; i++) {
            result.addLast(current.getCamel());
            current = current.getNext();
        }

        head = current;

        camel_num -= number;
        return result;

    }

    /**
     * Returns the number of camels in the caravan.
     *
     * @return the number of camels in the caravan.
     */
    public int size() {
        //TODO: implement method.
        return camel_num;
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
        // TODO: implement method.
        if (camel_num == 0) {
            return "[]";
        }

        String result = "[";

        CamelNode current = head;

        for (int i = 0; i < camel_num -1; i++) {
            result += current.toString();
            result = result + ", ";
            current = current.getNext();
        }
        result += current.toString();
        result += "] pace = ";

        int pace = getPace();

        result += pace;
        return result;
    }


    // TODO: define further classes, if needed (either here or in a separate file).
    public int  getPace() {
        if (camel_num == 0) {
            return 0;
        }
        CamelNode current = head;
        int maxpace = head.getCamel().getMaxPace();
        for (int i = 0; i < camel_num; i++) {
            if (maxpace > current.getCamel().getMaxPace()) {
                maxpace = current.getCamel().getMaxPace();
            }
            current = current.getNext();
        }
        return maxpace;
    }
}
