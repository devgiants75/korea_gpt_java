package chapter02;

public class G_Practice {
    public static void main(String[] args) {
//        *****
//        ****
//        ***
//        **
//        *

        // 줄의 순서: 1, 2, 3, 4, 5
        // 별의 개수: 5, 4, 3, 2, 1

        int height = 5; // 별의 높이를 고정값 5로 설정

        // 첫 번째 for문: 줄(row)을 제어 - 5줄 출력
        for (int i = height; i >= 1; i--) {

            // 두 번째 for문: 각 줄에 별을 출력
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); // 별 출력
            }
            System.out.println(); // 줄 바꿈
        }

//        -------------
        System.out.println("-----------------------------");
//        *****
//         ****
//          ***
//           **
//            *

        // int height = 5; // 별의 높이를 고정값 5로 설정

        // 첫 번째 for문: 줄(row)을 제어 - 5줄 출력
        for (int i = height; i >= 1; i--) {
            // i는 5, 4, 3, 2, 1

            // 두 번째 for문: 줄의 시작 부분에 공백을 추가 (오른쪽 정렬)
            // - 0, 1, 2, 3, 4
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            // 세 번째 for문: 별을 추가
            // - 5, 4, 3, 2, 1
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            System.out.println(); // 줄바꿈
        }

    }
}
