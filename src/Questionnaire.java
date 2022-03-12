import java.util.*;
/**
 * @author http://software-engineering-lab.com/
 *
 * Objectクラスは全てのクラスのスーパークラス
 * 配列でもObjectクラスの配列なら複数種類の基本データ及び参照型を扱える
 * Objectクラスの変数にアップキャストすることでデータを登録する
 * Objectクラスの変数からダウンキャストすることでデータを取り出す
 * ListとMapを組み合わせてデータ構造を持ったデータセットを扱う
 * プリミティブ型はnullを許容しないがラッパークラスは許容する
 * データなしは0ではない。0にしてしまうと平均値を求める場合などに誤差を生じる
 * try-catchは例外が発生してもcatchして処理を継続する
 * whileはループ内の処理が全く実行されないケースがある
 * do-whileはループ内の処理を必ず一回実行する
 * breakはループを中断
 * continueはループをスキップ
 */
public class Questionnaire {
    public static void main(String[] args){
        Map<String,Object> map = new HashMap();
        List<Map<String,Object>> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("アンケートを入力してください。");
        System.out.println("どれかキーを押すと開始します(0:入力の終了)");

        while(!scan.nextLine().equals("0")){
            do {
                System.out.println("名前を入力してください（必須）");
                map.put("name",scan.nextLine());//Object<-Stringにアップキャスト
            } while(map.get("name").equals(""));//必須入力なのでブランクなら再入力する

            //体重の入力(必須入力なのでnullを許容しないintで入力する)
            do {
                System.out.println("体重を入力してください（必須）");
                String s = scan.nextLine();
                try {
                    map.put("weight",Integer.parseInt(s));//Object<-intに型変換
                    break;//数字が入力されればブレイク
                } catch (NumberFormatException e) {
                    //入力エラーの場合は処理を継続して再入力
                    System.out.println("数字を入力してください");
                }
            } while(true);//あえて無限ループして条件があえばブレイクする

            //年齢の入力(任意入力なのでnullを許容するIntegerで入力する)
            do {
                System.out.println("年齢を入力してください（任意）");
                String s = scan.nextLine();
                if(s.equals("")) break;//任意入力なのでブランク入力されたらブレイク
                try {
                    map.put("age",Integer.valueOf(s));//Object<-Integerにアップキャスト
                    break;//数字が入力されればブレイク
                } catch (NumberFormatException e) {
                    //入力エラーの場合は処理を継続して再入力
                    System.out.println("数字を入力してください");
                }
            } while(true);//あえて無限ループして条件があえばブレイクする

            list.add(map);
            map = new HashMap<>();//Mapを再定義する
            System.out.println("どれかキーを押すと継続します(0:入力の終了)");
        }
        scan.close();
        /*
         * 体重は全ての回答者のデータの平均値を出すが、
         * 年齢は入力した回答者のデータだけを平均に含める。
         * 0才と入力された場合は平均に含める。
         */
        if (list.size() != 0){
            System.out.println("集計を出します");

            int totalWeight = 0,totalAge = 0,numWeight = 0,numAge = 0;//カンマで区切って複数の変数を宣言

            //拡張forループ
            for(Map value:list){
                totalWeight += (int) value.get("weight");//int<-Objectに型変換
                numWeight++;
                if(value.get("age") == null) continue; //年齢がnullであれば年齢の累計処理をスキップする
                totalAge += (Integer) value.get("age");//Integer<-Objectにダウンキャスト
                numAge++;
            }

            System.out.println("平均体重:" + (double) totalWeight / numWeight);
            System.out.println("平均年齢:" + (double) totalAge / numAge);
            System.out.println("回答者:"+list.size()+"名");
        } else {
            System.out.println("入力はありません。");
        }
        System.out.println("プログラムを終了します。");
    }
}