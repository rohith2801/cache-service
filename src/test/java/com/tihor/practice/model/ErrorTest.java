package com.tihor.practice.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Error test.
 */
class ErrorTest {
    /**
     * Error which is under test.
     */
    private Error sut;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        sut = new Error();
    }

    /**
     * When code is set then the same code should be returned in get.
     */
    @Test
    void whenCodeIsSetThenTheSameCodeShouldBeReturnedInGet() {
        assertNull(sut.getCode());

        final Integer code = new Random().nextInt();
        sut.setCode(code);

        assertEquals(code, sut.getCode());
    }

    /**
     * When message is set then the same message should be returned in get.
     */
    @Test
    void whenMessageIsSetThenTheSameMessageShouldBeReturnedInGet() {
        assertNull(sut.getMessage());

        final int length = 6;
        final String message = RandomStringUtils.random(length);
        sut.setMessage(message);

        assertEquals(message, sut.getMessage());
    }

    /**
     * When code message parameterized constructor is used to create an instance then the values should be saved respectively.
     */
    @Test
    void whenCodeMessageParameterizedConstructorIsUsedToCreateAnInstanceThenTheValuesShouldBeSavedRespectively() {
        final int length = 6;
        final Integer code = new Random().nextInt();
        final String message = RandomStringUtils.random(length);

        sut = new Error(code, message);

        assertEquals(code, sut.getCode());
        assertEquals(message, sut.getMessage());
    }

}