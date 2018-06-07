package shape.modules;

public class EquilateralTriangle extends VTrigon{

	//01_Attributes
		private double edgeLength;

	//02_Constructors
		public EquilateralTriangle(double translateX, double translateY, double borderSize, String borderColor, String fillColor, double edgeLength){
			this.setTranslateX(translateX);
			this.setTranslateY(translateY);
			
			this.setBorderSize(borderSize);
			this.setBorderColor(borderColor);
			
			this.setFillColor(fillColor);
			
			this.edgeLength=edgeLength;
		}
		
	//03_Methods

		
	
	
}
