package com.loiter;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

public class DemoEvent {
    public static void main(String[] args) {
        EventObservable eventObservable = new EventObservable();
        // 添加事情监听者
        eventObservable.addObserver(new ObserverDemo());
        // 发起事件动作
        eventObservable.notifyObservers(new EventObject("Hello, Event! Eventobject"));
    }

    static class EventObservable extends Observable {
        protected void setChanaged() {
            super.setChanged(); // 由于父类的setChanged()方法是 protected, 但是Observable 要有事件发起就需要有chanaged发生
        }

        public void notifyObservers(Object arg) {
            setChanaged();
            super.notifyObservers(arg);
            clearChanged();
        }
    }

    static class ObserverDemo implements Observer, EventListener{

        @Override
        public void update(Observable o, Object eventObject) {
            EventObject eventObject1 = (EventObject) eventObject;
            System.out.println("事件监听到动作： " + eventObject1.getSource() + "   " );
        }

    }
}
