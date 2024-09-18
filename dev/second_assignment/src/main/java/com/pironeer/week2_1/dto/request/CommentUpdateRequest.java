package com.pironeer.week2_1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CommentUpdateRequest(
        @NotBlank
        @Schema(description = "수정할 댓글 내용", example = "수정된 댓글 내용입니다.")
        String content
) {}