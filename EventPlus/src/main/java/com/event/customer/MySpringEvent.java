package com.event.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

public class MySpringEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param message the object on which the event initially occurred (never {@code null})
     */
    public MySpringEvent(String message) {
        super(message);
    }

    @Override
    public String getSource() {
        return (String)super.getSource();
    }

    public String getMessage() {
        return getSource();
    }
}
