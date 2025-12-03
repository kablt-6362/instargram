package com.example.instagram.repository;

import com.example.instagram.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Long> {
    Optional<Like> findByPostIdAndUserId(Long postId,Long UserId);
    boolean existsByPostIdAndUserId(Long postId,Long userId);
    Long countByPostId(Long postId);
}
