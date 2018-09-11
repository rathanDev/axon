package org.jana.message;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.jana.message.command.CreateMessageCommand;
import org.jana.message.command.MarkReadMessageCommand;
import org.jana.message.event.MessageCreatedEvent;
import org.jana.message.event.MessageReadEvent;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

public class MessageAggregate {

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public MessageAggregate(CreateMessageCommand command) {
        apply(new MessageCreatedEvent(command.getId(), command.getText()));
    }

    @EventHandler
    public void on(MessageCreatedEvent event) {
        this.id = event.getId();
    }

    @CommandHandler
    public void markRead(MarkReadMessageCommand command) {
        apply(new MessageReadEvent(id));
    }

    public MessageAggregate(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
