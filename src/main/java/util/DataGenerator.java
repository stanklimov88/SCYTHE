package util;

import java.util.Random;

public class DataGenerator {

    /** Сгенерировать рандомную цифровую строку указанной длины */
    public static String generateDigitalString(int length) {
        return buildString("digital", length);
    }

    /** Сгенерировать рандомную буквенную строку указанной длины */
    public static String generateLiteralString(int length) {
        return buildString("literal", length);
    }

    /** Сгенерировать рандомную буквенную строку указанной длины, включая буквы в верхнем регистре */
    public static String generateLiteralUpString(int length) {
        return buildString("literalWithUppercase", length);
    }

    /** Сгенерировать рандомную кириллическую строку указанной длины */
    public static String generateLiteralCyrillicString(int length) {
        return buildString("cyrillic", length);
    }

    /** Сгенерировать рандомную кириллическую строку указанной длины, включая буквы в верхнем регистре */
    public static String generateLiteralCyrillicUpString(int length) {
        return buildString("cyrillicWithUppercase", length);
    }

    /** Сгенерировать рандомную строку из спецсимволов указанной длины */
    public static String generateSpecialCharactersString(int length) {
        return buildString("special", length);
    }

    /** Сгенерировать тестовый email */
    public static String testUserEmail() {
            return "testuser-" + generateDigitalString(7) + "@" + PropertyLoader.loadProperties().getProperty("testDomain");
    }

    private static String buildString(String symbolsSet, int length) {
        if (length > 0) {
            String symbols = symbolSetSwitcher(symbolsSet);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(symbols.charAt(new Random().nextInt(symbols.length())));
            }
            return builder.toString();
        } else return "";
    }

    private static String symbolSetSwitcher(String symbolsSet) {
        switch (symbolsSet) {
            case "digital":
                return "0123456789";
            case "literal":
                return "abcdefghijklmnopqrstuvwxyz";
            case "literalWithUppercase":
                return "ABCDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            case "cyrillic":
                return "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
            case "cyrillicWithUppercase":
                return "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯабвгдеёжзийклмнопрстуфхцчшщьыъэюя";
            case "special":
                return "/:<>(){}''@#$%^&*_+!?";
            default:
                return "";
        }
    }
}