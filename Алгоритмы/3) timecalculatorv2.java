import java.util.concurrent.TimeUnit;

public class TimeCalculatorV2 {

    public static String formatTime(long seconds) {
        long[] timeUnits = { TimeUnit.DAYS.toSeconds(365), TimeUnit.HOURS.toSeconds(1), TimeUnit.MINUTES.toSeconds(1), TimeUnit.SECONDS.toSeconds(1) };
        String[] timeNames = {"год", "час", "минута", "секунда"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < timeUnits.length; i++) {
            long value = timeUnits[i];
            long count = seconds / value;
            if (count != 0) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                if (count > 1) {
                    result.append(count).append(" ").append(timeNames[i]).append("ы");
                } else {
                    result.append(count).append(" ").append(timeNames[i]);
                }
                seconds %= value;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        long seconds = 62;
        String formattedTime = formatTime(seconds);
        System.out.println(seconds + " секунд = " + formattedTime);

        seconds = 3662;
        formattedTime = formatTime(seconds);
        System.out.println(seconds + " секунд = " + formattedTime);
    }
}
