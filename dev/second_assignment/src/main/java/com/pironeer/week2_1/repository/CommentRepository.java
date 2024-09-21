package com.pironeer.week2_1.repository;

import com.pironeer.week2_1.repository.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong(0);
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public void save(Comment comment) {
        Assert.notNull(comment, "Comment must not be null");
        if(comment.getId() == null) {
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setId(id);
            commentMap.put(id, comment);
        } else {
            commentMap.replace(comment.getId(), comment);
        }
    }

    public Optional<Comment> findById(Long id) {
        Assert.notNull(id, "ID must not be null");
        return Optional.ofNullable(commentMap.get(id));
    }

    public List<Comment> findByTopicId(Long topicId) {
        Assert.notNull(topicId, "Topic ID must not be null");
        return commentMap.values().stream()
                .filter(comment -> topicId.equals(comment.getTopicId()))
                .collect(Collectors.toList());
    }

    public List<Comment> findAll() {
        return new ArrayList<>(commentMap.values());
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID must not be null");
        commentMap.remove(id);
    }
}



