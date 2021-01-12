using System;
using System.IO;
using System.Text;

namespace Prac {
    class Program {
        private static StreamReader sr = new StreamReader(Console.OpenStandardInput());
        private static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

        static void Main(String[] args) {
            int tc = int.Parse(sr.ReadLine());
            while (tc-->0) {
                string[] tmp = sr.ReadLine().Split(" ");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tmp.Length; i++) {
                    sb.Append(reverseStr(tmp[i]));
                    sb.Append(i < tmp.Length-1 ? " " : "\n");
                }
                sw.Write(sb.ToString());
            }
            sr.Close();
            sw.Flush();
            sw.Close();
        }

        private static string reverseStr(string str) {
            char[] strArr = str.ToCharArray();
            char[] resArr = new char[str.Length];
            for (int i = 0; i < str.Length; i++)
                resArr[i] = strArr[str.Length-i-1];
            return new string(resArr);
        }
    }
}
