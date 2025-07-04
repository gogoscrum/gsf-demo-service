package com.shimi.gsf.demo.book.event;

import org.springframework.context.ApplicationEvent;

/**
 * BaseDemoEvent is an abstract root class that represents a base event in the demo application.
 * It extends the ApplicationEvent class from the Spring framework. All demo events should extend this class.
 */
@SuppressWarnings("serial")
public abstract class BaseDemoEvent extends ApplicationEvent {
    public BaseDemoEvent(Object source) {
        super(source);
    }
}
