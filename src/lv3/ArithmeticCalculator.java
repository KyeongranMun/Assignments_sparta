package lv3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final LinkedList<Double> results = new LinkedList<>();

    //계산 메서드 제네릭 구현
    public double calculate(T num1, T num2, OperatorType operator) {
        double operand1 = num1.doubleValue();
        double operand2 = num2.doubleValue();
        double result;

        switch (operator) {
            case ADD -> result = operand1 + operand2;
            case SUBTRACT -> result = operand1 - operand2;
            case MULTIPLY -> result = operand1 * operand2;
            case DIVIDE -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("잘못된 연산자 입니다.");
        }
        addResult(result);
        return result;
    }
    //결과 저장, 결과가 5개 이상 쌓이면 가장 첫 번째 데이터를 삭제
    private void addResult(double result) {
        if (results.size() >= 5) {
            results.pollFirst();
        }
        results.add(result);
    }
    //기록 조회 getter메서드
    public List<Double> getHistory() {
        return List.copyOf(results);
    }
    //특정 조건(입력한 값보다 큰 결과 조회)에 맞는 결과 조회 - 람다 스트림
    public List<Double> filterResultsBiggerNum(double value) {
        return results.stream()
                .filter(result -> result > value) //사용자가 입력한 value값보다 큰 결과값 필터
                .collect(Collectors.toList()); //collect 메서드 : 결과를 리스트로 수집
    }
}
