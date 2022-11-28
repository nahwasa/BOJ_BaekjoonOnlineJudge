#include <iostream>
using namespace std;

int arr[100][100] = {0,};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, r, c, ans=0;
    cin >> n;
    while (n--) {
        cin >> r >> c;
        for (int i = r; i < r+10; i++) {
            for (int j = c; j < c+10; j++) {
                if (++arr[i][j] == 1)
                    ans++;
            }
        }
    }
    cout << ans;
}
