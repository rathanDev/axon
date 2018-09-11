package org.jana.message.event;

public class MessageReadEvent {

    private String id;

    public MessageReadEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
