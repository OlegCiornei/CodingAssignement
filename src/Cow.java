public class Cow {

    private boolean alive;
    private final long parentId;

    private final long cowID;
    private final String nickName;

    // if cow has multiple children than it will have this first child set here, and all the next to its sisters
    private Cow firstChild;
    //next born sister of the current cow
    private Cow nextSister;

    public Cow(long cowID, String nickName) {
        this.cowID = cowID;
        this.nickName = nickName;
        this.parentId = 0;//no parent
        this.alive = true;
    }

    public Cow(long cowID, String nickName, long parentId) {
        this.cowID = cowID;
        this.nickName = nickName;
        this.parentId = parentId;
        this.alive = true;
    }

    public void addChild(Cow child) {
        if (!this.alive) {
            throw new IllegalArgumentException("Dead cow cannot born a new one");
        }

        if (child == null) {
            this.firstChild = null;
            return;
        }

        if (this.firstChild == null) {
            this.firstChild = child;
            return;
        }
        Cow current = this.firstChild;
        while (current.nextSister != null) {
            current = current.nextSister;
        }
        current.nextSister = child;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void kill() {
        this.setAlive(false);
    }

    public long getParentId() {
        return parentId;
    }

    public long getCowID() {
        return cowID;
    }

    public String getNickName() {
        return nickName;
    }

    public Cow getFirstChild() {
        return firstChild;
    }

    public Cow getNextSister() {
        return nextSister;
    }

    @Override
    public String toString() {
        if (!alive) {
            return "";
        }

        return "Cow : {cowID=" + cowID + ", parentId=" + parentId + ", nickName='" + nickName + '}';
    }
}
