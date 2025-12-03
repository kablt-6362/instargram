package com.example.instagram.service;

import com.example.instagram.entity.Like;
import com.example.instagram.entity.Post;
import com.example.instagram.entity.User;
import com.example.instagram.repository.LikeRepository;
import com.example.instagram.repository.PostRepository;
import com.example.instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    @Override
    @Transactional
    public void toggleLike(Long postId,Long userId){
        Optional<Like> existingLike = likeRepository.findByPostIdAndUserId(postId,userId);

        // 좋아요가 있으면
        if(existingLike.isPresent()){
            likeRepository.delete(existingLike.get());
        }
        // 좋아요가 없으면
        else{
        Post post = postRepository.findById(postId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        Like like = Like.builder()
                .user(user)
                .post(post)
                .build();
        likeRepository.save(like);
        }

    };

    @Override
    public boolean isLiked(Long postId,Long userId){
        return likeRepository.existsByPostIdAndUserId(postId,userId);
    };

    @Override
    public Long getLikeCount(Long postId){
        return likeRepository.countByPostId(postId);
    };

}
