package chapter14.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public static User signUp(UserSignUpRequestDto dto) {
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
        UserSignUpRequestDto dto1 = new UserSignUpRequestDto(
                "123", "1234", "1234"
                , "이승아", "qwe", "01011112222", "개구리"
        );

        User user1 = signUp(dto1);
        System.out.println(user1.getSignUpDate()); // Thu Dec 12 12:06:11 KST 2024

        List<User> userList = null;
        List<UserSignUpRequestDto> dtos = new ArrayList<>();
        dtos.add(new UserSignUpRequestDto("123", "1234", "1234"
                , "이승아1", "qwe", "01011112222", "개구리"));
        dtos.add(new UserSignUpRequestDto("123", "1234", "1234"
                , "이승아2", "qwe", "01011112222", "개구리"));
        dtos.add(new UserSignUpRequestDto("123", "1234", "1234"
                , "이승아3", "qwe", "01011112222", "개구리"));

        userList = dtos.stream()
                .map(dto -> signUp(dto))
                .collect(Collectors.toList());

        userList = dtos.stream()
                .map(UserService::signUp)
                .collect(Collectors.toList());

        userList.forEach(System.out::println);
    }
}