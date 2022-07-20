import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        int x = new Scanner(System.in).nextInt();
        int cnt = 0;
        for (int i=0; i<=6; i++) cnt+=(x&1<<i)!=0?1:0;
        System.out.println(cnt);
    }
}
