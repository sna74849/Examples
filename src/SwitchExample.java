/**
 * @author sna74849
 *
 * switch文による段階的条件文
 */
public class SwitchExample {
    public static void main(String[] args){
        int level = 2;

        System.out.println("あなたの必須講義は\r\n");
        System.out.println("switch文の結果");
        switch (level){
            case 1:
                System.out.println("プログラミング基礎");
            case 2:
                System.out.println("Java言語基礎");
            case 3:
                System.out.println("Java言語プログラミング");
            case 4:
                System.out.println("Javaサーブレット基礎");
                break;
            default:
                System.out.println("値が不正です。");
                break;
        }
        System.out.println();
        System.out.println("if文の結果");
        if(level<5){
            if(level<4){
                if(level<3){
                    if(level<2){
                        System.out.println("プログラミング基礎");
                    }
                    System.out.println("Java言語基礎");
                }
                System.out.println("Java言語プログラミング");
            }
            System.out.println("Javaサーブレット基礎");
        }else{
            System.out.println("値が不正です。");
        }
    }
}
