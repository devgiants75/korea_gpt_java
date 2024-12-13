package chapter15;

/*
* 스트림 API
*
* 1. 스트림 생성
*   .stream() 메서드 사용
*
* 2. 중간(가공) 절차
*   - map(Function)
*   - filter(Predication)
*   - sorted(Comparator)
*
* 3. 최종(결과) 절차
*   - collect
*   - forEach
* */

// === 자바에서 배열과 리스트의 정렬 === //
// 1. 배열(Arrays 클래스) 정렬
// : Arrays 클래스에서 제공하는 정적 메서드 사용
// : Arrays.sort()
// - 오름차순 정렬만 지원

// cf) 내림차순 정렬은 Comparator 클래스를 사용

// 2. 리스트(List 클래스) 정렬
// : Collections.sort() 또는 List 클래스의 sort() 메서드를 사용

import java.util.*;
import java.util.stream.Collectors;

public class A_sort {
    public static void main(String[] args) {
        // 1. 배열 정렬
        // 1) 오름차순 정렬
        int[] numbers = {5, 3, 2, 8, 1};
        Arrays.sort(numbers); // 오름차순 정렬
        System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 5, 8]

        // 2) 내림차순 정렬 - Comparator 클래스 내의 reverseOrder() 정적 메서드를 사용

        // Collections.reverseOrder()는 Comparator<T>를 반환하는 메서드
        // : 객체간의 비교를 실시
        // - 기본 데이터 타입에 대한 비교 X, Comparator는 객체 타입에 대한 비교 O
        Integer[] numbers2 = {5, 3, 2, 6, 12};
        Arrays.sort(numbers2, Collections.reverseOrder());
        System.out.println(Arrays.toString(numbers2)); // [12, 6, 5, 3, 2]

        // 2. 리스트 정렬
        // 1) 오름차순
        List<Integer> number3 = new ArrayList<>(List.of(5, 3, 9, 7, 6));
        Collections.sort(number3);
        System.out.println(number3); // [3, 5, 6, 7, 9]

        // 2) 내림차순
        Collections.sort(number3, Collections.reverseOrder());
        System.out.println(number3); // [9, 7, 6, 5, 3]

        // == Comparator 클래스 사용 정렬 == //
        List<String> names = new ArrayList<>(List.of("Tom", "Jerry", "Pororo", "Ruffy"));
        // 문자열 길이 기준 정렬
        // 순회) name -> name.length == String::length
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names); // [Tom, Jerry, Ruffy, Pororo]

        // == 람다식 사용 == //
        List<String> names2 = new ArrayList<>(List.of("Pororo", "Jerry", "Tom", "Ruffy"));
        names2.sort((a, b) -> b.length() - a.length()); // 문자열 길이 내림차순 정렬
        // .sort() 메서드
        // : List 인터페이스의 메서드
        // - 리스트를 특정 기준에 따라 정렬
        // - 정렬 기준을 결정하는 Comparator(두 객체를 비교하여 정렬 순서를 결정)를 인수로 받음

        // (a, b) -> b.length() - a.length()
        // : a와 b는 리스트 안의 두 개의 요소를 나타냄
        // - 두 요소를 비교한 결과를 반환
        //      1) 반환값이 양수: b가 a보다 앞에 옴
        //      2) 반환값이 0: 순서 변경 X
        //      3) 반환값이 음수: a가 b보다 앞에 옴

        // cf) 오름차순: a.length() - b.length()

        System.out.println(names2); // [Pororo, Jerry, Ruffy, Tom]

        // == 스트림 API 사용 정렬 == //
        // : 정렬된 결과를 새로운 리스트로 받음
        List<Integer> listNumbers = new ArrayList<>(List.of(8, 2, 3, 4, 1));
        List<Integer> sorted = listNumbers.stream()
                .sorted() // 오름차순 - 중간 연산 메서드
                .collect(Collectors.toList());

        System.out.println(sorted); // [1, 2, 3, 4, 8]

        // == 내림차순 ==
        List<Integer> reverseSorted = sorted.stream()
                .sorted((a, b) -> b - a) // 내림차순
                .collect(Collectors.toList());

        List<String> characterNames = new ArrayList<>(List.of("Pororo", "Jerry", "Tom", "Ruffy"));
        List<String> sortedCharacter = characterNames.stream()
                .sorted((n1, n2) -> n1.length() - n2.length())
                .collect(Collectors.toList());

        System.out.println(sortedCharacter); // [Tom, Jerry, Ruffy, Pororo]

        // == Comparator 클래스 == //
        // : 사용자 정의 정렬 정의 시 유용한 인터페이스
        // - 람다식 & 메서드 참조와 함께 사용

        List<String> fruits = new ArrayList<>(List.of("banana", "strawberry", "mango", "kiwi", "apple"));
        // 여러 조건으로 정렬
        // 1) 문자열 길이 기준 오름차순
        // 2) 알파벳 순 정렬
        fruits.sort(Comparator.comparingInt(String::length)
                // String 클래스 compareTo 메서드
                // : 두 개의 문자열 값을 비교하여 int값으로 반환해주는 함수
                .thenComparing(String::compareTo));

        System.out.println(fruits); // [kiwi, apple, mango, banana, strawberry]





    }
}
