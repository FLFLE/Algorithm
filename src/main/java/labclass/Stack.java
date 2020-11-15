package labclass;

import java.security.PublicKey;

/**
 * @author zengfanyu
 * @date 2020/11/12 15:37
 */
public class Stack<T> {
    private T[] arr = (T[]) new Object[10];
    int N = 0;

    private void resize(int maxSize) {
        T[] temp = (T[]) new Object[maxSize];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T element) {
        if (N == arr.length) {
            resize(2 * N);
        }
        arr[N++] = element;
    }

    public T peek() {
        return arr[N-1];
    }

    public T pop() {
        T element = arr[--N];
        arr[N] = null;
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return element;
    }

}
