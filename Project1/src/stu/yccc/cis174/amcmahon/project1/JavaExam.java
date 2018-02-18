package stu.yccc.cis174.amcmahon.project1;
/**
 *  Description: Project 1: Java Exam -an application to test a persons knowledge of Java.  
 	Ask 10 Questions to evaluate a persons knowledge of Java. Calculate a students grade.
 	Should be able to add, edit, or delete exam questions without recompiling java code.  
  	Persist Exam results.
 *  Author:  Alex McMahon
 *  Due Date: 2/14/18
 *
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

 /**
  @author  alexanderjmcmahon
 */

public class JavaExam { 
	
	public void processFile(String questionFile, List<Question> questionList, int questionNum) {
	//method to read in question file, create Question objects, and put them into a list	
		try {
		 	 //open the input file for reading
		 	 FileReader fReader = new FileReader(questionFile);
		 	 //attach a scanner and read words until end of file
		 	 Scanner scan = new Scanner(fReader);
		 	 String line = "A";
		 	 while(scan.hasNextLine()){
		 		 
		 		line = scan.nextLine();
		 		
		 		 if(line.length() == 0) { //skip blank lines
		 			 continue;
		 		 }
		 		 if(Character.isDigit(line.charAt(0)) == true) { //if the first character is a number...
		 			 questionNum++;
		 		 //add the actual (numbered) question to Question object, then add answer options to content
		 		 Question question = new Question(line, ' ', questionNum);
		 		 questionList.add(question);
		 		 }
		 		 if(Character.isDigit(line.charAt(0)) == false) { //if the first character is not a number...
		 			 questionList.get(questionNum -1).setContent(questionList.get(questionNum -1).getContent() 
		 			+ "\n" + line); 
		 		 }
		 	 }
	 	 fReader.close();
	 	}
	 	catch (IOException e) {
	 	 	 //if an error happened...
	 	 	 System.out.println(e.getMessage());
	 	}
	}
	public void processAnswerFile(String answerFile, List<Answer> answerList, int questionNum) {
		//method to read in the answer file, create Answer objects, and add them to a list
		try {
		 	 FileReader fReader = new FileReader(answerFile);
		 	 Scanner scan = new Scanner(fReader);
		 	 String line = "A";
		 	 while(scan.hasNextLine()){
		 		 
		 		 line = scan.nextLine();
		 		 
		 		 if(line.length() == 0) {
		 			 continue;
		 		 }
		 		 //extract the actual letter answer from the line
		 		 char letter = line.charAt(line.length()-1);
		 		 if(Character.isDigit(line.charAt(0)) == true) {
		 			 questionNum++;
		 			 Answer answer = new Answer(letter, questionNum, ' ');
		 		 	 answerList.add(answer);
		 		 }
		 	 }
	 	 fReader.close();
	 	}
	 	catch (IOException e) {
	 	 	 System.out.println(e.getMessage());
	 	}
	}
	public void printResults(List<Answer> answerList, String outFile) {
		//method to print & write to exam results
		try{
			PrintWriter fWriter = new PrintWriter(outFile);
			int numCorrect = 0;
			int numQues = 0;
			double grade = 0;
			for(Answer answer : answerList) {
				numQues++;
				fWriter.println(answer);  //write the results to file
				System.out.println(answer);
				if(answer.isCorrect() == true) { //use Answer isCorrect method & count correct answers
					numCorrect++;
				}
			}
			grade = (double)numCorrect / (double)numQues * 100; //calculate grade
			System.out.println("Total Grade: " + grade);
			fWriter.println();
			fWriter.println("Total Grade: " + grade);
			fWriter.close();
	    }
		 catch (IOException e) {
 	 	 	 System.out.println(e.getMessage());
 	 	 }
	}
	public void run(String questionFile, String answerFile, String outFile) {
		Scanner scan = new Scanner(System.in);
		List<Question> questionList = new ArrayList<Question>(); //create Question list
		List<Answer> answerList = new ArrayList<Answer>(); // create Answer list
		int questionNum = 0;
		int i = 0;
		questionNum = 0;
		
		processFile(questionFile, questionList, questionNum);
		processAnswerFile(answerFile, answerList, questionNum);
		System.out.println("Welcome to the Java Exam!");
		//print exam questions, scan user answer & change to upper-case char, & store them in Answer objects
		for(Question question : questionList) {
			System.out.println(question);
			char userAnswer = scan.next().charAt(0);
			userAnswer = Character.toUpperCase(userAnswer);
			i++;
			for(Answer answer : answerList) {
				if(answer.getQuestionNum() == i) {
					answer.setUserAnswer(userAnswer);
				}
			}
		 }
		 printResults(answerList, outFile);
	}
	public static void main(String[] args) {
	 	 if (args.length < 1) {
	 	 	 System.out.println("error: usage: JavaExam <file name>");
	 	 	 return;
	 	 }
	 	 String questionFile = args[0]; // 1st argument question file
	 	 String answerFile = args[1]; // 2nd argument answer file
	 	 String outFile = "Results.txt";
	 	 
	 	JavaExam exam = new JavaExam();
  	 	exam.run(questionFile, answerFile, outFile);	 
	}
}
