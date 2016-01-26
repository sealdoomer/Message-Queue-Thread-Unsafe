package message_Queue_Interview;

public class Message {
	/*The message should have 2 attributes: the message ID and the message,
	 * in this case, message needs to be input manually by administrator. 
	*/
	int msgID;
	String msg;
	Message(int msgID, String msg){
		this.msgID = msgID;
		this.msg = msg;
	}
}
