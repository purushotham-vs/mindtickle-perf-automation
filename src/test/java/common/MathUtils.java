package common;

import java.util.Random;

public class MathUtils {

    public static String generateRandomBookId() {
        return String.valueOf(new Random().nextInt(100)); // Generate a random book ID between 0 and 99
    }
}
