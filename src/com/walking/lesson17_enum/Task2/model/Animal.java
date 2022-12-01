package com.walking.lesson17_enum.Task2.model;

public enum Animal {

        CAT("meow"),DOG("woof"),COW("moo");
        public String sound;
        Animal(String sound){
            this.sound=sound;
        }
        public String getSound(){
            return sound;
        }


}
