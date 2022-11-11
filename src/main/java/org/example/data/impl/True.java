package org.example.data.impl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;
import org.example.data.Assertion;

public class True extends Assertion {
    public True(String assertion) {
        super(assertion);
    }

    @Override
    public void parseAssertion() {
        Expression exp = StaticJavaParser.parseExpression(this.assertion);
        this.type = exp.asMethodCallExpr().getName().asString();
    }
}
