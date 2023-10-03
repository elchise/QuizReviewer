/*
Review Quiz Maker
Quiz class: create individual quizzes within each subject to study and test user
Creates a quiz which stores a list of a given number of questions. User can choose to hide questions they already know and can take each quiz. Quizzes can be saved and will be stored within the subject if they are.l
 */

public class Quiz {
    private int numQ, numCorrect;
    private String title;
    private Question[] questions;
    private Subject sub;
    private boolean hideKnown, isSaved;
    private double lastScore, highestScore;
    
    
    //new quiz
    public Quiz (int num, Subject s, boolean hide){
        sub = s;
        numQ = num;
        numCorrect = 0;
        hideKnown = hide;
        title = "";
        isSaved = false;
        questions = new Question[num];
        for (int i = 0; i < num; i++){
            Question q = sub.getQuestion(i);
            if (!hideKnown || !q.isKnown()){
                questions[i] = q;
            } else {
                num++;
            }
       }
        lastScore = 0;
        highestScore = 0;
        
    }

    //returns a specific question from the bank
    public Question getQuestion(int num){
        Question q = sub.getQuestion(num);
        return q;
    }
    

    //checks if answer is correct
    public boolean checkQ(int qNum, String ans){
        Question q = questions[qNum];
        boolean know = q.isKnown();
        boolean correct = q.checkAns(ans);
        if (correct){
            numCorrect++;
            if(!know && q.getTimesCorrect() >= 3){
                sub.setNumKnown(1);
            }
        } else {
            if (know){
                sub.setNumKnown(-1);
            }
        }
        return correct;
    }
    
    //returns final percentage score and stores
    public double calcScore(){
        lastScore = (100 * (double)numCorrect/numQ);
        sub.setLast(lastScore);
        if (lastScore > highestScore){
            highestScore = lastScore;
            if (lastScore > sub.getHighest()){
                sub.setHighest(lastScore);
            }
        }
        return lastScore;
    }
    
    //returns all questions with answers
    @Override
    public String toString(){
        String all = title + "<br/>";
        for (int i = 0; i < numQ; i++){
            all += ((i+1) + ". " + this.getQuestion(i).toString()) + "<br/><br>";
        }
        all = "<html>" + all + "</html>";
        return all;
    }

    //set the title
    public void setTitle(String t) {
        title = t;
    }

    //return the list of questions for the quiz
    public Question[] getAllQ(){
        return questions;
    }
    
    //returns if the quiz has been saved
    public boolean isSaved(){
        return isSaved;
    }
    
    //saves/unsaves quiz
    public void save(boolean s){
        isSaved = s;
    }
    
    //returns number of questions
    public int getNumQ(){
        return numQ;
    }
    
    //returns last score
    public double getLast(){
        return lastScore;
    }
    
    //returns highest score
    public double getHighest(){
        return highestScore;
    }
    
    public void reset(){
        numCorrect = 0;
    }
    

}
