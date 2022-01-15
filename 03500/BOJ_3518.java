import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String[]> arr = new ArrayList<>();

        int max = 0;
        while (true) {
            String cur = br.readLine();
            if (cur == null) break;
            String[] tmp = cur.trim().split("\\s+");
            max = Math.max(max, tmp.length);
            arr.add(tmp);
        }

        StringBuilder[] res = new StringBuilder[arr.size()];
        for (int i = 0; i < arr.size(); i++) res[i] = new StringBuilder();

        for (int i = 0; i < max; i++) {
            int maxWordLen = 0;
            for (int j = 0; j < arr.size(); j++) {
                String[] cur = arr.get(j);
                if (cur.length-1 < i) continue;
                maxWordLen = Math.max(maxWordLen, cur[i].length());
            }

            for (int j = 0; j < arr.size(); j++) {
                String[] cur = arr.get(j);
                if (cur.length-1 < i) continue;

                res[j].append(cur[i]);
                int gap = maxWordLen - cur[i].length();

                if (cur.length-1 != i) {
                    for (int k = 0; k < gap; k++)
                        res[j].append(' ');
                    res[j].append(' ');
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size()-1)
                System.out.print(res[i]);
            else
                System.out.println(res[i]);
        }
    }
}
