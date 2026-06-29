import java.util.ArrayList;
import java.util.Arrays;
public class TestPuzzleJava {

    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();

        System.out.println(randomRolls);
        String randomLetter = generator.getRandomLetter();

        System.out.println(randomLetter);
        String password = generator.generatePassword();

        System.out.println(password);
        String[] passwordSet = generator.getNewPasswordSet(5);

        System.out.println(Arrays.toString(passwordSet));

    }

}