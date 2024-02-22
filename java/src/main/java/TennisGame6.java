import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;

public class TennisGame6 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else
            player2Score++;

    }

    public String getScore()
    {

        if (areScoreEqual())
        {
            return  getTieScoreEqualScore();
        }
        else if (are2PlayerBigThat4())
        {
            return getEndGameScore();
        }
        else
        {
            return  getRegularScore();
        }
    }

    //Refactoring the condition
    private boolean areScoreEqual(){
        return player1Score == player2Score;
    }
    private  boolean are2PlayerBigThat4(){
        return  player1Score >= 4 || player2Score >= 4;
    }

    //Tie score for the ScoreEqual
    private  String getTieScoreEqualScore(){
        if(player1Score<3){
            String scoreName ;
            String strAll = "All";
            String res ;
            Map<Integer,String> stringMap = new HashMap<>();
            stringMap.put(0,"Love");
            stringMap.put(1,"Fifteen");
            stringMap.put(2,"Thirty");
            scoreName = stringMap.get(player1Score);
            res = scoreName+"-"+strAll;
            return res;
        }
        else {
            return "Deuce";
        }
    }
    private  String getEndGameScore(){
        // end-game score
        String endGameScore;

        if (isAdvantagePlayer1()) {
            endGameScore = "Advantage " + player1Name;
        } else if (isAdvantagePlayer2()) {
            endGameScore = "Advantage " + player2Name;
        } else if (isWinForPlayer1()) {
            endGameScore = "Win for " + player1Name;
        } else {
            endGameScore = "Win for " + player2Name;
        }

        return  endGameScore;

    }
    // Refactoring of Advantage
    private boolean isAdvantagePlayer1(){
        return player1Score - player2Score == 1;
    }
    private boolean isAdvantagePlayer2(){
        return player1Score - player2Score == -1;
    }

    private boolean isWinForPlayer1(){
        return player1Score - player2Score>=2;
    }
    private String getRegularScore(){
        // regular score
        String regularScore;
        String score1 =  getScoreName(player1Score);
        var score2 =  getScoreName(player2Score);
        regularScore = score1 + "-" + score2;

        return regularScore;
    }

    private  String getScoreName(int score){
        Map<Integer,String> scoreMap = new HashMap<>();
        scoreMap.put(0,"Love");
        scoreMap.put(1,"Fifteen");
        scoreMap.put(2,"Thirty");
        scoreMap.putIfAbsent(score,"Forty");

        return scoreMap.get(score);
    }
}
