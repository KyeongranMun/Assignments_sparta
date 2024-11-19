package lv3;

public enum OperatorType { //enum 열거형
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String sign;

    OperatorType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
    //연산자 기호로 Enum타입 반환
    public static OperatorType fromSign(String sign) {
        for (OperatorType type : values()) { //사용자가 입력한 연산기호와 일치할 때 열거 상수 반환.배열을 순회하며 비교
            if (type.getSign().equals(sign)) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 입력입니다 : ");//배열 순회 후 일치하는 열거 상수가 없으면 예외를 던짐
    }
}
