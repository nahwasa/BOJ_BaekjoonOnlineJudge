import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static final int MAX = 100000;

    private static ArrayList<String> getPrimeNumList() {
        ArrayList<String> pn = new ArrayList<>();
        boolean[] arr = new boolean[MAX+1];
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            int base = 2;
            while (i * base <= MAX) {
                arr[i*base] = true;
                base++;
            }
        }

        for (int i = MAX; i >= 2; i--) {
            if (arr[i]) continue;
            pn.add(String.valueOf(i));
        }
        return pn;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> pn = getPrimeNumList();
        while ((s = br.readLine()) != null) {
            if (s.charAt(0) == '0' && s.length() == 1) break;
            boolean none = true;
            for (int i = 0; i < pn.size(); i++) {
                if (!s.contains(pn.get(i))) continue;
                sb.append(pn.get(i)).append('\n');
                none = false;
                break;
            }
            if (none) {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
