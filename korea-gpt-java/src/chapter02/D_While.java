package chapter02;

public class D_While {
    public static void main(String[] args) {
        // while문
        // : 일반적으로 반복 횟수가 지정되지 않을 때 사용

        // 조건을 검사하고 해당 조건이 true인 경우 코드 블록을 실행
        // > if문의 반복형태

        /*
        while (조건) {
            조건이 참일 때 실행
        }
        */

        // 초기화
        int num = 1;

        // while문 (while문 내부에서 증감)
        while (num <= 5) {
            System.out.println(num);
            // 증감식
            num++;
        }

        // 프로그램 실행 중단: ctrl + f2

        // cf) while문 내부에서 코드블럭을 계속해서 실행: continue;
        //     while문의 코드블록을 중단: break;

        // === 0부터 20까지의 정수 중에서 홀수만 출력 ===
        int number = 0;
        while (true) { // 무한 루프 (while문 내부에서 break; 키워드를 만나기 전까지 실행)

            if (number % 2 == 0) {
                // 짝수
                number++;
                continue; // 루프 안에서 continue를 만나면 아래의 코드를 무시하고 다시 조건 검사
            }

            // 홀수만 아래의 내용이 실행
            System.out.println(number);
            number++;

            if (number == 20) break;
        }

        // cf) do while문
        // : while문과의 차이점 - 코드 블럭이 최소 한 번은 반드시 실행

        // do {
            // 실행할 코드
        // } while (조건);

        num = 1;

        do {
            System.out.println(num);
            num++;
        } while (num <= 5);
    }
}
