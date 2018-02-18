package stu.yccc.cis174.amcmahon.project1;
/**
 *  Description: Project 1: Question - an object consisting of question content, user answers, and
 *  question numbers.  
 *  Author:  Alex McMahon
 *  Due Date: 2/14/18
 *
 */

public class Question {
	//instance variables
	private String content;
	private char userAnswer;
	private int questionNum;
	
	public Question() { //Default Constructor
		content = "";
		userAnswer = 'Z';
		questionNum = 0;
	}
	public Question(String content, char userAnswer, int questionNum) { //Initializing Constructor
		this.content = content;
		this.userAnswer = userAnswer;
		this.questionNum = questionNum;
	}
	//getters
	public String getContent() {
		return content;
	}
	public char getUserAnswer() {
		return userAnswer;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	//setters
	public void setContent(String content) {
		this.content = content;
	}
	public void setUserAnswer(char userAnswer) {
		this.userAnswer = userAnswer;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String toString() {
		String quesStr = this.getContent();
		return quesStr;
	}
	
	public static void main(String[] args) {

	}

}
