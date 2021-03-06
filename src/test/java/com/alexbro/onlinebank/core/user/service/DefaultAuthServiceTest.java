package com.alexbro.onlinebank.core.user.service;

import com.alexbro.onlinebank.auth.model.service.DefaultAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class DefaultAuthServiceTest {

    private static final String USER_PASSWORD = "12345";

    private static final String INCORRECT_USER_PASSWORD = "123456";

    @InjectMocks
    private DefaultAuthService testedEntry;

    @Test
    public void shouldPasswordMatchesWhenPasswordAreEquals(){
        assertTrue(testedEntry.passwordMatches(USER_PASSWORD, USER_PASSWORD));
    }

    @Test
    public void shouldPasswordMatchesWhenPasswordsAreNotEquals(){
        assertFalse(testedEntry.passwordMatches(USER_PASSWORD, INCORRECT_USER_PASSWORD));
    }
}
