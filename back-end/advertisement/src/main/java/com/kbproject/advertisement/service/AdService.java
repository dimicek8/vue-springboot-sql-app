package com.kbproject.advertisement.service;

import com.kbproject.advertisement.controller.Ad;
import com.kbproject.advertisement.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public Ad saveAd(Ad ad) {
        return adRepository.save(ad);
    }

    public List<Ad> getAllads() {
        return adRepository.findAll();
    }

    public Ad getAdById(Long id) {
        return adRepository.findById(id).orElse(null);
    }

    public Ad updateAd(Long id, Ad ad) {
        Ad existingAd = adRepository.findById(id).orElse(null);
        if (existingAd != null) {
            existingAd.setFirstName(ad.getFirstName());
            existingAd.setLastName(ad.getLastName());
            existingAd.setEmail(ad.getEmail());
            existingAd.setCity(ad.getCity());
            existingAd.setPrice(ad.getPrice());
            existingAd.setCurrency(ad.getCurrency());
            existingAd.setDescription(ad.getDescription());
            existingAd.setFileContent(ad.getFileContent());
            return adRepository.save(existingAd);
        }
        return  null;
    }
    public void deletedAd(Long id) {
        adRepository.deleteById(id);
    }

}
