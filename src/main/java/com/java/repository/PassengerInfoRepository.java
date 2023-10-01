package com.java.repository;

import com.java.entity.PassengerInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
