package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultsComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationPage {
    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            citySelect = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg");

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultsComponent modalWindowComponent = new CheckResultsComponent();


    public StudentRegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public StudentRegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationPage checkResults(String key, String value) {
        modalWindowComponent.checkResults(key, value);
        return this;
    }


    public StudentRegistrationPage setHobbi(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public StudentRegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setState(String value) {
        stateSelect.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationPage setCity(String value) {
        citySelect.click();
        cityWrapper.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationPage pressSubmit() {
        submitButton.click();

        return this;
    }

    public StudentRegistrationPage checkModalIsVisible(String value) {
        $(modalDialog).should(appear);
        $(modalTitle).shouldHave(text(value));

        return this;
    }

    public StudentRegistrationPage checkI(String value) {
        addressInput.setValue(value);

        return this;
    }

    public SelenideElement getFirstNameInput() {
        return $(firstNameInput);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInput);
    }


    public StudentRegistrationPage checkFieldIsInvalid(SelenideElement element) {
        element.should(Condition.match("has :invalid pseudoclass", el ->
                executeJavaScript("return getComputedStyle(arguments[0], ':invalid').display !== 'none';", el).equals(true)
        ));

        return this;
    }

    public StudentRegistrationPage checkFirstNameInputIsInvalid() {
        return checkFieldIsInvalid(firstNameInput);
    }

    public StudentRegistrationPage checkLastNameInputIsInvalid() {
        return checkFieldIsInvalid(lastNameInput);
    }

    public StudentRegistrationPage checkUserNumberFieldIsInvalid() {
        return checkFieldIsInvalid(phoneNumberInput);
    }

}
