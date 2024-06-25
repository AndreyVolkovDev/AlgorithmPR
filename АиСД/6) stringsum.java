public class Main {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        String result = addStrings(num1, num2);
        System.out.println("Результат: " + result);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int sum = x1 + x2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
            p1--;
            p2--;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
