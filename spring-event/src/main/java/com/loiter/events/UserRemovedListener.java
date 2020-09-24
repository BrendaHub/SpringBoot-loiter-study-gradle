package com.loiter.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 12:17 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
public class UserRemovedListener {


    @EventListener
    ReturnedEvent handleUserRemoveEvent(UserRemoveEvent userRemoveEvent) {
        Display.show(userRemoveEvent.getName());
        return new ReturnedEvent();
    }

    @EventListener
    void handleReturnedEvent(ReturnedEvent event) {
        Display.show("ReturnedEvent Received");
    }

    @EventListener(condition = "#event.name eq 'reflectoring'")
    void handleConditionalListener(UserRemoveEvent event) {
        Display.show(event.getName() + " Contitional ");
    }

    @TransactionalEventListener(condition = "#event.name eq 'reflectoring'", phase = TransactionPhase.AFTER_COMPLETION)
    void handleAfterUserRemoved(UserRemoveEvent event) {
        Display.show(event.getName() + " @TransactionalEventListener ");
    }
}
