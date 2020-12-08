using System;
using System.Text;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int sumLimit = int.Parse(input[1]);
            int limit = int.Parse(input[2]);

            int cnt = 0;
            StringBuilder sb = new StringBuilder();

            while (n-- > 0) {
                string pps = Console.ReadLine();
                string[] tmp = pps.Split();
                int sum = 0;
                Boolean flag = true;
                foreach (string s in tmp) {
                    int score = int.Parse(s);
                    if (score < limit) {
                        flag = false;
                        break;
                    }
                    sum += score;
                }
                if (flag) {
                    if (sum < sumLimit)
                        continue;
                    cnt++;
                    sb.Append(pps + " ");
                }               
            }

            Console.WriteLine(cnt);
            Console.WriteLine(sb.ToString());
        }
    } 
}
