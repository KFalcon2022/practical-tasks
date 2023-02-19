package com.walking.lesson49_optional.Task3;

import java.util.Optional;

public abstract class Animal {
    public String getInfo() {
        return "Это %s, он (она) говорит %s".formatted(getType(), say());
    }

    public String getType() {
        //return getClass().getSimpleName(); <- Вот так-то проще бы

        return Optional.ofNullable(null)
                .or(() -> Optional.ofNullable(this)
                        .filter(e -> e.say().equals("meow"))
                )
                .or(() -> Optional.ofNullable(this)
                        .filter(e -> e.say().equals("woof"))
                )
                .or(() -> Optional.ofNullable(this)
                        .filter(e -> e.say().equals("moo"))
                )
                .map(e -> ((Animal) e).getDescription())
                .orElse("хз кто");
    }

    public abstract String say();

    public abstract String getDescription();
}

