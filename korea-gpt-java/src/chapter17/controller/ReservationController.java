package chapter17.controller;

import chapter17.service.ReservationService;
import chapter17.service.UserService;

import java.util.Scanner;

// 사용자 요청 처리 및 서비스 호출
public class ReservationController {
    private final UserService userService;
    private final ReservationService reservationService;

    public ReservationController() {
        this.userService = new UserService();
        this.reservationService = new ReservationService();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = getChoice(scanner);

            if (!processChoice(choice, scanner)) {
                break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. 사용자 등록 | 2. 로그인 | 3. 로그아웃");
        System.out.println("4. 예약하기 | 5. 예약 확인 | 6. 예약취소");
        System.out.println("7. 종료");
        System.out.print("선택: ");
    }

    private int getChoice(Scanner scanner) {
        // Scanner 클래스의 hasNextInt() 메서드
        // : Scanner 객체에 입력된 값이 int 값일 경우에는 true, 그렇지 않으면 false 반환
        while (!scanner.hasNextInt()) {
            // 입력 값이 정수가 아닌 경우
            System.out.println("숫자를 입력해주세요.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private boolean processChoice(int choice, Scanner scanner) {
        scanner.nextLine(); // 정수 값을 입력받고 남은 버퍼 처리

        
        return true;
    }
}
