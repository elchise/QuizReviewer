/*
Review Quiz Maker
Questions class: create questions to be tested on and make up quizzes. Each stores the question and corresponding answer and whether the user has gotten it correct/knows it or not.
 */
public class Question {
    private String q, ans;
    private int timesCorrect;
    private boolean know, lastCorrect;
    
    
    //makes a new question with inputted q&a
    Question(String q, String ans){
        this.q = q;
        this.ans = ans;
        know = false;
        timesCorrect = 0;
        lastCorrect = false;
    }
    
    //returns question
    public String getQ(){
        return q;
    }
    
    //returns answer
    public String getAns(){
        return ans;
    }
    
    //checks if the answer is correct
    public boolean checkAns(String a){
        lastCorrect = a.equalsIgnoreCase(ans);
        if (lastCorrect) {
            timesCorrect++;
            //marks the question as known if correct at least three times in a row
            if (timesCorrect >= 3){
                know = true;
            }
        } else {
            timesCorrect = 0;
        }
        return lastCorrect;
    }
    
    //returns whether the question is known
    public boolean isKnown(){
        return know;
    }
    
    //returns a string ("Question? Answer: ...")
    public String toString(){
        if (!lastCorrect){
            return q + "<br/>&emsp; Answer: <font color='red'>" + ans + "</font>";
        } else {
            return q + "<br/>&emsp; Answer: <font color='green'>" + ans + "</font>";
        }
            
    }
    
    //returns the number of times a question has been gotten right in a row
    public int getTimesCorrect(){
        return timesCorrect;
    }
    
    
}
