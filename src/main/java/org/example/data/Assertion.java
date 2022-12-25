package org.example.data;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;
import com.google.gson.internal.LinkedHashTreeMap;
import org.example.data.impl.*;

import java.util.ArrayList;

public class Assertion {
    public String assertion;
    protected String type;
    public ArrayList<Expression> arguments;
    public Expression error_message;
    protected int expected_args;

    protected LinkedHashTreeMap<Object, Object> result = new LinkedHashTreeMap<>();


    public Assertion(String assertion) {
        assertion = assertion.trim();
        while (assertion.endsWith(";")) {
            assertion = assertion.substring(0, assertion.length() - 1);
        }
        this.assertion = assertion;
        this.arguments = new ArrayList<Expression>();
        result.put("exact_match", false);
        result.put("swap_order", false);
        result.put("with_error_msg", false);
        result.put("true_or_false", false);
//        result.put("cannot_match", false);
        result.put("correct_answer", false);
        result.put("incorrect_type", false);
    }

    public Assertion getAssertionObject() {
        Expression exp = StaticJavaParser.parseExpression(this.assertion);
        this.type = exp.asMethodCallExpr().getName().asString();

        switch (this.type) {
            case "assertEquals":
                return new Equals(this.assertion);

            case "assertNotEquals":
                return new NotEquals(this.assertion);

            case "assertTrue":
                return new True(this.assertion);

            case "assertFalse":
                return new False(this.assertion);

            case "assertNull":
                return new Null(this.assertion);

            case "assertNotNull":
                return new NotNull(this.assertion);

            case "assertSame":
                return new Same(this.assertion);

            case "assertThat":
                return new That(this.assertion);

            default:
                throw new RuntimeException("Unknown assertion type: " + this.type);
        }
    }

    public static Expression remove_parentheses(Expression exp) {
        while (exp.isEnclosedExpr()) {
            exp = exp.asEnclosedExpr().getInner();
        }
        return exp;
    }

    public void parseAssertion() {
        Expression exp = StaticJavaParser.parseExpression(this.assertion);
        this.type = exp.asMethodCallExpr().getName().asString();
        int argument_cnt = exp.asMethodCallExpr().getArguments().size();
        if (argument_cnt == this.expected_args) {
            for (Expression argument : exp.asMethodCallExpr().getArguments()) {
                this.arguments.add(argument);
            }
        } else if (argument_cnt == this.expected_args + 1) {
            this.error_message = exp.asMethodCallExpr().getArgument(0);
            for (int i = 1; i < argument_cnt; i++) {
                this.arguments.add(exp.asMethodCallExpr().getArgument(i));
            }
        }
    }

    protected LinkedHashTreeMap<Object, Object> simpleOneParamCompare(Assertion other) {
        // todo: 简单的单参数的assertion比较
        if (this.arguments.get(0).toString().equals(other.arguments.get(0).toString())) {
            result.put("exact_match", true);
            result.put("correct_answer", true);
        } else {
            result.put("exact_match", false);
        }
        return result;
    }

    protected LinkedHashTreeMap<Object, Object> simpleTwoParamCompare(Assertion other) {
        // todo: 简单的双参数的assertion比较
        if (this.arguments.get(0).toString().equals(other.arguments.get(0).toString()) && this.arguments.get(1).toString().equals(other.arguments.get(1).toString())) {
            result.put("exact_match", true);
            result.put("correct_answer", true);
        } else {
            result.put("exact_match", false);
        }
        return null;
    }

    public LinkedHashTreeMap<Object, Object> compareWith(Assertion other) {
        return null;
    }

}
