package src.com.walking.lesson17_enum.task1;

public enum Answers {
    HI("Hi, my friend!"), BYE("Are you going home? Bye!"), HOW_ARE_YOU("How are you, monkey?");

    private String answer;

    Answers(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public static String talkBack(String value) {

        Answers answers = null;

        switch (value) {
            case ("Hi"):
                answers = Answers.HI;
                break;
            case ("Bye"):
                answers = Answers.BYE;
                break;
            case ("How are you"):
                answers = Answers.HOW_ARE_YOU;
                break;
            default:
                System.out.println("Nope");
        }

        return answers.getAnswer();

    }
}
