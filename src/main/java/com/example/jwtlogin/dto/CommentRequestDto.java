package com.example.jwtlogin.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long articleId;
    private String body;
}