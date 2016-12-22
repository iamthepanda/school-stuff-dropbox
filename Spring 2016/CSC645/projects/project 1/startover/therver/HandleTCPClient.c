#include <stdio.h> /* for printf() and fprintf() */
#include <sys/socket.h> /* for recv() and send() */
#include <unistd.h> /* for close() */
#include <string.h> /* for memset() */
#define RCVBUFSIZE 32 /* Size of receive buffer */
void DieWithError(char *errorMessage); /* Error handling function */

void HandleTCPClient(int clntSocket)
{
    char echoBuffer[RCVBUFSIZE]; /* Buffer for echo string */
    int recvMsgSize; /* Size of received message */
    int newRecvMsgSize; /* Size of received message */
    int bytesRcvd, totalBytesRcvd; /* Bytes read in single recv() and total bytes read */
unsigned int echoStringLen; /* Length of string to echo */




//  Local Declaration
char **temp[1000];
char proc[15];
char *entry;
char *loc;
int success = 0;
    //
    // /* Receive message from client */
    // if ((recvMsgSize = recv(clntSocket, echoBuffer, RCVBUFSIZE, 0)) < 0)
    //     DieWithError("recv() failed") ;
	

    // echoStringLen = strlen(RCVBUFSIZE); /* Determine input length */
	
	
/* Receive the same string back from the server */
    totalBytesRcvd = 0;
    while (totalBytesRcvd < 8)
    {
        
        /* Receive up to the buffer size (minus i to leave space for a null terminator) bytes from the sender */
        if ((recvMsgSize = recv(clntSocket, echoBuffer, RCVBUFSIZE - 1, 0)) <= 0)
            DieWithError("recv() failed or connection closed prematurely");
        totalBytesRcvd += recvMsgSize; /* Keep tally of total bytes */
		
        echoBuffer[recvMsgSize] = '\0'; /* Terminate the string! */
		// for(int i = 0; i<recvMsgSize; i++){

        printf("Log in User name is ");
		
		
		// for(int i=0; i<recvMsgSize; i++){
		strcpy(*temp[0],(strtok(echoBuffer, "\n\n")));
		if(temp)
 			printf(echoBuffer); /* Print the echo buffer */
		

		strcpy(*temp[32],(strtok(echoBuffer, "\n")));
		if(temp)
	 		printf(echoBuffer); /* Print the echo buffer */
		// }
		
		
		
		
    }

    printf("\n"); /* Print a final linefeed */
	
	
	
	newRecvMsgSize = recvMsgSize;
    /* Send received string and receive again until end of transmission */
    while (recvMsgSize > 0) /* zero indicates end of transmission */
    {

        /* Echo message back to client */
        if (send(clntSocket, echoBuffer, recvMsgSize, 0) != recvMsgSize)
            DieWithError("send() failed");

        // /* See if there is more data to receive */
//         if ((recvMsgSize = recv(clntSocket, echoBuffer, RCVBUFSIZE, 0)) < 0)
//             DieWithError("recv() failed") ;
		

	    // echoStringLen = strlen(echoBuffer); /* Determine input length */
		
	/* Receive the same string back from the server */
	    // totalBytesRcvd = 0;
// 	    printf("Received: "); /* Setup to print the echoed string */
//
// 	    while (totalBytesRcvd < newRecvMsgSize)
// 	    {
        
	        /* Receive up to the buffer size (minus i to leave space for a null terminator) bytes from the sender */
	        if ((recvMsgSize = recv(clntSocket, echoBuffer, RCVBUFSIZE, 0)) < 0)
	            DieWithError("recv() failed or connection closed prematurely");
	        // totalBytesRcvd += recvMsgSize; /* Keep tally of total bytes */
// 	        echoBuffer[recvMsgSize] = '\0'; /* Terminate the string! */
// 	        printf(echoBuffer); /* Print the echo buffer */
// 	    }
//
// 	    printf("\n"); /* Print a final linefeed */

    }


	printf("closing clnSocket\n");
    close(clntSocket); /* Close client socket */
}
