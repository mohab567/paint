package model;

public interface IPlayer {

    public double getxAxis();

    public void setxAxis(double x_Axis);

    public Score deltaScore(int delta);

    public Score getScore();

	void update();

}
