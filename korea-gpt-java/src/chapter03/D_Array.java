package chapter03;

import java.util.ArrayList;
import java.util.Arrays;

public class D_Array {
    public static void main(String[] args) {
        // cf) 자바의 기본 배열 형태
        //      : 한 번 생성되면 크기 변경 X
        //      > 크기 변경 시 새로운 배열 생성하여 원래 배열 요소를 복사
        int[] numbers = new int[5];
        System.out.println(Arrays.toString(numbers)); // [0, 0, 0, 0, 0]
        // System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException

        // == 동적 배열 (ArrayList) 사용법 ==

        // 1. ArrayList란?
        // : Java의 동적 배열 구현체
        // : 크기 제한 없이 동적으로 요소 추가/삭제 가능
        // > Java Collection Framework의 일부 'java.util.ArrayList'에서 제공

        // 2. ArrayList 장점
        // - 동적 크기, 유연성, 다양한 메서드 제공

        // 3. ArrayList 주의점

        // cf) int[] 배열명 = new int[크기];
        //      : 해당 배열의 기본값 - 해당 데이터 타입의 기본값 (0, 0.0, false)

        // ArrayList의 경우 기본 데이터 타입(int, char 등) 사용 X
        // : 참조형 데이터 타입만 가능
        // String
        // int >> Integer
        // char >> Character
        // boolean >> Boolean

        // +) 참조형 데이터 타입의 경우 기본값이 모두 null
        // cf) null
        //      : 아무 객체도 참조하지 않음을 나타내는 값 (기본 데이터 타입 사용 X)
        Integer a = null;
        // int b = null; - 오류 발생

        // == ArrayList 생성 ==
        // ArrayList<데이터타입> 변수명 = new ArrayList<>(초기용량);

        // int[] numberArray = new int[]; - 일반 배열은 크기 지정을 하지 않으면 오류!
        ArrayList<Integer> arrayList = new ArrayList<>(5);
        // +) 초기 용량 미설정 시, 기본값은 10

        System.out.println(arrayList); // []

        // == ArrayList 데이터 추가 ==
        // : 배열의 마지막에 값을 추가
        // > 배열명.add(추가할 데이터);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println(arrayList); // [10, 20, 30]

        // == ArrayList 데이터 변경 ==
        // > 배열명.set(인덱스번호, 변경할 데이터);
        arrayList.set(1, 50);
        System.out.println(arrayList); // [10, 50, 30]

        // == ArrayList 데이터 삭제 ==
        // > 배열명.remove(인덱스번호);
        arrayList.remove(2);
        System.out.println(arrayList); // [10, 50]

        // == ArrayList 크기 확인 ==
        // > 배열명.size();
        System.out.println(arrayList.size()); // 2

        // == ArrayList 원하는 위치에 데이터 삽입 ==
        // > 배열명.add(인덱스번호, 데이터값);
        arrayList.add(1, 123);
        System.out.println(arrayList); // [10, 123, 50]

        // == 특정 요소 접근 ==
        // > 배열명.get(인덱스번호)
        System.out.println(arrayList.get(1)); // 123
    }
}
