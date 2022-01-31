package practice;

import java.util.Stack;

public class StackDemo1 {
	
	public static void main(String[] args) {
		
		StackDemo1 objClass = new StackDemo1();
		System.out.println(objClass.checkIsBalanced("{[()]}"));
		System.out.println(objClass.checkIsBalanced("{[()]}{"));
		System.out.println(objClass.checkIsBalanced("}{[()]}"));
		System.out.println(objClass.checkIsBalanced("}{[({)]}"));
	}
	
	public String checkIsBalanced(String str) {
		
		Stack<Character> chrStack = new Stack<Character>();
		char popped;
		while((str.charAt(0) == '{' || str.charAt(0) == '[' || str.charAt(0) == '(') && str.length()>= 0 ) {
			chrStack.push(str.charAt(0));
			try {
				str = str.substring(1);
			}catch(IndexOutOfBoundsException ex) {
				System.out.println(ex.getMessage());
			}
		}
		if(chrStack.size() == str.length()) {
			while(str.length()> 0 ) {
				popped = chrStack.pop();
				switch (popped) {
				case '{':
					if(str.charAt(0) != '}') {
						return "Not balanced";
					}
					break;
				case '[':
					if(str.charAt(0) != ']') {
						return "Not balanced";
					}
					break;
				case '(':
					if(str.charAt(0) != ')') {
						return "Not balanced";
					}
					break;
				default:
					return "Not balanced";
				}
				if(str.length()> 1) {
					str = str.substring(1);
				}else{
					str = "";
				}
			}
		}else {
			return "Not balanced";
		}
		return "String is balanced";
	}
	
}
