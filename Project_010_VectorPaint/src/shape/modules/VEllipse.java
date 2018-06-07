package shape.modules;

public class VEllipse extends VOval{

	public VEllipse(double translateX, double translateY, double borderSize, String borderColor, String fillColor, double majorAxis, double minorAxis){
		
		this.setTranslateX(translateX);
		this.setTranslateY(translateY);
		
		this.setBorderSize(borderSize);
		this.setBorderColor(borderColor);
			
		this.setFillColor(fillColor);
		
		this.setMajorAxis(majorAxis);
		this.setMinorAxis(minorAxis);
		
	}
	
	public VEllipse(){
		
	}
	
	
	public VEllipse clone(){
		VEllipse tmp=new VEllipse();
		
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
