package chapter12;

// === MVC 패턴 ===
// : 사용자 인터페이스를 설계하는 소프트웨어 디자인 패턴 중 하나
// : 세 가지 구성 요소로 나누어(역할을 분담하여) 개발을 진행

// cf) 디자인 패턴
// : 소프트웨어 디자인 과정에서 자주 발생하는 문제들에 대해 일반적인 해결책

// === Model(모델), Controller(컨트롤러), View(뷰) ===

// 1. Model(모델)
// : 애플리케이션의 데이터와 비즈니스 로직을 담당
// : 데이터베이스, 파일 시스템, 외부 서비스와 통신을 통해 데이터를 저장하고 검색
// - 상태 변경에 대해 뷰와 컨트롤러에게 알릴 수 있는 메커니즘을 제공
// - 뷰와 컨트롤러의 구현 세부사항으로부터 독립적

// 2. View(뷰)
// : 사용자에게 데이터를 표시하는 방법을 정의
// : Model의 정보를 표시, 사용자의 액션을 Controller에게 전달
// - 모델이 가진 정보를 사용자가 이해할 수 있는 형태로 변환

// 3. Controller(컨트롤러)
// : 사용자의 입력을 처리하고 모델과 뷰 사이의 상호작용을 관리
// : 사용자의 입력에 반응하여 모델을 업데이트하고, 필요한 경우 뷰를 새롭게 출력(재렌더링)

// ! MVC 패턴의 장점
// - 관심사를 분리: 각 구성 요소는 독립적인 기능과 책임 > 코드의 관리와 확장이 용이
// - 유지보수의 용이성: 애플리케이션의 비즈니스 로직과 사용자 인터페이스가 분리되어
// 					, 유지보수가 용이

// ! MVC 패턴의 단점
// - 복잡성 증가: 간단한 애플리케이션 구현에는 MVC 패턴의 구조가 복잡성을 증가
// - 학습 곡선 높음: 이해하고 사용하기 까지 일정한 학습

// ! MVC 패턴의 작동 원리
// View >> Controller >> Model >> Controller >> View

// Spring: 자바 기반 통합 웹 프레임워크
// >> Spring Boot (String MVC)

// ===== Model: 데이터를 저장하는 역할 ===== //
class LunchMenu {
    private String menu;

    public String getMenu() { return menu; }
    public void setMenu(String menu) { this.menu = menu; }
}

// ===== View: 화면에 보여주는 역할 ===== //
class LunchView {
    public void displayMenu(String menu) {
        System.out.println("오늘의 급식 메뉴는 " + menu);
    }
}

// ===== Controller: Model과 View를 연결하는 역할 ===== //
class LunchController {
    private LunchMenu model;
    private LunchView view;

    public LunchController(LunchMenu model, LunchView view) {
        this.model = model;
        this.view = view;
    }

    // 모델에 데이터를 저장
    public void setLunchMenu(String menu) {
        model.setMenu(menu);
    }

    // 모델 데이터를 뷰에 전달
    public void updateView() {
        String menu = model.getMenu();
        view.displayMenu(menu);
        // view.displayMenu(model.getMenu());
    }
}

public class MVC {
    // 학교 급식 배식 시스템

    // Model (모델) - 데이터 담당
    // : 학교 급식표와 실제 음식 데이터를 담당
    // >> 급식표에 메뉴를 적는 역할

    // View (뷰) - 화면 담당
    // : 학생들에게 급식표를 보여줌
    // >> 급식을 쉽게 볼 수 있도록 보기 좋게 정리하는 역할

    // Controller (컨트롤러) - 연결 담당
    // : 모델과 뷰 사이의 통역사
    // >> "선생님"이 학생의 요청을 급식표에 반영하고 다시 칠판에 업데이트
    public static void main(String[] args) {
        // 모델과 뷰를 준비
        LunchMenu menu = new LunchMenu();
        LunchView view = new LunchView();

        LunchController controller = new LunchController(menu, view);
        controller.setLunchMenu("김밥, 떡볶이, 콜라");
        controller.updateView();
    }
}