// CommentResponse.java
package com.pironeer.week2_1.dto.response;

import com.pironeer.week2_1.repository.domain.Comment;
import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        String content,
        Long topicId,
        Long parentId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static CommentResponse of(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getTopicId(),
                comment.getParentId(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}

