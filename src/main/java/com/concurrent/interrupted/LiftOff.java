package com.concurrent.interrupted;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:52
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!")
                + ") .";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("中断");
                Thread.interrupted();
                //Thread.interrupted();
                //break;
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff yt1 = new LiftOff();
        Thread a = new Thread(yt1);
        a.start();
        //a.isInterrupted();
        //Thread.interrupted();
        System.out.println(a.isInterrupted());
        a.interrupt();
        System.out.println(a.isInterrupted());
		/*try {
			a.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*LiftOff ss = new LiftOff();
		Thread b = new Thread(ss);
		b.start();*/
        //Executors.newFixedThreadPool(1);
    }
}
