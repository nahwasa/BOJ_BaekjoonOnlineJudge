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
            char[,] arr = new char[2 * n+1, n];
            for (int i = 0; i < arr.GetLength(0); i++) {
                for (int j = 0; j < arr.GetLength(1); j++) {
                    arr[i, j] = '.';
                }
            }

            int cur = n;
            int positive = n;
            int negative = n;
            Boolean swt = true;
            for (int i = 0; i < n; i++) {
                if (str[i] == '=') {
                    arr[cur, i] = '_';
                    swt = true;
                    continue;
                }
                
                switch (str[i]) {
                    case '+':   arr[cur++, i] = '/';  swt = false;    break;
                    case '-':   if (swt) --cur; arr[cur, i] = '\\';     break;
                }
                positive = Math.Max(cur, positive);
                negative = Math.Min(cur, negative);
                swt = true;
            }
            swt = false;
            for (int j = 0; j < n; j++) {
                if (arr[positive, j] != '.')
                    swt = true;
            }
            for (int i = swt?positive:positive-1; i >= negative; i--) {
                for (int j = 0; j < n; j++) {
                    sw.Write(arr[i, j]);
                }
                sw.WriteLine();
            }
            sw.Flush();
            sr.Close();
            sw.Close();
        }
    }
}
