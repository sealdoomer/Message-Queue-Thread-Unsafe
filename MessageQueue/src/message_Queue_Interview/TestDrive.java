package message_Queue_Interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDrive {
	public static void main(String args[]){
		MessageSystem msSystem = new MessageSystem(3);

		try{
			while(true){
				System.out.println("Please indicate the queue you want to put message into, type 'quit' to end: ");
				Scanner input = new Scanner(System.in);
				String queueIndex = input.next();
				if(queueIndex.equalsIgnoreCase("quit")){
					break;
				}
				System.out.println("Please input the message, type 'quit' to end: ");
				InputStreamReader is_reader = new InputStreamReader(System.in);
				String str = new BufferedReader(is_reader).readLine();
				if(str.equalsIgnoreCase("quit")){
					break;
				}
				msSystem.publish(Integer.parseInt(queueIndex), str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			System.out.println("Please indicate the queue you want to subscribe: ");
			Scanner input = new Scanner(System.in);
			int queueIndex = input.nextInt();
			if(queueIndex > msSystem.mq.size() || queueIndex < 0){
				throw new ArithmeticException("No such messageQueue, No message to deliver!");
			}
			ArrayList<Message> am = msSystem.subscribe(queueIndex);
			for(int i = 0; i < am.size(); i++){
				System.out.println(am.get(i).msg);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
