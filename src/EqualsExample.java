/**
 * @author sna74849
 *
 * equalsメソッドは文字列結合でも正しい判定結果が出る。
 */
public class EqualsExample {
    public static void main(String[] args) {
        String s = "Hello";
        if (s.equals("Hello")) System.out.println("1.equalsでは一致");
        if (s == "Hello") System.out.println("1.==でも一致");

        s += " World";
        if (s.equals("Hello World")) System.out.println("2.equalsでは一致");
        if (s == "Hello World") System.out.println("2.==では不一致");

        s = "Hello";
        s = s + " World";
        if (s.equals("Hello World")) System.out.println("3.equalsでは一致");
        if (s == "Hello World") System.out.println("3.==では不一致");
    }
}
