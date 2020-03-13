
public class check
{
    boolean done;
    KVEntry current;

    KVEntry next; // chaining

    public check(boolean b, KVEntry e, KVEntry f) {
        done = b;
        current = e;
        next = f;
    }
}
