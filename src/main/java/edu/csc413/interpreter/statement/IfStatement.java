package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;

import java.util.List;


public class IfStatement implements Statement {
    private final List<Statement> bodyStatements;
    private final Condition condition;
    public IfStatement(Condition condition, List bodyStatements){
        this.condition = condition;
        this.bodyStatements = bodyStatements;
    }
    @Override
    public void run(ProgramState programState) {
        for(Statement statement:bodyStatements){
            if(condition.evaluate(programState)){
                statement.run(programState);
            }
        }
    }
}
