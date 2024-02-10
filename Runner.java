import java.util.*;

class Runner {
    public static void main(String[] args) {
        StandardBulgarianSolitaire bulgarianSolitaire = new StandardBulgarianSolitaire();

        ArrayList<Integer> initialCondition = testConditions();

        bulgarianSolitaire.createInitialCondition(initialCondition);
        bulgarianSolitaire.sortCurrentStacks();

        System.out.println(bulgarianSolitaire);

        for (int i = 0; i < 10; i++) {
            bulgarianSolitaire.advanceStep();
            System.out.println(bulgarianSolitaire);
        }
    }

    private static ArrayList<Integer> testConditions() {
        ArrayList<Integer> testConditions = new ArrayList<Integer>();

        testConditions.add(10);

        return testConditions;
    }
}