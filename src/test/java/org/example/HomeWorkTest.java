package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    MorseTranslator translator = new MorseTranslatorImpl();

    @Test
    void testEncode() {
        assertEquals(".... . .-.. .-.. ---", translator.encode("HELLO"));
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", translator.encode("HELLO WORLD"));
    }

    @Test
    void testDecode() {
        assertEquals("HELLO", translator.decode(".... . .-.. .-.. ---"));
        assertEquals("HELLO WORLD", translator.decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    void testEncodeDecode() {
        String original = "HELLO WORLD";
        String morse = translator.encode(original);
        assertEquals(original, translator.decode(morse));
    }

    @Test
    void testInvalidSymbols() {
        assertEquals("?", translator.encode("@"));
        assertEquals("?", translator.decode("...---..."));
    }


}