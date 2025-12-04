package com.example.instagram.dto.response;

import com.example.instagram.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String bio;
    private String username;
    private String profileImageUrl;

    // user정보를 수정하기 위해 데이터베이스의 데이터 entity 객체를 dto로 변환하는 매솓
    public static UserResponse from (User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .bio(user.getBio())
                .username(user.getUsername())
                .profileImageUrl(user.getProfileImageUrl())
                .build();

    }

}
