package labclass;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zengfanyu
 * @date 2020/11/5 17:02
 */
public class ListNode {

    class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    private void addHead(int value) {
        this.head = new Node(value);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    private void addTail(int value) {
        this.tail = new Node(value);
        head.next = tail;
        size++;
    }

    //向链表尾部插入元素
    public void insert(int value) {
        if (head == null) {
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

    //从文件中读取内容并创建链表
    public static ListNode readFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ListNode linkedList = new ListNode();
        StringBuilder str = new StringBuilder();
        String line;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            str.append(line);
        }
        String[] strings = str.toString().split(" ");
        for (String s : strings) {
            arrayList.add(Integer.parseInt(s));
        }
        for (int i : arrayList) {
            linkedList.insert(i);
        }
        return linkedList;
    }

    //将链表的数据存到文件中
    public void save(File file) throws IOException {
        int[] array = new int[size];
        Node temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.value;
            temp = temp.next;
        }
        FileWriter fw = new FileWriter(file);
        for (int i : array) {
            fw.write(i + " ");
        }
        fw.close();
    }

    //返回排序后的链表
    public ListNode sort() {
        ListNode listNode = new ListNode();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            arrayList.add(temp.value);
            temp = temp.next;
        }
        Integer[] array = arrayList.toArray(new Integer[0]);
        Arrays.sort(array);
        for (int s : array) {
            listNode.insert(s);
        }
        return listNode;
    }

    //查找链表中指定元素首次出现的下标(0作为起始位置）
    public int searchNode(int value) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    //查找链表中指定元素存在的位置的下表组成的集合（可能会有多个相同元素）
    public ArrayList<Integer> searchNodeList(int value) {
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

    //打印链表
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }


    public static void main(String[] args) throws IOException {
        ListNode linkedList = new ListNode();

        //创建单链表，向链表添加元素
        linkedList.insert(200);
        linkedList.insert(100);
        linkedList.insert(50);
        linkedList.insert(300);

        //打印链表结果
        linkedList.print();

        //将创建的链表排序并打印
        ListNode sortedList = linkedList.sort();
        sortedList.print();

        //将排序的链表写入文件
        sortedList.save(new File("save.txt"));

        //从文件读取链表的值并创建链表
        ListNode listReadFromFile = new ListNode();
        listReadFromFile = readFromFile(new File("read.txt"));
        listReadFromFile.print();

        //在链表中查找相应元素
        System.out.println(linkedList.searchNode(50)); //在链表中
        System.out.println(linkedList.searchNode(1000));//不在链表中，返回-1
    }
}
