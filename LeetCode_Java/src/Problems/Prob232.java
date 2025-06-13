package Problems;

import java.util.ArrayDeque;
import java.util.Stack;

public class Prob232 {
	

	static void test() {
		MyQueue testQueue = new MyQueue();
		testQueue.push(1);
		testQueue.push(2);
		testQueue.push(3);
		testQueue.push(4);
		testQueue.push(5);
		System.out.println(testQueue.pop());
		System.out.println(testQueue.pop());
		System.out.println(testQueue.pop());
		System.out.println(testQueue.pop());
		System.out.println(testQueue.pop());

	}

	public static void main(String args[]) {
		test();
	}

}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
	//primary stack and auxiliary stack
	ArrayDeque<Integer> pStk, auxStk;
	
    public MyQueue() {
    	pStk = new ArrayDeque<>();
    	auxStk = new ArrayDeque<>();
    }
    
    public void push(int x) {
    	while (!pStk.isEmpty()) {
    		auxStk.push(pStk.pop());
    	}//end while
    	auxStk.push(x);
    	
    	while (!auxStk.isEmpty()) {
    		pStk.push(auxStk.pop());
    	}//end while
    }
    
    public int pop() {
        return pStk.pop();
    }
    
    public int peek() {
    	return pStk.peek();
    }
    
    public boolean empty() {
    	return pStk.isEmpty();
    }
}

