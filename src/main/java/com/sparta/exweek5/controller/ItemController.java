package com.sparta.exweek5.controller;

import com.sparta.exweek5.dto.ItemRequestDto;
import com.sparta.exweek5.dto.ItemResponseDto;
import com.sparta.exweek5.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(requestDto));
    }

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(itemService.getList());
    }
    @GetMapping("/{postId}")
    public ResponseEntity<?> getOne(@PathVariable Long postId) {
        return ResponseEntity.ok(itemService.getOne(postId));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updateItem(@PathVariable Long postId, @RequestBody ItemRequestDto requestDto) {
        return ResponseEntity.ok(itemService.updateItem(postId, requestDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long postId) {
        return ResponseEntity.ok(itemService.delete(postId));
    }
}
