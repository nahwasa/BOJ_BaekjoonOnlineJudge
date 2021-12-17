import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

interface Tags {
    public static final int LEN_OF_A_TO_J = 'J'-'A'+1;
}

class Alphabet implements Comparable<Alphabet> {
    static boolean[] exist = new boolean[Tags.LEN_OF_A_TO_J];
    static int cnt = 0;

    int idx;
    long weight;
    boolean notZero;

    public Alphabet(int idx) {
        this.idx = idx;
        this.weight = 0;
        this.notZero = false;
    }

    public void addWeight(long weight) {
        this.weight += weight;
        setExist();
    }

    private void setExist() {
        if (!exist[idx]) {
            cnt++;
            exist[idx] = true;
        }
    }

    @Override
    public int compareTo(Alphabet o) {
        if (o.weight == this.weight) return 0;
        else if (o.weight > this.weight) return 1;
        return -1;
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Alphabet[] alphabets = new Alphabet[Tags.LEN_OF_A_TO_J];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = new Alphabet(i);
        }
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[i] = s;

            long w = 1;
            for (int j = s.length()-1; j >= 0; j--, w*=10) {
                int idx = s.charAt(j) - 'A';
                alphabets[idx].addWeight(w);
                if (j==0) {
                    alphabets[idx].notZero = true;
                }
            }
        }

        Arrays.sort(alphabets);
        if (Alphabet.cnt == Tags.LEN_OF_A_TO_J && alphabets[alphabets.length-1].notZero) {
            for (int i = alphabets.length-2; i >= 0; i--) {
                if (!alphabets[i].notZero) {
                    Alphabet tmp = alphabets[i];
                    for (int j = i; j < alphabets.length-1; j++) {
                        alphabets[j] = alphabets[j + 1];
                    }
                    alphabets[alphabets.length-1] = tmp;
                    break;
                }
            }
        }

        int[] weight = new int[Tags.LEN_OF_A_TO_J];
        int digit = 9;
        for (Alphabet ap : alphabets) {
            weight[ap.idx] = digit--;
        }

        long sum = 0;
        for (String s : arr) {
            long cur = 0;
            long w = 1;
            for (int j = s.length()-1; j >= 0; j--, w*=10) {
                int idx = s.charAt(j) - 'A';
                cur += weight[idx]*w;
            }
            sum += cur;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
