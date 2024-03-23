package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

public class PrintStatement implements Statement {
        private final Expression express;
        public PrintStatement(Expression express){
            this.express = express;
        }

        @Override
        public void run(ProgramState programState){
            System.out.println(express.evaluate(programState));
        }
    }

