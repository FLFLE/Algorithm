package linkedList;

import java.util.ArrayList;

/**
 * @author zengfanyu
 * @date 2020/3/17 8:30
 */
public class MyLinkedList {

    class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    //定义一个size，会随着添加元素而增加
    int size = 0;

    public int getSize() {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
//    public int getSize(){
//        return size;
//    }

    /**
     * 添加头节点（初始化链表时使用，一般用insert代替）
     *
     * @param value
     */
    public void addHead(int value) {
        this.head = new Node(value);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    /**
     * 添加尾节点(在只存在头节点时使用，一般使用insert方法添加）
     *
     * @param value
     */
    public void addTail(int value) {
        this.tail = new Node(value);
        head.next = tail;
        size++;
    }

    /**
     * 在头部添加元素
     *
     * @param value
     */
    public void insert_to_head(int value) {
        if (this.head == null) {
            addHead(value);
        } else if (tail == head) {
            Node new_head = new Node(value);
            head = new_head;
            head.next = tail;
            size++;
        } else {
            Node new_head = new Node(value);
            new_head.next = head;
            head = new_head;
            size++;
        }
    }

    /**
     * 在尾部添加元素
     *
     * @param value
     */
    public void insert_to_tail(int value) {
        if (this.head == null) {
            addHead(value);
        } else if (tail == head) {
            addTail(value);
        } else {
            Node new_tail = new Node(value);
            tail.next = new_tail;
            tail = new_tail;
            size++;
        }
    }

    /**
     * 在指定下标处添加元素
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            insert_to_head(value);
            return true;
        }
        if (index == size) {
            insert_to_tail(value);
            return true;
        }
        Node new_node = new Node(value);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        new_node.next = temp.next;
        temp.next = new_node;
        size++;
        return true;
    }

    /**
     * 删除头部元素
     */
    public void delete_head() {
        head = head.next;
        size--;
    }

    /**
     * 删除尾部元素
     */
    public void delete_tail() {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }

    /**
     * 删除指定下标处元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0) {
            delete_head();
            return true;
        }
        if (index == size - 1) {
            delete_tail();
            return true;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    /**
     * 修改指定下标处元素
     *
     * @param value
     * @param index
     * @return
     */
    public boolean revise(int value, int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    /**
     * 查找指定下标处元素
     *
     * @param index
     * @return
     */
    public int search_value(int index) {
        if (index < 0 || index >= size) {
            System.out.println("输入下标有误");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    /**
     * 返回一个包含指定元素的所有下标的集合
     *
     * @param value
     * @return
     */
    public ArrayList<Integer> search_node(int value) {
        ArrayList<Integer> index = new ArrayList<>();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                index.add(i);
            }
            temp = temp.next;
        }
        if (index.isEmpty()) {
            System.out.println("链表不存在该元素");
            return null;
        }
        return index;
    }

    /**
     * 打印链表
     */
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }


}
