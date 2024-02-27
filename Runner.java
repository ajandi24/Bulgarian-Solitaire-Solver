import java.util.*;

class Runner {

    static BulgarianSolitaire bulgarianSolitaire;
    static int attempts;
    
    public static void main(String[] args) {
        // Initializes the mode of game
        bulgarianSolitaire = new StandardBulgarianSolitaire();
        attempts = 100000;

        printPatterns(100);
        //printInDetail();
    }

    /***
     * Prints many lines to gauge if patterns emerge.
     */
    private static void printPatterns(int maxSize) {
        ArrayList<Integer> initialCondition = new ArrayList<>();

        for (int i = 1; i <= maxSize; i++) {
            initialCondition = new ArrayList<>();
            initialCondition.add(i);
            printSimply(initialCondition, i);
        }
    }

    /***
     * Prints one line for each initial condition.
     */
    private static void printSimply(ArrayList<Integer> initialCondition, int index) {

        // Initializing the game
        bulgarianSolitaire.createInitialCondition(initialCondition);
        bulgarianSolitaire.sortCurrentStacks();

        // Begin and simulate the game and retrieve how long it took
        bulgarianSolitaire.beginLoop(attempts);
        int cycleCount = bulgarianSolitaire.getCycleCount();
        int originalCycle = bulgarianSolitaire.getRepeatedCycles();
        int loopLength = cycleCount - originalCycle;

        String printString = "";
        boolean indexEqualsCycleCount = index == cycleCount;

        // Add δ: DIFFERENCE if it takes fewer cycles than usual, an anomaly
        printString += !indexEqualsCycleCount ? "δ: " + (index - cycleCount) : "";

        printString += "\tn: " + index + "\t c: " + cycleCount + "\t l: " + loopLength + "\t" + bulgarianSolitaire.getFinalStacks();

        System.out.println(printString);
    }

    /***
     * Prints a set of initial conditions into the console in great detail.
     * Good for debugging purposes.
     * @param initialCondition
     */
    private static void printInDetail() {
        // Creating the initial condition
        ArrayList<Integer> initialCondition;
        initialCondition = testConditions();
        //initialCondition = randomTestConditions();

        // Inserts the initial condition
        bulgarianSolitaire.createInitialCondition(initialCondition);
        bulgarianSolitaire.sortCurrentStacks();

        // Begin and simulate the game and retrieve how long it took
        bulgarianSolitaire.beginLoop(attempts);
        int cycleCount = bulgarianSolitaire.getCycleCount();
        int originalCycle = bulgarianSolitaire.getRepeatedCycles();
        int loopLength = cycleCount - originalCycle;

        // Creating the output strings
        String success = "Repeated cycle " + originalCycle + " after " + cycleCount + " cycles. (Loop of length " + loopLength + " cycles.)";
        String failure = "Timed out after " + attempts + " attempts.";

        // Outputting the strings
        bulgarianSolitaire.printHistory();
        String output = cycleCount != -1 ? success : failure;
        System.out.println(output);
    }

    /***
     * Simply to create stacks quickly.
     */
    private static ArrayList<Integer> testConditions() {
        ArrayList<Integer> testConditions = new ArrayList<Integer>();

        testConditions.add(56);
        //testConditions.add(0);

        return testConditions;
    }

    /***
     * Generates a random set of test conditions.
     */
    private static ArrayList<Integer> randomTestConditions() {
        ArrayList<Integer> testConditions = new ArrayList<Integer>();

        int length = (int) (Math.random() * 10 + 3);
        int randomValue;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            randomValue = (int) (Math.random() * 15 + 1);
            testConditions.add(randomValue);
            sum += randomValue;
        }

        System.out.println("Sum of random: " + sum);

        return testConditions;
    }
}