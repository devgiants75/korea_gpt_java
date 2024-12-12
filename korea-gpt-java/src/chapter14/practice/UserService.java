package chapter14.practice;

import java.util.Date;

public class UserService {
    public User signUp(UserSignUpRequestDto dto) {
        String password = dto.getPassword();
        String passwordCheck = dto.getPasswordCheck();

        if (!password.equals(passwordCheck)) {
            throw new Error("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        Long id = 1L;
        Date nowDate = new Date();

        User user = User.builder()
                .id(id)
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .nickname(dto.getNickname())
                .signUpDate(nowDate)
                .build();

        return user;
    }

    public static void main(String[] args) {

    }
}
