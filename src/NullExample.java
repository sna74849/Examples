import java.util.*;

/**
 * @author sna74849
 *
 * ラッパークラスはNullを許容するがプリミティブ型では許容しない
 */
public class NullExample {
    public static void main(String[] args){
        Object[] items;
        List<Object[]> list = new ArrayList<Object[]>();
        Scanner scan = new Scanner(System.in);

        items = new Object[3];
        System.out.println("アンケートを入力してください(どれかキーを押すと開始します)");
        System.out.println("0:入力の終了");
        while(!scan.nextLine().equals("0")){
            do {
                System.out.println("名前を入力してください（必須）");
                items[0] = (String) scan.nextLine();
            } while(items[0].equals(""));

            while(true){
                System.out.println("体重を入力してください（必須）");
                String s = scan.nextLine();
                if (!s.matches("^[0-9]+$")) {
                    System.out.println("数字を入力してください");
                    continue;
                } else {
                    items[1] = (int) Integer.parseInt(s);
                    break;
                }
            }

            while(true) {
                System.out.println("年齢を入力してください（任意）");
                String s = scan.nextLine();
                if(s.equals("")) {
                    break;
                } else if(!s.matches("^[0-9]+$")) {
                    System.out.println("数字を入力してください");
                    continue;
                } else {
                    items[2] = (Integer) Integer.valueOf(s);
                    break;
                }
            }

            list.add(items);
            items = new Object[3];
            System.out.println("アンケートを入力してください(どれかキーを押すと開始します)");
            System.out.println("0:入力の終了");
        }
        System.out.println("集計を出します");
        int totalWeight = 0;
        int totalAge = 0;
        int i = 0;
        int j = 0;

        for(Object[] value:list){
            totalWeight += (int)value[1];
            i++;
            if(value[2] == null) continue;
            totalAge += (int)value[2];
            j++;
        }
        System.out.println("平均体重:" + (double) totalWeight / i);
        System.out.println("平均年齢:" + (double) totalAge / j);
    }
}
