package com.example.thread;

public class StopThread extends Thread {
    private int i = 0, j = 0;

    @Override
    public void run() {
        //增加同步锁，保证线程安全
        synchronized (this) {
            ++i;
            try {
                //休眠10s模拟耗时操作
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++j;
        }
    }

    public void print() {
        System.out.println("i=" + i + ",j=" + j);
    }

    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        //休眠1s，确保变量自增成功
        Thread.sleep(1000);
        //中止线程
        thread.stop();
        while (thread.isAlive()) {
            //确保线程已经终止
        }
        //输出结果
        thread.print();
        //i=1,j=0
    }
}
