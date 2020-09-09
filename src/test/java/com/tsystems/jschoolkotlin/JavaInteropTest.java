package com.tsystems.jschoolkotlin;


import org.junit.jupiter.api.Test;

import com.tsystems.jschoolkotlin.exception.EmailInvalidException;
import com.tsystems.jschoolkotlin.exception.IdInvalidException;
import com.tsystems.jschoolkotlin.util.UtilsKt;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaInteropTest {

    private static final String INVALID_EMAIL = "invalid email";
    private static final String INVALID_UUID = "invalid UUID";

    @Test
    void emailValidatorTest() {
        EmailInvalidException thrown = assertThrows(
                EmailInvalidException.class,
                () -> UtilsKt.validateEmail(INVALID_EMAIL),
                "Expected validateEmail(" + INVALID_EMAIL + ") to throw, but it didn't"
        );
        assertNotNull(thrown);
    }

    @Test
    void toUUIDTest() {
        IdInvalidException thrown = assertThrows(
                IdInvalidException.class,
                () -> UtilsKt.toUUID(INVALID_UUID),
                "Expected validateEmail(" + INVALID_UUID + ") to throw, but it didn't"
        );
        assertNotNull(thrown);
    }
}
