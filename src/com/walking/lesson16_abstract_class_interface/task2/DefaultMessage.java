package com.walking.lesson16_abstract_class_interface.task2;

class DefaultMessage implements Printable {
    
    protected String message = "Default message";

    public void print(){
        Printable.say(this.message);
    }
    
}