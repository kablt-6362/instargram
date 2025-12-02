package com.example.instagram.service;

import com.example.instagram.dto.request.PostCreateRequest;
import com.example.instagram.dto.response.PostResponse;
import org.springframework.stereotype.Service;


public interface PostService {
    PostResponse create(PostCreateRequest postCreateRequest,Long userId);
}
