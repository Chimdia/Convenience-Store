package model;

import SupplyPackage.SupplyList;
import enums.PaymentMethod;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {


    public static void main(String[] args) {
        Store store = new Store();
        Product product = null;
        SupplyList supplyList = new SupplyList("src/main/java/SupplyPackage/Supply.csv");
        supplyList.readProductFile(product, store);
        for (Product productSupplyList : store.getSupplyList()) {
          System.out.println(productSupplyList);
        }

        Manager manager = Manager.getInstance();
        Cashier newCashier = new Cashier("Nma", 4, false);
        System.out.println("+++++++++++ Hiring A Cashier++++++++++++");
        manager.canHireACashier(newCashier);

        System.out.println("\n-------------Adding Products To Cart--------------\n");


        Customer customer1 = new Customer("Seun", PaymentMethod.Cash);
        customer1.canBuy("chocolate chip", "Cookies", 244, store, customer1);
//       customer1.canBuy("Potato chips", "Snacks", 300, store, customer1);
//        customer1.canBuy("Banana", "Bars", 30, store, customer1);


        Customer customer2 = new Customer("Chimudia", PaymentMethod.Card);
        customer2.canBuy("Chocolate Chip", "Cookies", 500, store, customer2);
//        customer2.canBuy("Carrot", "Bars", 10, store, customer2);
//        customer2.canBuy("Potato chips", "Snacks", 15, store, customer2);

        Customer customer3 = new Customer("Chukwuma", PaymentMethod.Cash);
        customer3.canBuy("Chocolate Chip", "Cookies", 250, store, customer3);
//        customer3.canBuy("Banana", "Bars", 10, store, customer3);
//        customer3.canBuy("carrot", "Bars", 200, store, customer3);

        Cashier cashier1 = new Cashier("Joyce", 4, true);
//        cashier1.canSell(customer1);
//        cashier1.issuesReceipt(customer1 /*, customer1.getCustomerCart()*/);
//        cashier1.receivePayment(customer1);


//        cashier1.canSell(customer2);
//        cashier1.issuesReceipt(customer2 /*, customer2.getCustomerCart()*/);
//        cashier1.receivePayment(customer2);


//        cashier1.canSell(customer1);
//        cashier1.issuesReceipt(customer3 /*customer3.getCustomerCart()*/);
//        cashier1.receivePayment(customer3);

        cashier1.comparingProducts(customer1);
        cashier1.comparingProducts(customer2);
        cashier1.comparingProducts(customer3);

        System.out.println(" \n--------------------Chocolate Chips  queue-----------------\n");
        while (!cashier1.getChocolateChip().isEmpty()) {
            System.out.println(cashier1.getChocolateChip().poll());
        }

        System.out.println("\n-----------------Potato chips Queue-------------------\n");
        while (!cashier1.getPotatoChip().isEmpty()) {
            System.out.println(cashier1.getPotatoChip().poll());
        }

        System.out.println("\n-----------------Carrot Queue-------------------\n");
        while (!cashier1.getCarrot().isEmpty()) {
            System.out.println(cashier1.getCarrot().poll());
        }

        System.out.println("\n-----------------Banana Queue-------------------\n");
        while (!cashier1.getBanana().isEmpty()) {
            System.out.println(cashier1.getBanana().poll());
        }

        cashier1.fifoQueue(customer2, cashier1.getCustomerQueue());
        cashier1.fifoQueue(customer1, cashier1.getCustomerQueue());
        cashier1.fifoQueue(customer3, cashier1.getCustomerQueue());

        System.out.println("\n---------------FIFO Queue-----------------");
        cashier1.printQueueList( cashier1.getCustomerQueue());







        System.out.println("\n========Multi-threading=========");
        ArrayList<Thread> threadList = new ArrayList<>();
        Queue<Customer> customerQueue = new LinkedList<>();

        SellThread st = new SellThread(cashier1,"Chocolate chip",customer1,customerQueue);
        Thread thread = new Thread(st);

        SellThread st1 = new SellThread(cashier1,"Chocolate chip",customer2,customerQueue);
        Thread thread1 = new Thread(st1);

        SellThread st2 = new SellThread(cashier1,"Chocolate chip",customer3,customerQueue);
        Thread thread2 = new Thread(st2 );

        thread.setName("Seun");
       thread1.setName("Chimudia");
        thread2.setName("Chukwuma");


        threadList.add(thread);
       threadList.add(thread1);
        threadList.add(thread2);


        threadStart(threadList);
    }

    public static int threadStart(ArrayList<Thread> threadList){
        for (Thread inThread : threadList){
            inThread.start();
            try{
                Thread.sleep(300);
                inThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }
}



