package local.Finaltask;

import java.util.*;
import java.util.function.*;
public class Main {
    public static void main(String[] args) {
        // Random variables
        String randomFrom = "slkjdhoijhdskfng"; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "lmkwnkywnwlt";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 6198;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

        // Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        myassert (firstMessage.getFrom().equals("Robert Howard") , "Wrong firstMessage from address");
        myassert (firstMessage.getTo().equals("H.P. Lovecraft") , "Wrong firstMessage to address");
        myassert (firstMessage.getContent().endsWith("Howard!") , "Wrong firstMessage content ending");

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

        // Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();


        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";


    }

    public static void myassert(boolean statement, String errmsg){
        if (!statement) System.out.println(errmsg);
    }

    public interface IMessage<T> {
        String getFrom();
        String getTo();
        T getContent();
    }

    public static class MailMessage implements IMessage<String> {
        private final String from;
        private final String to;
        private final String content;

        public MailMessage(String from, String to, String content){
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom(){
            return from;
        }

        public String getTo(){
            return to;
        }

        public String getContent(){
            return content;
        }
    }

    public static class Salary implements IMessage<Integer>{
        private String from;
        private String to;
        private Integer content;

        public Salary(String from, String to, Integer content){
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public final String getFrom() {
            return from;
        }

        public final String getTo() {
            return to;
        }

        public final Integer getContent(){
            return content;
        }
    }

    public static class MailService<T> implements Consumer<IMessage<T>> {
        private static class MyHashMap<K,V> extends HashMap<K,V>{
            @Override
            public V get(Object key){
                V temp = super.get(key);
                try {
                    if (temp == null) temp = (V)Collections.emptyList();
                } catch (ClassCastException e) {}
                return temp;
            }
        }

        private Map<String, List<T>> mailBox;

        public MailService(){
            mailBox = new MyHashMap<>();
        }

        public Map<String, List<T>> getMailBox(){
            return mailBox;
        }

        @Override
        public void accept(IMessage<T> t){
            if(mailBox.containsKey(t.getTo())) {
                List<T> val;
                val = mailBox.get(t.getTo());
                val.add(t.getContent());
                mailBox.put(t.getTo(), val);
            } else {
                List<T> val;
                val = new LinkedList<>();
                val.add(t.getContent());
                mailBox.put(t.getTo(), val);
            }
        }
    }
}

/*
Обратите внимание, что класс MailService ведет себя как Consumer, что общего у MailMessage и Salary и, как реализовать
одинаковое поведение MailService относительно их. Имейте в виду, что map.get(null).equals(List<T>)
в ассертах вызовет NullPointerException, значит он тоже требует переопределения. Примечательно,
что внутри одного из переопределяемых методов должно быть обращение к одноименному родительскому методу.. Всем Удачи, я закончил..
 */