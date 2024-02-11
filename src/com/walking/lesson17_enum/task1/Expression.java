package com.walking.lesson17_enum.task1;

public enum Expression {
    HI("Hi","Hello"),
    BYE("Bye","GoodBye"),
    HOW_ARE_YOU("How are you","How are you doing"),
    UNKNOWN(null,"Unknown message");

    private final String inputExpression;
    private final String outputExpression;
    Expression (String input, String output){
        this.inputExpression=input;
        this.outputExpression=output;
    }
    public String getInputExpression(){return inputExpression;}
    public String getOutputExpression(){return outputExpression;}
    public static Expression findExpression(String inputMessage){
        if (inputMessage==null)
            return UNKNOWN;
        for (Expression message : Expression.values()){
            if (inputMessage.equals(message.inputExpression))
                return message;
        }
        return UNKNOWN;
    }
}
