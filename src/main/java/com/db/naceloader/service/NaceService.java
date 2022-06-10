package com.db.naceloader.service;

import com.db.naceloader.model.Nace;
import com.db.naceloader.repository.NaceRepository;
import com.db.naceloader.util.FileToObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NaceService {

    private NaceRepository naceRepository;

    public NaceService(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    public Nace getNaceDetails(Integer orderId) {
        return naceRepository.findByOrderId(orderId);
    }

    public String putNaceDetails(MultipartFile file) {
        naceRepository.saveAll(FileToObjectUtil.fileToNaceList(file));
        return "File Uploaded Successfully";
    }

}
