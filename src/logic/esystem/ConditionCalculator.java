package logic.esystem;



import com.fuzzylite.Engine;
import com.fuzzylite.FuzzyLite;
import com.fuzzylite.Op;
import com.fuzzylite.rule.Rule;
import com.fuzzylite.rule.RuleBlock;
import com.fuzzylite.term.Triangle;
import com.fuzzylite.variable.InputVariable;
import com.fuzzylite.variable.OutputVariable;

import model.Conditions;


public class ConditionCalculator {

	public String caluclateState(Conditions conditions) {

		Engine engine = new Engine();
		engine.setName("simple-wear");

		InputVariable temp = new InputVariable();
		temp.setName("Temp");
		temp.setRange(-50, 50);
		temp.addTerm(new Triangle("COLD", -50, -20, 10));
		temp.addTerm(new Triangle("MEDIUM", 0, 10, 20));
		temp.addTerm(new Triangle("HOT", 15, 25, 50));
		engine.addInputVariable(temp);
		
		InputVariable wind = new InputVariable();
		wind.setName("Wind");
		wind.setRange(0, 50);
		wind.addTerm(new Triangle("WEAK", 0, 10, 15));
		wind.addTerm(new Triangle("STRONG", 10, 15, 50));
		engine.addInputVariable(wind);

		OutputVariable state = new OutputVariable();
		state.setName("State");
		state.setRange(0.000, 1.000);
		state.setDefaultValue(Double.NaN);
		state.addTerm(new Triangle("LOW", 0.000, 0.250, 0.500));
		state.addTerm(new Triangle("MEDIUM", 0.250, 0.500, 0.750));
		state.addTerm(new Triangle("HIGH", 0.500, 0.750, 1.000));
		engine.addOutputVariable(state);

		RuleBlock ruleBlock = new RuleBlock();
		ruleBlock.addRule(Rule.parse("if Temp is COLD and Wind is WEAK then State is LOW ", engine));
		ruleBlock.addRule(Rule.parse("if Temp is COLD and Wind is STRON then State is LOW ", engine));
		ruleBlock.addRule(Rule.parse("if Temp is MEDIUM and Wind is WEAK then State is MEDIUM ", engine));
		ruleBlock.addRule(Rule.parse("if Temp is MEDIUM and Wind is STRON then State is LOW ", engine));
		ruleBlock.addRule(Rule.parse("if Temp is HOT AND and is WEAK then State is HOT ", engine));
		ruleBlock.addRule(Rule.parse("if Temp is HOT AND and is STRON then State is MEDIUM ", engine));

		engine.addRuleBlock(ruleBlock);

		engine.configure("", "", "Minimum", "Maximum", "Centroid");

		StringBuilder status = new StringBuilder();
		if (!engine.isReady(status)) {
			throw new RuntimeException(
					"Engine not ready. " + "The following errors were encountered:\n" + status.toString());
		}

		temp.setInputValue(-11);
		wind.setInputValue(0);
        engine.process();
        FuzzyLite.logger().info(String.format(
                "Temp.input = %s Wind.input = %s -> State.output = %s",
                Op.str(-11),Op.str(0), Op.str(state.getOutputValue())));

		return null;
	}

}
