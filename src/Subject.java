/*
Review Quiz Maker
Subject class: create subjects to study, store questions, quizzes
Each subject stores a list of questions that can be used to generate quizzes and saved quizzes to review to be added to.
 */

import java.util.*;  

public class Subject {
    private String sub;
    private List<Question> questions;
    private List<Quiz> quizzes;
    private int numKnownQ;
    private double lastSc, highest;

    //creates a new Subject object (with list of saved quizzes, questions) with input title
    public Subject(String s){
        sub = s;
        numKnownQ = 0;
        questions = new ArrayList<Question>();
        quizzes = new ArrayList<Quiz>();
        lastSc = 0;
        highest = 0;
    }

    //creates new question and adds it to the subject's question bank
    public void addQuestion(String q, String ans){
        questions.add(new Question (q, ans));
    }
    
    //returns a question from the larger question bank
    public Question getQuestion(int n){
        return questions.get(n);
    }
    
    //returns title of subject
    @Override
    public String toString(){
        return sub;
    }
    
    //randomizes questions and makes a new quiz with 10 random questions
    public Quiz makeQuiz(int num, boolean hide){
        //randomizes question order
        Collections.shuffle(questions); 
        return new Quiz(num, this, hide);
    }
    
    //creates a new quiz of all questions for the subject
    public Quiz reviewAll(boolean hide){
        Collections.shuffle(questions);
        return new Quiz(getNumQ(), this, hide);
    }
    
    //saves the quiz; adds it to arrayList of quizzes
    public void saveQuiz(Quiz q){
        quizzes.add(q);
        q.save(true);
    }
    
    //returns total number of saved quizzes for the subject
    public int getNumQuizzes(){
        return quizzes.size();
    }
     
    //returns total number of questions
    public int getNumQ(){
        return questions.size();
    }
    
    //returns a specific quiz
    public Quiz getQuiz(int n){
        return quizzes.get(n);
    }
    
    //returns number of questions the user already knows
    public int getNumKnown(){
        return numKnownQ;
    }
    
    //adds to list of known questions
    public void setNumKnown(int add){
        numKnownQ += add;
    }
    
    //sets highest score of the subject
    public void setHighest(double sc){
        highest = sc;
    }
    
    //returns highest score
    public double getHighest(){
        return highest;
    }
    
    //sets last score taken
    public void setLast(double sc){
        lastSc = sc;
    }
    
    //returns last score
    public double getLast(){
        return lastSc;
    }
}
