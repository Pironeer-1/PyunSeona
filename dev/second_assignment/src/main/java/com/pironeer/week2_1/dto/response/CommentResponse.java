package com.pironeer.week2_1.dto.response;

import com.pironeer.week2_1.repository.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record CommentResponse(
        @Schema(description = "댓글 ID")
        Long id,

        @Schema(description = "댓글 내용")
        String content,

        @Schema(description = "게시물 ID")
        Long topicId,

        @Schema(description = "부모 댓글 ID")
        Long parentId,

        @Schema(description = "생성 시간")
        LocalDateTime createdAt,

        @Schema(description = "수정 시간")
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

