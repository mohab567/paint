package canvas.module;

import shape.modules.VShape;

	public interface ICanvas {

		//this method should take an empty constructor just in order to identify shape
		public void createNewShape(VShape shape);
		public void removeShape(int arrayIndex);
		
		public void undoAction();
		public void redoAction();
		
		public void saveImageXML(String fileName);
		public void saveImageJSON(String fileName);
		public void loadImageXML(String fileLocation);
		public void loadImageJSON(String fileLocation);
		
		public void resizeCanvas(int width, int height);
		
		public void modifyShapePosition(int arrayIndex, double newTranslateX, double newTranslateY);
		public void modifyShapeBorderSize(int arrayIndex, double newBorderSize);
		public void modifyShapeBorderColor(int arrayIndex, String newBorderColor);
		public void modifyShapeFillColor(int arrayIndex, String newFillColor);
		public void modifyShapeFullSize(int arrayIndex, double sizeIncrement);
		public void modifyShapeWidth(int arrayIndex, double widthIncrement);
		public void modifyShapeHeight(int arrayIndex, double heightIncrement);
	
}
