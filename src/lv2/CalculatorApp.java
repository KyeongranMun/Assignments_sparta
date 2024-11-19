package lv2;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("계산을 진행하시겠습니까? (Yes or No) : ");
            String input = sc.next();

            if (input.equalsIgnoreCase("no")) {
                break;
            } else if (!input.equalsIgnoreCase("yes")) {
                System.out.print("Yes 또는 No만 입력할 수 있습니다.");
                continue;
            }

            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            System.out.print("연산자를 입력하세요 ( +, -, *, /) : ");
            String operator = sc.next("[+\\-*/]");

            System.out.print("두 번째 숫자를 입력하세요 : ");
            int num2 = sc.nextInt();

            int result = calculator.calculate(num1, num2, operator);

            System.out.println("계산 결과 : " + num1 + operator + num2 + " = " + result);
            System.out.println("계산 기록 : " + calculator.getHistory());
        }
        sc.close();
    }
}
