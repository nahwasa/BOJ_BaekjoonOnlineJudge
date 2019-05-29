import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int TEAM1 = 1;
	private static final int TEAM2 = 2;

	private static boolean[][] arr;	// 서로간의 연관관계를 저장
	private static int[] team;		// n번이 몇번팀에 속하는지 저장
	private static int studentNum;	// 입력받은 학생 수
	private static int[] relationCnt;	// 속도를 빠르게 하기위해 사용. 각 학생의 연관관계 갯수 저장
	private static int[] teamCnt;	// 속도를 빠르게 하기위해 사용. 1팀과 2팀에 현재 속한 팀원수를 저장.

	private static boolean isStudentCanBeTeam(int student, int teamNum) {		
		for (int i = 1; i <= studentNum; i++) {			
			if (i != student && team[i] == teamNum && !arr[student][i])
				return false;
		}		
		return true;
	}

	private static void checkTeam(int student, int teamNum) {
		team[student] = teamNum;
		teamCnt[teamNum]++;

		if(teamCnt[teamNum] <= relationCnt[student])
			return;

		for (int i = 1; i <= studentNum; i++) {
			if (student == i || team[i] != 0)
				continue;			

			if (arr[student][i] && isStudentCanBeTeam(i, teamNum))
				checkTeam(i, teamNum);
		}
	}

	private static boolean isAllStudentHasTeam() {
		for (int i = 1; i <= studentNum; i++)
			if (team[i] == 0)
				return false;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		studentNum = Integer.parseInt(sc.readLine());
		arr = new boolean[studentNum+1][studentNum+1];
		relationCnt = new int[studentNum+1];
		teamCnt = new int[3];


		while(true) {	// 입력받아 관계표 작성
			StringTokenizer st = new StringTokenizer(sc.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1)
				break;

			arr[a][b] = true;
			arr[b][a] = true;
			relationCnt[a]++;
			relationCnt[b]++;
		}

		for(int i = 1; i <= studentNum; i++) {
			team = new int[studentNum+1];

			checkTeam(i, TEAM1);

			int team2Leader = 0;
			for(int k = 1; k <= studentNum; k++) {
				if (team[k] == 0) {
					team2Leader = k;
					break;
				}
			}

			if (team2Leader == 0) {	// 이미 팀 한개로 가능할 시
				printTeam(bw);
				bw.flush();
				bw.close();
				sc.close();
				return;
			}
			checkTeam(team2Leader, TEAM2);

			if (isAllStudentHasTeam()) {	// 팀 둘로 팀 짜기가 가능한 경우
				printTeam(bw);
				bw.flush();
				bw.close();
				sc.close();
				return;
			}
		}

		// 여기까지 왔다면 팀 짜기가 불가능한 경우.
		bw.write("-1");
		bw.flush();
		bw.close();
		sc.close();

	}

	private static void printTeam(BufferedWriter bw) throws IOException  {
		StringBuffer team1 = new StringBuffer();
		StringBuffer team2 = new StringBuffer();

		/*
		 * 1번 학생이 포함된 팀을 먼저 출력해야 하므로
		 */
		if (team[1] == TEAM1) {
			for (int i = 1; i <= studentNum; i++) {
				if (team[i] == TEAM1)
					team1.append(i + " ");
				else
					team2.append(i + " ");
			}
		} else {
			for (int i = 1; i <= studentNum; i++) {
				if (team[i] == TEAM1)
					team2.append(i + " ");
				else
					team1.append(i + " ");
			}
		}		

		team1.append("-1");
		team2.append("-1");

		bw.write("1\n" + team1.toString() + "\n");
		bw.write(team2.toString() + "\n");
	}
}
