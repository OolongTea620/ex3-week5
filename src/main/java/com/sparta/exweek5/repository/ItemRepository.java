package com.sparta.exweek5.repository;

import com.sparta.exweek5.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}