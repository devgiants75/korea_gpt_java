package chapter09;

// java.util 패키지
// : 자바 표준 라이브러리 중 하나
// - 데이터의 구조, 시간과 날짜 처리, 무작위 숫자 생성 등의 기능을 포함
// - 외부에 있는 클래스를 import 하여 사용

// === 시간과 날짜 처리 클래스 === //
// 1. Date 클래스
// : 날짜와 시간을 표현
// : 현재의 밀리초 단위까지를 반환 (1000밀리초 == 1초)

// 2. Calendar 클래스
// : 날짜와 시간을 조작하거나 필드를 개별적으로 제어할 수 있는 도구
// - '추상 클래스'이며 getInstance() 메서드를 통해 구현 객체를 반환받아 사용

// 3. java.time 패키지
// : 날짜와 시간을 다루는 도구 (명확성과 유연성을 제공)
// - java.util Date와 Calendar의 문제점을 보완

import java.util.Calendar;
import java.util.Date;

public class JavaUtil {
    public static void main(String[] args) {
        // 1. Date 클래스
        // : Date 객체를 생성하여 인스턴스 필드와 메서드를 활용
        Date date = new Date();

        // 1) toString(): 날짜와 시간을 문자열로 반환
        System.out.println("현재 날짜와 시간: " + date.toString());
        // 현재 날짜와 시간: Thu Dec 05 11:32:03 KST 2024

        // 2) getTime(): 1970년 1월 1일 00:00:00 (UTC)을 기준으로 현재 시간까지의 밀리초(ms)를 반환
        // UTC: 시간대의 기준점 (한국 == UTC + 9:00)
        // (오늘날짜 + 9:00) - (어제날짜 + 9:00)
        System.out.println("현재 시간의 밀리초: " + date.getTime());
        // 현재 시간의 밀리초: 1733366073254

        System.out.println("=========Calendar 클래스=========");
        // 2. Calendar 클래스
        // 1) .getInstance(): 현재 날짜와 시간으로 초기화된 Calendar 객체를 반환
        Calendar calendar = Calendar.getInstance(); // static 메서드

        // 2) get(int field): 지정된 필드의 값을 반환
        // Calendar.YEAR / .MONTH / .DAY_OF_MONTH
        System.out.println(calendar.get(Calendar.YEAR)); // 2024

        // month(월): 0 ~ 11까지의 수로 반환
        System.out.println(calendar.get(Calendar.MONTH) + 1); // 12
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 5

        // 3) set(int year, int month, int date): 날짜 설정
        calendar.set(2025, 3, 14);
        System.out.println(calendar.get(Calendar.YEAR)); // 2025
        System.out.println(calendar.get(Calendar.MONTH)); // 3
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 14
    }
}
