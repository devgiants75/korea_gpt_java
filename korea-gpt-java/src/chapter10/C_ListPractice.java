package chapter10;

// === 이벤트 관리 시스템 ===
// - 이벤트 참가자 명단과 대기열 관리를 위한 시스템
// - 참가자는 사전 등록된 명단을 통해 이벤트에 참가
// - 명단이 꽉 차면 대기열로 추가, 참가자가 떠나면 대기열에 다음 사람이 추가

// 1) 이벤트 참가자 명단 관리
// : 사전에 등록, 이벤트 당일에는 추가적인 참가자 등록 X
// >> ArrayList (목록 추가, 삭제 X / 참가자 조회 O)

// 2) 대기열 관리
// : 이벤트에는 한정된 좌석, 좌석이 모두 차면 추가 도착 참가자들은 대기열에 등록
// >> LinkedList (목록 추가, 삭제 O / 참가자 조회 X)

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    // === 필드 === //
    // 이벤트 참가자 명단
    ArrayList<String> participantList = new ArrayList<>();
    // 대기열 명단
    LinkedList<String> waitingQueue = new LinkedList<>();

    // === 메서드 === //
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }

    void leaveParticipant(String name) {
        if (waitingQueue.size() > 0) {
            String nextParticipant = waitingQueue.remove(0);
            addParticipant(nextParticipant);
        }
    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("이승아");
        eventManagement.addParticipant("이도경");
        eventManagement.addParticipant("이지희");
        eventManagement.addParticipant("이지훈");
        eventManagement.addParticipant("김명진");

        eventManagement.addToWaitingQueue("윤대휘");
        eventManagement.addToWaitingQueue("김소빈");
        eventManagement.addToWaitingQueue("정규민");
        eventManagement.addToWaitingQueue("박성욱");

        System.out.println(eventManagement.participantList); // [이승아, 이도경, 이지희, 이지훈, 김명진]
        System.out.println(eventManagement.waitingQueue); // [윤대휘, 김소빈, 정규민, 박성욱]

        eventManagement.leaveParticipant("이승아");
        System.out.println(eventManagement.participantList);
        // [이승아, 이도경, 이지희, 이지훈, 김명진, 윤대휘]

        eventManagement.leaveParticipant("이지훈");
        System.out.println(eventManagement.participantList);
        // [이승아, 이도경, 이지희, 이지훈, 김명진, 윤대휘, 김소빈]

        System.out.println(eventManagement.checkParticipant("김명진")); // true
        System.out.println(eventManagement.checkParticipant("박성욱")); // false

        System.out.println(eventManagement.waitingQueue); // [정규민, 박성욱]
    }
}