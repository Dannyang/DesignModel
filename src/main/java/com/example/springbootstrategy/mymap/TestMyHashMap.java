package com.example.springbootstrategy.mymap;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.add("key","value");
        hashMap.add("key1", "value1");
        hashMap.add("aa","aa");
        hashMap.add("bb","bb");
        hashMap.add("cc","cc");
        hashMap.add("dd","dd");
        hashMap.add("ee","ee");
        hashMap.add("ff","ff");

        System.out.println(hashMap.size());
        String valueOfKey = hashMap.get("key");
        System.out.println(valueOfKey);
        hashMap.remove("dd");
        System.out.println(hashMap.size());
        String valueOfKey0 = hashMap.get("dd");
        System.out.println(valueOfKey0);
    }
}
