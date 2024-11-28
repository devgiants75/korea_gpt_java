package chapter01;

public class E_Operation {
    public static void main(String[] args) {
        // 여러 줄 주석 단축키: ctrl + shift + /
        /*
            연산자(Operation)
            : 프로그램에서 데이터를 조작하거나 계산
        */

        System.out.println("=== 산술 연산자 ===");
        System.out.println(10 + 20); // 덧셈
        System.out.println(10 - 20); // 뺄셈
        System.out.println(10 * 20); // 곱셈
        System.out.println(21 / 10); // 나눗셈 - 나눈 결과의 몫을 저장

        System.out.println(21 % 10); // 나눗셈 - 나눈 결과의 나머지를 저장

        System.out.println("=== 증감 연산자 ===");
        int number = 10;
        // 후위 증감 연산자: 값이 계산된 후 변경됨
        System.out.println(number++); // 10
        System.out.println(number--); // 11

        // 전위 증감 연산자: 값이 먼저 변경되고 나서 계산에 사용됨
        System.out.println(++number); // 11
        System.out.println(--number); // 10

        number++;
        number++;
        ++number;
        --number;
        number--;
        number++;
        ++number;

        System.out.println("=== 대입(할당) 연산자 ===");
        number = 10;
        System.out.println(number += 3); // number = number + 3 (13)
        System.out.println(number -= 3); // number = number - 3 (10)
        System.out.println(number *= 3); // 30
        System.out.println(number /= 3); // 10
        System.out.println(number %= 3); // 1
        System.out.println(number); // 1

        number += 1; // ++number

        System.out.println("=== 비교 연산자 ===");
        // : 좌항을 우항과 비교한 결과를 논리(true, false) 값으로 반환
        // - <, >, <=, >=, ==, !=

        // 자바에서는 일치에 대한 연산이 ==(equals 2개로)로 작성됨
        System.out.println(5 > 3);
        System.out.println(5 < 3);
        System.out.println(5 >= 3);
        System.out.println(5 <= 3);
        System.out.println(5 == 3); // false
        System.out.println(5 != 3); // true

        System.out.println("=== 논리 연산자 ===");
        // : 논리 값(boolean)값을 연산
        // cf) &: 앰퍼샌드, |: vertical bar

        // &&: and(논리곱)
        // - 모든 값이 true면 true
        // - 하나의 값이라도 false면 false
        System.out.println(true && true);
        System.out.println(true && true && false);

        // ||: or(논리합)
        // - 하나의 값이라도 true면 true
        System.out.println(true || true);
        System.out.println(true || false || false);

        // !: not(부정논리)
        // - 값을 전환
        // - 논리값 앞에 작성하여 값을 전환
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.println(!bool1);
        System.out.println(!bool2);

        System.out.println(3 > 2 && 1 == 1); // true
        System.out.println(1 != 1); // false
        System.out.println(3 >= 3 || 10 < 11 && !bool2); // true

        System.out.println("=== 조건 연산자 ===");
        // : 삼항 연산자
        // 조건식 ? 조건식이 참인 경우 반환 : 조건식이 거짓인 경우 반환;
        // cf) 조건식은 결과값이 논리값으로 반환

        int age = 27;
        System.out.println(age > 19 ? "성인입니다." : "미성년자입니다.");

        // 정수를 담는 x, y 변수를 선언하여 각각 10과 2를 할당
        // x와 y를 사용하여
        // , x값이 짝수이면 "2의 배수입니다."
        // , x값이 홀수이면 "2의 배수가 아닙니다."를 출력

        int x = 10, y = 2; // 같은 자료형일 경우 쉼표로 구분하여 선언 가능
        // int y = 2;

        System.out.println(x % y == 0 ? "2의 배수입니다." : "2의 배수가 아닙니다.");

        System.out.println("=== 기타 연산자 ===");
        // 문자열 연결 연산자: +
        String result = "이" + "승아";
        System.out.println(result);

        // 괄호 연산자: 우선순위를 명시적으로 지정할 때 사용 ()
        int num = (1 + 3) * 4;
    }
}