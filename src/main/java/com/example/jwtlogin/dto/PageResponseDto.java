package com.example.jwtlogin.dto;

import com.example.jwtlogin.entity.Article;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class PageResponseDto {
    private Long articleId;
    private String articleTitle;
    private String memberNickname;
    private String createdAt;


    public static PageResponseDto of(Article article) {
        return PageResponseDto.builder()
                .articleId(article.getId())
                .articleTitle(article.getTitle())
                .memberNickname(article.getMember().getNickname())
                .createdAt(article.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}