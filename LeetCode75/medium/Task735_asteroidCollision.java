package LeetCode75.medium;

import java.util.Arrays;

// 100%
public class Task735_asteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {

        int resultIndex = -1;
        int asteroidIndex = 0;

        int[] result = new int[asteroids.length];


        while (asteroidIndex < asteroids.length) {
            if (resultIndex < 0) {
                resultIndex = 0;
                result[0] = asteroids[asteroidIndex];
                asteroidIndex++;
                continue;
            }

            if (asteroids[asteroidIndex] >= 0) {
                result[++resultIndex] = asteroids[asteroidIndex++];
            } else {
                if (result[resultIndex] >= 0) {
                    if (asteroids[asteroidIndex] * -1 < result[resultIndex]) {
                        asteroidIndex++;
                    } else if (asteroids[asteroidIndex] * -1 > result[resultIndex]) {
                        resultIndex--;
                    } else {
                        resultIndex--;
                        asteroidIndex++;
                    }
                } else {
                    result[++resultIndex] = asteroids[asteroidIndex++];
                }
            }
        }

        return Arrays.copyOf(result, resultIndex + 1);
    }
}
