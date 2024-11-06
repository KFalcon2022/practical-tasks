package com.walking.lesson67_locks.task1.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MessageService {
    private String message=null;
    private boolean transfer=false;
    private Scanner scanner;
    private PrintStream pS;
    private ReentrantLock lock;
    private Condition condition;

    public MessageService(InputStream iS, PrintStream pS){
        this.scanner=new Scanner(iS);
        this.pS=pS;
        this.lock=new ReentrantLock();
        this.condition=lock.newCondition();
    }

    public String send(){
        lock.lock();
        try {
            while (!transfer) {
                condition.await();
            }
            pS.println(message);
            String result=message;
            transfer=false;
            condition.signalAll();
            return result;
        } catch(InterruptedException e){
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }

    }

    public String receive(){
        lock.lock();
        try {
            while (transfer) {
                condition.await();
            }
            message=scanner.nextLine();
            String result=message;
            if (message.equals("Finish"))
                scanner.close();
            transfer=true;
            condition.signalAll();
            return result;
        } catch(InterruptedException e){
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
