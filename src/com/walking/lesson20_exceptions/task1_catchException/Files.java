package Lesson20.Task1;

public class Files {
    public final String fileName;
    public final FileTypes fileType;

    public Files (String fileName, FileTypes type, String ext)
    {
        this.fileType = type;
        this.fileName = fileName + type.getExt(ext);
    }
    public Files (String fileName)
    {
        this.fileType = FileTypes.TEXT;
        this.fileName = fileName + FileTypes.TEXT.getExt(".txt");
    }

    @Override
    public String toString() {
        return """
               name: %s
               type: %s
               """.formatted(fileName, fileType);
    }
}
