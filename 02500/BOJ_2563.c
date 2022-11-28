#include <stdio.h>

const int RANGE = 10;
int ans = 0;
int arr[100][100] = {0,};

void increase(int r, int c) {
    for (int i = r; i < r+RANGE; i++) {
        for (int j = c; j < c+RANGE; j++) {
            if (++arr[i][j] == 1)
                ans++;
        }
    }
}

int main() {
    int arr[100][100] = {0,};
    int n, r, c;
    scanf("%d", &n);
    while (n--) {
        scanf("%d %d", &r, &c);
        increase(r, c);
    }
    printf("%d", ans);
    return 0;
}
