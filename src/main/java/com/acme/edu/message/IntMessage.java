package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;

public class IntMessage extends Message {
    private int message;

    public IntMessage(int message, Decorator decorator) {
        super (decorator);
        this.message = message;
    }

    @Override
    public Message accumulate(Message nextMessage) {
        IntMessage downcastedMessage = (IntMessage) nextMessage;
        return new IntMessage(this.message + downcastedMessage.message, this.getDecorator());
    }

    @Override
    public String getDecoratedMessage() {
        getDecorator().setMessage(Integer.toString(message));
        return getDecorator().getDecoratedMessage();
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }
}
