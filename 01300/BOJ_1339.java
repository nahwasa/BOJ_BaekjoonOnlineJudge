import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	protected static final int MAX_STR_LENGTH = 8;	// 최대 길이가 8임
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Data[] arr = new Data['Z'-'A'+1];
		String[] str = new String[N];
		for (int i = 0; i <= 'Z'-'A'; i++)
			arr[i] = new Data((char)(i+'A'));
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			for (int j = 0; j < str[i].length(); j++)
				arr[str[i].charAt(str[i].length()-1-j)-'A'].addOrder(MAX_STR_LENGTH-1-j);
		}
		Arrays.sort(arr);
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int num = 9;
		for (Data d : arr) {
			if (d.size==0) break;
			hm.put(d.alphabet, num--);
		}
		long sum = 0;
		for (String s : str) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++)
				sb.append(hm.get(s.charAt(i)));
			sum += Integer.parseInt(sb.toString());
		}
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}

class Data implements Comparable<Data> {
	char alphabet;
	int[] order;
	int size;
	public Data(char alphabet) {
		this.alphabet = alphabet;
		this.order = new int[Main.MAX_STR_LENGTH];
		this.size = 0;
	}
	void addOrder(int pos) {
		size++;
		order[pos]++;
	}
	@Override
	public int compareTo(Data o) {
		for (int i = 0; i < Main.MAX_STR_LENGTH; i++)
			if (this.order[i] == o.order[i]) continue;
			else return o.order[i] - this.order[i];
		return 0;
	}
}
