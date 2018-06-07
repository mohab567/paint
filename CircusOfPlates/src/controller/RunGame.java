package controller;

import java.util.List;
import model.Shape;
import model.ShapePool;

public class RunGame {
    private ShapePool s;
    private int count = 0;
  
    public RunGame(double deltaTime) {
          
        s = ShapePool.getInstance();
        s.fillArray();
        
    }

    public List<Shape> platesToRender() {
        return s.getUsedShapes();
    }

    public void run() {

        if (count % 50 == 0) {
            s.acquireShape();
            count = 0;

        }
        count++;
        s.updateY();
        // s.releaseShape();

    }

}
