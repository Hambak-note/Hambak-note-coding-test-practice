#include <iostream>
#include <list>
#include <vector>
//#pragma warning(disable:4996)
using namespace std;

vector<int> printList;

void josephus(int n, int m)
{
	list<int> survivors;
	for (int i = 1; i <= n; ++i) survivors.push_back(i);

	list<int>::iterator kill = survivors.begin();
	while (n > 1){
		for (int i = 0; i < m - 1; ++i){
			++kill;
			if (kill == survivors.end()) kill = survivors.begin();
		}
		printList.push_back(*kill);
		kill = survivors.erase(kill);
		if (kill == survivors.end()) kill = survivors.begin();
		--n;
	}
	printList.push_back(*(survivors.begin()));
}

int main(void)
{
	int N, M;
	cin >> N >> M;

	printList.clear();
	josephus(N, M);

	
	cout << "<";
	for (int i = 0; i < N-1; ++i){
		cout << printList.at(i) << ", ";
	}
	cout << printList.at(N - 1) << ">" << endl;
	
	return 0;
}