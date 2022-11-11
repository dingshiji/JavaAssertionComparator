package org.example.data.impl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;
import org.example.data.Assertion;

public class False extends Assertion {
    public False(String assertion) {
        super(assertion);
    }


}
