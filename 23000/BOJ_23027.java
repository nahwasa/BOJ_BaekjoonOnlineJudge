import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.contains("A")) {
            String[] target = new String[]{"B","C","D","F"};
            for (String t : target)
                s = s.replaceAll(t, "A");
            System.out.println(s);
            return;
        }

        if (s.contains("B")) {
            String[] target = new String[]{"C","D","F"};
            for (String t : target)
                s = s.replaceAll(t, "B");
            System.out.println(s);
            return;
        }

        if (s.contains("C")) {
            String[] target = new String[]{"D","F"};
            for (String t : target)
                s = s.replaceAll(t, "C");
            System.out.println(s);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            sb.append('A');
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
