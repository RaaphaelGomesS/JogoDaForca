package application;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        String word = newWord();

        char[] mockedWord = mockedWord(word);

        JOptionPane.showMessageDialog(null, "Você tem 15 chances para descobrir a palavra:");

        List<Character> tries = new ArrayList<>();

        int n = 0;

        while (n < 15) {

            char character = Character.toUpperCase(JOptionPane.showInputDialog("Digite uma letra: ").charAt(0));

            if (!hasTheCharacter(character, word)) {

                tries.add(character);

                JOptionPane.showMessageDialog(null, "A palavra não possui essa letra, tentativas: " + tries);
            } else {

                mockedWord = addCharacterInThePosition(word, mockedWord, character);

                JOptionPane.showMessageDialog(null, "Boa! A palavra possui a letra: " + Arrays.toString(mockedWord));

                String guess = JOptionPane.showInputDialog("De um palpite:").toUpperCase();

                if (guess.equals(word)) {
                    JOptionPane.showMessageDialog(null, "Parabéns você acertou! A palavra era: " + word);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Está errado, tente novamente");
                }
            }

            n++;
        }

        if (n == 15) {
            JOptionPane.showMessageDialog(null, "Acabaram as chances, a palavra era: " + word);
        }
    }

    private static char[] mockedWord(String word) {

        String mockedWord = "";

        for (int i = 0; i < word.length(); i++) {
            mockedWord += "_";
        }

        return mockedWord.toCharArray();
    }

    private static String newWord() {

        String[] words = new String[]{"CADEIRA", "COMPUTADOR", "TEMPO", "CAFE", "LAPIS", "LIVRO", "MUSICA", "JOGO", "CODIGO", "FONE"};

        int random = (int) (Math.random() * 10);

        return words[random];
    }

    private static boolean hasTheCharacter(char character, String word) {

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == character) {
                return true;
            }
        }

        return false;
    }

    private static boolean[] positionOfCharacter(char character, String word) {

        boolean[] positions = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == character) {
                positions[i] = true;
            } else {
                positions[i] = false;
            }
        }

        return positions;
    }

    private static char[] addCharacterInThePosition(String word, char[] mockedWord, char character) {

        boolean[] positions = positionOfCharacter(character, word);

        char[] aux = mockedWord;

        for (int i = 0; i < mockedWord.length; i++) {

            if (aux[i] == '_') {
                if (positions[i]) {
                    aux[i] = character;
                }
            }
        }

        return aux;
    }
}
