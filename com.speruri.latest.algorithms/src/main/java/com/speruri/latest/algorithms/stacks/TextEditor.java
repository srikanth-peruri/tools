package com.speruri.latest.algorithms.stacks;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

	private String str = "";
	private Stack<OPERTATION> sequenceStack = new Stack<TextEditor.OPERTATION>();
	private Stack<String> opStack = new Stack<String>();

	enum OPERTATION {
		DELETE, COPY, UNDO, APPEND, PRINT, ACCEPTINPUT
	}

	private Scanner scanner = new Scanner(System.in);

	public TextEditor() {
		sequenceStack.push(OPERTATION.ACCEPTINPUT);
		sequenceStack.push(OPERTATION.PRINT);
		sequenceStack.push(OPERTATION.DELETE);
		sequenceStack.push(OPERTATION.APPEND);
		sequenceStack.push(OPERTATION.PRINT);
		sequenceStack.push(OPERTATION.UNDO);
		sequenceStack.push(OPERTATION.UNDO);
		sequenceStack.push(OPERTATION.PRINT);
	}

	public void performOperation() {

		while (!sequenceStack.isEmpty()) {
			OPERTATION operation = sequenceStack.peek();
			switch (operation) {
			case ACCEPTINPUT:
				str += scanner.nextLine();
				break;
			case PRINT:
				int charNum = scanner.nextInt();
				print(charNum, charNum);
				break;
			case DELETE:
				int delCharNum = scanner.nextInt();
				delete(delCharNum, delCharNum);
				break;
			case APPEND:
				String append = scanner.nextLine();
				append(append);
				break;
			case UNDO:
				System.out.println(opStack.peek());
				break;
			default:
				break;
			}
		}

	}

	private void print(int start, int end) {
		System.out.println(str.substring(start, end));
	}

	private void delete(int start, int end) {
		opStack.push(str);
		str = str.replace(str.substring(start, end), "");
	}

	private void append(String append) {
		opStack.push(str);
		str = str + append;
	}

	private void undo() {
		sequenceStack.peek();
	}

	private void cleanUp() {
		this.scanner.close();
	}

	public static void main(String[] args) {
		TextEditor textEditor = new TextEditor();

	}
}
