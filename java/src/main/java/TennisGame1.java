import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName))
            m_score1 ++;
        else
            m_score2 ++;
    }

    // Variable
    String score = "";
    int tempScore=0;
    public  String getScore(){
        if (m_score1==m_score2){
            score = getScoreEqual();
        }
        else if(m_score1>=4 || m_score2>=4){
            score =  getScoreWin();
        }
        else {
            score = getScoreRegular();
        }

        return score;
    }

    private  String getScoreEqual(){
        Map<Integer,String> score = Map.of(
                0, "Love-All",
                1, "Fifteen-All",
                2, "Thirty-All"
        );
        return  score.getOrDefault(m_score1,"Deuce");
    }
    private String getScoreWin() {
        int scoreDifference = m_score1 - m_score2;

        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else if (scoreDifference <= -2) {
            return "Win for player2";
        } else {
            throw new IllegalStateException("Invalid score difference");
        }
    }

    private String getScoreRegular() {
        Map<Integer, String> scoreMap = Map.of(
                0, "Love",
                1, "Fifteen",
                2, "Thirty",
                3, "Forty"
        );

        StringBuilder scoreBuilder = new StringBuilder();
        appendScore(scoreBuilder, m_score1, scoreMap);
        scoreBuilder.append("-");
        appendScore(scoreBuilder, m_score2, scoreMap);

        return scoreBuilder.toString();
    }

    private void appendScore(StringBuilder scoreBuilder, int score, Map<Integer, String> scoreMap) {
        scoreBuilder.append(scoreMap.get(score));
    }


}
