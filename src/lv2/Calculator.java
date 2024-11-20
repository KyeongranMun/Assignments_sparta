package lv2;

import java.util.LinkedList;

public class Calculator {
    private final LinkedList<Integer> linkedList = new LinkedList<>(); //수정 불가

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
        addResult(result); //add메서드로 계산 결과 linkedList에 저장
        return result;
    }
    public LinkedList<Integer> getHistory() { //getter메서드로 계산 기록 불러오기
        return new LinkedList<>(linkedList); //외부에서 수정할 수 없도록 linkedList를 복제한 새로운 리스트 인스턴스 반환
    }
    private void addResult(int result) { //setter메서드로 linkedList에 새로운 계산 결과 추가, 접근제어자 private으로 외부에서 호출되어 저장 기록에 값을 추가하거나 수정할 수 없게 캡슐화
        if (linkedList.size() >= 5) {
            linkedList.pollFirst(); //최대 5개 기록이 초과되면 가장 먼저 들어간 데이터 삭제
        }
        linkedList.add(result);
    }
}