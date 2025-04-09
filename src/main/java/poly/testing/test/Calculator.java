package poly.testing.test;

public class Calculator {
    //lab2, 3
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return (double) a / b;
    }

    //lab3
    public int parseNumber(String input) {
        if (input == null) {
            throw new NullPointerException("Lỗi: Dữ liệu nhập vào là null!");
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Lỗi: Giá trị nhập vào không phải là số hợp lệ!");
        }
    }
}
