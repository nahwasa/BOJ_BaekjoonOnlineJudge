import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int nextInt() throws Exception      { return Integer.parseInt(br.readLine()); }
    private String nextLine() throws Exception  { return br.readLine(); }
    private StringBuilder sb = new StringBuilder();
    private void write(Object o) { sb.append(o); }
    private void flush() { System.out.println(sb); }

    class Number implements Comparable<Number> {
        int num;
        BigInteger cnt;

        public Number(int num) {
            this.num = num;
            this.cnt = new BigInteger("0");
        }

        public Number(int num, BigInteger cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public void add36BaseDigit(int digit) {
            cnt = cnt.add(powArr[digit]);
        }

        public void makeCntToGap() {
            int gap = 35-num;
            cnt = cnt.multiply(new BigInteger(String.valueOf(gap)));
        }

        @Override
        public int compareTo(Number o) {
            return -this.cnt.compareTo(o.cnt);
        }
    }

    private static BigInteger[] powArr;

    private BigInteger[] get36PowArr() {
        BigInteger[] powArr = new BigInteger[50];
        BigInteger mult = new BigInteger("36");
        powArr[0] = BigInteger.ONE;
        for (int i = 1; i < powArr.length; i++) {
            powArr[i] = powArr[i-1].multiply(mult);
        }
        return powArr;
    }

    private int atoi(char c) {
        if (c <= '9') return c-'0';
        return c-'A'+10;
    }

    private char itoa(int i) {
        if (i <= 9) return (char)('0'+i);
        return (char)('A'+i-10);
    }

    private void solution() throws Exception {
        powArr = get36PowArr();

        int n = nextInt();

        Number[] cnt = new Number[35+1];
        for (int i = 0; i <= 35; i++) {
            cnt[i] = new Number(i);
        }

        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            String cur = nextLine();
            arr[i] = cur.toCharArray();

            for (int j = 0; j < cur.length(); j++) {
                int num = atoi(cur.charAt(j));
                int digit = cur.length()-j-1;
                cnt[num].add36BaseDigit(digit);
            }
        }

        for (int i = 0; i < cnt.length; i++)
            cnt[i].makeCntToGap();

        Arrays.sort(cnt);

        int k = nextInt();
        boolean[] selectedNum = new boolean[35+1];
        for (int i = 0; k-->0 && i < cnt.length; i++) {
            selectedNum[cnt[i].num] = true;
        }

        int[] answer = new int[52];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int digit = arr[i].length - j - 1;
                int cur = atoi(arr[i][j]);
                answer[digit] += (selectedNum[cur] ? 35 : cur);
            }
        }

        for (int digit = 0; digit < answer.length-1; digit++) {
            int cur = answer[digit];
            answer[digit] = cur % 36;
            answer[digit+1] += cur / 36;
        }

        boolean firstZeroChk = true;
        for (int digit = answer.length-1; digit >= 0 ; digit--) {
            if (firstZeroChk && answer[digit] == 0) continue;
            firstZeroChk = false;
            write(itoa((int)answer[digit]));
        }
        if (firstZeroChk)
            System.out.println(0);
        else
            flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
