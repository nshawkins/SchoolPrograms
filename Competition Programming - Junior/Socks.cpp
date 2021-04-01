#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;
int main()
{
	vector<int> arr;
	int n;
	cin >> n;
	n = n * 2;

	arr.resize(n);
	stack<int> original;
	stack<int> aux;

	int input; int count = 0; int temp = 0;

	for (int i = 0; i < n; i++){
		cin >> input;
		arr[i] = input;
	}
	for (int i = n - 1; i >= 0; i--){
		original.push(arr[i]);
	}
	while (count < 10000000){
		if ((original.empty() && aux.empty())){
			break;
		}
		else if (aux.empty() && !original.empty()){
			temp = original.top();
			original.pop();
			aux.push(temp);
			count++;
		}
		else if (!aux.empty() && original.empty()){
			temp = aux.top();
			aux.pop();
			original.push(temp);
			count++;
		}
		else if (original.top() != aux.top()){
			if (original.size() >= aux.size()){
				temp = original.top();
				original.pop();
				aux.push(temp);
				count++;
			}
			else{
				temp = aux.top();
				aux.pop();
				original.push(temp);
				count++;
			}
		}
		else if (original.top() == aux.top()){
			original.pop();
			aux.pop();
			count++;
		}
	}
	if (count < 10000000){
		cout << (count);
	} 
	else{
		cout << ("impossible");
	}

}
