package com.loiter.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 12:05 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
public class Publisher {

    private final ApplicationEventPublisher publisher;

    Publisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    void publishEvent (){
        // Async Event
        publisher.publishEvent("I'm Async");

        // @EventListern Annotated and ApplicationListener
        publisher.publishEvent(new UserCreateEvent(this, "Lucario"));
        publisher.publishEvent(new UserRemoveEvent("Lucario"));

        // Contitional Listener
        publisher.publishEvent(new UserCreateEvent(this, "reflectoring"));
        publisher.publishEvent(new UserRemoveEvent( "reflectoring"));
    }
}
