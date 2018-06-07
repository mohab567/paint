package shape.modules;

public class VSquare extends VRectangle{

	
	public VSquare(double translateX, double translateY, double borderSize, String borderColor, String fillColor, double edge){

		super(translateX, translateY, borderSize, borderColor, fillColor, edge, edge);
		
	}
	
	
	public VSquare(){
		
	}
	
	public VSquare clone(){
		VSquare tmp=new VSquare();
		
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
