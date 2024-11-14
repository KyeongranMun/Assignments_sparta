package lv2;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();


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

            int result = calculator.calculate(num1, num2, operator); //calculate 함수 호출
            System.out.println(num1 + operator + num2 + " = " + result);
        }
        sc.close();
    }
}

