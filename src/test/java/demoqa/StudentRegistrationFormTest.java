package demoqa;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import static utils.RandomUtils.*;

public class StudentRegistrationFormTest extends TestBase {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void studentRegistrationFormTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender()
                .setPhoneNumber(phoneNumber)
                .setSubject()
                .setDateOfBirth()
                .setHobby()
                .setPicture()
                .setAddress(streetAddress)
                .setState()
                .setCity()
                .pressSubmit()
                .checkModalIsVisible();

        studentRegistrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkGender()
                .checkResults("Mobile", phoneNumber)
                .checkDateOfBirth()
                .checkSubject()
                .checkHobby()
                .checkPicture()
                .checkResults("Address", streetAddress)
                .checkStateAndCity();
    }

    @Test
    void registrationFormRequiredFieldsTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender()
                .setPhoneNumber(phoneNumber)
                .pressSubmit()
                .checkModalIsVisible();
        studentRegistrationPage.checkResults("Student Name", firstName + " " + lastName)
                .checkGender()
                .checkResults("Mobile", phoneNumber);
    }

    @Test
    void invalidRequiredFieldsTest() {

        studentRegistrationPage.openPage()
                .removeBanner()
              //  .setPhoneNumber(emptyString)
                .pressSubmit()
                .checkFirstNameInputIsInvalid()
                .checkLastNameInputIsInvalid()
                .checkUserNumberFieldIsInvalid();
    }

    @Test
    void registrationFormWithShortPhoneNumberTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setPhoneNumber(invalidPhoneNumber)
                .pressSubmit()
                .checkUserNumberFieldIsInvalid();
    }
}