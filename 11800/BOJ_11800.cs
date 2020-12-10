using System;
using System.IO;
using System.Text;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            StreamReader sr = new StreamReader(Console.OpenStandardInput());
            StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

            int n = int.Parse(sr.ReadLine());
            for (int i = 1; i <= n; i++) {
                new St(sr.ReadLine()).print(i, sw);
            }
            
            sw.Flush();
            sr.Close();
            sw.Close();
        }
    }

    class St {
        private static readonly string[] NUM_STR = { "", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh" };
        private static readonly string[] SAME_NUM_STR = { "", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh" };
        private static readonly string EXCEPT_STR = "Sheesh Beesh";

        int max, min;

        public St(string s) {
            string[] tmp = s.Split();
            int a = int.Parse(tmp[0]);
            int b = int.Parse(tmp[1]);
            max = Math.Max(a, b);
            min = Math.Min(a, b);
        }

        public void print(int caseNum, StreamWriter sw) {
            sw.Write(string.Format("Case {0}: ", caseNum));
            if (max == 6 && min == 5) {
                sw.WriteLine(EXCEPT_STR);
                return;
            }
            if (max == min) {
                sw.WriteLine(SAME_NUM_STR[max]);
                return;
            }
            sw.WriteLine(string.Format("{0} {1}", NUM_STR[max], NUM_STR[min]));
        }
    }
}
