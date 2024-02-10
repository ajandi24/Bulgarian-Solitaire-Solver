import java.util.*;

class Runner {
    public static void main(String[] args) {
        StandardBulgarianSolitaire bulgarianSolitaire = new StandardBulgarianSolitaire();

        ArrayList<Integer> initialCondition;

        // initialCondition = testConditions();
        initialCondition = randomTestConditions();
        int attempts = 1000;

        bulgarianSolitaire.createInitialCondition(initialCondition);
        bulgarianSolitaire.sortCurrentStacks();

        bulgarianSolitaire.beginLoop(attempts);
        int cycleCount = bulgarianSolitaire.getCycleCount();
        int originalCycle = bulgarianSolitaire.getRepeatedCycles();

        String output = cycleCount != -1 ? "Repeated cycle " + originalCycle + " after " + cycleCount + " cycles." : "Timed out after " + attempts + " attempts.";
        bulgarianSolitaire.printHistory();
        System.out.println(output);
    }

    /***
     * Simply to create stacks quickly.
     */
    private static ArrayList<Integer> testConditions() {
        ArrayList<Integer> testConditions = new ArrayList<Integer>();

        testConditions.add(5);
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

        for (int i = 0; i < length; i++) {
            randomValue = (int) (Math.random() * 15 + 1);
            testConditions.add(randomValue);
        }

        return testConditions;
    }
}