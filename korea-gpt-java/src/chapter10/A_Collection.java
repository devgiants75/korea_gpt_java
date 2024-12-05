package chapter10;

// === 자바 컬렉션 프레임워크 === //

// cf) 프레임워크(Framework)
// : frame (틀) + work (일하다)
// - 제공받은 일정한 요소와 틀, 규약을 가지고 무언가를 만드는 일

// 1. 컬렉션 프레임워크란?
// : 데이터를 저장하고 처리하는 자료구조의 표준화 된 설계
// - 다양한 자료구조를 제공, 데이터의 효율적인 관리를 지원

// 2. 컬렉션 프레임워크의 주요 '인터페이스'와 특성
// 1) Collection
//      - 자바 컬렉션 프레임워크의 최상위 인터페이스
//      - 데이터의 집합을 다룸 (List, Set 등이 하위 인터페이스)

// 2) List
//      - 데이터의 순서를 유지 (Index로 접근 가능)
//      - 중복 허용
//      - 주요 구현체: ArrayList, LinkedList, Vector 등

// 3) Set
//      - 데이터의 순서를 유지하지 않음 (특정 구현체는 정렬 또는 순서 제공 가능*)
//      - 중복 허용하지 않음
//      - 주요 구현체: HashSet, TreeSet*, LinkedHashSet*

// 4) Map
//      - 키(Key)-값(Value) 쌍으로 이루어진 데이터를 다룸
//      - 키는 중복 허용 X, 값은 중복 허용 O
//      - 주요 구현체: HashMap, TreeMap, LinkedHashMap

// +) Queue (큐): FIFO(First In, First Out)
//      Stack (스택): LIFO(Last In, First Out)

public class A_Collection {
    public static void main(String[] args) {
        // 컬렉션 프레임워크 사용 방법
        // 1. 데이터의 특성에 맞는 클래스를 선택
        // 2. 데이터의 중복에 대한 필요성, 순서 유지에 대한 필요성 점검
        // 3. 키-값 쌍 데이터의 필요성
    }
}
