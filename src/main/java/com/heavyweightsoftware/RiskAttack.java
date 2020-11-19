package com.heavyweightsoftware;

import java.util.Arrays;

public class RiskAttack {
    private static Die6[] ATTACK_DICE = {new Die6(), new Die6(), new Die6()};
    private static Die6[] DEFEND_DICE = {new Die6(), new Die6()};

    public ArmyValues blitz(ArmyValues startingValue) {
        ArmyValues result = new ArmyValues(startingValue);

        while (result.attacker > 1 && result.defender > 0) {
            Die6[] attackDice = getAttackDice(result.attacker);
            Die6[] defenseDice = getDefenseDice(result.defender);

            result = attack(attackDice, defenseDice, result);
        }

        return result;
    }

    protected ArmyValues attack(Die6[] attackDice, Die6[] defenseDice, ArmyValues armyValues) {
        int[] attackValues = rollAll(attackDice);
        int[] defenseValues = rollAll(defenseDice);

        ArmyValues rollResult = resolveRoll(attackValues, defenseValues);
        ArmyValues result = armyValues.substract(rollResult);

        return result;
    }

    private int[] rollAll(Die6[] dice) {
        int[] result = new int[dice.length];
        for (int ix = 0; ix < dice.length; ++ix) {
            Die6 d6 = dice[ix];
            result[ix] = d6.roll();
        }
        Arrays.sort(result);
        result = reverse(result);
        return result;
    }

    private int[] reverse(int[] values) {
        int[] result = new int[values.length];
        int forwardIdx = 0;
        int backIdx = values.length - 1;

        while (backIdx >= 0) {
            result[forwardIdx] = values[backIdx];
            ++forwardIdx;
            --backIdx;
        }

        return result;
    }

    protected ArmyValues resolveRoll(int[] attackValues, int[] defenseValues) {
        int lastDie;
        if (attackValues.length == defenseValues.length || attackValues.length < defenseValues.length) {
            lastDie = attackValues.length;
        } else {
            lastDie = defenseValues.length;
        }

        ArmyValues result = new ArmyValues();
        for (int ix = 0; ix < lastDie; ++ix) {
            if (attackValues[ix] > defenseValues[ix]){
                result.defender += 1;
            }
            else {
                result.attacker += 1;
            }
        }

        return result;
    }

    protected Die6[] getAttackDice(int attacker) {
        Die6[] result;
        if (attacker >= 4) {
            result = ATTACK_DICE;
        }
        else if (attacker <= 1) {
            result = new Die6[0];
        }
        else {
            int numDice = attacker - 1;
            result = new Die6[numDice];
            for (int ix = 0; ix < numDice; ++ix) {
                result[ix] = ATTACK_DICE[ix];
            }
        }

        return result;
    }

    protected Die6[] getDefenseDice(int defender) {
        Die6[] result;
        if (defender >= 2) {
            result = DEFEND_DICE;
        }
        else if (defender < 1) {
            result = new Die6[0];
        }
        else {
            int numDice = defender;
            result = new Die6[numDice];
            for (int ix = 0; ix < numDice; ++ix) {
                result[ix] = DEFEND_DICE[ix];
            }
        }

        return result;
    }
}
