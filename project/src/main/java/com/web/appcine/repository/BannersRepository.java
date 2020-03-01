package com.web.appcine.repository;

import com.web.appcine.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {
    List<Banner> findByStatusOrderByIdDesc(String status);
}