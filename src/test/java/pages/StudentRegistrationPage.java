package pages;

import java.nio.file.Paths;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultsComponent;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static pages.components.CalendarComponent.fullDate;


public class StudentRegistrationPage {

    public RandomUtils randomUtils = new RandomUtils();
    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public StudentRegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    private final SelenideElement firstNameInput = $("#firstName"),
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

    public String selectedGender;

    public StudentRegistrationPage setGender() {
        selectedGender = randomUtils.getRandomGender();
        genderWrapper.$(byText(selectedGender)).click();

        return this;
    }

    public StudentRegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public StudentRegistrationPage setDateOfBirth() {
        calendarInput.click();
        calendarComponent.setRandomDate();

        return this;
    }

    public StudentRegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public String selectedSubject;

    public StudentRegistrationPage setSubject() {
        selectedSubject = randomUtils.getRandomSubject();
        subjectsInput.setValue(selectedSubject).pressEnter();

        return this;
    }

    public StudentRegistrationPage setHobby() {
        selectedHobby = randomUtils.getRandomHobby();
        hobbiesWrapper.$(byText(selectedHobby)).click();

        return this;
    }

    String selectedPicture = randomUtils.getRandomPicture();

    public StudentRegistrationPage setPicture() {
        selectedPicture = randomUtils.getRandomPicture();
        uploadPicture.uploadFromClasspath(selectedPicture);

        return this;
    }
    private String selectedState;

    public StudentRegistrationPage setState() {
        stateSelect.click();
        selectedState = randomUtils.getRandomState();
        stateWrapper.$(byText(selectedState)).click();
        return this;
    }

    public String selectedCity;

    public StudentRegistrationPage setCity() {
        citySelect.click();
        selectedCity = randomUtils.getRandomCity(selectedState);
        cityWrapper.$(byText(selectedCity)).click();
        return this;
    }

    public StudentRegistrationPage checkSubject() {
        checkResults("Subjects", selectedSubject);

        return this;
    }

    public StudentRegistrationPage checkResults(String key, String value) {
        modalWindowComponent.checkResults(key, value);

        return this;
    }

    public StudentRegistrationPage checkGender() {
        checkResults("Gender", selectedGender);

        return this;
    }

    public String selectedHobby;

    public StudentRegistrationPage checkHobby() {
        checkResults("Hobbies", selectedHobby);

        return this;
    }

    public StudentRegistrationPage checkPicture() {
        String fileName = Paths.get(selectedPicture).getFileName().toString();
        checkResults("Picture", fileName);
        return this;
    }

    public StudentRegistrationPage checkDateOfBirth() {
        checkResults("Date of Birth", fullDate);

        return this;
    }

    public StudentRegistrationPage checkStateAndCity() {
        checkResults("State and City", selectedState + " " + selectedCity);

        return this;
    }

    public StudentRegistrationPage pressSubmit() {
        submitButton.click();

        return this;
    }

    public void checkModalIsVisible() {
        $(modalDialog).should(appear);
        String modalSuccessTest = "Thanks for submitting the form";
        $(modalTitle).shouldHave(text(modalSuccessTest));

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

    public void checkUserNumberFieldIsInvalid() {
        checkFieldIsInvalid(phoneNumberInput);
    }
}
