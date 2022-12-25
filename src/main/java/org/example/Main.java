package org.example;

import org.example.comparator.Comparator;

/*
    需要考虑的情况有
    0.  能匹配
    1.  多了一个参数, 是error message
    2.  assertEquals, 交换参数位置
    3.  assertTrue, assertFalse, 参数取反
    4.  不能匹配

    八个assertion type
    1.  assertEquals/notEquals
    2.  assertTrue/False
    3.  assertNull/NotNull
    4.  assertSame
    5.  assertThat


    "exact_match"       考虑error message, 完全相同
    "swap_order"        不考虑error message, 交换参数位置是正确答案
    "correct_answer"    不考虑error message, 不交换参数是正确答案
    "with_error_msg"    两个assertion, 是否至少一个有error message
    "cannot_match"      不能匹配
    "true_or_false"     assertTrue/False, 参数取反是正确答案
    "incorrect_type"    assertion type不能匹配





 */

public class Main {
    public static void main(String[] args) {
        String assertion1 = "assertEquals(a,b);";
        String assertion2 = "assertEquals(b,a);";
        Comparator comparator = new Comparator();
        comparator.compare2assertions(assertion1, assertion2);
//        System.out.println("Hello world!");
//        String code = "assertEquals(a, !a)";
//
//        Expression exp = StaticJavaParser.parseExpression(code);
//        System.out.println(exp);
//        System.out.println(exp.asMethodCallExpr().getName().asString()); // get name
//
//        System.out.println(exp.asMethodCallExpr().getArguments().get(0).toString()); // get first argument
//
//        System.out.println((exp.asMethodCallExpr().getArguments().get(1)).getClass()); // get second argument
//
//        NodeList<Expression> arguments = exp.asMethodCallExpr().getArguments();
//        System.out.println(arguments.get(0).equals(arguments.get(1))); // get second argument
    }
}