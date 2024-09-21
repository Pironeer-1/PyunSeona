package com.pironeer.week2_1.mapper;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.repository.domain.Comment;

public class CommentMapper {
    public static Comment from(CommentCreateRequest request) {
        return Comment.builder()
                .content(request.content())
                .topicId(request.topicId())
                .parentId(request.parentId())
                .build();
    }
}

