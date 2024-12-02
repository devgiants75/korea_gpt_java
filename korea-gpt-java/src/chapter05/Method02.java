package chapter05;

/*
    메서드(Method)
    : 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
    : 어떤 값들을 입력하면 해당 값들로 작업을 수행하여 결과를 반환

    == 메서드의 구조 ==
    : 선언부, 구현부

    반환타입 메서드명() {}
    - 선언부: 반환타입 메서드명 ()
    - 구현부: { 메서드 호출 시 수행될 코드 }

    cf) 메서드를 "정의한다": 선언부와 구현부를 작성한다

    1. 메서드 선언부
    : '반환타입', '메서드명', '매개변수 선언'

    1) 반환타입(return type)
    - 메서드의 작업 수행 결과인 반환값의 타입을 명시
    - void: 반환값이 없는 경우

    2) 매개변수(parameter) 선언
    - 메서드가 작업을 수행하는데 필요한 값들을 제공받기 위한 것
    - 필요한 값의 개수만큼 변수를 선언, 데이터 타입과 변수명을 쉼표(,)로 구분하여 나열
    cf) 변수들의 데이터 타입이 같더라도 타입 생략 X

    EX) int add (int x, y) {} - Error

    2. 메서드의 구현부
    : 메서드 선언부 다음에 오는 중괄호 {}
    : 반환타입이 void가 아닐 경우 return문을 반드시 포함!
    - 해당 반환값은 반환타입과 일치하거나 자동 형 변환이 가능한 데이터

    double 타입(8) - int 타입(4)

    double addDouble(int a, int b) {
        int sum = a + b;
        return sum;
    }

    cf) 지역변수(local variable)
    : 메서드 내에 선언된 변수
    - 그 메서드 내에서만 사용 가능
    - 매개변수 뿐만이 아니라 구현부 내에서 작성된 변수도 지역변수로 인식
*/

class Example {
    int x, y; // (인스턴스) 변수 - 데이터 타입이 일치할 경우 생략 가능

    int add(int x, int y) { // 더하다. - x, y는 매개변수
        int result = x + y;
        return result;
    }

    double multiply(int x, int y) { // 곱하다.
        int result = x * y;
        return result;
    }

    // 매개변수 X, 반환값 X
    void print99dan() {
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(j * i + " ");
            }

            System.out.println();
        }
    }
}

public class Method02 {
    public static void main(String[] args) {
        Example example = new Example();

        example.print99dan();

        // 함수의 파라미터에 데이터 전달
        // : 함수 호출 시 ()영역 내에서 parameter에 전달되는 값을 argument라고 부름

        // 매개변수(Parameter) VS 인자(인수, Argument)

        // 1. 매개변수
        // - 메서드를 정의할 때 괄호 안에 선언되는 '변수'
        // - 메서드가 호출될 때 값을 전달받기 위한 입력변수로 사용
        // > 메서드의 선언부에 정의, 호출 시 전달받은 값은 내부적으로 사용

        // 2. 인자(인수)
        // - 메서드를 호출할 때 괄호 안에 전달하는 '값'
        // - 호출된 메서드의 매개변수에 실제 값을 전달
        // > 메서드의 호출부에서 전달, 매개변수에 전달되어 메서드 안에서 사용됨

        // example.add(1);
        // example.add(10, 20, 30); - Error (인자값은 매개변수의 수와 같아야 한다!)

        // example.add("10", "20"); - Error (인자값은 매개변수의 타입과 같거나 자동 형 변환이 가능해야한다!)
        example.add('a', 'b'); // char 타입(2) >> int 타입(4): 자동 형 변환

        System.out.println(example.add(10, 20)); // - 10, 20은 인자
    }
}
