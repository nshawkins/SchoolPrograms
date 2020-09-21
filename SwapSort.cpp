#include <iostream>
#include <vector>
using namespace std;

const int MAX_NODES = 1000000;
int parent[MAX_NODES];
int rankarr[MAX_NODES];
int root(int i) {
	return (parent[i] == i) ? i : parent[i] = root(parent[i]);
}

bool same(int i, int j) {
	return root(i) == root(j);
}

void makeunion(int i, int j) {
	if (!same(i, j)) {
		int x = root(i);
		int y = root(j);
		if (rankarr[x] > rankarr[y]) {
			parent[y] = x;
		}
		else {
			parent[x] = y;
			if (rankarr[x] == rankarr[y]) {
				rankarr[y]++;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;

	int q;
	cin >> q;
	for (int i = 0; i < n; i++) {
		parent[i] = i;
		rankarr[i] = 0;
	}

	for (int i = 0; i < q; i++) {
		int num1;
		int num2;
		cin >> num1;
		cin >> num2;
		makeunion(num1, num2);
	}
	int top = n;
	int bottom = 1;
	bool isright = true;
	while (top > bottom && isright) {
		if (same(parent[top], parent[bottom])) {
			isright = true;
			top--;
			bottom++;
		}
		else {
			isright = false;
		}
	}
	if (isright) {
		cout << "yes";
	}
	else {
		cout << "no";
	}
}