package shape.modules;

public class VCircle extends VOval{
	
	public VCircle(double translateX, double translateY, double borderSize, String borderColor, String fillColor, int radius){
		
		this.setTranslateX(translateX);
		this.setTranslateY(translateY);
		
		this.setBorderSize(borderSize);
		this.setBorderColor(borderColor);
			
		this.setFillColor(fillColor);
		
		this.setMajorAxis(radius);
		this.setMinorAxis(radius);
		
	}
	
	public VCircle(){
		
	}
	
	
	public VCircle clone(){
		VCircle tmp=new VCircle();
		
		tmp.setTranslateX(this.getTranslateX());
		tmp.setTranslateY(this.getTranslateY());
		tmp.setBorderSize(this.getBorderSize());
		tmp.setBorderColor(this.getBorderColor());
		tmp.setFillColor(this.getFillColor());
		
		tmp.setMajorAxis(this.getMajorAxis());
		tmp.setMinorAxis(this.getMinorAxis());
		
		return tmp;
	}


}
