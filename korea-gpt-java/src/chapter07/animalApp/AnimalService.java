package chapter07.animalApp;

/*
* AnimalService 클래스 (서비스 계층)
* : 공통 부모 타입 Animal을 활용하여 동물 객체를 처리
* */
public class AnimalService {
    void handleAnimal(Animal animal) {
        // 다형성을 활용하여 공통 메서드를 처리
        animal.speak();
    }
}
