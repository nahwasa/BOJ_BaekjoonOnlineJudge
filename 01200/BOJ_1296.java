import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String boyName = br.readLine();
		int n = Integer.parseInt(br.readLine());
		LinkedList<Girl> ll = new LinkedList<Girl>();
		
		int[] boyCnt = getLOVEcnt(boyName);
		
		for (int i = 0; i < n; i++) {
			String girlName = br.readLine();	
			
			ll.add(new Girl(girlName, getLoveChance(boyCnt, getLOVEcnt(girlName))));			
		}
		
		Collections.sort(ll);
		
		bw.write(ll.get(0).getName() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}	
	
	private static int getLoveChance(int[] boyCnt, int[] girlCnt) {
		int L = boyCnt[0] + girlCnt[0];
		int O = boyCnt[1] + girlCnt[1];
		int V = boyCnt[2] + girlCnt[2];
		int E = boyCnt[3] + girlCnt[3];
		
		return ((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100;		
	}

	private static int[] getLOVEcnt(String str) {
		int[] result = new int[4];
		
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'L' :
				result[0]++;
				break;
			case 'O' :
				result[1]++;
				break;
			case 'V' :
				result[2]++;
				break;
			case 'E' :
				result[3]++;
				break;
			}
		}
		
		return result;
	}
}
	

class Girl implements Comparable<Girl> {
	private int chance;
	private String name;
	
	public Girl(String name, int chance) {
		this.chance = chance;
		this.name = name;
	}

	public int getChance() {
		return chance;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Girl g) {
		if (this.chance == g.getChance()) {
			return this.name.compareTo(g.getName());
		}		
		return g.getChance() - this.chance;
	}
}
