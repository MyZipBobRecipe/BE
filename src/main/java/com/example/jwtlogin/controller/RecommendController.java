package com.example.jwtlogin.controller;

import com.example.jwtlogin.dto.MessageDto;
import com.example.jwtlogin.dto.PostRecommendDto;
import com.example.jwtlogin.dto.RecommendDto;
import com.example.jwtlogin.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
@CrossOrigin(origins = "http://localhost:3000")
public class RecommendController {
    private final RecommendService recommendService;

    @GetMapping("/list")
    public ResponseEntity<RecommendDto> getRecommends(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(recommendService.allRecommend(id));
    }

    @PostMapping("/")
    public ResponseEntity<MessageDto> postRecommend(@RequestBody PostRecommendDto dto) {
        recommendService.createRecommend(dto.getId());
        return ResponseEntity.ok(new MessageDto("Success"));
    }

    @DeleteMapping("/one")
    public ResponseEntity<MessageDto> deleteRecommend(@RequestParam(name = "id") Long id) {
        recommendService.removeRecommend(id);
        return ResponseEntity.ok(new MessageDto("Success"));
    }

}