using System;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            int tc = int.Parse(Console.ReadLine());
            System.Text.StringBuilder sb = new System.Text.StringBuilder();
            while (tc-->0) {
                String[] arr = Console.ReadLine().Split();
                sb.Append(toReverseInt(toReverseInt(arr[0]) + toReverseInt(arr[1])));
                sb.AppendLine();
            }
            Console.WriteLine(sb.ToString());
        }

        static int toReverseInt(string s) {
            char[] tmp = new char[s.Length];
            for (int i = 0; i < s.Length; i++) {
                tmp[s.Length - i - 1] = s[i];
            }
            return int.Parse(tmp);
        }

        static int toReverseInt(int i)
        {
            return toReverseInt(i.ToString());
        }
    }
}
