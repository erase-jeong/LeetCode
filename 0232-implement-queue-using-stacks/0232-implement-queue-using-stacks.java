class MyQueue {
    Stack<Integer> inputStack=new Stack<>();
    Stack<Integer> outputStack=new Stack<>();

    public MyQueue() { //생성자

    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        while(inputStack.isEmpty()==false){
            outputStack.push(inputStack.pop()); //선입 선출로 만들기
        }
        int result=outputStack.pop();

        while(outputStack.isEmpty()==false){
            inputStack.push(outputStack.pop());
        }

        return result;

    }
    
    public int peek() {
     while(inputStack.isEmpty()==false){
        outputStack.push(inputStack.pop());
     }   
     int result=outputStack.peek();

     while(outputStack.isEmpty()==false){
        inputStack.push(outputStack.pop());
     }
     return result;
    }
    
    public boolean empty() {
        return inputStack.isEmpty();
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

 /*

 */