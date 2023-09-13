package com.sparta.exweek5.dto;

import com.sparta.exweek5.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {
    private Long id;
    private String title;
    private String username;
    private String content;
    private int price;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.username = item.getUsername();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
