import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    StringBuilder sb = new StringBuilder();

    private void printSplitShells(int n) {
        for (int j = 0; j < n; j++) sb.append('@');
        for (int j = 0; j < n*3; j++) sb.append(' ');
        for (int j = 0; j < n; j++) sb.append('@');
        sb.append('\n');
    }

    private void printFullShells(int n) {
        for (int j = 0; j < n*5; j++) sb.append('@');
        sb.append('\n');
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n*2; i++)   printSplitShells(n);
        for (int i = 0; i < n; i++)     printFullShells(n);
        for (int i = 0; i < n; i++)     printSplitShells(n);
        for (int i = 0; i < n; i++)     printFullShells(n);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
