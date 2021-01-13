using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Prac {
    class Program {
        private static StreamReader sr = new StreamReader(Console.OpenStandardInput());
        private static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

        static void Main(String[] args) {
            string input = sr.ReadLine();
            StringBuilder sb = new StringBuilder();
            List<char> l = new List<char>();
            char[] arr = input.ToCharArray();
            int i = -1;
            bool isTag = false;
            while(++i < arr.Length) {
                if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= '0' && arr[i] <= '9')) {
                    l.Add(arr[i]);
                    continue;
                }
                switch (arr[i]) {
                case '>' :
                    isTag = false;
                    sb.Append(getStr(l, 0));
                    sb.Append(arr[i]);
                    break;
                case ' ' :
                    if (!isTag) { 
                        sb.Append(getStr(l, 1));
                        sb.Append(arr[i]);
                    } else {
                        l.Add(arr[i]);
                    }

                    break;
                case '<' :
                    isTag = true;
                    sb.Append(getStr(l, 2));
                    sb.Append(arr[i]);
                    break;
                }
            }
            sb.Append(getStr(l, 1));
            sw.Write(sb.ToString());
            
            sr.Close();
            sw.Flush();
            sw.Close();
        }

        private static string getStr(List<char> l, int type) {
            StringBuilder sb = new StringBuilder();
            int cnt = l.Count;
            switch (type) {
            case 0 :
                while (cnt-->0) {
                    sb.Append(l[0]);
                    l.RemoveAt(0);
                }
                break;
            default :
                while (cnt-->0) {
                    sb.Append(l[l.Count - 1]);
                    l.RemoveAt(l.Count - 1);
                }
                break;
            }
            return sb.ToString();
        }
    }
}
