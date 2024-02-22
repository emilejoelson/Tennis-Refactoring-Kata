import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    private static final Map<Integer, String> SCORE_NAMES = new HashMap<>();

    static {
        SCORE_NAMES.put(0, "Love");
        SCORE_NAMES.put(1, "Fifteen");
        SCORE_NAMES.put(2, "Thirty");
        SCORE_NAMES.put(3, "Forty");
    }

    public TennisGame5(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else if (playerName.equals("player2"))
            player2Score++;
        else
            throw new IllegalArgumentException("Invalid player name.");
    }

    @Override
    public String getScore() {
        if (areScoresEqual()) {
            return getEqualScore();
        } else if (isAnyPlayerInAdvantage()) {
            return getAdvantageOrWinScore();
        } else {
            return getRegularScore();
        }
    }

    private boolean areScoresEqual() {
        return player1Score == player2Score;
    }

    private String getEqualScore() {
        if (player1Score < 3) {
            return SCORE_NAMES.get(player1Score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private boolean isAnyPlayerInAdvantage() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getAdvantageOrWinScore() {
        int difference = player1Score - player2Score;
        if (difference == 1) {
            return "Advantage " + player1Name;
        } else if (difference == -1) {
            return "Advantage " + player2Name;
        } else if (difference >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }

    private String getRegularScore() {
        return SCORE_NAMES.get(player1Score) + "-" + SCORE_NAMES.get(player2Score);
    }
}
