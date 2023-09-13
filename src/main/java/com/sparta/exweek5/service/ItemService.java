package com.sparta.exweek5.service;

import com.sparta.exweek5.dto.HttpResponseDto;
import com.sparta.exweek5.dto.ItemRequestDto;
import com.sparta.exweek5.dto.ItemResponseDto;
import com.sparta.exweek5.entity.Item;
import com.sparta.exweek5.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = itemRepository.save(new Item(requestDto));
        return new ItemResponseDto(item);
    }

    public ItemResponseDto getOne(Long postId) {
        Item findItem = itemRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당하는 게시글이 없습니다."));
        return new ItemResponseDto(findItem);
    }

    public List<ItemResponseDto> getList() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(ItemResponseDto::new).toList();
    }

    @Transactional
    public ItemResponseDto updateItem(Long postId, ItemRequestDto requestDto) {
        Item item = itemRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없습니다."));
        item.updateItem(requestDto);
        return new ItemResponseDto(item);
    }

    public HttpResponseDto delete(Long postId) {
        Item item = itemRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없습니다."));
        itemRepository.delete(item);
        return new HttpResponseDto("삭제 완료");
    }
}
