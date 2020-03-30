public class ifKeyword {

    public static void main (String[] args) {

        boolean gameOver = true;
        int score = 5000;
        int level = 5;
        int bonus = 100;
        if(score < 5000 && score > 1000) {
            System.out.println("Your score is: " + score);
        } else if (score < 1000){
            System.out.println("Your score was less than 1000");
        }
        else {
            System.out.println("Got here without any hassle");
        }

        if (gameOver == true){
           int finalScore = (level * bonus) + score;
            System.out.println("You final score is: " + finalScore);
        }
        // As you can note, you are able to access the variables aoutside of the code block
        // but take a look ar this scenario
//        int savedFinalScore = finalScore;  // this will throw error for following reasons.
        // you will get an error on line 24, that's because you are accessing a variable created inside a code block.
        // Once the code is executed, that variable would be destroyed and you wont be able to access it.
    }
}
