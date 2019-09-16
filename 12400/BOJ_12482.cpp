#include <iostream>
#include <string>
#include <math.h>
using namespace std;

int main(){
   cin.tie(NULL);
   ios_base::sync_with_stdio(false);
   
   int tc;
   cin >> tc;
   for (int i = 1; i <= tc; i++) {
      string s;
      cin >> s;
      long long bit0Chk = 0;
      long long bit1Chk = 0;
      for (int i = 0; i < s.length(); i++) {
         switch(s.at(i)) {
         case '0' :
            bit0Chk |= 1l << (s.length()-1-i);
            break;
         case '1' :
            bit1Chk |= 1l << (s.length()-1-i);
            break;
         default :
            // ?인경우 -> 처리안함
            break;
         }
      }
      long long tmp = 1;
      for (long long l = sqrt(pow(2, s.length()-1)); ; l++) {
         tmp = l * l;
         if ((tmp&bit0Chk) == 0 && (tmp&bit1Chk) == bit1Chk)
            break;
      }
      string sTmp;
      for (int i = 0; i < s.length(); i++) {
      	sTmp.insert(0, (tmp&1)==1?"1":"0");
      	tmp>>=1;
      }
      cout << "Case #" << i << ": " << sTmp << endl;
   }
   return 0;
}
