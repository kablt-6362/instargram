package com.example.instagram.dto.response;


import com.example.instagram.entity.User;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProfileResponse {

    private Long id;
    private String username;
    private String bio;
    private String name;

    // 통계
    private Long postCount;
    private Long followerCount;
    private Long followingCount;


    public static ProfileResponse from(User user){
        return ProfileResponse.builder()
                .username(user.getUsername())
                .bio(user.getBio())
                .name(user.getName())
                .postCount(0L)
                .followerCount(0L)
                .followingCount(0L)
                .build();

    }

}
