package com.example.springbootstrategy.juc;

/**
 * 生产者消费者模型
 */
public class ProdcutorAndConsumer {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();
        // 生产者
        new Thread(() -> {
            while (true) {
                synchronized (pipeline) {
                    pipeline.setProducts(pipeline.getProducts() + 1);
                    System.out.println("produce 1 now left " + pipeline.getProducts());
                    try {
                        Thread.sleep(1000L);
                        pipeline.notifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();


        // 消费者
        new Thread(() -> {
            while (true) {
                synchronized (pipeline) {
                    try {
                        if (pipeline.getProducts() <= 0) {
                            System.out.println("no products left waiting ");
                            pipeline.wait();
                        } else {
                            pipeline.setProducts(pipeline.getProducts() - 1);
                            System.out.println("consume 1 now left " + pipeline.getProducts());
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

}

class Pipeline {
    int products = 0;

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}
