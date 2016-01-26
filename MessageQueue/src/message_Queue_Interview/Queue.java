package message_Queue_Interview;

import java.util.LinkedList;
/*
 * This is the father class of messageQueue.java, in this class, a raw queue is
 * implemented using the structure LinkedList. 
 * */
public class Queue {
	LinkedList<Message> queue = new LinkedList<Message>();
	
	public void enqueue(Message msg){
		// Put the message into the queue
		queue.add(msg);
	}
	
	public Message dequeue(){
		// Get a message from the queue
		if(queue.isEmpty()){
			System.out.println("The queue is empty.");
			return null;
		}
		return queue.poll();
	}
	
	public boolean isEmpty(){
		// Determine if the queue is empty, notify user that there's no message if it is.
		if(queue.isEmpty()){
			return true;
		}
		return false;
	}
	
	public void purge(){ 
		// Clear the queue.
		queue.clear();
	}
}
