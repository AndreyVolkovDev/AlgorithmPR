public class IntervalCount {
    public static void main(String[] args) {
        int[][] intervals = { {1, 2}, {6, 10}, {11, 15} };

        int totalNumbers = countNumbersInIntervals(intervals);

        // Выводим результат
        System.out.println("Количество чисел в интервале: " + totalNumbers);
    }

    public static int countNumbersInIntervals(int[][] intervals) {
        int total = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            total += (end - start);
        }

        return total;
    }
}
