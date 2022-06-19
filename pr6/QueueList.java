public class QueueList {
    private ListNode front;
    private ListNode rear;
    private int length;

    public QueueList () {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty () {
        return length == 0;
    }
    public void remove (int index) {
        ListNode ptr_sec = front;

        if (index == length) {
            ListNode p = front;
            while (p.next.next != null)
                p = p.next;
            p.next = null;
        }
        else if (index == 1)
            front = front.next;
        else
            for (int i = 1; i < length; i++) {
                if (i + 1 == index) {
                    int temp = ptr_sec.next.data;
                    ptr_sec.next.data = ptr_sec.next.next.data;
                    ptr_sec.next.next.data = temp;

                    ptr_sec.next.next = ptr_sec.next.next.next;

                }
                ptr_sec = ptr_sec.next;
            }
    }
    public void insert (int data) {
        ListNode temp = new ListNode(data);
        if (isEmpty())
            front = temp;
        else rear.next = temp;
        rear = temp;
        length++;
    }

    public void printIndex(int index) {
        int counter = 1;
        ListNode list = front;
        while (counter <= index) {
            if (counter == index) {
                System.out.print(list.data);
            } else
                list = list.next;
            counter++;
        }
    }

    public void printQueue() {
        if (isEmpty())
            return;

        ListNode current = front;
        System.out.println();
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueList queue = new QueueList();
        System.out.print("Queue implemented as list: ");

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.printQueue();
        queue.printIndex(3);
        queue.remove(4);
        queue.printQueue();
    }
}
