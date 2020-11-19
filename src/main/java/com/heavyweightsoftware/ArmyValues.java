package com.heavyweightsoftware;

import java.util.Arrays;

public class ArmyValues {
    public int attacker;
    public int defender;

    public ArmyValues() {
        attacker = 0;
        defender = 0;
    }

    public ArmyValues(ArmyValues other) {
        attacker = other.attacker;
        defender = other.defender;
    }

    public ArmyValues substract(ArmyValues other) {
        ArmyValues result = new ArmyValues();

        result.attacker = attacker - other.attacker;
        result.defender = defender - other.defender;

        return result;
    }

    @Override
    public String toString() {
        return "ArmyValues{" +
                "attacker=" + attacker +
                ", defender=" + defender +
                '}';
    }
}
