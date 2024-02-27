// Singleton class

import java.util.*;

abstract class BulgarianSolitaire {

    // protected static BulgarianSolitaire instance;
    protected ArrayList<Integer> currentStacks;
    protected ArrayList<ArrayList<Integer>> history = new ArrayList<ArrayList<Integer>>();

    protected int cycleCount; // The number of cycles until a repeat is found
    protected int repeatedCycles; // The original repeated cycle (not the second one)

    // ******************************************************************************
    // Constructor

    protected BulgarianSolitaire() {
    };

    // ******************************************************************************
    // Abstract methods

    // abstract BulgarianSolitaire getInstance();
    /***
     * Advances to the next iteration of the game.
     * Updates currentStacks.
     */
    abstract void advanceStep();

    // ******************************************************************************
    // Getters and setters and more

    /***
     * Starts the loop and runs until finished or timing out.
     * 
     * @param attempts number of attempts before timing out.
     * @return number of cycles, -1 if timing out.
     */
    public int beginLoop(int attempts) {

        // Clearing history
        history = new ArrayList<ArrayList<Integer>>();
        
        // Need to add the initial condition to history
        addHistory();

        for (int i = 0; i < attempts; i++) {
            advanceStep();
            addHistory();

            // Print the current stack
            // System.out.println("Current stacks: " + this.toString());

            // If history has been repeated, end the loop
            if (checkHistory()) {
                cycleCount = i + 1;
                return 0;
            }
        }
        cycleCount = -1;
        return -1;
    }

    /***
     * Checks backwards to the beginning to see if the current stacks have happened
     * before. Also adds the first repeated cycle to repeatedCycles
     * 
     * @return true if repeated, false if not.
     */
    public boolean checkHistory() {

        for (int i = history.size() - 2; i >= 0; i--) {
            if (history.get(i).equals(currentStacks)) {
                repeatedCycles = i;
                return true;
            }
        }

        return false;
    }

    /***
     * Needed because otherwise it is the object not the values being added or
     * something
     */
    public void addHistory() {
        ArrayList<Integer> newHistory = new ArrayList<>();

        for (int i = 0; i < currentStacks.size(); i++) {
            newHistory.add(currentStacks.get(i));
        }

        history.add(newHistory);
    }

    /***
     * Prints the history, may return String in the future
     * Need to actually implement
     */
    public void printHistory() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(i + ": " + history.get(i));
        }
    }

    /***
     * Returns the string of the final stacks of the game.
     * @return String of stacks to be printed
     */
    public String getFinalStacks() {
        String historyString = "";

        // Concatenates history to a string
        ArrayList<Integer> finalStacks = history.get(history.size() - 1);
        for (int i = 0; i < finalStacks.size(); i++ ){
            historyString += finalStacks.get(i) + " ";
        }
        historyString.substring(historyString.length() - 1);

        return historyString;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public int getRepeatedCycles() {
        return repeatedCycles;
    }

    /***
     * Sorts the stack into non-increasing order.
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

    /***
     * Returns the current stacks.
     */
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