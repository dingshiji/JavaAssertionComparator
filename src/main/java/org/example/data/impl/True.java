package org.example.data.impl;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.expr.Expression;
import com.google.gson.internal.LinkedHashTreeMap;
import org.example.data.Assertion;

public class True extends Assertion {
    public True(String assertion) {
        super(assertion);
        this.expected_args = 1;
        parseAssertion();
    }

    @Override
    public LinkedHashTreeMap<Object, Object> compareWith(Assertion other) {
        if (!(other instanceof True)) {
            if (other instanceof False) {
                Expression this_arg = this.arguments.get(0);
                Expression other_arg = other.arguments.get(0);
                if(this_arg.isUnaryExpr() && !other_arg.isUnaryExpr()){
                    if(this_arg.toString().startsWith("!")&&this_arg.getChildNodes().get(0).toString().equals(other.arguments.get(0).toString())){
                        result.put("true_or_false", true);
                        result.put("correct_answer", true);
                    }
                }else if(other_arg.isUnaryExpr() && !this_arg.isUnaryExpr()){
                    if(other_arg.toString().startsWith("!")&&other_arg.getChildNodes().get(0).toString().equals(this.arguments.get(0).toString())){
                        result.put("true_or_false", true);
                        result.put("correct_answer", true);
                    }
                }
            } else {
                result.put("incorrect_type", true);
                return result;
            }
        }

        if (this.assertion.equals(other.assertion)) {
            result.put("exact_match", true);
            result.put("correct_answer", true);
        }

        // with error message
        if (this.error_message != null || other.error_message != null) {
            this.result.put("with_error_msg", true);
        }



        // cannot match
//        result.put("cannot_match", true);
        return result;
    }
}
