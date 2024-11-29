package chapter03;

import java.util.ArrayList;

public class E_Array {
    public static void main(String[] args) {
        /*
            크기 10의 ArrayList를 생성, 1 ~ 10까지의 숫자를 추가한 뒤 출력
            : 반복문을 사용(1부터 10까지 증가하는 숫자)

            추가한 숫자 중 홀수만 제거하고 결과를 출력
            : 반복문과 조건문을 사용

            인덱스 3에 값 50을 삽입한 뒤 결과를 출력
        */

        ArrayList<Integer> list = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        System.out.println("원본 리스트: " + list);
        // 원본 리스트: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        list.remove(1); // [1, 3, 4, 5, 6, 7, 8, 9, 10]
        list.remove(2); // [1, 3, 5, 6, 7, 8, 9, 10]

        for (int i = 0; i < list.size(); i++) {
            // 리스트의 크기가 변동되기 때문에 크기값을 매번 동적으로 확인
            // : 인덱스 초과 오류 방지 (IndexOutOfBoundsException)

            // 홀수 조건
            if (list.get(i) % 2 != 0) {
                list.remove(i);

                // 요소를 삭제하고난 후 인덱스 조정 (ArrayList의 경우 크기가 동적으로 변경)

                // cf) 인덱스 조정을 하지 않을 경우 정상 동작이 되지 않는 경우
                // : 연속된 요소를 제거할 때 (홀수가 연속될 경우)
                // list = [1, 3, 5, 7, 9];

                // i = 0 일 때 list.remove(0)
                // >> 리스트 [3, 5, 7, 9] 이고 i = 1(for문의 증가연산)
                // >> (3을 건너뛰고) 5가 삭제
                // 따라서 요소를 삭제한 경우(홀수 제거) 인덱스 번호를 조정
                i--;
            }
        }
        System.out.println(list); // [2, 4, 6, 8, 10]

        // [2, 4, 5, 6, 7, 8, 9, 10] - 1, 3이 제거되고 난 후

        list.add(3, 50);
        System.out.println(list); // [2, 4, 6, 50, 8, 10]
    }
}