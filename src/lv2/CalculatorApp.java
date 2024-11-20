package lv2;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); //Calculator 클래스 - calculate 객체 생성

        while (true) {
            System.out.print("계산을 진행하시겠습니까? (Yes or No) : "); //프로그램 시작 시 계산 진행 여부 선택
            String input = sc.next();

            if (input.equalsIgnoreCase("no")) { //equalsIgnoreCase 메서드로 사용자가 대소문자 구분없이 입력해도 조건 인식
                break;
            } else if (!input.equalsIgnoreCase("yes")) {
                System.out.print("Yes 또는 No만 입력할 수 있습니다.");
                continue; //리팩토링으로 if문을 간단하게 수정
            }

            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            System.out.print("연산자를 입력하세요 ( +, -, *, /) : ");
            String operator = sc.next("[+\\-*/]"); //정규표현식을 활용하여 지정한 사칙연산기호가 아닌 문자나 숫자가 입력되면 프로그램 종료

            System.out.print("두 번째 숫자를 입력하세요 : ");
            int num2 = sc.nextInt();

            int result = calculator.calculate(num1, num2, operator); //calculate 함수 호출

            System.out.println("계산 결과 : " + num1 + operator + num2 + " = " + result);
            System.out.println("계산 기록 : " + calculator.getHistory()); //getHistory메서드를 사용해 결과 기록 조회
        }
        sc.close();
    }
}
