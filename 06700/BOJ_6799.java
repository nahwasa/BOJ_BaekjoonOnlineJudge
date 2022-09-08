import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Computer implements Comparable<Computer> {
    String name;
    int factor;
    public Computer(String name, int r, int s, int d) {
        this.name = name;
        this.factor = 2*r+3*s+d;
    }

    @Override
    public int compareTo(Computer o) {
        if (o.factor == this.factor)
            return this.name.compareTo(o.name);
        return o.factor - this.factor;
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Computer[] arr = new Computer[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Computer(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        if (n == 0) {
            return;
        }
        if (n == 1) {
            System.out.println(arr[0].name);
            return;
        }
        Arrays.sort(arr);
        System.out.println(arr[0].name + "\n" + arr[1].name);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
