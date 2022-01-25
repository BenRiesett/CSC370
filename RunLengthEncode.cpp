
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
using namespace std;
int main()
{
	std::string message;
	int errorCode;
	//the do-while loop is for the constraints listed in the project description. 
	//Only characters a-z, A-Z, 0-9, and {}[]():;'+=., are accepted by the system
	//Input must also be between 0 and 50 characters inclusive
	do
	{
		errorCode = 0;
		cout << "Enter the message to be encoded: ";
		std::getline(std::cin, message);
		if (message.size() > 50)
		{
			cout << "Message cannot be larger than 50 characters, try again.\n ";
			errorCode = 1;
		}
		else
		{
			for (int i = 0; i < message.size(); i++) //ASCII code is used to find the unaccepted characters and if the string contains them it is not accepted
			{
				if (message[i] >= 126 || message[i] == 124 || message[i] == 95 || message[i] == 94 || message[i] == 92 || message[i] == 64
					|| message[i] == 63 || message[i] == 62 || message[i] == 60 || message[i] == 47 || message[i] == 42 || message[i] == 38
					|| message[i] == 37 || message[i] == 36 || message[i] == 35 || message[i] == 34 || message[i] == 33)
				{
					cout << "Message has unacceptable characters. Acceptable characters inlcude a-z, A-Z, 0-9, and {}[]():;'+=.,\nPlease try again.\n";
					errorCode = 2;
					break;
				}
			}
		}
	} while (errorCode != 0);

	int i = 0;
	int count = 0;
	char storeChar = message[0];
	string output = "";
	stringstream stream;
	string countStr;

	for (i = 0; i < message.size(); i++)
	{
		if (i + 1 < message.size())
		{
			if (message[i] == message[i + 1]) //comparing the next 2 characters in the string
			{
				count++;
			}
			else if (count >= 9)
			{
				stream << count+1;
				stream >> countStr;
				output = output + "/" + countStr + storeChar;
				count = 0;
				storeChar = message[i + 1];
			}
			else if (count >= 4)
			{
				stream << count+1;
				stream >> countStr;
				output = output + "/0" + countStr + storeChar;
				count = 0;
				storeChar = message[i + 1];
			}
			else
			{
				for (int ii = 0; ii < count + 1; ii++)
				{
					output = output + storeChar;
				}
				storeChar = message[i+1];
				count = 0;
			}
		}
		else
		{
			if (count >= 9)
			{
				stream << count + 1;
				stream >> countStr;
				output = output + "/" + countStr + storeChar;
			}
			else if (count >= 4)
			{
				stream << count + 1;
				stream >> countStr;
				output = output + "/0" + countStr + storeChar;
			}
			else
			{
				output = output + storeChar;
			}
		}
	}
	cout << "Encoded: " + output;
	
}