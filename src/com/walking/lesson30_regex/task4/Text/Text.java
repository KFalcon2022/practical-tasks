package com.walking.lesson30_regex.task4.Text;

public class Text {
    private final String srcText;

    private TextElement topTextElement;

    public Text(String srcText) {
        this.srcText = srcText;
    }

    public void parseText() {
        topTextElement = new TextElement(this.srcText, TextElementType.TEXT);
        topTextElement.parse();
    }

    public String getProcessedText() {
        return topTextElement.buildText();
    }

    class TextElement {
        private TextElement[] subTextElements;
        private String srcText;
        private final TextElementType textElementType;

        public TextElement(String srcText, TextElementType textElementType) {
            this.srcText = srcText;
            this.textElementType = textElementType;
        }

        public void setSubTextElement(TextElement[] subTextElements) {
            this.subTextElements = subTextElements;
        }

        public String getSrcText() {
            return srcText;
        }

        public void parse() {

            if (textElementType.srcDelimeter == null) {
                //нет разделителя -выходим
            } else {          //есть разделитель - рекурсивно разбираем текушие части
                //разбор самого элемента, заполнение subTextElement
                String[] subText = srcText.split(textElementType.srcDelimeter);

                int nextId = textElementType.id + 1;
                TextElementType nextTextElementType = TextElementType.getById(nextId);
                subTextElements = new TextElement[subText.length];
                int i = 0;
                for (String subTextSingle : subText) {
                    subTextElements[i] = new TextElement(subTextSingle, nextTextElementType);
                    subTextElements[i].parse();
                    i++;
                }
            }
        }

        public String getOutString() {
            return null;
        }

        public String buildText() {
            if (subTextElements == null){
                return srcText;
            }

            StringBuilder text = new StringBuilder();
            int i = 1;
            for (TextElement subTextElement : subTextElements){
                text.append(subTextElement.buildText());
                if (textElementType.trgDelimeter != null){
                    text.append(textElementType.trgDelimeter);
                }

            }
            return text.toString().trim();
        }
    }

    enum TextElementType {
        TEXT(0, "\\n", "\n"),
        PARAGRAPH(1, "\\.{3}|\\?!|\\?|!|\\.", "."),
        SENTENCE(2, "\\s+|\\t+|,\\s*|:\\s*|-\\s*|;\\s*", " "),
        WORD(3);

        private final int id;
        private final String srcDelimeter;
        private final String trgDelimeter;

        TextElementType(int id, String srcDelimeter, String trgDelimeter) {
            this.srcDelimeter = srcDelimeter;
            this.trgDelimeter = trgDelimeter;
            this.id = id;
        }
        TextElementType(int id) {
            this(id, null, null);
        }

        public String getSrcDelimeter() {
            return srcDelimeter;
        }

        public String getTrgDelimeter() {
            return trgDelimeter;
        }

        public int getId() {
            return id;
        }

        public static TextElementType getById(int id) {
            TextElementType[] textElementTypes = TextElementType.values();
            for (TextElementType textElementType : textElementTypes) {
                if (textElementType.id == id) {
                    return textElementType;
                }
            }
            return null;
        }
    }
}
