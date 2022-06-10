package com.db.naceloader.repository;

import com.db.naceloader.model.Nace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class NaceRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    NaceRepository naceRepository;

    @Test
    void findByOrderId() {
        final Nace flushFind = testEntityManager.persistFlushFind(new Nace(1234, 2, "B"));
        final Nace foundInRepo = naceRepository.findByOrderId(1234);
        assertEquals(flushFind.getOrderId(), foundInRepo.getOrderId());
        assertEquals(flushFind.getLevel(), foundInRepo.getLevel());
        assertEquals(flushFind.getCode(), foundInRepo.getCode());
    }
}