package edu.csc413.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * ProgramState represents the Program's storage information at any point in time while the program is running. It
 * should keep track of all defined variables, as well as their assigned values, and allow the running program to read
 * or set those values.
 */
public class ProgramState {
    // TODO: Implement. Add instance variables.
    private final Map<String, Integer> varName;

    public ProgramState() {
        // TODO: Implement.
        this.varName = new HashMap<>();
    }

    public int getVariable(String variable) {
        // TODO: Implement.
        return varName.get(variable);

    }

    public void setVariable(String variable, int value) {
        // TODO: Implement.
        varName.put(variable, value);
    }
}
