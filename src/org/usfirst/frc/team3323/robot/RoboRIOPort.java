package org.usfirst.frc.team3323.robot;

public enum RoboRIOPort
{
    ONE(1),
    TWO(2);

    private final int value;

    RoboRIOPort(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
