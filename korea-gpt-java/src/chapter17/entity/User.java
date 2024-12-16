package chapter17.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    // 사용자 고유 아이디
    private final String userId;
    private final String password;
    private final String name;
    private final String email;
}