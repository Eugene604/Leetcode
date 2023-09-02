package Problems;

import java.util.*;

public class Prob225 {
	
	
	private static void test() {
	

	}
	
	public static void main(String[] args) {
		test();
	}
}

class MyStack {
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	private Queue<Integer> tmpQueue;
	
	

    public MyStack() {
    	queue1 = new LinkedList<>();
    	queue2 = new LinkedList<>();
    }//end constructor
    
    public void push(int x) {
    	queue2.add(x);
    	while (!queue1.isEmpty()) {
    		queue2.add(queue1.poll());
    	}//end while
    	tmpQueue = queue1;
    	queue1 = queue2;
    	queue2 = tmpQueue;
    }//end method
    
    public int pop() {
    	return queue1.poll();
    }
    
    public int top() {
    	return queue1.peek();
    }
    
    public boolean empty() {
    	return queue1.isEmpty();
    }
	

}//end class

class MyStack_v1 {
	
	private static int[] stackArr = new int[135];
	private int lastStackElementInx;

	/*
    public MyStack() {
    	lastStackElementInx = -1;
    }//*/
    
    public void push(int x) {
    	++lastStackElementInx;
    	stackArr[lastStackElementInx] = x;
    }
    
    public int pop() {
    	if (lastStackElementInx < 0) {
    		return -1;
    	} else {
    		return stackArr[lastStackElementInx--];
    	}//fi
    }
    
    public int top() {
    	if (lastStackElementInx < 0) {
    		return -1;
    	} else {
    		return stackArr[lastStackElementInx];
    	}//fi
    }
    
    public boolean empty() {
    	return lastStackElementInx < 0;
    }

}//end class