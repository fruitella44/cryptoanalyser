package ua.com.javarush.darvin.module1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BruteForce {
    private static final String ALPHABET  = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,«»\"\\:!? ";
    private static final int ALPHABET_LENGTH = ALPHABET.length();

    private static final String[] FAMOUS_WORDS = {"и", "в", "не", "на", "я", "быть", "он", "с", "что", "а", "по",
            "это", "она", "этот", "к", "но", "они", "мы", "как", "из", "у", "который", "то", "за", "что", "свой",
            "весь", "год", "от", "так", "о", "для", "ты", "же", "все", "тот", "мочь", "вы", "человек", "его", "сказать",
            "только", "или", "ещё", "бы", "себя", "один", "как", "уже", "до", "время", "если", "сам", "когда", "другой",
            "вот", "говорить", "наш", "мой", "знать", "стать", "при", "чтобы", "дело", "жизнь", "кто", "первый", "очень",
            "два", "день", "ее", "новый", "рука", "даже", "во", "сто", "раз", "где", "там", "под", "можно", "ну",
            "какой", "после", "их", "работа", "без", "самый", "потом", "надо", "хотеть", "ли", "слово", "идти",
            "большой", "должен", "место", "иметь", "ничто"};

    public static final Pattern SPLIT_STRING = Pattern.compile("[\\p{P} \\t\\n\\r]");

    public static List<String> getFamousWords() {
        return Arrays.asList(FAMOUS_WORDS);
    }

    public static StringBuilder bruteForce(String line, int key) {
        StringBuilder inputText = new StringBuilder(Main.readFile(line).toString().toLowerCase());
        StringBuilder outputText = new StringBuilder();

        while (key > 0 && key < ALPHABET_LENGTH) {

            for (int i = 0; i < inputText.length(); i++) {
                int index = ALPHABET.indexOf(inputText.charAt(i));
                int shiftIndexBack = (index - key) % ALPHABET_LENGTH;

                if (shiftIndexBack < 0) {
                    shiftIndexBack = ALPHABET.length() + shiftIndexBack;
                }

                char decoding = ALPHABET.charAt(shiftIndexBack);
                outputText.append(decoding);
            }

            String[] words = outputText.toString().split(SPLIT_STRING.toString());

            for (String word : words) {
                if (getFamousWords().contains(word)) {
                    return outputText;
                }
            }
            key++;
            outputText = new StringBuilder();
        }

        return outputText;
    }

}
