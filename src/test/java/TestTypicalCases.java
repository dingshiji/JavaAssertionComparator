import com.google.gson.internal.LinkedHashTreeMap;
import org.example.comparator.Comparator;

import java.util.ArrayList;

public class TestTypicalCases {
    public static void main(String[] args) {
        ArrayList<String> codeList = new ArrayList<>();
        codeList.add("assertEquals(a, b);");
        codeList.add("assertEquals(a,b);");
        codeList.add("assertEquals(err, a,b);");
        codeList.add("assertEquals(b,a);");
        codeList.add("assertEquals(err, b, a);");
        codeList.add("assertEquals(err, b, c);");

        for(int i=0;i<codeList.size();i++){
            for(int j=i;j<codeList.size();j++){
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
