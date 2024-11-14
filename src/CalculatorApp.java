import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            System.out.print("연산자를 입력하세요 (exit 입력 시 종료됩니다) : ");
            String operator = sc.next();

            if (operator.equals("exit")) {
                System.out.println("프로그램을 종료합니다. ");
                break;
            }

            System.out.print("숫자를 입력하세요 : ");
            int num2 = sc.nextInt();

            int result;

            switch (operator) {
                case "-" -> result = num1 - num2;
                case "+" -> result = num1 + num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        continue;
                    }
                    result = num1 / num2;
                }
                default -> {
                    System.out.println("잘못된 연산자 입니다. 다시 입력해주세요.");
                    continue;
                }
            }
            System.out.println(num1 + operator + num2 + " = " + result);
        }
        sc.close();
    }
}

