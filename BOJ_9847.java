import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] abcd = new int[4];
        for (int i = 0; i < 4; i++) abcd[i] = Integer.parseInt(st.nextToken());

        int[] tmp = new int[abcd[0]];
        for (int i = 0; i < abcd[0]; i++) tmp[i] = Integer.parseInt(br.readLine());

        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 0; i < abcd[1]; i++) {
            int b = Integer.parseInt(br.readLine());
            for (int j = 0; j < abcd[0]; j++) {
                hm.put(tmp[j] + b, tmp[j] + " " + b);
            }
        }

        tmp = new int[abcd[2]];
        for (int i = 0; i < abcd[2]; i++) tmp[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < abcd[3]; i++) {
            int d = Integer.parseInt(br.readLine());
            for (int j = 0; j < abcd[2]; j++) {
                if (hm.containsKey(-(tmp[j]+d))) {
                    System.out.println(hm.get(-(tmp[j]+d)) + " " + tmp[j] + " " + d);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
