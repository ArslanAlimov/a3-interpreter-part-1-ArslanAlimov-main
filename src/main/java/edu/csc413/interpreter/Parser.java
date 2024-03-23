package edu.csc413.interpreter;

import edu.csc413.interpreter.expression.*;
import edu.csc413.interpreter.statement.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Parser class is used to convert information that Interpreter pulls from the program lines into actual Statement,
 * Expression, and Condition objects. You will need to implement all of the methods marked by TODO.
 *
 * You will find it useful to call parseExpression and parseCondition in your implementation. Both of these are already
 * complete and don't need to be modified, though they do rely on your createConstantExpression, etc. methods being
 * implemented.
 */
public class Parser {
    public Expression createConstantExpression(int value) {
        // TODO: Implement.
        Expression ConstantExpression = new ConstantExpression(value);
        return ConstantExpression;
    }

    public Expression createVariableExpression(String variableName) {
        // TODO: Implement.
        VariableExpression variableExpression = new VariableExpression(variableName);
        return variableExpression;
    }

    public Expression createArithmeticExpression(String operator, String lhsAsString, String rhsAsString) {
        // TODO: Implement.
                   return switch(operator){
                    case "+" -> new AddExpression(parseExpression(rhsAsString),parseExpression(lhsAsString));
                    case "-" -> new SubtractExpression(parseExpression(rhsAsString),parseExpression(lhsAsString));
                    case "*" -> new MultiplyExpression(parseExpression(rhsAsString),parseExpression(lhsAsString));
                    case "/" -> new DivideExpression(parseExpression(rhsAsString),parseExpression(lhsAsString));
                       default -> throw new IllegalStateException("Unexpected value: " + operator);
                   };
            }


    public Condition createCondition(String operator, String lhsAsString, String rhsAsString) {
        // TODO: Implement.
            return switch(operator){
                case "==" -> new EqualsCondition(parseExpression(lhsAsString),parseExpression(rhsAsString));
                case ">" -> new GreaterThanCondition(parseExpression(lhsAsString),parseExpression(rhsAsString));
                case "<" -> new LessThanCondition(parseExpression(lhsAsString),parseExpression(rhsAsString));
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };

    }

    public Statement createPrintStatement(String expressionAsString) {
        // TODO: Implement.
        PrintStatement printStatement = new PrintStatement(parseExpression(expressionAsString));
        return printStatement;
    }

    public Statement createAssignStatement(String variableName, String expressionAsString) {
        // TODO: Implement.

       AssignStatement assignStatement = new AssignStatement(variableName,parseExpression(expressionAsString));
        return assignStatement;
    }

    public Statement createIfStatement(String conditionAsString, List<Statement> bodyStatements) {
        // TODO: Implement.
        IfStatement ifStatement = new IfStatement(parseCondition(conditionAsString),bodyStatements);
        return ifStatement;
    }

    /** Converts a String representing an expression into an Expression object, based on the pattern detected. */
    public Expression parseExpression(String expressionAsString) {
        if (expressionAsString.matches(CONSTANT_PATTERN.pattern())) {
            return createConstantExpression(Integer.parseInt(expressionAsString));
        }

        if (expressionAsString.matches(VARIABLE_NAME_PATTERN.pattern())) {
            return createVariableExpression(expressionAsString);
        }

        for (String operator: ARITHMETIC_OPERATORS) {
            Matcher matcher = Pattern.compile(String.format("^(.+)\\%s(.+)$", operator)).matcher(expressionAsString);
            if (matcher.matches()) {
                return createArithmeticExpression(operator, matcher.group(1).trim(), matcher.group(2).trim());
            }
        }

        throw new RuntimeException("Unrecognized expression: " + expressionAsString);
    }

    /** Converts a String representing a boolean condition into a Condition object, based on the pattern detected. */
    public Condition parseCondition(String conditionAsString) {
        for (String operator: CONDITION_OPERATORS) {
            Matcher matcher = Pattern.compile(String.format("^(.+)%s(.+)$", operator)).matcher(conditionAsString);
            if (matcher.matches()) {
                return createCondition(operator, matcher.group(1).trim(), matcher.group(2).trim());
            }
        }

        throw new RuntimeException("Unrecognized condition: " + conditionAsString);
    }

    private final Pattern CONSTANT_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    private final Pattern VARIABLE_NAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z0-9_]*$");
    private final String[] ARITHMETIC_OPERATORS = new String[]{"+", "-", "*", "/"};
    private final String[] CONDITION_OPERATORS = new String[]{"==", "<", ">"};
}
