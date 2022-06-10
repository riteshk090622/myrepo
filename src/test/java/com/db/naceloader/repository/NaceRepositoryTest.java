package com.db.naceloader.repository;

import com.db.naceloader.model.Nace;
import com.db.naceloader.model.NaceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class NaceRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    NaceRepository naceRepository;

    @Test
    void findByOrderId() {
        final Nace flushFind = testEntityManager.persistFlushFind(
//                new Nace(1234, 1, "A"));
                new NaceBuilder()
                        .setOrderId(1234)
                        .setLevel(2)
                        .setCode("B")
                        .setParent(null)
                        .setDescription("AGRICULTURE, FORESTRY AND FISHING")
                        .setIncludes("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.")
                        .setAlsoIncludes(null)
                        .setRulings(null)
                        .setExcludes(null)
                        .setReference("A")
                        .createNace());
        final Nace foundInRepo = naceRepository.findByOrderId(1234);
        assertEquals(flushFind.getOrderId(), foundInRepo.getOrderId());
        assertEquals(flushFind.getLevel(), foundInRepo.getLevel());
        assertEquals(flushFind.getCode(), foundInRepo.getCode());
        assertEquals(flushFind.getParent(), foundInRepo.getParent());
        assertEquals(flushFind.getDescription(), foundInRepo.getDescription());
        assertEquals(flushFind.getIncludes(), foundInRepo.getIncludes());
        assertEquals(flushFind.getAlsoIncludes(), foundInRepo.getAlsoIncludes());
        assertEquals(flushFind.getRulings(), foundInRepo.getRulings());
        assertEquals(flushFind.getExcludes(), foundInRepo.getExcludes());
        assertEquals(flushFind.getReference(), foundInRepo.getReference());
    }

}