package com.example.springboot.enumerator;

import lombok.Getter;

@Getter
public enum VehicleType {
    MOTORCYCLE(0),
    CAR(1);

    private final int value;

    VehicleType(int value) {
        this.value = value;
    }

    public static VehicleType fromInt(int value) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.getValue() == value) {
                return vehicleType;
            }
        }
        throw new IllegalArgumentException("Invalid value " + value);
    }
}
