package org.example.data.impl;

import com.google.gson.internal.LinkedHashTreeMap;
import org.example.data.Assertion;

public class Null extends Assertion {
    public Null(String assertion) {
        super(assertion);
        this.expected_args = 1;
        parseAssertion();
    }

    @Override
    public LinkedHashTreeMap<Object, Object> compareWith(Assertion other) {
        return simpleOneParamCompare(other);
    }

}
