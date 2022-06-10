package com.db.naceloader.repository;

import com.db.naceloader.model.Nace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaceRepository extends JpaRepository<Nace, Integer> {
    Nace findByOrderId(Integer orderId);
}
