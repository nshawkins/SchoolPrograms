#include <iostream>
#include <string>

using namespace std;
int main() {
	int n = 0;
	string house; int low = 0; int high = 0; int interval = 0; string plus = "+"; bool concat = false; int sum = 0;
	string answer;
	int marble[10];
	string address;
	string eatWord;
	int addrNum = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin.ignore();
		getline(cin, address);
		if (concat == true) {
			address = house + " " + address;
			concat = false;
		}
		cin >> addrNum;
		cin >> eatWord;
		for (int i = 0; i < 10; i++) {
			marble[i] = 0;
		}
		sum = 0;
		for (int j = 0; j < addrNum; j++) {
			cin >> house;
			if (isdigit(house.at(0))) {
				answer += house;
			}
			else if (house == plus){
				cin >> low;
				cin >> high;
				cin >> interval;
				for (int k = low; k < high + 1; k += interval) {
					answer += to_string(k);
				}
			}
			else {
				concat = true;
				break;
			}
		}
		for (int j = 0; j < answer.length(); j++) {
			/*
			int number = answer.at(j);
			(int)number;
			cout << "number: " << number << endl;
			marble[number] += 1;
			*/
			if (answer.at(j) == '0') {
				marble[0] += 1;
			}
			else if (answer.at(j) == '1') {
				marble[1] += 1;
			}
			else if (answer.at(j) == '2') {
				marble[2] += 1;
			}
			else if (answer.at(j) == '3') {
				marble[3] += 1;
			}
			else if (answer.at(j) == '4') {
				marble[4] += 1;
			}
			else if (answer.at(j) == '5') {
				marble[5] += 1;
			}
			else if (answer.at(j) == '6') {
				marble[6] += 1;
			}
			else if (answer.at(j) == '7') {
				marble[7] += 1;
			}
			else if (answer.at(j) == '8') {
				marble[8] += 1;
			}
			else if (answer.at(j) == '9') {
				marble[9] += 1;
			}
		}
		answer = "";
		cout << address << endl << addrNum << " " << eatWord << endl;
		for (int j = 0; j < 10; j++) {
			cout << "Make " << marble[j] << " digit " << j << endl;
			sum += marble[j];
		}
		if (sum == 1) {
			cout << "In total 1 digit" << endl;
		}
		else {
			cout << "In total " << sum << " digits" << endl;
		}
	}
}