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
		Student[] arr = new Student[3];
		for (int i = 0; i < 3; i++)
			arr[i] = new Student(i+1);
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				switch(Integer.parseInt(st.nextToken())) {
				case 1 : arr[i].cnt1++; arr[i].sum+=1; break;
				case 2 : arr[i].cnt2++; arr[i].sum+=2; break;
				case 3 : arr[i].cnt3++; arr[i].sum+=3; break;
				}
			}
		}
		Arrays.sort(arr);
		if (arr[0].compareTo(arr[1]) == 0)
			bw.write("0 " + arr[0].sum + "\n");
		else if (arr[0].compareTo(arr[1]) < 0)
			bw.write(arr[0].num + " " + arr[0].sum + "\n");
		else
			bw.write(arr[1].num + " " + arr[1].sum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}

class Student implements Comparable<Student>{
	int cnt3,cnt2,cnt1,sum,num;

	public Student(int num) {
		this.cnt3 = 0;
		this.cnt2 = 0;
		this.cnt1 = 0;
		this.sum = 0;
		this.num = num;
	}

	@Override
	public int compareTo(Student o) {
		if (this.sum!=o.sum)
			return o.sum-sum;
		if (cnt3!=o.cnt3)
			return o.cnt3-cnt3;
		if (cnt2!=o.cnt2)
			return o.cnt2-cnt2;	
		return o.cnt1-cnt1;		
	}	
}
