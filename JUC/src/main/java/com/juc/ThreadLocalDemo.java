package com.juc;

public class ThreadLocalDemo {



        public static void main(String[] args) {
            new Thread(() -> {
                Message message = new Message();
                message.setInfo("AAAAAAA");
                MesUtil.setThreadLocal(message);
                new MessageCustomer().display();
            }, "Thread A").start();

            new Thread(() -> {
                Message message = new Message();
                message.setInfo("BBBBBBB");
                MesUtil.setThreadLocal(message);
                new MessageCustomer().display();
            }, "Thread B").start();
        }

}

class Message {
    private String info ;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Message{" +
                "info='" + info + '\'' +
                '}';
    }
}

class MessageCustomer{
    public void display() {
        System.out.println(Thread.currentThread().getName() + ">>> Message is " + MesUtil.getThreadLocal().get());
    }
}

 class MesUtil {
   static ThreadLocal<Message> threadLocal = new ThreadLocal<>();

     public static ThreadLocal<Message> getThreadLocal() {
         return threadLocal;
     }

     public static  void setThreadLocal(Message message) {
         threadLocal.set(message);
     }
 }