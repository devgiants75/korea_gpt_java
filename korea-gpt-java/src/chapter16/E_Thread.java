package chapter16;

public class E_Thread {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("첫 번째 for문: " + i);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("두 번째 for문: " + i);
//        }

        // 1) 스레드 1을 생성, 시작
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("스레드1: " + i);
                try {
                    Thread.sleep(1000); // 1초 동안 스레드를 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        // 2) 스레드 2를 생성, 시작
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("스레드2: " + i);
                try {
                    Thread.sleep(1000); // 1초 동안 스레드를 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}