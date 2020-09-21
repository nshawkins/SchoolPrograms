#include <iostream>
#include <vector>

using namespace std;
int main() {
	int n;
	while (cin >> n && n != -1){
		vector<vector<int> > arr;
		arr.resize(n, vector<int>(n));

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				cin >> arr[i][j];
			}
		}

		for (int i = 0; i < n; i++){
			bool triangle = true;

			for (int j = 0; j < n; j++){
				for (int k = 0; k < n; k++){
					if (arr[i][k] == 1 && arr[i][j] == 1 && arr[j][k] == 1 && i != k && i != j && j != k){
						triangle = false;
					}
				}
			}

			if (triangle){
				cout << i << " ";
			}
		}
		cout << endl;
	}
}