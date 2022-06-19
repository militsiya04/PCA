public class Queue {
    private final int[] queue;
    private final int maxSize; // кількість елементів у черзі
    private int nElem;         // поточна кількість елементів у черзі
    private int front;         // перший елемент у черзі
    private int rear;          // кінцевий елемент у черзі

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }
    public boolean isEmpty() {
        return (nElem == 0);
    }
    
    public void insert(int elem) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = elem;
        nElem++;
    }
    
    public void remove(int index) {
        int temp = 0;
        if (index < queue.length)
            for (int i = index; i < queue.length - 1; i++) {
                temp = queue[i+1];
                queue[i + 1] = queue[i];
                queue[i] = temp;
            }
        nElem = maxSize - 1;
    }
    public void printIndex (int index)
    {
        if (index >= 0 && index < maxSize)
            System.out.println("\n" + queue[index]);
        else
            System.out.printf ("%n[%d] element is not in the queue", index);
    }
    public void printQueue ()
    {
        if (!isEmpty()) {
            System.out.print("\n[");
            for (int i = 0; i < nElem; i++) {
                if (i == 0)
                    System.out.print(queue[i]);
                else
                    System.out.print(", " + queue[i]);
            }
            System.out.print("]");
        }
        else
            System.out.println("Queue is empty");
    }
}
