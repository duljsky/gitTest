package com.fitsco.thread;

public class Race implements Runnable{
    private static String winner;

    @Override
    public void run() {
        boolean overFlag = false;

        for (int i = 1; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子") && (i%10 == 0)){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            overFlag = gameOver(i);
            if (true == overFlag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "步");
        }
    }

    /**
     *
     * @param steps
     * @return
     */
    private boolean gameOver(int steps){

        if (winner != null){
            return true;
        }else{
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();


    }


}
