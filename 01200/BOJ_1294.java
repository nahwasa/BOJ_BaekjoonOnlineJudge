import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            len += arr[i].length();
        }

        int[] idxs = new int[n];
        StringBuilder sb = new StringBuilder();
        while (len-->0) {
            char minChar = 'Z'+1;
            int selectedStrIdx = 0;

            for (int i = 0; i < n; i++) {
                int idx = idxs[i];
                if (idx == arr[i].length()) continue;
                if (arr[i].charAt(idx) < minChar) {
                    minChar = arr[i].charAt(idx);
                    selectedStrIdx = i;
                } else if (arr[i].charAt(idx) == minChar) {
                    int remainLenA = arr[selectedStrIdx].length() - idxs[selectedStrIdx];
                    int remainLenB = arr[i].length() - idxs[i];
                    int loopLen = Math.min(remainLenA, remainLenB);

                    boolean isNeedLenCompare = false;
                    for (int a = idxs[selectedStrIdx], b = idxs[i]; loopLen-->0; a++, b++) {
                        char charA = arr[selectedStrIdx].charAt(a);
                        char charB = arr[i].charAt(b);
                        isNeedLenCompare = true;
                        if (charA == charB) continue;
                        if (charA > charB)
                            selectedStrIdx = i;
                        isNeedLenCompare = false;
                        break;
                    }

                    if (isNeedLenCompare && remainLenB > remainLenA) {
                        selectedStrIdx = i;
                    }
                }
            }
            idxs[selectedStrIdx]++;
            sb.append(minChar);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
