package com.kbproject.advertisement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbproject.advertisement.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class MainController {
    @Autowired
    private AdService adService;

    @PostMapping(consumes = "multipart/form-data")
    public Ad createAd(@RequestParam("ad") String adJson, @RequestParam("file")MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Ad ad = objectMapper.readValue(adJson, Ad.class);
          byte[] fileContent = file.getBytes();
          ad.setFileContent(fileContent);
          return adService.saveAd(ad);
    }

    @GetMapping
    public List<Ad> getAllads() {
        return adService.getAllads();
    }
    @GetMapping("/{id}")
    public Ad getAdById(@PathVariable Long id) {
        return adService.getAdById(id);
    }
    @PutMapping("/{id}")
    public Ad updateAd(@PathVariable Long id, @RequestBody Ad ad) {
        return adService.updateAd(id, ad);
    }
    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Long id) {
        adService.deletedAd(id);
    }
}
