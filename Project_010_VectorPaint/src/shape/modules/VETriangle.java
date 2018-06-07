package shape.modules;

public class VETriangle extends VTrigon{

	//01_Attributes
	private double edgeLength;

	//02_Constructors
		public VETriangle(double translateX, double translateY, double borderSize, String borderColor, String fillColor, double edgeLength){
			this.setTranslateX(translateX);
			this.setTranslateY(translateY);
			
			this.setBorderSize(borderSize);
			this.setBorderColor(borderColor);
			
			this.setFillColor(fillColor);
			
			this.edgeLength=edgeLength;
		}
		
		public VETriangle(){
			
		}
		
	//03_Methods
		
		public void setEdge(double edgeLength){
			this.edgeLength=edgeLength;
		}
		public double getEdge(){
			return this.edgeLength;
		}
		
		
		
		public VETriangle clone(){
			VETriangle tmp=new VETriangle();
			
			tmp.setTranslateX(this.getTranslateX());
			tmp.setTranslateY(this.getTranslateY());
			tmp.setBorderSize(this.getBorderSize());
			tmp.setBorderColor(this.getBorderColor());
			tmp.setFillColor(this.getFillColor());
			
			tmp.setEdge(this.getEdge());
			
			return tmp;
		}
	
}
