package model;

import java.util.ArrayList;


public class LevelFactory {
ArrayList<Level> l=new ArrayList<Level>();
private long StartTime;
private long deltaTime;

   public LevelFactory() {
	//StartTime=now;
	l.add(new LevelOne());
	l.add(new LevelTwo());
	l.add(new LevelThree());
}
public int getFPS(){
	long now = System.nanoTime();
	deltaTime=now-StartTime;
	for(Level level:l){
		
		if(level.acceptRange(deltaTime)){
			return level.FPS();
		}
	}
	return -1;
}

public long getStartTime() {
	return StartTime;
}
public void setStartTime(long startTime) {
	StartTime = startTime;
}

}
