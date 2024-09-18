package com.pironeer.week2_1.repository.domain;

import com.pironeer.week2_1.dto.request.CommentUpdateRequest;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private String content;
    private Long topicId;
    private Long parentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Long id, String content, Long topicId, Long parentId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.topicId = topicId;
        this.parentId = parentId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

