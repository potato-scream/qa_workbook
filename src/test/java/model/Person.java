package model;

public class Person {
    private String name;

    private Integer age;

    private Car[] cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] personsCar) {
        this.cars = personsCar;
    }
}
