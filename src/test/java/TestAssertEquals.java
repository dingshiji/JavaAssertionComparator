import org.example.comparator.Comparator;

import java.util.ArrayList;

public class TestAssertEquals {
    public static void main(String[] args) {
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
