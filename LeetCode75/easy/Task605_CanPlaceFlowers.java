package LeetCode75.easy;

public class Task605_CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        if (flowerbed.length == 1) {
            return (flowerbed[0] == 1 && n == 0) || (flowerbed[0] == 0 && n <= 1);
        }

        int newCount = 1;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0) {
                newCount++;
                if (newCount == 3) {
                    count++;
                    if (i == flowerbed.length - 2 && flowerbed[flowerbed.length - 1] == 0) {
                        count++;
                        continue;
                    }
                    newCount = 1;
                }
            } else {
                if (flowerbed.length >= 3 && i == flowerbed.length - 3) {
                    newCount = 1;
                    continue;
                }
                newCount = 0;
            }
        }

        return n >= count;
    }
}
