package com.example.hotelproject.repository;

import com.example.hotelproject.entity.Prefecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefectureRepository extends JpaRepository<Prefecture, Long> {

}
