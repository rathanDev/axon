package org.jana.message;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.jana.message.command.CreateMessageCommand;
import org.jana.message.event.MessageCreatedEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class MessageAggregateTest {

    private FixtureConfiguration<MessageAggregate> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<MessageAggregate>(MessageAggregate.class);
    }

    @Test
    public void testCreate() {
        String eventText = "Hello, how is your day?";
        String id = UUID.randomUUID().toString();
        fixture.given()
                .when(new CreateMessageCommand(id, eventText))
                .expectEvents(new MessageCreatedEvent(id, eventText));
    }

    @Test
    public void testRead() throws Exception {

    }

}