package com.cybertek.test.day5;

import com.github.javafaker.Faker;

public class FakerTask {
    public static void main(String[] args) {

        Faker faker = new Faker();

        String fact = faker.chuckNorris().fact();
        System.out.println(fact);

        System.out.println(faker.artist().name());
    }
}
