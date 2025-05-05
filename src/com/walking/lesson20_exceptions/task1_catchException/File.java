package com.walking.lesson20_exceptions.task1_catchException;

import java.util.Objects;

public class File {
    private final String name;
    private final int size;
    private final InformationType type;

    public File(String name, int size, InformationType type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return """
                file: %s
                size: %d
                type: %s
                """.formatted(name, size, type.name());
    }

    public int getSize() {
        return size;
    }

    public InformationType getType() {
        return type;
    }


}
