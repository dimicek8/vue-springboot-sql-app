package com.kbproject.advertisement.repository;

import com.kbproject.advertisement.controller.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
