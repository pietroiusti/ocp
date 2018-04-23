/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.Concurrency;

/**
 *
 * @author PietroS
 */
public class RunnableExample {

    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();

        System.out.println("begin");
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        System.out.println("end");

    }
}

class PrintData implements Runnable {

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing record: " + i);
        }
    }

//    public static void main(String[] args) {
//        (new Thread(new PrintData())).start();
//    }
}

class ReadInventoryThread extends Thread {

    public void run() {
        System.out.println("Printing zoo inventory");
    }

//    public static void main(String[] args) {
//        (new ReadInventoryThread()).start();
//    }
}
