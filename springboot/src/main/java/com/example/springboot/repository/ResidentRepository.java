package com.example.springboot.repository;

import com.example.springboot.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    @Query(value = "SELECT TOP 1 * FROM resident r WHERE r.document = :document", nativeQuery = true)
    Optional<Resident> findByDocument(@Param("document") String document);
}
