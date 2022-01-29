import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Name implements Comparable<Name> {
    String first, last;
    public Name(String name) {
        StringTokenizer st = new StringTokenizer(name);
        first = st.nextToken();
        last = st.nextToken();
    }

    @Override
    public int compareTo(Name o) {
        if (this.last.compareTo(o.last) == 0)
            return this.first.compareTo(o.first);
        return this.last.compareTo(o.last);
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Name[] arr = new Name[n];
        while (n-->0) {
            arr[n] = new Name(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder answer = new StringBuilder();
        for (Name name : arr) {
            answer.append(name.first).append(' ').append(name.last).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
