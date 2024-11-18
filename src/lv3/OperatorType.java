package lv3;

public enum OperatorType { //enum 열거형
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
    //연산자 기호로 Enum타입 반환
    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType type : values()) {
            if (type.getSymbol().equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 입력입니다 : ");
    }
}
