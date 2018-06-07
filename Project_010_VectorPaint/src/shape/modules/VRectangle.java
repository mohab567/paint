package shape.modules;

public class VRectangle extends VQuadrilateral{
	
	//01_Attributes---------------------------------------------------
		private double width;
		private double height;
	
	//02_Constructor--------------------------------------------------
		public VRectangle(double translateX, double translateY, double borderSize, String borderColor, String fillColor, double width, double height){
			
			this.setTranslateX(translateX);
			this.setTranslateY(translateY);
			
			this.setBorderSize(borderSize);
			this.setBorderColor(borderColor);
				
			this.setFillColor(fillColor);
			
			this.width=width;
			this.height=height;
			
		}
		
		
		public VRectangle(){
			
		}
		
	
	//03_Methods----------------------------------------------------
		//Setters-------------------
		public void setWidth(double width){
			this.width=width;
		}
		public void setHeight(double height){
			this.height=height;
		}
		//Getter--------------------
		public double getWidth(){
			return this.width;
		}
		public double getHeight(){
			return this.height;
		}
		
		
		public VRectangle clone(){
			VRectangle tmp=new VRectangle();
			
			tmp.setTranslateX(this.getTranslateX());
			tmp.setTranslateY(this.getTranslateY());
			tmp.setBorderSize(this.getBorderSize());
			tmp.setBorderColor(this.getBorderColor());
			tmp.setFillColor(this.getFillColor());
			
			tmp.setWidth(this.getWidth());
			tmp.setHeight(this.getHeight());
			
			return tmp;
		}

}
