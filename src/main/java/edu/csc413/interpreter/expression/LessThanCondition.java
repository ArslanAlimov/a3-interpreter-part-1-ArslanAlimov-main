package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;

public class LessThanCondition extends Condition{
    public LessThanCondition(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public boolean evaluate(ProgramState programState) {
        Expression lhsValue = getLhsValue();
        Expression rhsValue = getRhsValue();
        Boolean temp = false;
        if(lhsValue.evaluate(programState) < rhsValue.evaluate(programState)){
            temp = true;
        }else if(lhsValue.evaluate(programState) > rhsValue.evaluate(programState)){
            temp = false;
        }
        return  temp;
    }
}
