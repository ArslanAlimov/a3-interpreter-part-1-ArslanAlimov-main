package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;

public abstract class ArithmeticExpression implements Expression {
    private Expression lhs;
    private Expression rhs;

   public ArithmeticExpression(Expression lhs, Expression rhs) {
       this.lhs = lhs;
       this.rhs = rhs;
    }
    public Expression getLhsValue() {
        return lhs;
    }

    public Expression getRhsValue() {
        return rhs;
    }
}
