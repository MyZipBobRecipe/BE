package com.example.jwtlogin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeArticleRequestDto {
    private Long id;
    private String title;
    private String body;
}
