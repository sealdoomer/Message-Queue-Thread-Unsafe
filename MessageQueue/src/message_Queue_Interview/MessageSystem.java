package message_Queue_Interview;

import java.util.ArrayList;

public class MessageSystem {
	/*
	 * Message System class, manages the message subscription and publishing
	 * */
	
	/*
	 * In this case, I setup the message ID to be self incremental. every time
	 * the publish() executes, messageID increases by 1
	 * */ 
	
	// The messageID starts from 0
	private static int messageID = 0;
	// We need an ArrayList to contain the message queues
	ArrayList<MessageQueue> mq = new ArrayList<MessageQueue>();
	// The queueNumber limits the maximum number of message queues allowed in the system
	MessageSystem(int queueNumber){
		for(int i = 0; i < queueNumber; i++){
			MessageQueue msq = new MessageQueue(i);
			mq.add(msq);
		}
	}
	
	// queueID indicates which message queue the user wants to subscribe
	public ArrayList<Message> subscribe(int queueID){
		ArrayList<Message> subM = new ArrayList<Message>();
		if(mq.get(queueID - 1).isEmpty()){
			System.out.println("No message to deliver.");
			return subM;
		}
		while(!mq.get(queueID - 1).isEmpty()){
			// Return all the messages to the subscriber in the subscribed queue
			subM.add(mq.get(queueID - 1).dequeue());
		}
		return subM;
	}
	
	public void publish(int queueID, String msg){
		Message message = new Message(messageID, msg);
		// Push the message into the message queue
		mq.get(queueID - 1).enqueue(message);
		messageID++;
	}
}
