package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

public class AssignStatement implements Statement{

    private final String varName;
    private final Expression express;

    public AssignStatement(String varName, Expression express){
        this.varName = varName;
        this.express = express;
    }
    @Override
    public void run(ProgramState programState){
        int var = express.evaluate(programState);
        programState.setVariable(varName, var);
    }
}
