package com.example.jwtlogin.repository;


import com.example.jwtlogin.dto.PageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ArticleRepositoryCustom {
    Page<PageResponseDto> searchAll(Pageable pageable);
}