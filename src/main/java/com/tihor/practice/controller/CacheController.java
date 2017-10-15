package com.tihor.practice.controller;

import com.tihor.practice.model.Data;
import com.tihor.practice.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Cache controller.
 */
@RestController
@RequestMapping("/api/v1")
public class CacheController {
    /**
     * Cache Service.
     */
    @Autowired
    private CacheService cacheService;

    /**
     * Gets data.
     *
     * @param key the key
     * @return the data
     */
    @GetMapping("/cache/{key}")
    public String getData(@PathVariable("key") final String key) {
        return cacheService.getData(key);
    }

    /**
     * Save data response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/cache")
    public ResponseEntity saveData(@RequestBody final Data request) {
        cacheService.saveData(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Delete cache entry.
     *
     * @param key the key
     */
    @DeleteMapping("/cache/{key}")
    public void deleteCacheEntry(@PathVariable("key") final String key) {
        cacheService.deleteData(key);
    }
}
