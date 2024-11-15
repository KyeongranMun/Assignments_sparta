package lv2;

import java.util.*;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("계산을 시작하시겠습니까? Yes or No : ");
            String input = sc.next();

            if (input.equalsIgnoreCase("No")) {
                break;
            } else if (!input.equalsIgnoreCase("Yes")) {
                System.out.println("잘못된 입력입니다. Yes 혹은 No만 입력할 수 있습니다.");
                continue; //잘못된 입력일 경우 프로그램 처음부터 다시 실행
            }
            System.out.print("숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            System.out.print("연산자를 입력하세요 : ");
            String operator = sc.next();

            System.out.print("숫자를 입력하세요 : ");
            int num2 = sc.nextInt();

            int result = calculator.calculate(num1, num2, operator); //calculate 함수 호출
            System.out.println(num1 + operator + num2 + " = " + result);
            System.out.println("계산 기록 : " + calculator.getHistory());
        }
        sc.close();
    }
}

