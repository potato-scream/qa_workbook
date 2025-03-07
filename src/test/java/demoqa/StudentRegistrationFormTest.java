package demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import utils.RandomUtils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTest extends TestBase {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Tag("demoqa")
    @Test
    void studentRegistrationFormTest() {
        step("Open form", () -> {
            studentRegistrationPage.openPage();
        });
        step("Remove banner", () -> {
            studentRegistrationPage.removeBanner();
        });
        step("Fill form", () -> {
            studentRegistrationPage.setFirstName(randomUtils.firstName)
                    .setLastName(randomUtils.lastName)
                    .setEmail(randomUtils.userEmail)
                    .setGender()
                    .setPhoneNumber(randomUtils.phoneNumber)
                    .setSubject()
                    .setDateOfBirth()
                    .setHobby()
                    .setPicture()
                    .setAddress(randomUtils.streetAddress)
                    .setState()
                    .setCity();
        });
        step("Press Submit", () -> {
            studentRegistrationPage.pressSubmit();
        });
        step("Check modal is visible", () -> {
            studentRegistrationPage.checkModalIsVisible();
        });

        step("Check results", () -> {
            studentRegistrationPage.checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                    .checkResults("Student Email", randomUtils.userEmail)
                    .checkGender()
                    .checkResults("Mobile", randomUtils.phoneNumber)
                    .checkDateOfBirth()
                    .checkSubject()
                    .checkHobby()
                    .checkPicture()
                    .checkResults("Address", randomUtils.streetAddress)
                    .checkStateAndCity();
        });
    }

    @Test
    void registrationFormRequiredFieldsTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender()
                .setPhoneNumber(randomUtils.phoneNumber)
                .pressSubmit()
                .checkModalIsVisible();
        studentRegistrationPage.checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkGender()
                .checkResults("Mobile", randomUtils.phoneNumber);
    }

    @Test
    void invalidRequiredFieldsTest() {

        studentRegistrationPage.openPage()
                .removeBanner()
                .pressSubmit()
                .checkFirstNameInputIsInvalid()
                .checkLastNameInputIsInvalid()
                .checkUserNumberFieldIsInvalid();
    }

    @Test
    void registrationFormWithShortPhoneNumberTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setPhoneNumber(randomUtils.invalidPhoneNumber)
                .pressSubmit()
                .checkUserNumberFieldIsInvalid();
    }
}