package chapter09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        // == 생일까지 남은 일수 계산 프로그램 ==
        // : 사용자로부터 생년월일을 입력받고 다가오는 생일까지 남은 일수를 반환

        Scanner scanner = new Scanner(System.in);

        // 1. 사용자로부터 생년월일 입력 받기 (형식 YYYY-MM-DD)
        System.out.println("생일을 입력하세요 (YYYY-MM-DD): "); // 2000-12-04
        String inputDate = scanner.nextLine();

        // 2. 사용자 입력을 LocalDate로 변환 (formatter)
        // cf) Scanner를 통해 입력 받는 값의 타입: String (문자열 타입)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // parse: 분석하다
        // cf) parse(a, b): a를 b의 형태로 재구성
        LocalDate birthDate = LocalDate.parse(inputDate, formatter);

        // 3. 현재 날짜 구하기
        LocalDate today = LocalDate.now(); // 2024-12-05

        // 4. 올해의 생일 계산
        // .withYear()
        // : 년도를 조작하는 메서드
        LocalDate nextBirthday = birthDate.withYear(today.getYear()); // 2024-12-04

        // 5. 생일이 이미 지났다면 내년으로 설정
        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1); // 2025-12-04
        }

        // 6. 남은 일수 계산
        // ChronoUnit.DAYS: java.time 패키지에서 날짜와 시간 간의 차이를 계산할 때 사용
        long daysUntilBirthday = ChronoUnit.DAYS.between(today, nextBirthday);

        // 7. 결과 출력
        System.out.println("남은 생일까지 " + daysUntilBirthday + "일 남았습니다.");
    }
}
