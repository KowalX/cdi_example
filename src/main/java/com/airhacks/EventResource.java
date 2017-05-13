package com.airhacks;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("event")
public class EventResource {

    private static final Logger LOG = LoggerFactory.getLogger(EventResource.class);

    @Inject
    private Event<ExampleEvent> exampleEventSender;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("fire")
    public String fire(@QueryParam("content") String content) {
        LOG.info("Sending event with content = {}.", content);

        ExampleEvent exampleEvent = new ExampleEvent();
        exampleEvent.setContent(content);

        exampleEventSender.fire(exampleEvent);

        return "Event has been sent!";
    }
}
