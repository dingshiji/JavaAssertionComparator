package org.example.data.impl;

import com.google.gson.internal.LinkedHashTreeMap;
import org.example.data.Assertion;

public class Same extends Assertion {
    public Same(String assertion) {
        super(assertion);
        this.expected_args = 2;
        parseAssertion();
    }

    @Override
    public LinkedHashTreeMap<Object, Object> compareWith(Assertion other) {
        return simpleTwoParamCompare(other);
    }


}
