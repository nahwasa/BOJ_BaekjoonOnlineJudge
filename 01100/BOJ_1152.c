#include <stdio.h>

int main(void)
{
    char str[1000001];
    int count = 0, result = 0;
    scanf("%[^\n]s", str);
    if (str[0] == ' ' && str[1] == '\0') {
        printf("0\n");
        return 0;
    }
    if (str[0] == ' ')  str[0] = 'a';
    int cnt = 0;
    int idx = -1;
    while (str[++idx] != '\0') {
        if (str[idx] == ' ')
            cnt++;
    }
    if (str[idx-1] != ' ')
        cnt++;
    printf("%d\n", cnt);
    return 0;
}
