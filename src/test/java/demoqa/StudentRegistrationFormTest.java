package demoqa;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;


public class StudentRegistrationFormTest extends TestBase {
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void studentRegistrationFormTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setFirstName("Kseniia")
                .setLastName("Romanovskaya")
                .setEmail("potato@cat.com")
                .setGender("Female")
                .setPhoneNumber("1234567890")
                .setSubject("Math")
                .setDateOfBirth("30", "July", "2008")
                .setHobbi("Sports")
                .setPicture("img/1.png")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit()
                .checkModalIsVisible(" Thanks for submitting the form");

        studentRegistrationPage.checkResults("Student Name", "Kseniia Romanovskaya")
                .checkResults("Student Email", "potato@cat.com")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "1234567890")
                .checkResults("Date of Birth", "30 July,2008")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "1.png")
                .checkResults("Address", "Some address 1")
                .checkResults("State and City", "NCR Delhi");
    }

    @Test
    void registrationFormRequiredFieldsTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setFirstName("Kseniia")
                .setLastName("Romanovskaya")
                .setGender("Female")
                .setPhoneNumber("1234567890")
                .pressSubmit()
                .checkModalIsVisible(" Thanks for submitting the form");
        studentRegistrationPage.checkResults("Student Name", "Kseniia Romanovskaya")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "1234567890");
    }

    @Test
    void invalidRequiredFieldsTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setPhoneNumber("")
                .pressSubmit()
                .checkFirstNameInputIsInvalid()
                .checkLastNameInputIsInvalid()
                .checkUserNumberFieldIsInvalid();
    }

    @Test
    void registrationFormWithShortPhoneNumberTest() {
        studentRegistrationPage.openPage()
                .removeBanner()
                .setPhoneNumber("123")
                .pressSubmit()
                .checkUserNumberFieldIsInvalid();
    }
}