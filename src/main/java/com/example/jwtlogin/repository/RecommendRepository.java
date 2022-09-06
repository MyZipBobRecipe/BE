package com.example.jwtlogin.repository;

import com.example.jwtlogin.entity.Article;
import com.example.jwtlogin.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    List<Recommend> findAllByArticle(Article article);

}