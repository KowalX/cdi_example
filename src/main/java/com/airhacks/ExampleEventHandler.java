package com.airhacks;

import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleEventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleEventHandler.class);

    public void onExampleEvent(@Observes ExampleEvent exampleEvent) {
        LOG.info("Handling event with content = {}.", exampleEvent.getContent());
    }
}
