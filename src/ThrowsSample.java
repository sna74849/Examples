import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThrowsSample {
    public static void main(String[] args){

        System.out.println("文字列を入力してください");
        try {
            System.out.println("入力された文字列は"+inputConsole()+"です。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String inputConsole() throws IOException {
        String str = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        return str;
    }
}
