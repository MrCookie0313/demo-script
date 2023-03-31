package com.example.demoscript.util;

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class SingleLinkedList {
    public Node head;//定义单链表的第一个结点，编译器自动初始化为null
    public int usedSize;//用来记录单链表的长度

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.usedSize++;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        this.usedSize++;
    }

    //打印单链表
    public void myToString() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //得到单链表的长度
    public int length() {
        Node cur = this.head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //寻找待插入位置的前驱结点
    public Node getIndex(int pos) {
        Node cur = this.head;
        int index = 0;
        while (index != pos - 1) {
            cur = cur.next;
            index++;
        }
        return cur;
    }

    public Node getNodeByValue(int value) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void insert(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            throw new RuntimeException("插入位置不合法");
        }

        if (pos == 0) {
            addFirst(data);
            return;
        }

        if (pos == this.usedSize) {
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node prev = getIndex(pos);
        node.next = prev.next;
        prev.next = node;
        this.usedSize++;
    }

    //修改指定位置的值
    public void modify(int pos, int data) {
        if (head == null) {
            throw new RuntimeException("链表为空，无法进行修改");
        }
        if (pos < 0 || pos > this.usedSize - 1) {
            throw new RuntimeException("操作位置不合法");
        }
        Node cur = this.head;
        int index = 0;
        while (index != pos) {
            cur = cur.next;
            index++;
        }
        cur.value = data;
    }

    //寻找关键字key的前一个结点
    private Node getPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.value == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            throw new RuntimeException("链表为空，无法进行操作");
        }

        if (this.head.value == key) {
            //如果链表为空或第一个结点为删除的值
            this.usedSize--;
            this.head = this.head.next;
            return;
        }
        Node prev = getPrev(key);
        prev.next = prev.next.next;
        this.usedSize--;
    }

    //删除所有值为key的节点
    public void removeAll(int key) {
        if (this.head == null) {
            throw new RuntimeException("单链表为空，无法进行删除");
        }
        Node prev = this.head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.value == key) {
                prev.next = cur.next;
                cur = cur.next;
                this.usedSize--;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.value == key) {
            this.head = this.head.next;
            this.usedSize--;
        }
    }

    //清空单链表
    public void clear() {
        this.head = null;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 0; i < 60; i++) {
            if (i % 2 == 0) {
                singleLinkedList.addLast(i);
            }
        }
        singleLinkedList.myToString();
        int usedSize1 = singleLinkedList.usedSize;
        System.out.println("usedSize1 = " + usedSize1);
        Node index = singleLinkedList.getIndex(30);
        if (index.next == null) {
            System.out.println(singleLinkedList.head.value);
        }
        System.out.println("index = " + index);

        Node prev = singleLinkedList.getPrev(20);

        Node nodeByValue = singleLinkedList.getNodeByValue(20);
        System.out.println("nodeByValue = " + nodeByValue);
    }
}