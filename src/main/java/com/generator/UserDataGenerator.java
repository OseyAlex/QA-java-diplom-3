package com.generator;

import com.github.javafaker.Faker;

public class UserDataGenerator {
    private static Faker faker = new Faker();

    public String getEmail() {
        return faker.bothify("????##@gmail.com");
    }

    public String getPassword() {
        return faker.bothify("????##????");
    }

    public String getUserName() {
        return faker.name().username();
    }
}
