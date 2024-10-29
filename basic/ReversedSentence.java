package Basic;

public class ReversedSentence {
    public static void main(String[] args) {
        String sentence = "This is the sentence that I want to start with";
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = 0; i < sentence.split(" ").length; i++) {
            int length = sentence.split(" ").length;
            reversedSentence.append(sentence.split(" ")[length - 1 - i] + " ");
        }

        System.out.println(reversedSentence.toString().trim());
    }
}