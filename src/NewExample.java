/**
 * @author sna74849
 *
 * New演算子による配列の再定義
 */
public class NewExample {
    public static void main(String[] args){
        String[] s = new String[3];
        s[0] = "鈴木一郎";
        s[1] = "鈴木二郎";
        s[2] = "鈴木三郎";

//        String[] ss = s;
        s = new String[5];
//        for (int i=0;i<ss.length;i++) s[i] = ss[i];

        for(String value:s) System.out.println(value);
    }
}
