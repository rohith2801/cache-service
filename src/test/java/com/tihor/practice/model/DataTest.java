package com.tihor.practice.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Data test.
 */
class DataTest {
    /**
     * Data which is under test.
     */
    private Data sut;

    /**
     * set up.
     */
    @BeforeEach
    void setUp() {
        sut = new Data();
    }

    /**
     * When key is set then the same key should be returned in get.
     */
    @Test
    void whenKeyIsSetThenTheSameKeyShouldBeReturnedInGet() {
        assertNull(sut.getKey());

        final int length = 6;
        final String key = RandomStringUtils.random(length);
        sut.setKey(key);

        assertEquals(key, sut.getKey());
    }

    /**
     * When value is set then the same value should be returned in get.
     */
    @Test
    void whenValueIsSetThenTheSameValueShouldBeReturnedInGet() {
        assertNull(sut.getValue());

        final int length = 6;
        final String value = RandomStringUtils.random(length);
        sut.setValue(value);

        assertEquals(value, sut.getValue());
    }

    /**
     * When key value parameterized constructor is used to create an instance then the values should be saved respectively.
     */
    @Test
    void whenKeyValueParameterizedConstructorIsUsedToCreateAnInstanceThenTheValuesShouldBeSavedRespectively() {
        final int length = 6;
        final String key = RandomStringUtils.random(length);
        final String value = RandomStringUtils.random(length);

        sut = new Data(key, value);

        assertEquals(key, sut.getKey());
        assertEquals(value, sut.getValue());
    }
}