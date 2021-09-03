package com.interview.accela.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BadRequestExceptionTest {
    private static final String ERROR_MSG = "TEST MESSAGE";

    @Test
    public void instantiation() throws BadRequestException {
        BadRequestException badRequestException = new BadRequestException(ERROR_MSG);
        assertEquals(ERROR_MSG, badRequestException.getMessage());
    }


}
