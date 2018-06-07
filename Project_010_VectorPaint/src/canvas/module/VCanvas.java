package canvas.module;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import history.module.DynamicHistory;
import shape.modules.VCircle;
import shape.modules.VETriangle;
import shape.modules.VEllipse;
import shape.modules.VLine;
import shape.modules.VQuadrilateral;
import shape.modules.VRectangle;
import shape.modules.VShape;
import shape.modules.VSquare;

public class VCanvas implements ICanvas{
	
	//********************************************************************************
	//01_Attributes-------------------------------------------------------------------
	//********************************************************************************
		private double width;
		private double height;
		private ArrayList<VShape> shapesContainer;
		private DynamicHistory<ArrayList<VShape>> history;
		//private String fileName;
	//********************************************************************************
	//01_Attributes-------------------------------------------------------------------
	//********************************************************************************
		
		
		
		
	//********************************************************************************
	//02_Constructor/InitializeApp----------------------------------------------------
	//********************************************************************************
		public VCanvas(double width, double height){
			this.width=width;
			this.height=height;
			shapesContainer=new ArrayList<VShape>();
			history=new DynamicHistory<>();
			
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		public VCanvas(){
			
		}
	//********************************************************************************
	//02_Constructor/InitializeApp----------------------------------------------------
	//********************************************************************************
		

		
		
		
	//********************************************************************************
	//03_Methods/Operations-----------------------------------------------------------
	//********************************************************************************
		

		//***************************************************************************************
		//Undo/Redo Methods----------------------------------------------------------------------
			public void undoAction(){
				this.shapesContainer=cloneList(this.history.goBack());
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void redoAction(){
				this.shapesContainer=cloneList(this.history.goForward());
			}
		//Undo/Redo Methods----------------------------------------------------------------------
		//***************************************************************************************
			/*public DynamicHistory<ArrayList<VShape>> getHistory(){
				return this.history;
			}
		*/
		
		//***************************************************************************************
		//Save/Load Image Methods----------------------------------------------------------------
			public void saveImageXML(String fileName){
				try {
					//01_Open file
					XMLEncoder outputFile=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
					//02_Write to file
					outputFile.writeObject(this);
					//03_Close file
					outputFile.close();	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error creating or opening file");
				}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void loadImageXML(String fileLocation){
				try {
					//01_Open file
					XMLDecoder inputFile=new XMLDecoder(new BufferedInputStream(new FileInputStream(fileLocation)));
					//02_Write to file
					VCanvas tmp=(VCanvas)(inputFile.readObject());
					this.setHeight(tmp.getHeight());
					this.setWidth(tmp.getWidth());
					this.setShapesContainer(tmp.getShapesContainer());
					tmp=null;
					//03_Close file
					inputFile.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error creating or opening file");
				}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void saveImageJSON(String fileName){
				try{
					ObjectMapper mapper = new ObjectMapper();
					mapper.writeValue(new File(fileName), this.shapesContainer);
				}catch(Exception ex){}
				
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void loadImageJSON(String fileLocation){
				/*
				ArrayList<Object> tmp;
				try{
					ObjectMapper mapper = new ObjectMapper();
					tmp=mapper.readValue(new File(fileLocation), new TypeReference<ArrayList<Object>>(){});
					VEllipse tmp2=(VEllipse)tmp.get(0);
					tmp2.getTranslateX();
					System.out.println("Success");
					//this.setShapesContainer(tmp);
					//ArrayList<VShape> tmp=mapper.readValue(new File(fileLocation), typeFactory.constructCollectionType(ArrayList.class, VShape.class));
					//ArrayList<VShape> tmp=mapper.readValue(new File(fileLocation), ArrayList.class);
					
					
					//private ArrayList<VShape> shapesContainer;
				}catch(Exception ex){
					System.out.println("Could Not Load File");
				}
				*/
			}
			
		//Save/Load Image Methods----------------------------------------------------------------
		//***************************************************************************************
		
		
		public void resizeCanvas(int width, int height){}
		
		
		//***************************************************************************************
		//Shape Operations Methods---------------------------------------------------------------
			public void createNewShape(VShape shape){
				if(initializeShape(shape)){
					ArrayList<VShape> tmp=cloneList(this.shapesContainer);
					this.history.addNewHistoryEntry(tmp);
				}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void removeShape(int arrayIndex){
				try{
					this.shapesContainer.set(arrayIndex, null);
					//save history
					ArrayList<VShape> tmp=cloneList(this.shapesContainer);
					this.history.addNewHistoryEntry(tmp);
				}catch(Exception ex){}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapePosition(int arrayIndex, double newTranslateX, double newTranslateY){
				shapesContainer.get(arrayIndex).setTranslateX(newTranslateX);
				shapesContainer.get(arrayIndex).setTranslateY(newTranslateY);
				//save history
				ArrayList<VShape> tmp=cloneList(this.shapesContainer);
				this.history.addNewHistoryEntry(tmp);
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapeBorderSize(int arrayIndex, double newBorderSize){
				shapesContainer.get(arrayIndex).setBorderSize(newBorderSize);
				//save history
				ArrayList<VShape> tmp=cloneList(this.shapesContainer);
				this.history.addNewHistoryEntry(tmp);
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapeBorderColor(int arrayIndex, String newBorderColor){
				shapesContainer.get(arrayIndex).setBorderColor(newBorderColor);
				//save history
				ArrayList<VShape> tmp=cloneList(this.shapesContainer);
				this.history.addNewHistoryEntry(tmp);
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapeFillColor(int arrayIndex, String newFillColor){
				shapesContainer.get(arrayIndex).setFillColor(newFillColor);
				//save history
				ArrayList<VShape> tmp=cloneList(this.shapesContainer);
				this.history.addNewHistoryEntry(tmp);
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapeFullSize(int arrayIndex, double sizeIncrement){
				boolean successfulModification=false;
				VShape shape=shapesContainer.get(arrayIndex);
				try{
					//01_Shape Is Line
					VLine tmp=(VLine)shape;
					double oldEndX=tmp.getEndX();
					double oldEndY=tmp.getEndY();
					double newEndX=oldEndX+sizeIncrement;
					double newEndY=(newEndX*oldEndY)/oldEndX;
					tmp.setEndX(newEndX);
					tmp.setEndY(newEndY);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					//02_Shape Is Quadrilateral
					VRectangle tmp=(VRectangle)shape;
					if(tmp.getWidth()==tmp.getHeight()){
						//A_Shape Is Square
						tmp.setWidth(tmp.getWidth()+sizeIncrement);
						tmp.setHeight(tmp.getHeight()+sizeIncrement);
						successfulModification=true;
					}else{
						//A_Shape Is Rectangle
						double oldwidth=tmp.getWidth();
						double oldHeight=tmp.getHeight();
						double newWidth=oldwidth+sizeIncrement;
						double newHeight=(newWidth*oldHeight)/oldwidth;
						tmp.setWidth(newWidth);
						tmp.setHeight(newHeight);
						successfulModification=true;
					}
				}catch(Exception ex){}
				try{
					VEllipse tmp=(VEllipse)shape;
					double oldMajorAxis=tmp.getMajorAxis();
					double oldMinorAxis=tmp.getMinorAxis();
					double newMajorAxis=oldMajorAxis+sizeIncrement;
					double newMinorAxis=(newMajorAxis*oldMinorAxis)/oldMajorAxis;
					tmp.setMajorAxis(newMajorAxis);
					tmp.setMinorAxis(newMinorAxis);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					VCircle tmp=(VCircle)shape;
					tmp.setMajorAxis(tmp.getMajorAxis()+sizeIncrement);
					tmp.setMinorAxis(tmp.getMinorAxis()+sizeIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					VETriangle tmp=(VETriangle)shape;
					tmp.setEdge(tmp.getEdge()+sizeIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				if(successfulModification){
					//save history
					ArrayList<VShape> tmp=cloneList(this.shapesContainer);
					this.history.addNewHistoryEntry(tmp);
				}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapeWidth(int arrayIndex, double widthIncrement){
				boolean successfulModification=false;
				VShape shape=shapesContainer.get(arrayIndex);
				try{
					//01_Shape Is Line
					VLine tmp=(VLine)shape;
					tmp.setEndX(tmp.getEndX()+widthIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					//02_Shape Is Quadrilateral
					VRectangle tmp=(VRectangle)shape;
					if(tmp.getWidth()==tmp.getHeight()){
						//A_Shape Is Square
						tmp.setWidth(tmp.getWidth()+widthIncrement);
						tmp.setHeight(tmp.getHeight()+widthIncrement);
						successfulModification=true;
					}else{
						//A_Shape Is Rectangle
						tmp.setWidth(tmp.getWidth()+widthIncrement);
						successfulModification=true;
					}
				}catch(Exception ex){}
				try{
					VEllipse tmp=(VEllipse)shape;
					tmp.setMajorAxis(tmp.getMajorAxis()+widthIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					VCircle tmp=(VCircle)shape;
					tmp.setMajorAxis(tmp.getMajorAxis()+widthIncrement);
					tmp.setMinorAxis(tmp.getMinorAxis()+widthIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					VETriangle tmp=(VETriangle)shape;
					tmp.setEdge(tmp.getEdge()+widthIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				if(successfulModification){
					//save history
					ArrayList<VShape> tmp=cloneList(this.shapesContainer);
					this.history.addNewHistoryEntry(tmp);
				}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			public void modifyShapeHeight(int arrayIndex, double heightIncrement){
				boolean successfulModification=false;
				VShape shape=shapesContainer.get(arrayIndex);
				try{
					//01_Shape Is Line
					VLine tmp=(VLine)shape;
					tmp.setEndY(tmp.getEndY()+heightIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					//02_Shape Is Quadrilateral
					VRectangle tmp=(VRectangle)shape;
					if(tmp.getWidth()==tmp.getHeight()){
						//A_Shape Is Square
						tmp.setWidth(tmp.getWidth()+heightIncrement);
						tmp.setHeight(tmp.getHeight()+heightIncrement);
						successfulModification=true;
					}else{
						//A_Shape Is Rectangle
						tmp.setHeight(tmp.getHeight()+heightIncrement);
						successfulModification=true;
					}
				}catch(Exception ex){}
				try{
					VEllipse tmp=(VEllipse)shape;
					tmp.setMinorAxis(tmp.getMinorAxis()+heightIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					VCircle tmp=(VCircle)shape;
					tmp.setMajorAxis(tmp.getMajorAxis()+heightIncrement);
					tmp.setMinorAxis(tmp.getMinorAxis()+heightIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				try{
					VETriangle tmp=(VETriangle)shape;
					tmp.setEdge(tmp.getEdge()+heightIncrement);
					successfulModification=true;
				}catch(Exception ex){}
				if(successfulModification){
					//save history
					ArrayList<VShape> tmp=cloneList(this.shapesContainer);
					this.history.addNewHistoryEntry(tmp);
				}
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			
			
			
		//***************************************************************************************
		//Setters & Getters for Serialization----------------------------------------------------
			public void setWidth(double width){
				this.width=width;
			}
			public void setHeight(double height){
				this.height=height;
			}
			public void setShapesContainer(ArrayList<VShape> shapesContainer){
				this.shapesContainer=shapesContainer;
			}
			
			
			public double getWidth(){
				return this.width;
			}
			public double getHeight(){
				return this.height;
			}
			public ArrayList<VShape> getShapesContainer(){
				return this.shapesContainer;
			}
		//Setters & Getters for Serialization----------------------------------------------------
		//***************************************************************************************

		
		//***************************************************************************************
		//Private Methods------------------------------------------------------------------------
		private boolean initializeShape(VShape shape){
			try{
				//01_Shape Is Line
				VLine tmp=(VLine)shape;
				shapesContainer.add(new VLine(70, 70, 3, "0x000000ff", "0xffff00ff", 10, 10, 70, 100));
				return true;
			}catch(Exception ex){}
			try{
				//02_Shape Is Quadrilateral
				VQuadrilateral tmp=(VQuadrilateral)shape;
				//A_Shape Is Square
				try{
					VSquare tmp2=(VSquare)shape;
					shapesContainer.add(new VSquare(70, 70, 3, "0x000000ff", "0xffff00ff", 100));
					return true;
				}catch(Exception ex){}
				//A_Shape Is Rectangle
				shapesContainer.add(new VRectangle(70, 70, 3, "0x000000ff", "0xffff00ff", 200, 100));
				return true;
			}catch(Exception ex){}
			try{
				VEllipse tmp=(VEllipse)shape;
				shapesContainer.add(new VEllipse(70, 70, 3, "0x000000ff", "0xffff00ff", 60, 40));
				return true;
			}catch(Exception ex){}
			try{
				VCircle tmp=(VCircle)shape;
				shapesContainer.add(new VCircle(70, 70, 3, "0x000000ff", "0xffff00ff", 50));
				return true;
			}catch(Exception ex){}
			try{
				VETriangle tmp=(VETriangle)shape;
				shapesContainer.add(new VCircle(70, 70, 3, "0x000000ff", "0xffff00ff", 70));
				return true;
			}catch(Exception ex){}
			
			return false;
		}
		//Private Methods------------------------------------------------------------------------
		//***************************************************************************************
				
		
		
		private ArrayList<VShape> cloneList(ArrayList<VShape> inputList){
			
			ArrayList<VShape> outputList=new ArrayList<>();
			
			for(int i=1; i<=inputList.size(); i++){
				try{
					VSquare tmp=(VSquare)inputList.get(i-1);
					outputList.add(tmp.clone());
					continue;
				}catch(Exception ex){}
				try{
					VRectangle tmp=(VRectangle)inputList.get(i-1);
					outputList.add(tmp.clone());
					continue;
				}catch(Exception ex){}
				try{
					VLine tmp=(VLine)inputList.get(i-1);
					outputList.add(tmp.clone());
					continue;
				}catch(Exception ex){}
				try{
					VCircle tmp=(VCircle)inputList.get(i-1);
					outputList.add(tmp.clone());
					continue;
				}catch(Exception ex){}
				try{
					VEllipse tmp=(VEllipse)inputList.get(i-1);
					outputList.add(tmp.clone());
					continue;
				}catch(Exception ex){}
			}
			
			return outputList;
		}
		
		
}






















