package com.ucc.application.Models;

import java.util.Objects;

public class MessageModel {

    private String message;
    private String from;


    public MessageModel() {
    }

    public MessageModel(String message, String from) {
        this.message = message;
        this.from = from;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public MessageModel message(String message) {
        setMessage(message);
        return this;
    }

    public MessageModel from(String from) {
        setFrom(from);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessageModel)) {
            return false;
        }
        MessageModel messageModel = (MessageModel) o;
        return Objects.equals(message, messageModel.message) && Objects.equals(from, messageModel.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, from);
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", from='" + getFrom() + "'" +
            "}";
    }

    
}
