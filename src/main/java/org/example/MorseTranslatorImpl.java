package org.example;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslatorImpl implements MorseTranslator {
    private final Map<String, Character> morseToChar = new HashMap<>();
    private final Map<Character, String> charToMorse = new HashMap<>();

    public MorseTranslatorImpl() {
        initializeMorseDictionary();
    }

    private void initializeMorseDictionary() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < letters.length; i++) {
            charToMorse.put(letters[i].charAt(0), morse[i]);
            morseToChar.put(morse[i], letters[i].charAt(0));
        }

        charToMorse.put(' ', "/");
        morseToChar.put("/", ' ');
    }

    @Override
    public String decode(String morseCode) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = morseCode.split(" / ");
        for (String word : words) {
            for (String symbol : word.split(" ")) {
                decodedMessage.append(morseToChar.getOrDefault(symbol, '?'));
            }
            decodedMessage.append(' ');
        }
        return decodedMessage.toString().trim();
    }

    @Override
    public String encode(String source) {
        StringBuilder encodedMessage = new StringBuilder();
        source = source.toUpperCase();
        for (char c : source.toCharArray()) {
            String morse = charToMorse.getOrDefault(c, "?");
            encodedMessage.append(morse).append(' ');
        }
        return encodedMessage.toString().trim();
    }
}
