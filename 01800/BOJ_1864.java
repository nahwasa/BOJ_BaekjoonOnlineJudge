import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int getNum(char c) {
        switch (c) {
            case '-' : return 0;
            case '\\' : return 1;
            case '(' : return 2;
            case '@' : return 3;
            case '?' : return 4;
            case '>' : return 5;
            case '&' : return 6;
            case '%' : return 7;
            case '/' : return -1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        StringBuilder sb = new StringBuilder();
        while (!(s = br.readLine()).equals("#")) {
            int len = s.length();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += getNum(s.charAt(i)) * Math.pow(8, len-i-1);
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
