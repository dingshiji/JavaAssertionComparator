import com.google.gson.internal.LinkedHashTreeMap;
import org.example.comparator.Comparator;

import java.util.ArrayList;

public class TestAssertTrue {
    public static void main(String[] args) {

        ArrayList<String> codeList = new ArrayList<>();
        codeList.add("assertTrue(a);");
        codeList.add("assertFalse(!a);");
        codeList.add("assertFalse(!b);");
        codeList.add("assertTrue(!a)");
        codeList.add("assertTrue( c)");

        for (int i = 0; i < codeList.size(); i++) {
            if(!codeList.get(i).contains("assertTrue")){
                continue;
            }
            for (int j = i; j < codeList.size(); j++) {
                System.out.println("======== compare 2 assertions ========");
                System.out.println(codeList.get(i));
                System.out.println(codeList.get(j));
                Comparator comparator = new Comparator();
                LinkedHashTreeMap<Object, Object> result = comparator.compare2assertions(codeList.get(i), codeList.get(j));
                System.out.println(result);

            }
        }
    }
}
