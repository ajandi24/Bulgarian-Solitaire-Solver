// Singleton class

import java.util.*;

abstract class BulgarianSolitaire {

    // protected static BulgarianSolitaire instance;
    protected ArrayList<Integer> currentStacks;
    protected ArrayList<String> history;

    //******************************************************************************
    // Constructor

    protected BulgarianSolitaire() {
    };

    //******************************************************************************
    // Abstract methods

    // abstract BulgarianSolitaire getInstance();
    abstract void advanceStep();

    //******************************************************************************
    // Getters and setters and more

    /***
     * Sorts the stack into non-increasing order
     */
    public void sortCurrentStacks() {
        currentStacks.sort(null);
        Collections.reverse(currentStacks);
    }

    public void createInitialCondition(ArrayList<Integer> currentStacks) {
        this.currentStacks = currentStacks;
    }

    public ArrayList<Integer> getCurrentStacks() {
        return currentStacks;
    }

    public String toString() {
        // If currentStacks is empty stuff breaks
        if (currentStacks.size() == 0) {
            return "Current Stack is empty.";
        }

        String output = "";

        // Prints out the current stack, mostly debugging
        for (int i = 0; i < currentStacks.size(); i++) {
            output += currentStacks.get(i) + ", ";
        }
        // Trimming last comma and space from output
        output = output.substring(0, output.length() - 2);

        return output;
    }
}