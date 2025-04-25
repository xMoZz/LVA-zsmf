/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class ApplicationTest1 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        System.out.println("Test 'ConstConstTreeMap' ...");
        System.out.println("Test 'put' and 'get' method:");
        ConstConstTreeMap map = new ConstConstTreeMap();
        testIdentical(map.put(new IntConst(7), new IntConst(1)), null);
        testIdentical(map.put(new IntConst(2), new IntConst(5)), null);
        map.put(new IntConst(12), new IntConst(-3));
        testEquals(map.put(new IntConst(7), new IntConst(3)), new IntConst(1));
        testEquals(map.get(new IntConst(2)),new IntConst(5));
        testIdentical(map.get(new IntConst(-10)), null);

        System.out.println("Test 'copy constructor' method:");
        ConstConstTreeMap anotherMap = new ConstConstTreeMap(map);
        map.put(new IntConst(-2), new IntConst(-20));
        anotherMap.put(new IntConst(11), new IntConst(110));
        testEquals(map.get(new IntConst(11)), null);
        testEquals(anotherMap.get(new IntConst(-2)), null);
        testEquals(map.get(new IntConst(-2)), new IntConst(-20));
        testEquals(anotherMap.get(new IntConst(11)), new IntConst(110));

        System.out.println("Test 'addAllKeysTo' method:");
        map = new ConstConstTreeMap();
        anotherMap = new ConstConstTreeMap();
        IntConstQueue queue = new IntConstQueue();
        map.put(new IntConst(2), new IntConst(5));
        map.put(new IntConst(12), new IntConst(-3));
        map.put(new IntConst(7), new IntConst(3));
        anotherMap.put(new IntConst(2), new IntConst(2));
        anotherMap.put(new IntConst(5), new IntConst(-3));
        anotherMap.put(new IntConst(7), new IntConst(-3));
        map.addAllKeysTo(queue);
        testEquals(queue.toString().replaceAll("\\s", ""), "[2,7,12]");
        anotherMap.addAllKeysTo(queue);
        testEquals(queue.toString().replaceAll("\\s", ""), "[2,7,12,2,5,7]");

        System.out.println("Test 'Polynomial':");
        map = new ConstConstTreeMap();
        map.put(new IntConst(2), new IntConst(5));
        map.put(new IntConst(12), new IntConst(-3));
        map.put(new IntConst(7), new IntConst(3));
        Polynomial p = new Polynomial(map);
        testEquals(p.toString().replaceAll("\\s", "")
                .replaceFirst("^\\+", ""), "5x^2+3x^7+-3x^12");
        map = new ConstConstTreeMap();
        map.put(new IntConst(2), new IntConst(-5));
        p = p.plus(new Polynomial(map));
        testEquals(p.toString().replaceAll("\\s", "")
                .replaceFirst("^\\+", ""), "3x^7+-3x^12");

    }

    /**
     * Checks two objects for identity and prints "OK" only if given == expected.
     * @param given the given object.
     * @param expected the expected object.
     */
    public static void testIdentical(Object given, Object expected) {
        if (given == expected) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Compares two objects for equality using the 'equals' method.
     * Prints "OK" if and only if
     * (given == null ? expected == null : given.equals(expected) == 0)
     * @param given the given rational number.
     * @param expected the rational number to compare 'given' to.
     */
    public static void testEquals(Object given, Object expected) {
        if (given == null ? expected == null : given.equals(expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    /**
     * Compares two 'IntConst' objects for equality using the 'isEqual' method.
     * Prints "OK" if and only if
     * (given == null ? expected == null : given.isEqual(expected) == 0)
     * @param given the given number.
     * @param expected the number to compare 'given' to.
     */
    public static void testEquals(IntConst given, IntConst expected) {
        if (given == null ? expected == null : expected != null && given.isEqual(expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }
}