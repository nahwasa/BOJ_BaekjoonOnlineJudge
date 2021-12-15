import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++)
            arr[i] = Integer.parseInt(tmp[i]);

        int sum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        HashSet<String> dupChk = new HashSet<>();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    String str = arr[i] + " " + arr[j];
                    if (dupChk.contains(str)) continue;
                    dupChk.add(str);
                    sb.append(str).append('\n');
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
