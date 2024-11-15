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
                    return result; //예외 1. 0으로 나눌 경우 계산 중단
                }
                result = num1 / num2;
            }
            default -> System.out.println("잘못된 연산자 입니다. 다시 입력해주세요.");//예외 2. 잘못된 연산자 입력 시 계산 중단
        }
        //setter 메서드 추가
            addResult(result);//계산 결과 linkedList에 저장
            return result;
        }
        //getter 메서드 추가
        public LinkedList<Integer> getHistory() { //계산 기록 조회
            return new LinkedList<>(linkedList); //getHistory 메서드에서 new 키워드로 새로운 LinkedList 인스턴스 생성(linkedList를 복사).메인에서 기록 조회만 가능하고 수정은 불가
        }
        private void addResult(int result){ //addResult 메서드에 접근하지 못하도록 private 접근제어자 사용
            if (linkedList.size() >= 5) {
                linkedList.pollFirst(); //결과 5개가 쌓이면 가장 먼저 들어간 데이터 삭제
            }
            linkedList.add(result);
        }
    }