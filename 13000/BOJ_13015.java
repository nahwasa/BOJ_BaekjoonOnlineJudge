import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StarPrinter sp = new StarPrinter(n);

        sp.printTopAndBottom();
        sp.printUpperMiddle();
        sp.printMiddle();
        sp.printLowerMiddle();
        sp.printTopAndBottom();

        System.out.print(sp.getAnswer());
    }
}

class StarPrinter {
    private static final char STAR = '*';
    private static final char BLANK = ' ';
    private int n;
    private StringBuilder sb;

    public StarPrinter(int n) {
        this.n = n;
        this.sb = new StringBuilder();
    }

    public void printTopAndBottom() {
        printStar(n);
        printBlank(2*n-3);
        printStar(n);
        ln();
    }

    public void printUpperMiddle() {
        for (int i = 1; i <= n-2; i++) {
            printUpperAndLowerMiddle(n, i);
        }
    }

    public void printLowerMiddle() {
        for (int i = n-2; i >= 1; i--) {
            printUpperAndLowerMiddle(n, i);
        }
    }

    public void printMiddle() {
        printBlank(n-1);
        printStar();
        printBlank(n-2);
        printStar();
        printBlank(n-2);
        printStar();
        ln();
    }

    public String getAnswer() {
        return sb.toString();
    }

    private void printUpperAndLowerMiddle(int n, int i) {
        printBlank(i);
        printStar();
        printBlank(n-2);
        printStar();
        printBlank(2*(n-i-2)+1);
        printStar();
        printBlank(n-2);
        printStar();
        ln();
    }

    private void printStar() {
        printStar(1);
    }

    private void printStar(int n) {
        while (n-->0) sb.append(STAR);
    }

    private void printBlank(int n) {
        while (n-->0) sb.append(BLANK);
    }

    private void ln() {sb.append('\n');}
}
