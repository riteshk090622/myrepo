package com.db.naceloader.service;

import com.db.naceloader.model.Nace;
import com.db.naceloader.repository.NaceRepository;
import org.springframework.stereotype.Service;

@Service
public class NaceService {

    private NaceRepository naceRepository;

    public NaceService(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    public Nace getNaceDetails(Integer orderId) {
        return naceRepository.findByOrderId(orderId);
    }
}
