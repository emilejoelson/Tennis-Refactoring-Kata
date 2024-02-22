import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    String score = "";
    public String getScore(){

        if (P1point == P2point && P1point < 4)
        {
            score = getScoreEqualAndUnderThanFour();
        }
        if (P1point==P2point && P1point>=3)
            score = "Deuce";

        if (P1point > 0 && P2point==0)
        {
            score = getScoreP1PositiveAndP2EqualZero();
        }
        if (P2point > 0 && P1point==0)
        {
            score = getScoreFrom50to30();
        }

        if (P1point>P2point && P1point < 4)
        {
            score = getScorePlayer1Advantage();
        }
        if (P2point>P1point && P2point < 4)
        {
            score = getScorePlayer2Advantage();
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    //The refactoring function
    private  String getScoreEqualAndUnderThanFour(){
        Map<Integer,String> scoreMap = Map.of(
                0,"Love",
                1,"Fifteen",
                2,"Thirty"
        );

        return scoreMap.getOrDefault(P1point,"")+"-All";
    }
    private  String getScoreP1PositiveAndP2EqualZero(){
        Map<Integer,String> scoreMap = Map.of(
                1,"Fifteen",
                2,"Thirty",
                3,"Forty"
        );
        P1res = scoreMap.getOrDefault(P1point, "");
        P2res = "Love";
        String score = P1res + "-" + P2res;
        return score;
    }
    private String getScoreFrom50to30(){
        Map<Integer,String> scoreMap = Map.of(
                1,"Fifteen",
                2,"Thirty",
                3,"Forty"
        );

        //Initialization
        P1res = "";
        P2res = "";
        P2res = scoreMap.getOrDefault(P2point,"");
        P1res = "Love";
        score = P1res + "-" + P2res;
        return  score;
    }
    private String getScorePlayer1Advantage(){
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        P1res = (P1point >= 0 && P1point < scores.length) ? scores[P1point] : "";
        P2res = (P2point >= 0 && P2point < scores.length) ? scores[P2point] : "";
        score = P1res + "-" + P2res;
        return  score;
    }

    private String getScorePlayer2Advantage(){
        String [] scores = {"Love","Fifteen","Thirty","Forty"};
        P1res = (P1point>=0 && P1point<scores.length)?scores[P1point]:"";
        P2res = (P2point >= 0 && P2point < scores.length) ? scores[P2point] : "";
        score = P1res + "-" + P2res;
        return score;
    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}