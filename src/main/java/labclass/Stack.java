package labclass;
/**
 * @author zengfanyu
 * @date 2020/11/12 15:37
 */
public class Stack<T> {
    //定义存放栈元素的数组，初始容量为10
    private T[] arr = (T[]) new Object[10];
    //栈元素数量
    int N = 0;

    //当压栈后数组满时，将数组容量扩充至原来的2倍
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

    //当弹出元素后栈的容量不足数组的1/4时，将数组长度重置为原来的一半避免空间浪费
    public T pop() {
        T element = arr[--N];
        arr[N] = null;
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return element;
    }

}
