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
                }
                result = num1 / num2;
            }
            default -> {
                System.out.println("잘못된 연산자 입니다. 다시 입력해주세요.");
            }
        }
        linkedList.add(result);
        return result;
    }
    public LinkedList<Integer> history() {
        return linkedList;
    }
}
