import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class MyCircularQueue {

    int[] queue;
    int head;
    int tail;

    // constructor
    public MyCircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;
    }

    // add to tail
    public boolean enQueue(int value) {
        if (isEmpty()) {
            head++;
            tail++;
            queue[0] = value;
        } else if (isFull()) {
            return false;
        } else if (tail == queue.length - 1) {
            tail = 0;
            queue[tail] = value;
        } else {
            tail++;
            queue[tail] = value;
        }

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if (head == queue.length - 1) {
            queue[head] = -1;
            head = 0;
        } else {
            queue[head] = -1;
            head++;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        if (head == -1 && tail == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((tail == queue.length - 1 && head == 0) || (tail == head - 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear()); // return 3
        System.out.println(myCircularQueue.isFull()); // return True
        System.out.println(myCircularQueue.deQueue()); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear()); // return 4
        System.out.println(Arrays.toString(myCircularQueue.queue));
    }
}
