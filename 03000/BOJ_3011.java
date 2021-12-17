import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends FastInput {
    private boolean isOdd(int x) {
        return (x&1)==1;
    }

    private void solution() throws Exception {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nextInt();
        int a = nextInt();
        int b = nextInt();
        if (a == b) {
            System.out.println(a);
            return;
        }
        Arrays.sort(arr);

        ArrayList<Integer> candidate = new ArrayList<>();
        candidate.add(isOdd(a)?a:a+1);
        candidate.add(isOdd(b)?b:b-1);
        for (int i = 1; i < n; i++) {
            int tmp = arr[i-1]+(arr[i]-arr[i-1])/2;
            if (isOdd(tmp)) {
                if (a <= tmp && tmp <= b)
                    candidate.add(tmp);
            } else {
                if (a <= tmp-1 && tmp-1 <= b)
                    candidate.add(tmp-1);
                if (a <= tmp+1 && tmp+1 <= b)
                    candidate.add(tmp+1);
            }
        }

        int maxMin = 0;
        int answer = 0;
        for (int i = 0; i < candidate.size(); i++) {
            int min = Integer.MAX_VALUE;
            int cur = candidate.get(i);
            for (int j = 0; j < n; j++) {
                min = Math.min(min, Math.abs(cur-arr[j]));
            }
            if (maxMin < min) {
                maxMin = min;
                answer = cur;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
