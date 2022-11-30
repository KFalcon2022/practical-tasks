package src.com.walking.lesson16_abstract_class_interface.task2;

public interface ComeBack {
    public static final String HI = "hi";
    public static final String BYE = "Good bye";
    public static final String HOW_ARE_YOU = "How are your doing";

    static String saySomething(String request) {

        if (request.contains("Hi")) {

            return HI;

        } else if (request.contains("Bye")) {

            return BYE;

        } else if (request.contains("How are you")) {

            return HOW_ARE_YOU;
        }

        return "Nothing to say";

    }


}
