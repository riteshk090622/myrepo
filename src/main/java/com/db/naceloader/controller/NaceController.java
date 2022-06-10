package com.db.naceloader.controller;

import com.db.naceloader.model.Nace;
import com.db.naceloader.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaceController {

    @Autowired
    private NaceService naceService;

    @GetMapping("/nace/{orderId}")
    public Nace getNaceDetails(@PathVariable Integer orderId){
        return naceService.getNaceDetails(orderId);
    }

}
