package org.example.data.impl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;
import org.example.data.Assertion;

public class NotNull extends Assertion {
    public NotNull(String assertion) {
        super(assertion);
    }

}
