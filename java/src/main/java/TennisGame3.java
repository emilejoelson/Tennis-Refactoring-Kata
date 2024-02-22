public class TennisGame3 implements TennisGame {

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (bothPlayersHaveRegularScores()) {
            return getRegularScore();
        } else if (isDeuce()) {
            return "Deuce";
        } else {
            String s = (p1 > p2) ? p1N : p2N;
            return isAdvantage() ? "Advantage " + s : "Win for " + s;
        }
    }

    private boolean bothPlayersHaveRegularScores() {
        return p1 < 4 && p2 < 4 && !(p1 + p2 == 6);
    }

    private String getRegularScore() {
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String score1 = scores[p1];
        String score2 = scores[p2];
        return (p1 == p2) ? score1 + "-All" : score1 + "-" + score2;
    }

    private boolean isDeuce() {
        return p1 == p2;
    }

    private boolean isAdvantage() {
        return ((p1 - p2) * (p1 - p2) == 1);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(p1N))
            this.p1 += 1;
        else
            this.p2 += 1;
    }
}
