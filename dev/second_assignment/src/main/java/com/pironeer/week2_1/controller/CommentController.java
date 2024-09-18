package com.pironeer.week2_1.controller;

import com.pironeer.week2_1.dto.request.CommentCreateRequest;
import com.pironeer.week2_1.dto.response.CommentResponse;
import com.pironeer.week2_1.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
@Tag(name = "Comment", description = "댓글 API")
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "댓글 생성", description = "새로운 댓글을 생성합니다.")
    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentCreateRequest request) {
        commentService.save(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "특정 댓글 조회", description = "댓글 ID로 특정 댓글을 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.findById(id));
    }

    @Operation(summary = "게시글의 댓글 조회", description = "특정 게시글의 모든 댓글을 조회합니다.")
    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<CommentResponse>> getCommentsByTopicId(@PathVariable Long topicId) {
        return ResponseEntity.ok(commentService.findByTopicId(topicId));
    }
}



