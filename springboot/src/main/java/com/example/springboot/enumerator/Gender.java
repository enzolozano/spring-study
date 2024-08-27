package com.example.springboot.enumerator;

import lombok.Getter;

@Getter
public enum Gender {
    MALE(0),
    FEMALE(1),
    NON_BINARY(2),
    OTHER(3);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public static Gender fromInt(int value) {
        for (Gender gender : Gender.values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
