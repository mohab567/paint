package shape.modules;

public class VLine extends VMonogon{
	
	//01_Attributes----------------------------
		private double startX;
		private double startY;
		private double endX;
		private double endY;
	
	//02_Constructor---------------------------
		public VLine(double translateX, double translateY, double borderSize, String borderColor, String fillColor, double startX, double startY, double endX, double endY){
			
			this.setTranslateX(translateX);
			this.setTranslateY(translateY);
			
			this.setBorderSize(borderSize);
			this.setBorderColor(borderColor);
				
			this.setFillColor(fillColor);
			
			this.startX=startX;
			this.startY=startY;
			this.endX=endX;
			this.endY=endY;
			
		}
		
		public VLine(){
			
		}
	
	//03_Methods------------------------------
		public void setStartX(double startX){
			this.startX=startX;
		}
		public void setStartY(double startY){
			this.startY=startY;
		}
		public void setEndX(double endX){
			this.endX=endX;
		}
		public void setEndY(double endY){
			this.endY=endY;
		}
		
		
		public double getStartX(){
			return this.startX;
		}
		public double getStartY(){
			return this.startY;
		}
		public double getEndX(){
			return this.endX;
		}
		public double getEndY(){
			return this.endY;
		}
		
		
		public VLine clone(){
			VLine tmp=new VLine();
			
			tmp.setTranslateX(this.getTranslateX());
			tmp.setTranslateY(this.getTranslateY());
			tmp.setBorderSize(this.getBorderSize());
			tmp.setBorderColor(this.getBorderColor());
			tmp.setFillColor(this.getFillColor());
			
			tmp.setStartX(this.getStartX());
			tmp.setStartY(this.getStartY());
			tmp.setEndX(this.getEndX());
			tmp.setEndY(this.getEndY());
			
			return tmp;
		}
	
}
