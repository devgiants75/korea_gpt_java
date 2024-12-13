package chapter15;

// === 스트림 API의 최종 연산 === //
// 1. collect 메서드
// : 스트림의 요소를 변환하거나 집계해서 최종 결과를 생성하는 데 사용
// - 스트림의 종결 작업 중 하나
// - 스트림에서 생성된 데이터를 특정한 컨테이너(List, Set, Map)로 변환하거나, 값을 합산, 집계에 사용

// <R, A> R collect(Collector<? super T, A, R> collector);

// Collector
// : 스트림의 요소를 어떻게 수집할지 정의하는 객체
// - Collectors 유틸리티 클래스에서 다양한 정적 메서드를 제공

// R: 최종 결과 타입
// A: 중간 결과 컨테이너의 타입 (내부적으로 사용)

// 2. Collectors 클래스
//      : 다양한 Collector를 제공하여 collect 메서드와 결합해 하나의 결과를 반환
//      : 유틸리티 클래스에서 다양한 정적 메서드를 제공

// 정적 메서드
// - toList()
// - toSet()
// - toMap()
// - joining(): 문자열 요소를 연결
// - counting(): 스트림의 요소 수를 계산
// - groupingBy(): 요소를 그룹화
// - partitioningBy(): 스트림 요소를 조건에 따라 두 그룹으로 나눔

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B_collect {
    public static void main(String[] args) {
        // Collectors.toList()
        // : 스트림 데이터를 List로 변환할 때 사용
        List<String> languages = Arrays.asList("java", "python", "javascript");

        List<String> uppercaseLanguages = languages.stream()
                // .map(language -> language.toUpperCase()) // 문자열을 대문자로 변경 - 람다식
                .map(String::toUpperCase) // 문자열을 대문자로 변경 - 메서드 참조
                .collect(Collectors.toList());

        // Collectors.joining()
        // : 문자열 요소를 결합하여 하나의 문자열로 반환
        String result = uppercaseLanguages.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        // delimiter: 구분자
        // prefix: 접두사
        // suffix: 접미사
        System.out.println(result); // [JAVA, PYTHON, JAVASCRIPT]

        // Collectors.groupingBy()
        // : 특정 기준에 따라 요소를 그룹화
        Map<Character, List<String>> groupedByFirstChar = uppercaseLanguages.stream()
                .collect(Collectors.groupingBy(language -> language.charAt(0)));

        System.out.println(groupedByFirstChar); // {P=[PYTHON], J=[JAVA, JAVASCRIPT]}

        // Collectors.partitioningBy()
        // : 조건에 따라 두 그룹으로 나눔
        Map<Boolean, List<Integer>> partitinoned = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(partitinoned); // {false=[1, 3, 5], true=[2, 4]}
    }
}
