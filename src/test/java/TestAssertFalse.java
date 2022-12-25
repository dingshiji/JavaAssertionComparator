import org.example.comparator.Comparator;

import java.util.ArrayList;

public class TestAssertFalse {
    public static void main(String[] args) {
        // 这里只是调用了一个简单的比较函数

        ArrayList<String> codeList = new ArrayList<>();
        codeList.add("assertFalse(a);");
        codeList.add("assertFalse(b);");
        codeList.add("assertFalse(!a);");
        codeList.add("assertFalse (!  a)  ;");

        for (int i = 0; i < codeList.size(); i++) {
            for (int j = i; j < codeList.size(); j++) {
                System.out.println("======== compare 2 assertions ========");
                System.out.println(codeList.get(i));
                System.out.println(codeList.get(j));
                Comparator comparator = new Comparator();
                comparator.compare2assertions(codeList.get(i), codeList.get(j));
            }
        }
    }
}
