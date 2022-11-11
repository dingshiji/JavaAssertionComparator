package org.example.comparator;

import com.google.gson.internal.LinkedHashTreeMap;
import org.example.data.Assertion;

import java.util.ArrayList;

public class Comparator {

    private boolean exact_match;
    private boolean with_error_msg;
    private boolean true_or_false;
    private boolean cannot_match;

//    public Comparator(){
//        exact_match = false;
//        swap_operands = false;
//        with_error_msg = false;
//        true_or_false = false;
//        cannot_match = false;
//    }

    public void compare2assertions(String assertion1, String assertion2) {
        try{
            Assertion a1 = new Assertion(assertion1);
            Assertion parse_a1 = a1.getAssertionObject();

            Assertion a2 = new Assertion(assertion2);
            Assertion parse_a2 = a2.getAssertionObject();

            LinkedHashTreeMap<Object, Object> result = parse_a1.compareWith(parse_a2);

            System.out.println(result);

        }catch (Exception e){
            System.out.println(String.format("Error in assertion: %s, %s", assertion1, assertion2));
        }

    }

    public static void main(String[] args) {



//        String code1 = "assertEquals(err, a, b);";
//        String code2 = "assertEquals(b  ,   a)";
//        Comparator comparator = new Comparator();
//        comparator.compare2assertions(code1, code2);

        /*
            0.  能匹配
            1.  多了一个参数, 是error message
            2.  assertEquals, 交换参数位置
            3.  assertTrue, assertFalse, 参数取反
            4.  不能匹配
         */

        ArrayList<String> codeList = new ArrayList<>();
        codeList.add("assertEquals(err, a, ,,,);");
        codeList.add("assertEquals(err, a, b);");
        codeList.add("assertEquals(err, (a), (b));");
        codeList.add("assertEquals(err, b, a);");
        codeList.add("assertEquals(err, b, a());");
        codeList.add("assertEquals(b  ,   a())");
        codeList.add("assertEquals(c.b  ,   a)");
        codeList.add("assertEquals(err, a.b.c.b  ,   a)");
        codeList.add("assertEquals(b  ,   a)");
        codeList.add("assertEquals   (a, b);");
        codeList.add("assertEquals(a   , b, err)");
        codeList.add("assertEquals(a, !b);");
        codeList.add("assertEquals(a, b, err);");

        for(int i=0;i<codeList.size();i++){
            for(int j=i;j<codeList.size();j++){
                System.out.println("======== compare 2 assertions ========");
                System.out.println(codeList.get(i));
                System.out.println(codeList.get(j));
                Comparator comparator = new Comparator();
                comparator.compare2assertions(codeList.get(i), codeList.get(j));
            }
        }

    }
}
