package com.example.springbootstrategy.mymap;

import java.util.ArrayList;

/**
 * 利用arrayList和链表实现hashMap功能
 */
public class MyHashMap {
    private int bucketSize;
    private int mapSize;

    // 定义一个数组，每个元素用来存储一个链表
    private ArrayList<Node> bucket;

    static class Node {
        String key;
        String value;
        // 下一个元素
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        bucket = new ArrayList<>();
        mapSize = 0;
        bucketSize = 10;
        for (int i = 0; i < bucketSize; i++) {
            bucket.add(null);
        }
    }

    // 自定义的数组下标算法
    private int getIndexOfBucket(String key) {
//        int hashCode = key.hashCode();
//        return hashCode % bucketSize;
        return key.length() % bucketSize;
    }

    public void add(String key, String value) {
        int index = getIndexOfBucket(key);
        // 存储在array里的是链表,链表中每个元素有当前元素的值和指向下一个元素的指针
        Node head = bucket.get(index);
        // 先遍历一次数组元素指向的链表查询有没有key相同的元素
        Node temp = head;
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // 如果没有key相同的元素，则在链表末尾再添加一个node
        Node newNode = new Node(key, value);
        // 先进后出将新节点放在链表顶端
        newNode.next = temp;
        bucket.set(index, newNode);
        mapSize++;

    }

    public String get(String key) {
        int index = getIndexOfBucket(key);
        Node head = bucket.get(index);
        if (head == null) {
            return null;
        } else {
            while (head != null) {
                if (head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }
            // 当前链表已经遍历完成都没有找到对应的value则直接返回null
            return null;
        }
    }

    public void remove(String key) {
        int index = getIndexOfBucket(key);
        Node head = bucket.get(index);
        Node prev = null;
        while (head != null) {
            if (key.equals(head.key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        // 如果head为null则没有找到对应的key
        if (head == null) {
            return;
        } else {
            prev.next = head.next;
        }
    }

    public int size() {
        return mapSize;
    }
    // 数组扩容
//    private void extendBucket(){
//
//    }
}
