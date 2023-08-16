public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int length;
    private int front;
    private int last;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        length = 8;
        size = 0;
        front = 4;
        last = 4;
    }

    public int leftAdd(int index) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }

    public int rightAdd(int index, int realLen) {
        index %= realLen;
        if (index == realLen - 1) {
            return 0;
        }
        return index + 1;
    }

    public void grow() {
        T[] newArray = (T[]) new Object[length * 2];
        int oldPtr = front;
        int newPtr = length;
        while(oldPtr != last) {
            newArray[newPtr] = array[oldPtr];
            oldPtr = rightAdd(oldPtr, length);
            newPtr = rightAdd(newPtr, length * 2);
        }
        front = length;
        last = newPtr;
        array = newArray;
        length *= 2;
    }

    public void shrink() {
        T[] newArray = (T[]) new Object[length / 2];
        int oldPtr = front;
        int newPtr = length / 4;
        while (oldPtr != last) {
            newArray[newPtr] = array[oldPtr];
            oldPtr = rightAdd(oldPtr, length);
            newPtr = rightAdd(newPtr, length / 2);
        }
        front = length / 4;
        last = newPtr;
        array = newArray;
        length /= 2;
    }

    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        front = leftAdd(front);
        array[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        array[last] = item;
        last = rightAdd(last);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int ptr = front;
        while (ptr != last) {
            System.out.print(array[ptr] + " ");
            ptr = rightAdd(ptr);
        }
    }

    public T removeFirst() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        T res = array[front];
        front = rightAdd(front);
        size--;
        return res;
    }

    public T removeLast() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        last = leftAdd(last);
        size--;
        return array[last];
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = rightAdd(ptr);
        }
        return array[ptr];
    }
}
