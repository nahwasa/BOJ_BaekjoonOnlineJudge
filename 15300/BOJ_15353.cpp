#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string add(string &a, string &b)
{
	string result(max(a.size(), b.size()), '0');
	bool c = false;

	for (int i = 0; i < result.size(); i++)
	{
		int tmp = c;
		c = false;

		if (i < a.size())
			tmp += a[a.size() - i - 1] - '0';
		if (i < b.size())
			tmp += b[b.size() - i - 1] - '0';
		if (tmp >= 10)
		{
			c = true;
			tmp -= 10;
		}

		result[result.size() - i - 1] = tmp + '0';
	}

	if (c)
		result.insert(result.begin(), '1');

	return result;
}

int main()
{
	string a, b;
	cin >> a >> b;
	cout << add(a, b) << endl;

    return 0;
}

