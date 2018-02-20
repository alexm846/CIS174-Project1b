package stu.yccc.cis174.amcmahon.project1;

/**
 * Description: Project 1: Answer - an object consisting of answer content, user
 * answers, and question numbers & isCorrect method. Author: Alex McMahon Due
 * Date: 2/14/18
 *
 */

public class Answer {
	// instance variables
	private char content;
	private int questionNum;
	private char userAnswer;

	public Answer() { // Default Constructor
		content = 'z';
		questionNum = 0;
		userAnswer = 'Z';
	}

	public Answer(char content, int questionNum, char userAnswer) { // Initializing Constructor
		this.content = content;
		this.questionNum = questionNum;
		this.userAnswer = userAnswer;
	}

	public char getContent() {
		return content;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public char getUserAnswer() {
		return userAnswer;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public void setContent(char content) {
		this.content = content;
	}

	public void setUserAnswer(char userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String toString() {
		String quesStr = this.getQuestionNum() + ". User Answer: " + this.getUserAnswer() + " = ";
		if (this.isCorrect() == true) { // convert boolean to string
			quesStr += "Correct";
		} else {
			quesStr += "Incorrect";
		}
		return quesStr;
	}

	public boolean isCorrect() {
		// method returns true if user answer is correct
		if (this.content == this.userAnswer) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

	}

}
