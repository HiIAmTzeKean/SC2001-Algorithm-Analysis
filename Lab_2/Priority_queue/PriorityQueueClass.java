package Priority_queue;

import Node.Node;
public abstract class PriorityQueueClass {
    public abstract boolean isEmpty();
    public abstract int[] getCounts();
    public abstract Node getHead();
    public abstract void delHead();
    public abstract void decreaseKey(int weight, int vertex);
}
