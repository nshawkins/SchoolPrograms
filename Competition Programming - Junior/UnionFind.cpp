#include <iostream>
#include <vector>
using namespace std;

vector<int> parent;
vector<int> rankarr;

int root(int i){
	return (parent[i] == i) ? i : parent[i] = root(parent[i]);
}

bool same(int i, int j){
	return root(i) == root(j);
}

void makeunion(int i, int j){
	if (!same(i, j)){
		int x = root(i);
		int y = root(j);
		if (rankarr[x] > rankarr[y]){
			parent[y] = x;
			// size of x += y;
		}
		else{
			parent[x] = y;
			// size of y += x;
			if (rankarr[x] == rankarr[y]){
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
	parent.resize(n);
	rankarr.resize(n);

	int q;
	cin >> q;
	for (int i = 0; i < n; i++) {
		parent[i] = i;
	}
	for (int i = 0; i < n; i++){
		rankarr[i] = 0;
	}
	for (int i = 0; i < q; i++) {
		char whatis;
		cin >> whatis;
		int num1;
		int num2;
		cin >> num1;
		cin >> num2;
		if (whatis == '?') {
			if (same(num1, num2)) {
				cout << "yes\n";
			}
			else {
				cout << "no\n";
			}
		}
		else if (whatis == '=') {
			makeunion(num1, num2);
		}
	}
}