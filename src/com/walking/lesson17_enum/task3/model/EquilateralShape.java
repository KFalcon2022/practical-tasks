package com.walking.lesson17_enum.task3.model;

public enum EquilateralShape {
    Triagle{
        @Override
        public String getStringShape(int length) {
            String stringShape = "";
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i; j++) {
                    stringShape += " ";
                }

                stringShape += "/";

                for (int j = 0; j < i * 2; j++) {
                    stringShape += " ";
                }

                stringShape += "\\" + "\n";
            }

            stringShape += " ";

            for (int i = 0; i < length; i++) {
                stringShape += "--";
            }
            return stringShape;
        }
    },
    Square{
        @Override
        public String getStringShape(int length) {
            String stringShape = "";
            for (int i = 0; i < length; i++) {
                stringShape += "-";
            }
            for (int j = 2; j < length; j++) {
                stringShape+="\n";
                stringShape+="|";
                for (int i = 2; i < length; i++) {
                    stringShape+=" ";
                }
                stringShape+="|";
            }
            stringShape+="\n";
            for (int i = 0; i < length; i++) {
                stringShape+="-";
            }
            stringShape+="\n";
            return stringShape;
        }
    };

    public abstract String getStringShape(int length);
}
