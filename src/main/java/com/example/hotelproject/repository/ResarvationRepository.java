package com.example.hotelproject.repository;

import java.util.List;

import com.example.hotelproject.entity.Resarvation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResarvationRepository extends JpaRepository<Resarvation, Long> {
    List<Resarvation> findByHotelId(Long hotel_id);
}