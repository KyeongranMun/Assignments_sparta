package lv2;

import java.util.LinkedList;

public class Calculator {
    private final LinkedList<Integer> linkedList = new LinkedList<>();

    public int calculate(int num1, int num2, String operator) {
        int result=0;

        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                }
                result = num1 / num2;
            }
            default -> {
                System.out.println("잘못된 연산자 입니다. ( +, -, *, /) 만 입력할 수 있습니다.");
            }
        }
        addResult(result);
        return result;
    }
    public LinkedList<Integer> getHistory() {
        return new LinkedList<>(linkedList);
    }
    private void addResult(int result) {
        if (linkedList.size() >= 5) {
            linkedList.pollFirst();
        }
        linkedList.add(result);
    }
}