package com.tihor.practice.controller;

import com.tihor.practice.exception.KeyNotFoundException;
import com.tihor.practice.model.Data;
import com.tihor.practice.model.Error;
import com.tihor.practice.service.CacheService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The type Cache controller test.
 */
class CacheControllerTest {
    /**
     * Cache Controller which is under test.
     */
    @InjectMocks
    private CacheController sut;

    /**
     * Cache service mock.
     */
    @Mock
    private CacheService cacheService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * When a valid key is passed then it should return the appropriate value.
     */
    @Test
    void whenAValidKeyIsPassedThenItShouldReturnTheAppropriateValue() {
        final int length = 6;
        final String key = RandomStringUtils.random(length);
        final String value = RandomStringUtils.random(length);

        when(cacheService.getData(key)).thenReturn(value);

        assertEquals(value, sut.getData(key));
    }

    /**
     * When request has a null key then it should respond with proper error message.
     *
     * @throws Exception the exception
     */
    @Test
    void whenRequestHasANullKeyThenItShouldRespondWithProperErrorMessage() throws Exception {
        final String key = null;

        final int length = 6;
        final String value = RandomStringUtils.random(length);

        Data data = new Data(key, value);

        KeyNotFoundException exception = new KeyNotFoundException("Key cannot be null");
        doThrow(exception).when(cacheService).saveData(data);

        ResponseEntity responseEntity = sut.saveData(data);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        Error error = (Error) responseEntity.getBody();
        assertEquals(exception.getMessage(), error.getMessage());
    }

    /**
     * When save data is called then data should be saved in cache.
     *
     * @throws Exception the exception
     */
    @Test
    void whenSaveDataIsCalledThenDataShouldBeSavedInCache() throws Exception {
        final int length = 6;
        final String key = RandomStringUtils.random(length);
        final String value = RandomStringUtils.random(length);

        Data data = new Data(key, value);
        doNothing().when(cacheService).saveData(data);

        ResponseEntity responseEntity = sut.saveData(data);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(cacheService, times(1)).saveData(data);
    }

    /**
     * When delete is called then it should delete cache entry.
     */
    @Test
    void whenDeleteIsCalledThenItShouldDeleteCacheEntry() {
        final int length = 6;
        final String key = RandomStringUtils.random(length);

        doNothing().when(cacheService).deleteData(key);

        sut.deleteCacheEntry(key);

        verify(cacheService, times(1)).deleteData(key);
    }
}
