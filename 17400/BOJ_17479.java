import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Menu {
	Map<String, Integer> map;
	Set<String> set;
	boolean isMap;
	public Menu(boolean isMap, BufferedReader br, int num) throws Exception {
		this.isMap = isMap;
		if (isMap)	map = new HashMap<>();
		else		set = new HashSet<>();
		input(br, num);
	}
	boolean contains(String s) {
		if (isMap)	return map.containsKey(s);
		return set.contains(s);
	}
	void add(String s) {
		set.add(s);
	}
	void add(String s, int i) {
		map.put(s, i);
	}
	int get(String s) {
		return map.get(s);
	}
	private void input(BufferedReader br, int num) throws Exception {
		while (num-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (isMap)	add(st.nextToken(), Integer.parseInt(st.nextToken()));
			else		add(st.nextToken());
		}
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Menu[] menu = new Menu[3];
		menu[0] = new Menu(true, br, Integer.parseInt(st.nextToken()));
		menu[1] = new Menu(true, br, Integer.parseInt(st.nextToken()));
		menu[2] = new Menu(false, br, Integer.parseInt(st.nextToken()));
		
		int n = Integer.parseInt(br.readLine());
		int[] sum = new int[2];
		boolean[] chk = new boolean[3];
		while (n-->0) {
			String tmp = br.readLine();
			if (menu[0].contains(tmp)) {
				if (sum[0]+sum[1] < 50000 || sum[0] < 20000)	sum[0] += menu[0].get(tmp);
				chk[0] = true;
			} else if (menu[1].contains(tmp)) {
				if (sum[0]+sum[1] < 50000)	sum[1] += menu[1].get(tmp);
				chk[1] = true;
			} else {
				if (chk[2]) {
					System.out.println("No");
					return;
				}
				chk[2] = true;
			}
		}

		if (chk[1] && sum[0] < 20000) {
			System.out.println("No");
			return;
		}
		if (chk[2] && sum[0]+sum[1] < 50000) {
			System.out.println("No");
			return;
		}
		System.out.println("Okay");
	}
}
