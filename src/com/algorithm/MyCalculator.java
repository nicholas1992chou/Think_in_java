package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MyCalculator {
	static Stack<Character> stack = new Stack<Character>();
	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		while(true){
		System.out.println("Enter your expression below:");
		String str = null;
		Scanner scan = new Scanner(System.in);
		str = scan.next();
		if(str.equals("exit"))
			break;
		System.out.println(cal(infixToSuffix(str)));
		}
		
	}
	private static List<String> infixToSuffix(String str){
		str+= "#";//加表达式结束标识。
		//valid(str);
		stack.push('#');//设置“#”的优先级最低。压栈可避免栈空的场景。
		int i=0;
		while(i < str.length()){
			char ch= str.charAt(i);
			if('#' != ch){
				//如果是操作数直接存入集合。操作数为一位数即一个字符时。
				if(Character.isDigit(ch)){
					String temp = "" + ch;
					StringBuffer sb = new StringBuffer(temp);
					while(i+1 < str.length()-1 && Character.isDigit(str.charAt(i+1))){//如果下面也是数字则连接在一起。且不为结束标识。
						sb.append(str.charAt(i+1));
						i++;
					}
					list.add(sb.toString());
					
				}else if(ch != ')' && ch != ']'){
					//取出栈顶操作符 与 扫描的当前操作符比较 优先级，
					//若栈顶元素优先级高，则出栈，存入集合.继续当前操作符与栈顶元素比较优先级
					//直到当前操作符比栈顶元素优先级高，则压栈。
					while(stack.peek() !='(' && stack.peek() != '[' && (!priority(stack.peek(), ch))){//如果栈顶优先级高
						list.add(String.valueOf(stack.pop()));
					}
					stack.push(ch);
					
				}else if(ch == ')' ){
					while(stack.peek() != '('){
						list.add(String.valueOf(stack.pop()));
					}
					stack.pop();
					
				}else if(ch == ']' ){
					while(stack.peek() != '['){
						list.add(String.valueOf(stack.pop()));
					}
					stack.pop();
				
				}
				
			}else{//如果扫描到结束标识# 全部出栈
				do {
					list.add(String.valueOf(stack.pop()));
				} while (!stack.isEmpty());
			}
			i++;
		}
		return list;
	}
	private static boolean priority(char char1, char char2){//true 则第二个优先级大
		if(char2 == '(' || char2 == '[' || char2 == '{')//如果第二个操作符是( 必然优先级最高，
			return true;
		if(char2 == '^' ){
			if(char1 != '(' && char1 != '[' && char1 != '{')
				return true;
		}
		if(char2 == '*' || char2 == '/'){//如果第二个为乘除，只有第一个是
			if(char1 == '+' || char1 == '-' || char1 == '#')
				return true;
		}
		if((char2 == '+' || char2 == '-') && char1 == '#')
			return true;
		return false;
	}
	private static boolean isPerator(char c){
		switch(c){
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '(':
		case ')':
		case '[':
		case ']':
		case '{':
		case '}':
			return true;
		default:
			return false;
		}
	}
	public static Integer cal(List<String> sufFix){
		Stack<Integer> stack = new Stack<Integer>();
		Integer left,right;
		for(String str:sufFix){
			switch (str) {
			case "+":
				right = stack.pop();
				left = stack.pop();
				stack.push(left + right);
				break;
			case "-":
				right = stack.pop();
				left = stack.pop();
				stack.push(left - right);
				break;
			case "*":
				right = stack.pop();
				left = stack.pop();
				stack.push(left * right);
				break;
			case "/":
				right = stack.pop();
				left = stack.pop();
				stack.push(left / right);
				break;
			case "^":
				right = stack.pop();
				left = stack.pop();
				stack.push((int)Math.pow(left, right));
				break;
			case "#":
				break;
			default:
				stack.push(Integer.parseInt(str));
				break;
			}
		}
		return stack.pop();
	}
	static void valid(String expression){
		Stack<Character> valid = new Stack<Character>();
		for(int i = 0; i<expression.length();i++){
			switch (expression.charAt(i)) {
			case '(':
			case '[':
			case '{':
				valid.push(expression.charAt(i));
				break;
			case ']':
				if(valid.isEmpty() || valid.pop() != '[')
					throw new RuntimeException();
				break;
			case ')':
				if(valid.isEmpty() || valid.pop() != '(')
					throw new RuntimeException();
				break;
			case '}':
				if(valid.isEmpty() ||valid.pop() != '{')
					throw new RuntimeException();
				break;
			default:
				
				break;
			}
		}
		if(!valid.isEmpty())
			throw new RuntimeException("invalid");
	}
}
