
public class Farm {

    private Cow root;

    public Farm() {
        createFirstCow();
    }

    private void createFirstCow() {
        this.root = new Cow(1, "PrimalCow");
    }

    public Cow giveBirth(long parentCowId, long childCowId, String childNickName) {
        if (parentCowId == childCowId) {
            throw new IllegalArgumentException("How do you think thats possible :)");
        }

        if (childNickName == null) {
            throw new IllegalArgumentException("Child name cannot be null");
        }
        Cow parent = findById(parentCowId);
        if (parent == null || !parent.isAlive()) {
            throw new IllegalArgumentException("Parent does not exist");
        }
        if (findById(childCowId) != null) {
            throw new IllegalArgumentException("Cow with this id already exists");
        }

        Cow child = new Cow(childCowId, childNickName, parentCowId);
        parent.addChild(child);
        return child;
    }

    public void endLifeSpan(long id) {
        if (id == root.getCowID()) {
            throw new IllegalArgumentException("First cow cannot be deleted");
        }
        Cow cowToDelete = findById(id);
        if (cowToDelete == null) {
            throw new IllegalArgumentException("This cow does not exist");
        }
        cowToDelete.kill();
    }

    public void printFarm() {
        System.out.println("Cows : ");
        printTree(root, 0);
    }

    private Cow findById(long id) {
        return findById(id, root);
    }

    private Cow findById(long id, Cow current) {
        if (current == null) {
            return null;
        }

        if (current.getCowID() == id) {
            return current;
        }

        Cow found = findById(id, current.getFirstChild());
        if (found != null) {
            return found;
        }
        return findById(id, current.getNextSister());
    }

    private void printTree(Cow current, int depth) {
        if (current == null) {
            return;
        }
        if (current.isAlive()) {
            printDepth(depth);
            System.out.println(current);
        }
        printTree(current.getFirstChild(), depth + 1);
        printTree(current.getNextSister(), depth);
    }

    private void printDepth(int depth) {
        System.out.print("|");
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
    }
}






