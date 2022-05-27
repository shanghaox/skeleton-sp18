public class LinkedListDeque<T> {
    private class Node {
        Node prev;
        Node next;
        //        int size;
        T item;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }

    }
    private int size;
    final private Node sentinel;
    public LinkedListDeque() {//TODO:public
        sentinel = new Node(null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
//        if (sentinel == null) {
//
//        }
        Node newNode = new Node(item,sentinel,sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item,sentinel.prev, sentinel);
        sentinel.prev.next = newNode;//TODO：去掉一个prev
        sentinel.prev = newNode;
        size++;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node temp = sentinel;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            System.out.print(temp.item+" ");
        }
        System.out.println();
    }
    public T removeFirst() {
        T result = sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return result;
    }
    public T removeLast() {
        T result = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        size--;
        return result;
    }

    public T get(int index) {
        Node temp = sentinel;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelp(sentinel,index);
    }
    public T getRecursiveHelp(Node start, int index) {
        return getRecursiveHelp(start.next,index--);
    }



}
