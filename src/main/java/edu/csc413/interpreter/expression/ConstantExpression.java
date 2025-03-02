package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;

public class ConstantExpression  implements Expression{
    private final int val;

    public ConstantExpression(int val){
        this.val = val;
    }
    @Override
    public int evaluate(ProgramState programState){
        return val;
    }
}