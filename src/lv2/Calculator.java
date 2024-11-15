package lv2;

import java.util.LinkedList;

public class Calculator {
    private final LinkedList<Integer> linkedList = new LinkedList<>();
    public int calculate(int num1, int num2, String operator) { //수정 불가
        int result = 0;

        switch (operator) {
            case "-" -> result = num1 - num2;
            case "+" -> result = num1 + num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    return result; //예외 1 : 0으로 나눌 경우 계산 중단
                }
                result = num1 / num2;
            }
            default -> {
                System.out.println("잘못된 연산자 입니다. 다시 입력해주세요.");
                return result; // 예외 2 : 잘못된 연산자 입력할 경우 계산 중단
            }
        }
        if (linkedList.size() >= 5) {
            linkedList.pollFirst(); //결과 5개가 쌓이면 가장 먼저 들어간 데이터 삭제
        }
        linkedList.add(result);
        return result; //계산 결과 추가
    }
    public LinkedList<Integer> history() {
        return linkedList;
    }
}
