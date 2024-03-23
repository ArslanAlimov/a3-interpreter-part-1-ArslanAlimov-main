package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;

/** A conditional comparison that can evaluate to true or false. */
public abstract class Condition {
    // TODO: Implement. Add instance variables.
    private Expression lhs;
    private Expression rhs;
    // TODO: Implement. You can modify the parameters of this constructor.
    public Condition(Expression lhs, Expression rhs) {
        // TODO: Implement.
        this.lhs = lhs;
        this.rhs = rhs;
    }
    public Expression getLhsValue() {
        return lhs;
    }

    public Expression getRhsValue() {
        return rhs;
    }
    /** Resolves the comparison to true or false based on the lhs and rhs expressions and the operator. */
    public abstract boolean evaluate(ProgramState programState);

    // TODO: Implement. You can add additional non-public methods.
}
