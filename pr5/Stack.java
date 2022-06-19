import java.util.Arrays;

public class Stack {
    private char [] array_2;
    private int [] array;
    private int top;
    private int top_s;
    
    public Stack(int value) {
        array = new int [value];
        array_2 = new char [value];
        top = -1;
        top_s = -1;
    }
    public boolean isEmpty(){
        return (top == -1 || top_s == -1);
    }
    public void push (int a) {
        int i = ++top;
        array[i] = a;
    }
    
    public void push_s (char s) {
        int l = ++top_s;
        array_2[l] = s;
    }
    public int pop(int choice){
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else {
            if (choice == 0)
                return array[top--];
            else
                return array_2[top--];
        }
    }
    public int pick (int choice){
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        else {
            if (choice == 0)
                return array[top];
            else
                return array_2[top];
        }
    }
    public void changeFirstAndLast ()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else {
            int temp = array[0];
            array[0] = array[array.length-1];
            array[array.length-1] = temp;
        }
    }
    public void printStack (int choice)
    {
        if (choice == 0)
            System.out.println("Stack is: \n" +Arrays.toString(array));
        else
            System.out.println(array_2);
    }
    public String charToString ()
    {
        return String.valueOf(array_2);
    }
    public boolean isPalindrome (String string)
    {
        if (string.length() == 1 || string.length() == 0)
            return true;
        if (string.charAt(0) == string.charAt(string.length() - 1))
            return isPalindrome(string.substring(1, string.length() - 1));    

        return false;
    }

    public static void main(String[] args) {
        int len = 10, min = 1, max = 30;
        Stack stack = new Stack(len);
        for (int i = 0; i < len; i++) {
            int x = (int) (Math.random() * (max - min + 1) + min);
            stack.push(x);
        }
        stack.printStack (0);
        stack.changeFirstAndLast();
        stack.printStack(0);
        for (int i = 0; i < len; i++) {
            int number = 65 + (int)(Math.random() * (91 - 65));
            char s = (char) number;
            stack.push_s(s);
        }
        stack.printStack(1);
        System.out.println(stack.isPalindrome(stack.charToString()));
    }

}
