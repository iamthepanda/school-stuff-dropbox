#include <stdio.h> /* for printf() and fprintf() */
#include <sys/socket.h> /* for socket(), connect(), send(), and recv() */
#include <arpa/inet.h> /* for sockaddr_in and inet_addr() */
#include <stdlib.h> /* for atoi() */
#include <string.h> /* for memset() */
#include <unistd.h> /* for close() */

#define RCVBUFSIZE 32 /* Size of receive buffer */

typedef enum { false, true } bool;
bool flag = false;

int sock; /* Socket descriptor */
struct sockaddr_in echoServAddr; /* Echo server address */
unsigned short echoServPort; /* Echo server port */
char *servlP; /* arg Server IP address (dotted quad) */
// char *servIP[20]; /* input Server IP address (dotted quad) */
char *servIP; /* input Server IP address (dotted quad) */
char *echoString; /* String to send to echo server */
char username[32]; /* username to send to echo server */
char password[32]; /* password to send to echo server */
char usernameAndPassword[32];
char echoBuffer[RCVBUFSIZE]; /* Buffer for echo string */
unsigned int echoStringLen; /* Length of string to echo */
unsigned int echoUsernameLen; /* Length of string to echo */
unsigned int echoPasswordLen; /* Length of string to echo */
int bytesRcvd, totalBytesRcvd; /* Bytes read in single recv() and total bytes read */

void DieWithError(char *errorMessage); /* Error handling function */

void connectToServer(){
    printf("Please enter the IP address: ");
    // scanf("%s",servIP);
    servIP = "0.0.0.0";
    printf("Please enter the port number: ");
    // scanf("%d",&echoServPort);
    echoServPort = 8008;
    
    printf("Connecting.....\n");
    
    /* Create a reliable, stream socket using TCP */
    if ((sock = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0)
        DieWithError(" socket () failed") ;
    
    /* Construct the server address structure */
    memset(&echoServAddr, 0, sizeof(echoServAddr)); /* Zero out structure */
    echoServAddr.sin_family = AF_INET; /* Internet address family */
    echoServAddr.sin_addr.s_addr = inet_addr(servIP); /* Server IP address */
    echoServAddr.sin_port = htons(echoServPort); /* Server port */
    /* Establish the connection to the echo server */
    if (connect(sock, (struct sockaddr *) &echoServAddr, sizeof(echoServAddr)) < 0)
        DieWithError(" connect () failed");


    printf("Connected!\n");
    printf("Welcome! Please log in.\n");
    printf("Username: ");
    // scanf("%s",username);


	strcpy(username, "Alice");
    printf("Password: ");
    // scanf("%s",password);
	strcpy(password, "123456");
	
	// char str[80];
	strcpy(usernameAndPassword, "\n");
	strcat(usernameAndPassword, username);
	strcat(usernameAndPassword, "\n");
	strcat(usernameAndPassword, password);
	
	// &usernameAndPassword = &username + "\n" + &password;
	
    echoUsernameLen = sizeof(usernameAndPassword); /* Determine input length */

    // echoPasswordLen = sizeof(password); /* Determine input length */
	
	

    /* Send the string to the server */
    if (send(sock, usernameAndPassword, echoUsernameLen, 0) != echoUsernameLen)
        DieWithError("send() sent a different number of bytes than expected");
    


    /* Send the string to the server */
    // if (send(sock, password, echoPasswordLen, 0) != echoPasswordLen)
//         DieWithError("send() sent a different number of bytes than expected");
    
}


void display_menu(){
    printf("0. Connect to the server\n");
    printf("1. Get the user list\n");
    printf("2. Send a message\n");
    printf("3. Get my messages\n");
    printf("4. Initiate a chat with my friend\n");
    printf("5. Chat with my friend\n");
}

void selectionHandler(int input){
    switch(input){
        case 0:
            connectToServer();
            break;
        case 1:
            printf("This is the user list\n");
            // getUserList();
            break;
        case 2:
            printf("Send a text message\n");
            // sendMessage();
            break;
        case 3:
            printf("Get my messages\n");
            // getMessages();
            break;
        case 4:
            printf("Initiate a chat\n");
            // initiateChat();
            break;
        case 5:
            printf("Chat with my friend\n");
            // chat();
            break;
        default:
            printf("%d is not an acceptable input\n",input);
            // using = false;
    }
}



int main(int argc, char *argv[])
{

    int inputOption;
    printf("-----------------------------------------\nCommand:\n");

    for(;;){
        display_menu();
        printf("Your option(enter a number): ");
        if(flag==true)
            scanf("%d",&inputOption);
        selectionHandler(inputOption);
        flag = true;
    }

    // if ((argc < 3) || (argc > 4)) /* Test for correct number of arguments */
    // {
    //     fprintf(stderr, "Usage: %s <Server IP> <Echo Word> [<Echo Port>]\n", argv[0]);
    //     exit(1);
    // }

    // // servlP = argv[1] ; /* First arg' server IP address (dotted quad) */
    // echoString = argv[2] ; /* Second arg' string to echo */

    // if (argc == 4)
    //     echoServPort = atoi(argv[3]); /* Use given port, if any */
    // else
    //     echoServPort = 7; /* 7 is the well-known port for the echo service */







    echoStringLen = strlen(echoString); /* Determine input length */


/* Send the string to the server */
    if (send(sock, echoString, echoStringLen, 0) != echoStringLen)
        DieWithError("send() sent a different number of bytes than expected");


/* Receive the same string back from the server */
    totalBytesRcvd = 0;
    printf("Received: "); /* Setup to print the echoed string */
    while (totalBytesRcvd < echoStringLen)
    {
        
        /* Receive up to the buffer size (minus i to leave space for a null terminator) bytes from the sender */
        if ((bytesRcvd = recv(sock, echoBuffer, RCVBUFSIZE - 1, 0)) <= 0)
            DieWithError("recv() failed or connection closed prematurely");
        totalBytesRcvd += bytesRcvd; /* Keep tally of total bytes */
        echoBuffer[bytesRcvd] = '\0'; /* Terminate the string! */
        printf(echoBuffer); /* Print the echo buffer */
    }

    printf("\n"); /* Print a final linefeed */

    close(sock);
    exit(0);
}
