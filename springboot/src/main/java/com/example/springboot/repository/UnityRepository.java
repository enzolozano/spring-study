package com.example.springboot.repository;

import com.example.springboot.entity.Unity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnityRepository extends JpaRepository<Unity, Long> {
}
