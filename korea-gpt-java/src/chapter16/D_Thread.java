package chapter16;

/*
* === Thread (스레드) ===
* : 동시에 여러 작업을 수행할 수 있도록 도와주는 기능
* EX) 식당 시스템
*   - 손님s: 사용자s
*   - 요리사s: 스레드s
*   - 식당: 프로그램
*
* - 프로그램 내에서 실행되는 작업 흐름의 단위
* - 하나의 프로그램에서 여러 스레드를 사용하면, 여러 작업을 동시에 처리
*
* cf) 스레드 사용 목적
* - 여러 작업을 동시에 처리: 프로그램의 효율 증가
*   EX) 문서 편집 프로그램에서 문서 저장 & 문서 편집 & 문서 조회
* */

class MyThread extends Thread {
    // Thread 클래스를 상속받아 run 메서드를 재정의
    @Override
    public void run() {
        System.out.println("Thread 스레드가 일을 시작합니다!");
    }
}

class MyRunnable implements Runnable {
    // Runnable 인터페이스를 구현받아 run 추상 메서드를 재정의
    public void run() {
        System.out.println("인터페이스 스레드가 일을 시작합니다.");
    }
}

public class D_Thread {
    public static void main(String[] args) {
        // 자바 스레드 생성 방법
        // 1) Thread 클래스를 상속받아 만들기
        // : MyThread 객체를 생성하고, start() 메서드를 호출하여 스레드를 실행
        MyThread myThread = new MyThread();
        myThread.start(); // 스레드가 일을 시작합니다!

        // 2) Runnable 인터페이스를 구현해서 만들기
        // : MyRunnable 객체를 Thread의 객체 생성자에게 전달
        // : start() 메서드 호출
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // 인터페이스 스레드가 일을 시작합니다.
    }
}