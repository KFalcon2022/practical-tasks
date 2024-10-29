package com.walking.lesson62_wait_notify.task1.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MessageService {
    private String message=null;
    private boolean transfer=false;
    private Scanner scanner;
    private PrintStream pS;

    public MessageService(InputStream iS, PrintStream pS){
        this.scanner=new Scanner(iS);
        this.pS=pS;
    }

    public synchronized String send(){
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted");
            }
        }
        pS.println(message);
        String result=message;
        transfer=false;
        notifyAll();
        return result;
    }

    public synchronized String receive(){
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread Interrupted");
            }
        }
        message=scanner.nextLine();
        String result=message;
        if (message.equals("Finish"))
            scanner.close();
        transfer=true;
        notifyAll();
        return result;
    }
}
