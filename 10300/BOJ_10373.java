import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

class Buff implements Comparable<Buff> {
    int idx, value;
    public Buff(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
    public void add(Buff b) {
        this.value += b.value;
    }

    @Override
    public int compareTo(Buff o) {
        return o.value - this.value;
    }
}

public class Main {
    private static long getBuffSum(int b, int dSum, int pSum) {
        return 1l*(b+dSum)*(100+pSum);
    }

    private static void solution() throws Exception {
        int b = nextInt();
        int k = nextInt();
        int n1 = nextInt();
        int n2 = nextInt();

        if (n1+n2 <= k) {
            StringBuilder sb = new StringBuilder();
            sb.append(n1).append(' ').append(n2).append('\n');
            if (n1 != 0) {
                for (int i = 1; i <= n1; i++) sb.append(i).append(' ');
                sb.append('\n');
            }
            
            for (int i = 1; i <= n2; i++) sb.append(i).append(' ');
            System.out.print(sb);
            return;
        }

        Buff[] arr1 = new Buff[n1];
        Buff[] arr2 = new Buff[n2];
        for (int i = 0; i < n1; i++) arr1[i] = new Buff(i, nextInt());
        for (int i = 0; i < n2; i++) arr2[i] = new Buff(i, nextInt());

        //sort
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //prefix sum
        for (int i = 1; i < arr1.length; i++) arr1[i].add(arr1[i-1]);
        for (int i = 1; i < arr2.length; i++) arr2[i].add(arr2[i-1]);

        //solve
        int maxDi = 0;
        int maxPi = 0;
        long max = 0l;
        int loopLen = Math.min(k, n1);
        for (int di = 0; di <= loopLen; di++) {
            int pi = Math.min(k-di, n2);
            long sum = getBuffSum(b, di==0?0:arr1[di-1].value, pi==0?0:arr2[pi-1].value);
            if (max < sum) {
                max = sum;
                maxDi = di;
                maxPi = pi;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxDi).append(' ').append(maxPi).append('\n');
        if (maxDi != 0) {
            for (int i = 0; i < maxDi; i++) {
                sb.append(arr1[i].idx + 1).append(' ');
            }
            sb.append('\n');
        }
        
        for (int i = 0; i < maxPi; i++) {
            sb.append(arr2[i].idx+1).append(' ');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
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
