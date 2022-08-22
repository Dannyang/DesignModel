package com.example.springbootstrategy.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用线程字符串交替输出
 */
public class MyConcurrentPrint {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "abcdefghi".toCharArray();
        AtomicInteger flag = new AtomicInteger();
        new Thread(() -> {

            try {
                synchronized (monitor) {
                    for (char ch : chars1) {
                        if (flag.get() == 0) {
                            monitor.print(ch);
                            flag.set(1);
                            monitor.notifyAll();
                            monitor.wait();
                        } else {
                            monitor.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();
        new Thread(() -> {

            try {
                synchronized (monitor) {
                    for (char ch : chars2) {
                        if (flag.get() == 1) {
                            monitor.print(ch);
                            flag.set(2);
                            monitor.notifyAll();
                            monitor.wait();
                        } else {
                            monitor.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

class Monitor {
    void print(char ch) {
        System.out.println(ch);
    }
}