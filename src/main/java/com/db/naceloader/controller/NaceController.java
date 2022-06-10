package com.db.naceloader.controller;

import com.db.naceloader.model.Nace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaceController {

    @GetMapping("/nace/{orderId}")
    public Nace getNaceDetails(@PathVariable Integer orderId){
        return null;
    }

}
