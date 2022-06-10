package com.db.naceloader.controller;

import com.db.naceloader.model.Nace;
import com.db.naceloader.model.ResponseUserMessage;
import com.db.naceloader.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class NaceController {

    @Autowired
    private NaceService naceService;

    @GetMapping("/nace/{orderId}")
    public Nace getNaceDetails(@PathVariable Integer orderId){
        return naceService.getNaceDetails(orderId);
    }

    @PostMapping("/uploadCsv")
    public ResponseUserMessage putNaceDetails(@RequestPart("file") MultipartFile file){
        return new ResponseUserMessage(naceService.putNaceDetails(file));
    }
}
