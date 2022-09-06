package com.example.jwtlogin.dto;

import com.example.jwtlogin.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponseDto {
    private long commentId;
    private String memberNickname;
    private String commentBody;
    private Long createdAt;
    private boolean isWritten;

    public static CommentResponseDto of(Comment comment, boolean bool) {
        return CommentResponseDto.builder()
                .commentId(comment.getId())
                .memberNickname(comment.getMember().getNickname())
                .commentBody(comment.getText())
                .createdAt(Timestamp.valueOf(comment.getCreatedAt()).getTime())
                .isWritten(bool)
                .build();
    }
}