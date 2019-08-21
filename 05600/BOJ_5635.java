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
		Student[] arr = new Student[N];
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[N] = new Student(
					st.nextToken(),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					);
		}
		Arrays.sort(arr);
		bw.write(arr[arr.length-1].name + "\n" + arr[0].name + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Student implements Comparable<Student> {
	String name;
	int d,m,y;
	public Student(String name, int d, int m, int y) {
		this.name = name;
		this.d = d;
		this.m = m;
		this.y = y;
	}	
	@Override
	public int compareTo(Student s) {
		if (y != s.y) return y-s.y;
		if (m != s.m) return m-s.m;
		return d-s.d;
	}	
}
