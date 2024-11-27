package chapter01;

public class B_DataType {
    public static void main(String[] args) {
        /*
            데이터 타입 (자료형, Data Type)
            : 자바는 '강' 타입 언어
            >> 모든 변수 선언 시 반드시! 데이터 타입을 명시

            1. 데이터 타입 종류
            1) 기본 타입
                - 변수 선언 시 해당되는 자료형의 크기 만큼 메모리가 할당
                - 실질적인 데이터가 저장

            2) 참조 타입
                - 객체의 참조(메모리 주소)를 저장하는 변수 타입
                - 객체나 배열과 같이 메모리의 Heap 영역에 저장된 데이터를 참조
        */

        // 1) 기본 타입(자료형 - 8개)
        // byte(1), short(2), long(8), float(4)
        //* int(4), double(8), char(2), boolean(1)

        // 1byte == 8bit
        // : 1bit는 메모리 한 칸

        // 1-1) 정수형
        // byte(1바이트 정수): -128 ~ 127
        // short(2바이트 정수): -32,768 ~ 32,767
        // int(4바이트 정수*): 약 -2.1억 ~ 약 2.1억
        // long(8바이트 정수): 약 -2의 63제곱 ~ 약 2의 63제곱

        byte byteValue = 1;
        short shortValue = 32767;
        int intValue = 86412658;
        // long타입은 숫자 뒤에 알파벳(l, L)을 써서 표기
        long longValue = 123123359593459345L;

        // 1-2) 문자형
        // char (2바이트 문자 - 단일 문자 저장): 홑따옴표로 표기
        char grade = 'A';
        char lastName = '이';

        // 1-3) 실수형 (부동소수점 타입 - 소수점 자리가 있는 수)
        // float (4바이트 실수)
        // double (8바이트 실수*)

        float dollar1 = 32.123F; // 데이터값 뒤에 알파벳 f,F 사용
        double dollar2 = 32.123;

        // 1-4) 논리형 (데이터 값으로 true, false 만을 가짐)
        // 1바이트, 값 지정 시 소문자 값 사용을 권장
        // +) 변수명 지정 시 의문문을 사용

        boolean isMarried = false;
        boolean isActived = true;
        boolean hasSnack = false;

        // 2) 참조 자료형
        // : 기본 자료형을 기초로 만들어진 자료형
        // > 실제 데이터 값 X, 데이터가 저장된 주소값을 가지는 자료형

        // 2-1) 문자열
        // String: 문자열을 저장하는 데 사용
        // - 쌍따옴표를 사용하여 문자열을 작성
        String name = "이승아";
        System.out.println(name);
        char charName = '이';
        System.out.println(charName);
    }
}
