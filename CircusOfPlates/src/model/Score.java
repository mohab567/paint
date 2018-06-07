package model;

public class Score {
    private int matchScore;
    // 0 still playing , 1 win , 2 lost ,3 draw
    private int state;

    Score() {
        matchScore = 0;
        state = 0;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public int deltaMatchScore(int delta) {
        // to do
        return matchScore;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
