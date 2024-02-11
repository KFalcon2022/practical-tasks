package com.walking.lesson20_exceptions.task1_throwsException.models;

public class File {
    private final String name;
    private final int size;
    private final FileType fileType;
    private final int hashCode;

    public File (String name, int size, FileType fileType){
        this.name=name;
        this.size=size;
        this.fileType=fileType;
        System.out.print("New file created: "+this.name+", file type: "+this.fileType+"\n");
        hashCode=hashCode();
    }
    public String getName(){
        return name;
    }
    public int getSize(){
        return size;
    }
    public FileType getFileType(){
        return fileType;
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (!getClass().equals(obj.getClass())){
            return false;
        }
        File file = (File) obj;
        if (this.name.equals(file.name)&&this.fileType.equals(file.fileType)) {
            return true;
        }
            else return false;
        }
        @Override
    public int hashCode(){
        if (hashCode==0){
            int result =name.hashCode();
            result+=fileType.hashCode();
            return result;
        }
        else return hashCode;
        }
        @Override
    public String toString() {
            String result = "File name: " + getName() + "\n";
            result += "File size: " + getSize() +" Kb"+ "\n";
            result += "File type: " + getFileType() + "\n";
            return result;
        }
    }
