package chapter01;

public class A_Variable {
    public static void main(String[] args) {
        // 변수 (Variable)
        // : 데이터를 저장할 수 있는 메모리 '공간'

        // 1. 변수 선언: 메모리 공간 생성
        // - 변수 선언 방법 (그릇 생성 방법)
        // : 데이터타입 변수명;

        int num; // 정수를 담는 그릇(1, 100, 50000 ...)
        char chr; // 문자를 담는 그릇(가, 나, 다 ...)
        boolean bool; // 논리를 담는 그릇(true, false)

        // 2. 변수 초기화(할당): 그릇에 데이터 넣기
        // cf) 처음 데이터를 넣는 과정: 초기화
        //      데이터를 바꾸는 과정: (재)할당
        // : 변수명 = 데이터값;

        num = 10;
        chr = '가';
        bool = true;

        // 3. 변수 선언과 동시에 초기화
        // : 데이터타입 변수명 = 데이터값;

        int number = 10;
        char character = '가';
        boolean boolValue = false;

        // = 변수 명명 규칙 =
        // : 문자, 숫자, 기호를 사용
        // - 대소문자를 구분, 길이 제한 X (Name과 name이 다름)
        // - 숫자로 시작 X
        // - 기호는 _(언더스코어)와 $(달러)만 가능
        // - 자바의 예약어, 키워드는 변수명으로 사용 X
        // +) lowerCamelCase 사용 권장
        //      전체 대문자 사용 X (상수와의 구분)

        // int 24num = 24; (X)
        int num24 = 24;
        int nu24m = 24;
        int _24num = 24;
        int $num24 = 24;
        // int *24num = 24; (X)

        num24 = 48; // 변수는 재할당이 가능 (변하는 수)
        // char num24 = '가'; - 변수는 재선언이 불가능

        int height = 167;
        height = 169; // 키는 변할 수 있는 변수값

        // 상수 (Constant)
        // : 프로그램 실행 동안 그 값이 변경되지 않는 변수
        // > 선언과 동시에 반드시! 초기화가 이루어져야 함!

        // 1. 상수 선언 방법
        // - final 키워드를 사용하여 상수 선언
        // : final 데이터타입 = 데이터값;

        // 2. 상수 명명 규칙
        // - UPPER_SNAKE_CASE 사용
        // - 모든 문자를 대문자 + 연결은 _(언더스코어) 사용

        final int RESIDENT_NUMBER = 1234567;
        final double PI = 3.14159;
    }
}
