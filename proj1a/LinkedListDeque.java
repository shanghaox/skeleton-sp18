public class LinkedListDeque<T> {
    private class LinkedNode {
        private LinkedNode prev;
        private LinkedNode next;
        private T data;

        LinkedNode(T data, LinkedNode prev, LinkedNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }
    private LinkedNode sentinel;
    private int  size;

    public LinkedListDeque() {
        sentinel = new LinkedNode(null, sentinel, sentinel);
        sentinel.prev = sentinel;
        //sentinel前后都指向自己出问题了？
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new LinkedNode(null, sentinel, sentinel);
        sentinel.next = new LinkedNode(x, sentinel, sentinel.next);
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new LinkedNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    public void addLast(T item) {
        sentinel.prev = new LinkedNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedNode p = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.println(p.data + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        T temp = sentinel.next.data;
        sentinel.next = sentinel.next.next;
        size--;
        return temp;
    }

    public T removeLast() {
        T temp = sentinel.prev.data;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return temp;
    }

    public T get(int index) {
        int count = 0;
        LinkedNode p = sentinel.next;
        while (count < index) {
            p = p.next;
            count++;
        }
        return p.data;
    }
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }
    private T getRecursiveHelper(LinkedNode t, int times) {
        if (times == 0) {
            return t.data;
        } else {
            return getRecursiveHelper(t.next, times - 1);
        }
    }


    public static void main(String[] args) {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        lld1.printDeque();




    }
}
