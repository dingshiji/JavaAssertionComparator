package org.example.data.impl;

import com.google.gson.internal.LinkedHashTreeMap;
import org.example.data.Assertion;

public class Equals extends Assertion {

    public Equals(String assertion) {
        super(assertion);
        this.expected_args = 2;
        parseAssertion();
 //       System.out.println("finish parsing");
    }

    @Override
    public LinkedHashTreeMap<Object, Object> compareWith(Assertion other) {
//        result.put("assertion", this.assertion);
//        result.put("compare with", other.assertion);
        if (!(other instanceof Equals)) {
            result.put("incorrect_type", true);
            return result;
        }

        // exact match

        if (this.assertion.equals(other.assertion)) {
            result.put("exact_match", true);
            result.put("correct_answer", true);
        }


        // with error message
        if (this.error_message != null || other.error_message != null) {
            this.result.put("with_error_msg", true);
        }

        // swap order
        if (this.arguments.get(0).equals(other.arguments.get(1)) && this.arguments.get(1).equals(other.arguments.get(0))) {
            result.put("swap_order", true);
            return result;
        }else if(this.arguments.get(1).equals(other.arguments.get(1)) && other.arguments.get(0).equals(this.arguments.get(0))){
            result.put("correct_answer", true);
            return result;
        }

        // cannot match
        result.put("cannot_match", true);
        return result;
    }
}
