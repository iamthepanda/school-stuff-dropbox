// The goal of this project is to write simple client and server programs for text messaging and Internet chatting. The programming language is C and the operating system is Linux.

#include <stdio.h>
#include <string.h>

const char * username[] = {
    "Alice",
    "Bob",
    "Fred",
};
const char * password[] = {
    "password",
    "Seconden",
    "Thirdent",
};

#define n_user (sizeof (username) / sizeof (const char *))

typedef enum { false, true } bool;
bool using = true;


void display_menu(){
	printf("0. Connect to the server\n");
	printf("1. Get the user list\n");
	printf("2. Send a message\n");
	printf("3. Get my messages\n");
	printf("4. Initiate a chat with my friend\n");
	printf("5. Chat with my friend\n");
}

// 0. Connect to the server
void connectToServer(){

	char usernameInput[16];
	char passwordInput[16];

	strcpy(usernameInput, "Alice");
	strcpy(passwordInput, "password");
	
	char* user = usernameInput;
	char* pass = passwordInput;

	bool verified = false;
	for(int i=0;i<n_user;i++){
		if(strcmp(user,username[i]) && strcmp(pass,password[i])){
			verified = true;
		}
	}

	if(verified == true){

		printf("User verified\n");

		printf("Hello %s.\n",user);
	}else{
		printf("User not verified\n");
	}
}

void getUserList(){
	for(int i;i<n_user;i++){
		printf("%s\n", username[i]);
	}
}

void sendMessage(){

	char recipientInput[16];
	strcpy(recipientInput, "Bob");
	
	printf("Enter recipient\n");

	char* recipient = recipientInput;

	bool recipientFound = false;
	for(int i=0;i<n_user;i++){
		if(strcmp(recipient,username[i])){
			recipientFound = true;
		}
	}

	if(recipientFound){

		printf("What do you want to send to %s?\n", recipient);
	}else{

		printf("%s is not on the list\n", recipient);
	}

}

void getMessages(){
	bool haveMessages = false;

	if(haveMessages){
		printf("You have messages\n");
	}
	else{
		printf("You have no messages\n");
	}
}

void initiateChat(){

}

void chat(){

}

void selectionHandler(int input){
	switch(input){
		case 0:
			printf("Connecting to the server\n");
			connectToServer();
			break;
		case 1:
			printf("This is the user list\n");
			getUserList();
			break;
		case 2:
			printf("Send a text message\n");
			sendMessage();
			break;
		case 3:
			printf("Get my messages\n");
			getMessages();
			break;
		case 4:
			printf("Initiate a chat\n");
			initiateChat();
			break;
		case 5:
			printf("Chat with my friend\n");
			chat();
			break;
		default:
			printf("exiting\n");
			using = false;
	}
}


int main(int argc, char const *argv[])
{
	int selection;
	display_menu();
	selection = 0;

	// scanf("%d", &selection);
	while(using){
		selectionHandler(selection);
		selection++;
	}

	return 0;
}