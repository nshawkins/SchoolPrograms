#include <iostream>
#include <vector>
#include <list>

using namespace std;
int main(){
	int n = 0;
	cin >> n;
	int max = 0;
	cin >> max;
	int in = 0;
	vector<int> arr;
	arr.resize(n);

	for (int i = 0; i < n; i++) {
		cin >> in;
		arr[i] = in;
	}

	vector<int> times;
	times.resize(n);
	// Integer [] position = new Integer[n];
	vector<int> position;
	position.resize(n);
	vector<vector<int>> master;
	master.resize(n, vector<int>(2));
	int visited = -1;
	for (int i = 0; i < n; i++) {
		int count = 1;
		if (arr[i] != -1) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					count++;
					arr[j] = visited;
				}
			}
		}
		if (arr[i] != visited) {
			times[i] = count;
			position[i] = arr[i];
		}
		master[i][0] = times[i];
		master[i][1] = position[i];
	}
	int i, j, imin;
	for (i = 0; i < n; i++) {
		imin = i;
		for (j = i + 1; j < n; j++) {
			if (master[j][0] < master[imin][0])
				imin = j;
			cout << "i: " << master[i][0] << " | imin: " << master[imin][0] << endl;
			swap(master[i][0], master[imin][0]);
			swap(master[i][1], master[imin][1]);
		}
		//cout << "---------------------------" << endl;
		cout << "master freq: " << master[i][0];
		cout << " | master pos: " << master[i][1] << endl;
	}
	for (int i = (n - 1); i >= 0; i--) {
		for (int j = 0; j < master[i][0]; j++) {
			cout << master[i][1] << " ";
		}
	}
}