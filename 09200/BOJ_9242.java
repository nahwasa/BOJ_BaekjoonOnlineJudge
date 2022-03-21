import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String[] ORIGINAL = {
            "***   * *** *** * * *** *** *** *** ***",
            "* *   *   *   * * * *   *     * * * * *",
            "* *   * *** *** *** *** ***   * *** ***",
            "* *   * *     *   *   * * *   * * *   *",
            "***   * *** ***   * *** ***   * *** ***"
    };
    class Digit {
        boolean[][] arr;
        public Digit() {
            arr = new boolean[5][3];
        }

        @Override
        public boolean equals(Object obj) {
            Digit ano = (Digit)obj;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.arr[i][j] != ano.arr[i][j])
                        return false;
                }
            }
            return true;
        }
    }
    private void init(Digit[] digits) {
        for (int i = 0; i < 10; i++) {
            digits[i] = new Digit();
        }
        for (int i = 0; i < 5; i++) {
            String cur = ORIGINAL[i];
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < 3; k++) {
                    digits[j].arr[i][k] = cur.charAt(j*4+k)=='*'?true:false;
                }
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Digit[] digits = new Digit[10];
        init(digits);
        
        try {
            Digit[] inputs = new Digit[0];
            for (int i = 0; i < 5; i++) {
                String cur = br.readLine();
                if (i == 0) {
                    inputs = new Digit[cur.length() / 4 + 1];
                    for (int z = 0; z < inputs.length; z++) inputs[z] = new Digit();
                }
                for (int j = 0; j < inputs.length; j++) {
                    for (int k = 0; k < 3; k++) {
                        inputs[j].arr[i][k] = cur.charAt(j * 4 + k) == '*' ? true : false;
                    }
                }
            }


            int num = 0;
            for (int i = 0; i < inputs.length; i++) {
                num *= 10;
                boolean chk = true;
                for (int j = 0; j < 10; j++) {
                    if (inputs[i].equals(digits[j])) {
                        num += j;
                        chk = false;
                        break;
                    }
                }
                if (chk) {
                    System.out.println("BOOM!!");
                    return;
                }
            }
            System.out.println(num % 6 == 0 ? "BEER!!" : "BOOM!!");
        } catch (Exception e) {
            System.out.println("BOOM!!");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
