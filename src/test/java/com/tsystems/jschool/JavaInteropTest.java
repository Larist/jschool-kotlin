package com.tsystems.jschool;


import org.junit.jupiter.api.Test;

import com.tsystems.jschool.exception.EmailInvalidException;
import com.tsystems.jschool.exception.IdInvalidException;
import com.tsystems.jschool.util.UtilsKt;

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
