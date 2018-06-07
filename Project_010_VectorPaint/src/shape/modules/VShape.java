package shape.modules;

public abstract class VShape {
	
	//--------------------------------------------------------------------------------
	//01_Attributes-------------------------------------------------------------------
	//--------------------------------------------------------------------------------
		private double translateX;
		private double translateY;
		private double borderSize;
		private String borderColor;
		private String fillColor;
		//private double containerWidth;
		//private double containerHeight;
	//--------------------------------------------------------------------------------
	//01_Attributes-------------------------------------------------------------------
	//--------------------------------------------------------------------------------
		
	//********************************************************************************
		
	//--------------------------------------------------------------------------------
	//02_Constructor------------------------------------------------------------------
	//--------------------------------------------------------------------------------
		public VShape(){
			
		}
		
	//********************************************************************************
		
	//--------------------------------------------------------------------------------
	//03_Methods/Operations-----------------------------------------------------------
	//--------------------------------------------------------------------------------
		//Setters-------------------------
		public void setTranslateX(double translateX){
			this.translateX=translateX;
		}
		public void setTranslateY(double translateY){
			this.translateY=translateY;
		}
		public void setBorderSize(double borderSize){
			this.borderSize=borderSize;
		}
		public void setBorderColor(String borderColor){
			this.borderColor=borderColor;
		}
		public void setFillColor(String fillColor){
			this.fillColor=fillColor;
		}
		//Getters--------------------------
		public double getTranslateX(){
			return this.translateX;
		}
		public double getTranslateY(){
			return this.translateY;
		}
		public double getBorderSize(){
			return this.borderSize;
		}
		public String getBorderColor(){
			return this.borderColor;
		}
		public String getFillColor(){
			return this.fillColor;
		}
	//--------------------------------------------------------------------------------
	//03_Methods/Operations-----------------------------------------------------------
	//--------------------------------------------------------------------------------
		

}
