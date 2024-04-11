package com.ani.backend.repositories;

import com.ani.backend.dao.bookingModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingRepo extends JpaRepository<bookingModel, Integer> {
    List<bookingModel> findByUserId(int userId);
}