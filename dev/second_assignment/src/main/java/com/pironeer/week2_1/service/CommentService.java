package com.pironeer.week2_1.service;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.mapper.CommentMapper;
import com.pironeer.week2_1.repository.CommentRepository;
import com.pironeer.week2_1.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentCreateRequest request) {
        commentRepository.save(CommentMapper.from(request));
    }

    public CommentResponse findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COMMENT NOT FOUND"));
        return CommentResponse.of(comment);
    }

    public List<CommentResponse> findByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findByTopicId(topicId);
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentResponse::of)
                .collect(Collectors.toList());
    }
}



