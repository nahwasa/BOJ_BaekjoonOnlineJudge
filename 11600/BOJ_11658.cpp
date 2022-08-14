#include <iostream>
#include <string.h>
using namespace std;

int N;
int arr[1025][1025];
int bit[1025][1025];

int getPrefixSum(int r, int c) {
    int sum = 0;
    while (r > 0) {
        int cc = c;
        while (cc > 0) {
            sum += bit[r][cc];
            cc -= cc&-cc;
        }
        r -= r&-r;
    }
    return sum;
}

void update(int r, int c, int diff) {
    while (r <= N) {
        int cc = c;
        while (cc <= N) {
            bit[r][cc] += diff;
            cc += cc&-cc;
        }
        r += r&-r;
    }
}

int query(int x1, int y1, int x2, int y2) {
    return getPrefixSum(x2, y2) - getPrefixSum(x2, y1-1) - getPrefixSum(x1-1,y2) + getPrefixSum(x1-1, y1-1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> N >> m;
    memset(bit, 0, sizeof(bit));
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> arr[i][j];
            update(i, j, arr[i][j]);
        }
    }

    int op, a, b, c, d, diff;
    while (m--) {
        cin >> op;
        if (op == 0) {
            cin >> a >> b >> c;
            diff = c - arr[a][b];
            arr[a][b] = c;
            update(a, b, diff);
        } else {
            cin >> a >> b >> c >> d;
            cout << query(a,b,c,d) << '\n';
        }
    }
    return 0;
}
