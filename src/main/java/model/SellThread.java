package model;

import enums.PaymentMethod;

import java.util.Queue;

public class SellThread implements Runnable{

        Cashier cashier;
        private String productName;
        Customer customer;
        Queue<Customer> customerQueue;


    public SellThread(Cashier cashier, String productName, Customer customer, Queue<Customer> customerQueue) {
        this.cashier = cashier;
        this.productName = productName;
        this.customer = customer;
        this.customerQueue = customerQueue;
    }

    @Override
        public void run() {


            System.out.println(Thread.currentThread().getName() + " is buying\n");

            cashier.issuesReceipt(customer) ;

            System.out.println(Thread.currentThread().getName() + " has bought\n");

        }

    }

