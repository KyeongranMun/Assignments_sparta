package lv3;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                System.out.print("계산을 시작하시겠습니까? (Yes/No): ");
                String input = sc.next();

                if (input.equalsIgnoreCase("No")) {
                    break;
                } else if (!input.equalsIgnoreCase("Yes")) {
                    System.out.println("잘못된 입력입니다. Yes 또는 No만 입력해주세요.");
                    continue;
                }

                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();

                System.out.print("연산자를 입력하세요 (+, -, *, /): ");
                String operatorInput = sc.next();
                OperatorType operator = OperatorType.fromSymbol(operatorInput);

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();

                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

                //계산 기록 출력
                System.out.println("계산 기록: " + calculator.getHistory());

                //입력 값보다 큰 결과 필터링
                System.out.print("입력한 값보다 큰 결과를 조회하려면 값을 입력하세요: ");
                double filterValue = sc.nextDouble();
                System.out.println("조회된 결과: " + calculator.filterResultsBiggerNum(filterValue));
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("오류: " + e.getMessage());
            }
        }

        sc.close();
    }
}
