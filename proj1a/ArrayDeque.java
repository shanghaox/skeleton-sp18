public class ArrayDeque<T> {

    private static int RFACTOR = 100;
    private static int INITLENGTH = 10;
    private T[] items;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (T[]) new Object[INITLENGTH];
        size = 0;
    }

    private void resize(int newcap) {
        //        int[] temp = list;
        T[] a = (T[]) new Object[newcap];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private void shrink() {
        float rate = (float) size / (float) items.length;
        if (rate < 0.25f) {
            resize(items.length / 2);
        }
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(T x) {
        if (items.length == size) {
            resize(items.length * RFACTOR);
        }
        items[size] = x;
        size++;
    }

    public void addFirst(T x) {
        if (items.length <= size + 1) {
            resize(items.length * RFACTOR);
        }
        T[] temp = (T[]) new Object[items.length];
        temp[0] = x;
        System.arraycopy(items, 0, temp, 1, size);
        items = temp;
        size++;
    }

    /**
     * Returns the item from the back of the list.
     */
    private T getLast() {
        //        shrink();
        return items[size - 1];
    }


    /**
     * Gets the ith item in the list (0 is the front).
     */
    public T get(int i) {
        //        shrink();
        //        if (i < 0 || i > size - 1) {
        //            return null ;
        //        }
        return items[i];
    }
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i] + " ");
        }
    }
    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T[] temp = (T[]) new Object[items.length];
        T tempi = items[0];
        System.arraycopy(items, 1, temp, 0, size - 1);
        size--;
        return tempi;
    }
    public T removeLast() {
        //        shrink();
        //        T x = getLast();
        if (size == 0) {
            return null;
        }
        T temp = items[size];
        items[size] = null;
        size--;
        return temp;
    }


    private static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++) {
            totalLength++;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                a[aIndex] = x[i][j];
                aIndex++;
            }
        }
        return a;
    }

    private static void print1d(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
