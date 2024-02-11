package com.walking.lesson20_exceptions.task1_throwsException.models;

public enum FileType {
    Text(0),
    Image(1),
    Video(2),
    Music(3);
    private final int ordinal;
    private FileType(int ordinal){
        this.ordinal=ordinal;
    }
    private int getOrdinal(){
        return ordinal;
    }
    public static FileType getOrdinalType(int ordinal) throws Exception {
        for (FileType type : FileType.values()){
            if (type.getOrdinal()==ordinal){
                return type;
            }
        }
        throw new Exception("There is no file type with input number: "+ordinal);
    }
}
