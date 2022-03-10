import java.util.Scanner;

/**
 * @author http://software-engineering-lab.com/
 *
 * 配列は数を増やす(減らす)場合は再定義しなければならない
 * 再定義する際には一時的に格納しておく配列を用意してデータを退避しておく
 * 一時的な配列から再定義した配列にそのままコピーはできない
 */
public class ImmutableArray {
    public static void main(String[] args){
        String[] items = null;

        Scanner scan = new Scanner(System.in);

        int ctr = 0;
        //ループの回数の上限が決まっていないうえに入力待ちを必ず一度はしなければならないのでdo-whileを用いる
        do {
            System.out.println("名前を入力してエンターキーを押してください。終了するならそのままエンターキーを押してください。");
            String s = scan.nextLine();
            if(s.equals("")) break;
            if(items == null) {
                items = new String[ctr+1];
            } else {
                String[] temp = items;//待避用の一時的な配列にメインの配列の中身を待避する
                items = new String[ctr+1];//配列を再定義
                for(int i=0;i < temp.length;i++) items[i] = temp[i]; //ループで一つ一つコピーする
            }
            items[ctr++] = s;
        } while(true);

        if(items == null) {
            System.out.println("終了します...");
         } else {
            System.out.println("名前のリストを出力します...");
            for(String value:items) System.out.println(value);
        }
    }
}
