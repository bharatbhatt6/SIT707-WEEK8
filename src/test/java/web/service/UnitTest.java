package web.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class UnitTest {

    @Test
    public void validLoginTest() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void invalidUsernameTest() {
        assertFalse(LoginService.login("invalid_user", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void invalidPasswordTest() {
        assertFalse(LoginService.login("ahsan", "invalid_pass", "1980-01-01"));
    }

    @Test
    public void invalidDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void allInvalidCredentialsTest() {
        assertFalse(LoginService.login("invalid_user", "invalid_pass", "2000-01-01"));
    }

    @Test
    public void nullUsernameTest() {
        assertFalse(LoginService.login(null, "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void nullPasswordTest() {
        assertFalse(LoginService.login("ahsan", null, "1980-01-01"));
    }

    @Test
    public void nullDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
    }

    @Test
    public void allNullValuesTest() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void emptyUsernameTest() {
        assertFalse(LoginService.login("", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void emptyPasswordTest() {
        assertFalse(LoginService.login("ahsan", "", "1980-01-01"));
    }

    @Test
    public void emptyDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
    }

    @Test
    public void whitespaceUsernameTest() {
        assertFalse(LoginService.login(" ", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void whitespacePasswordTest() {
        assertFalse(LoginService.login("ahsan", " ", "1980-01-01"));
    }

    @Test
    public void whitespaceDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", " "));
    }

    @Test
    public void specialCharsUsernameTest() {
        assertFalse(LoginService.login("!@#$%", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void specialCharsPasswordTest() {
        assertFalse(LoginService.login("ahsan", "!@#$%", "1980-01-01"));
    }

    @Test
    public void specialCharsDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "!@#$%"));
    }

    @Test
    public void invalidDateFormatTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "01-01-1980"));
    }

    @Test
    public void futureDateDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "3000-01-01"));
    }

    @Test
    public void leadingTrailingSpacesUsernameTest() {
        assertFalse(LoginService.login(" ahsan ", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void leadingTrailingSpacesPasswordTest() {
        assertFalse(LoginService.login("ahsan", " ahsan_pass ", "1980-01-01"));
    }

    @Test
    public void leadingTrailingSpacesDobTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", " 1980-01-01 "));
    }

    @Test
    public void mixedCaseUsernameTest() {
        assertFalse(LoginService.login("Ahsan", "ahsan_pass", "1980-01-01"));
    }

    @Test
    public void mixedCasePasswordTest() {
        assertFalse(LoginService.login("ahsan", "Ahsan_pass", "1980-01-01"));
    }

    @Test
    public void dobWithSlashesTest() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "1980/01/01"));
    }
}


