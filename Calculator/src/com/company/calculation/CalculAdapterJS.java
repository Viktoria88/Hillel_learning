package com.company.calculation;


import com.company.annotations.DescriptionCalculation;
import com.company.annotations.TypeCalculation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;


@TypeCalculation(type = TypeCalculation.Type.JS_CALCULATION)
@DescriptionCalculation(description = "Can count simple operation, follow the calculation priority if it is set in brackets, and use JavaScript")
public class CalculAdapterJS extends Calculation {

    final ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    final ScriptEngine engine = scriptEngineManager.getEngineByName("js");
    final Object eval = null;
    StringBuilder sb = new StringBuilder();
    String value = "";

    public CalculAdapterJS(String[] args) {
        super(args);
        for (int i = 0; i < args.length; i++) {
            value += args[i];
        }
    }

    @Override
    public BigDecimal getResult() {
        try {
            Object res = engine.eval(value);
            return new BigDecimal(res.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
