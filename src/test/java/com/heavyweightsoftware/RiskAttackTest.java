package com.heavyweightsoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiskAttackTest {

    private RiskAttack riskAttack;

    @BeforeEach
    void setUp() {
        riskAttack = new RiskAttack();
    }

    @Test
    void blitz() {
    }

    @Test
    void getAttackDice() {
        Die6[] dice = riskAttack.getAttackDice(4);
        assertEquals(3, dice.length);

        dice = riskAttack.getAttackDice(3);
        assertEquals(2, dice.length);

        dice = riskAttack.getAttackDice(2);
        assertEquals(1, dice.length);

        dice = riskAttack.getAttackDice(1);
        assertEquals(0, dice.length);

        dice = riskAttack.getAttackDice(0);
        assertEquals(0, dice.length);
    }

    @Test
    void getDefenseDice() {
        Die6[] dice = riskAttack.getDefenseDice(3);
        assertEquals(2, dice.length);

        dice = riskAttack.getDefenseDice(2);
        assertEquals(2, dice.length);

        dice = riskAttack.getDefenseDice(1);
        assertEquals(1, dice.length);

        dice = riskAttack.getDefenseDice(0);
        assertEquals(0, dice.length);
    }
}