package com.heavyweightsoftware;

import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws Exception{
        ArmyValues armyValues = new ArmyValues();
        armyValues.attacker = 16;
        armyValues.defender = 9;

        PrintWriter writer = new PrintWriter("attacks.out");
	    RiskAttack riskAttack = new RiskAttack();
	    for (int ix = 0; ix < 1000; ++ix) {
	        ArmyValues currentValues = new ArmyValues(armyValues);
	        currentValues = riskAttack.blitz(currentValues);

	        writer.print(ix);
            writer.print(",");
            writer.print(currentValues.attacker);
            writer.print(",");
            writer.println(currentValues.defender);
        }
	    writer.close();
    }
}
