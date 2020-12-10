using System;
using System.IO;
using System.Text;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            StreamReader sr = new StreamReader(Console.OpenStandardInput());
            StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

            int n = int.Parse(sr.ReadLine());
            char[] str = sr.ReadLine().ToCharArray();
            char[][] arr = new char[2 * n+1][];
            for (int i = 0; i < arr.Length; i++) {
                arr[i] = new char[n];
                for (int j = 0; j < arr[i].Length; j++) {
                    arr[i][j] = '.';
                }
            }

            int cur = n;
            int positive = n;
            int negative = n;
            Boolean swt = true;
            for (int i = 0; i < n; i++) {
                if (str[i] == '=') {
                    arr[cur][i] = '_';
                    swt = true;
                    continue;
                }
                
                switch (str[i]) {
                    case '+':   arr[cur++][i] = '/';  swt = false;    break;
                    case '-':   if (swt) --cur; arr[cur][i] = '\\';     break;
                }
                positive = Math.Max(cur, positive);
                negative = Math.Min(cur, negative);
                swt = true;
            }
            swt = false;
            for (int j = 0; j < n; j++) {
                if (arr[positive][j] != '.')
                    swt = true;
            }
            for (int i = swt?positive:positive-1; i >= negative; i--) {
                sw.WriteLine(arr[i]);
            }
            sw.Flush();
            sr.Close();
            sw.Close();
        }
    }
}
