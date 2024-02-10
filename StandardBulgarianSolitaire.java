// Singleton class
public class StandardBulgarianSolitaire extends BulgarianSolitaire {
    
    public StandardBulgarianSolitaire() {
    };

    @Override
    public void advanceStep() {
        // Need to count the number of stacks, will be added at the end
        int stackCount = currentStacks.size();

        // Decrement every stack by one
        for (int i = 0; i < stackCount; i++) {
            currentStacks.set(i, currentStacks.get(i) - 1);
        }

        // Removing stacks of size 0
        for (int i = 0; i < currentStacks.size(); i++) {
            if (currentStacks.get(i) == 0) {
                currentStacks.remove(i);
                i--;
            }
        }

        // Adding the newly created stack to the end
        currentStacks.add(stackCount);

        // Sorting
        this.sortCurrentStacks();
    }
}
