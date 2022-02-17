import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String ext = st.nextToken();
            if (!hm.containsKey(ext)) {
                arr.add(ext);
                hm.put(ext, 1);
            } else {
                hm.put(ext, hm.get(ext)+1);
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str).append(' ').append(hm.get(str)).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
