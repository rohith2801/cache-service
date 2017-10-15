package com.tihor.practice.service;

import com.tihor.practice.exception.KeyNotFoundException;
import com.tihor.practice.model.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Cache service.
 */
@Service
public class CacheService {
    /**
     * Data.
     */
    private Map<String, String> data;

    /**
     * Instantiates a new Data storage.
     */
    public CacheService() {
        this.data = new ConcurrentHashMap<>();
    }

    /**
     * Save data.
     *
     * @param key   the key
     * @param value the value
     */
    private void saveData(final String key, final String value) {
        this.data.put(key, value);
    }

    /**
     * Gets data.
     *
     * @param key the key
     * @return the data
     */
    public String getData(final String key) {
        return this.data.get(key);
    }

    /**
     * Save data.
     *
     * @param request the request
     */
    public void saveData(final Data request) throws KeyNotFoundException {
        if (StringUtils.isEmpty(request.getKey())) {
            throw new KeyNotFoundException("Key cannot be null");
        }

        this.saveData(request.getKey(), request.getValue());
    }

    /**
     * Delete data.
     *
     * @param key the key
     */
    public void deleteData(final String key) {
        this.data.remove(key);
    }
}
