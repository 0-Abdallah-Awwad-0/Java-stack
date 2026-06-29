import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {

        Random randMachine = new Random();

        ArrayList<Integer> rolls = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {

            int randomNumber = randMachine.nextInt(20) + 1;

            rolls.add(randomNumber);

        }


        return rolls;
    }
    public String getRandomLetter() {

        Random randMachine = new Random();

        String[] letters = {
                "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"
        };

        int randomIndex = randMachine.nextInt(26);

        return letters[randomIndex];
    }
    public String generatePassword() {

        String password = "";

        for (int i = 0; i < 8; i++) {

            password += getRandomLetter();

        }

        return password;
    }
    public String[] getNewPasswordSet(int length) {

        String[] passwords = new String[length];

        for (int i = 0; i < length; i++) {

            passwords[i] = generatePassword();

        }

        return passwords;
    }
}