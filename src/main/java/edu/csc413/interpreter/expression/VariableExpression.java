package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;

public class VariableExpression implements Expression {
    private final String varName;
    public VariableExpression(String varName) {
        this.varName = varName;
    }
    @Override
    public int evaluate(ProgramState programState){
        return programState.getVariable(varName);
    }

}
