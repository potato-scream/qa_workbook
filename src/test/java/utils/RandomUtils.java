package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils {
    public static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            phoneNumber = faker.numerify("##########");

    public static String[] generateRandomDate() {
        Faker faker = new Faker(Locale.ENGLISH);
        Date dateOfBirth = faker.date().birthday(11, 80);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(dateOfBirth);
        int year = calendar.get(Calendar.YEAR);
        return new String[]{month, String.valueOf(year), String.format("%02d", day)};
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    private static final Map<String, String[]> stateCityMap = new HashMap<>();

    static {
        stateCityMap.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateCityMap.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateCityMap.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateCityMap.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public static String getRandomState() {
        return faker.options().option(stateCityMap.keySet().toArray(new String[0]));
    }

    public static String getRandomCity(String state) {
        String[] cities = stateCityMap.get(state);
        return faker.options().option(cities);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Math", "Chemistry", "Physics", "Biology", "History", "Literature", "Geography"};
        String randomSubject = faker.options().option(subjects);

        boolean useFullName = faker.bool().bool();
        if (useFullName) {
            return randomSubject;
        } else {
            return randomSubject.substring(0, faker.number().numberBetween(1, randomSubject.length()));
        }
    }

    public static String getRandomPicture() {
        String[] pictures = {"img/1.png", "img/2.jpeg", "img/3.jpeg"};
        return faker.options().option(pictures);
    }
}