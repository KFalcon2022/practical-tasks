package com.walking.lesson20_exceptions.task1_catchException.model;

public class File {
    private String name;
    private long size;
    private MediaType mediaType;

    public File() {
    }

    public File(String name, long size, MediaType mediaType) {
        this.name = name;
        this.size = size;
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        return """
                name: %s
                size: %d
                mediaType: %s
                """.formatted(
                name, size, mediaType.name());
    }
}
