package canvas.module;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import shape.modules.VCircle;
import shape.modules.VEllipse;
import shape.modules.VLine;
import shape.modules.VSquare;

public class ConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		VCanvas paintApp=new VCanvas(900,1100);

		

		paintApp.createNewShape(new VEllipse());
		paintApp.createNewShape(new VCircle());
		paintApp.createNewShape(new VLine());
		//paintApp.createNewShape(new VRectangle());
		//paintApp.createNewShape(new VSquare());
		
		
		paintApp.modifyShapePosition(0, 23, 27);
		paintApp.modifyShapePosition(0, 23, 27);
		paintApp.modifyShapePosition(0, 23, 27);
		
		
		paintApp.undoAction();
		paintApp.undoAction();
		paintApp.undoAction();
		
		//paintApp.redoAction();
		//paintApp.redoAction();
		//paintApp.redoAction();
		
		
		System.out.println(paintApp.getShapesContainer().get(0).getTranslateX());
		System.out.println(paintApp.getShapesContainer().get(1).getTranslateX());
		System.out.println(paintApp.getShapesContainer().get(2).getTranslateX());

		
		/*
		paintApp.modifyShapeFullSize(0, 1000);
		paintApp.modifyShapeFullSize(1, 1000);
		paintApp.modifyShapeFullSize(2, 1000);
		paintApp.modifyShapeFullSize(3, 1000);
		paintApp.modifyShapeFullSize(4, 1000);
		*/

		//paintApp.modifyShapePosition(4, 500, 500);
		//paintApp.modifyShapeBorderSize(4, 500);
		//paintApp.modifyShapeBorderColor(4, "Green");
		//paintApp.modifyShapeFillColor(4, "Green");
		
		
		
		
		
		//System.out.println(paintApp.getShapesContainer().get(3).getTranslateX());
		//System.out.println(paintApp.getShapesContainer().get(3).getBorderSize());
		//System.out.println(paintApp.getShapesContainer().get(3).getBorderColor());
		//System.out.println(paintApp.getShapesContainer().get(3).getFillColor());
		//System.out.println(((VSquare)(paintApp.getShapesContainer().get(4))).getWidth());
		
		/*
		paintApp.modifyShapeBorderSize(0, 20);
		paintApp.modifyShapeBorderSize(1, 20);
		paintApp.modifyShapeBorderSize(2, 20);
		paintApp.modifyShapeBorderSize(3, 20);
		paintApp.modifyShapeBorderSize(4, 20);
		*/
		
		
		

	}
	
	public static void saveJSON(String fileName){
		VSquare tmp=new VSquare(70, 70, 3, "0x000000ff", "0xffff00ff", 100);
		try{
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(fileName), tmp);
		}catch(Exception ex){}
	}
	

}
