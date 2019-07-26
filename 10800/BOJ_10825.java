import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stud[] arr = new Stud[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Stud(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}			
		Arrays.sort(arr);
		for (Stud tmp : arr) bw.write(tmp.name + "\n");
		bw.close();
		br.close();
	}
}
class Stud implements Comparable<Stud> {
	String name;
	int[] n;
	public Stud(String name, int n1, int n2, int n3) {
		this.name = name;
		this.n = new int[3];
		n[0]=n1;
		n[1]=n2;
		n[2]=n3;
	}
	@Override
	public int compareTo(Stud o) {
		if (n[0]==o.n[0] && n[1]==o.n[1] && n[2]==o.n[2])
			return name.compareTo(o.name);
		else if (n[0]==o.n[0] && n[1]==o.n[1])
			return o.n[2]-n[2];
		else if (n[0]==o.n[0])
			return n[1]-o.n[1];
		else
			return o.n[0]-n[0];
	}
}
