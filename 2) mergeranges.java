import java.util.*;

public class MergeRanges {

    public static String mergeRanges(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int startIndex = numbers[0];
        int endIndex = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == endIndex + 1) {
                endIndex = numbers[i];
            } else {
                if (startIndex == endIndex) {
                    result.append(startIndex).append(",");
                } else {
                    result.append(startIndex).append("-").append(endIndex).append(",");
                }
                startIndex = numbers[i];
                endIndex = numbers[i];
            }
        }

        if (startIndex == endIndex) {
            result.append(startIndex);
        } else {
            result.append(startIndex).append("-").append(endIndex);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        String mergedRanges = mergeRanges(numbers);
        System.out.println(mergedRanges);
    }
}
