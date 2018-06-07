package userinterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import canvas.module.VCanvas;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import shape.modules.VCircle;
import shape.modules.VETriangle;
import shape.modules.VEllipse;
import shape.modules.VLine;
import shape.modules.VRectangle;
import shape.modules.VShape;
import shape.modules.VSquare;



public class VectorPaintUI extends Application {
	
	//--------------------------------------------------------------------------------
	//01_Attributes-------------------------------------------------------------------
	//--------------------------------------------------------------------------------
		//A_Control Bar Buttons
			private static Button createNewImageBtn;
			private static Button saveImageBtn;
			private static Button loadImageBtn;
			private static Button undoActionBtn;
			private static Button redoActionBtn;

		//B_Add & Delete Buttons
			private static Button addLineBtn;
			private static Button addTriangleBtn;
			private static Button addSquareBtn;
			private static Button addRectangleBtn;
			private static Button addEllipseBtn;
			private static Button addCircleBtn;
		//C_Size Controls
			private static Label resizeControlsLabel;
			private static Slider fullResizeSlider;
			private static Slider widthResizeSlider;
			private static Slider heightResizeSlider;
		//D_Border Controls
			private static Label borderControlsLabel;
			private static Slider borderThicknessSlider;
			private static ColorPicker borderColorPicker;
		//E_Shape Fill Controls
			private static Label fillControlsLabel;
			private static ColorPicker fillColorPicker;
		//F_Misc Controls
			private static Label miscControlsLabel;
			private static Button removeShapeBtn;
		//G_More Attributes
			private static BorderPane layout;
			private static Pane canvas;
			private static Stage primaryWindow;
		//H_Engine Related
			private static ArrayList<Shape> shapesArray;
			private static int selectedElement;
			private static int engineSelectedElement;
			private static VCanvas appEngine;
			
	
	//--------------------------------------------------------------------------------
	//01_Attributes-------------------------------------------------------------------
	//--------------------------------------------------------------------------------
			
	//********************************************************************************				
			
	//--------------------------------------------------------------------------------
	//02_Constructor/InitializeApp----------------------------------------------------
	//--------------------------------------------------------------------------------
			
		public static void initializeApplication(){
			initializeWindowElements();
			//setWindowElementStyling();
			setActionListeners();
			setWindowLayout();
		}	
		
		
		public static void initializeWindowElements(){
			//01_Control Bar Buttons
			createNewImageBtn=new Button("N");
			saveImageBtn=new Button("S");
			loadImageBtn=new Button("L");
			undoActionBtn=new Button("U");
			redoActionBtn=new Button("R");
			
			//02_Add Shape Buttons
			addLineBtn=new Button("Line");
			addTriangleBtn=new Button("Triangle");
			addSquareBtn=new Button("Square");
			addRectangleBtn=new Button("Rectangle");
			addEllipseBtn=new Button("Ellipse");
			addCircleBtn=new Button("Circle");
			//02_Resize Controls
			resizeControlsLabel=new Label("Resize Controls");
			fullResizeSlider=new Slider();
			fullResizeSlider.setMinWidth(200);fullResizeSlider.setMaxWidth(200);
			fullResizeSlider.setMin(-1000);fullResizeSlider.setMax(1000);
			widthResizeSlider=new Slider();
			widthResizeSlider.setMinWidth(200);widthResizeSlider.setMaxWidth(200);
			widthResizeSlider.setMin(-1000);widthResizeSlider.setMax(1000);
			heightResizeSlider=new Slider();
			heightResizeSlider.setMinWidth(200);heightResizeSlider.setMaxWidth(200);
			heightResizeSlider.setMin(-1000);heightResizeSlider.setMax(1000);
			//03_Border Control
			borderControlsLabel=new Label("Border Controls");
			borderThicknessSlider=new Slider();
			borderThicknessSlider.setMinWidth(200);borderThicknessSlider.setMaxWidth(200);
			borderThicknessSlider.setMin(1);borderThicknessSlider.setMax(10);
			borderColorPicker=new ColorPicker();
			//04_Shape Fill Control
			fillControlsLabel=new Label("Fill Controls");
			fillColorPicker=new ColorPicker();
			//05_MISC Controls
			miscControlsLabel=new Label("Misc Controls");
			removeShapeBtn=new Button("Remove");
			//06_More Attributes
			canvas=new Pane();
			primaryWindow=new Stage();
			//07_Engine Related
			shapesArray=new ArrayList<>();
			selectedElement=-1;
			engineSelectedElement=-1;
			appEngine=new VCanvas(600,400);

		}
		
		
		public static void setActionListeners(){
			//01_Control Bar Buttons
			createNewImageBtn.setOnMouseClicked(e ->{
				createNewImage();
				
			});
			saveImageBtn.setOnMouseClicked(e ->{
				saveImage();
			});
			loadImageBtn.setOnMouseClicked(e ->{
				loadImage();
			});
			undoActionBtn.setOnMouseClicked(e ->{
				appEngine.undoAction();
				renderImageFromEngine();
			});
			redoActionBtn.setOnMouseClicked(e ->{
				appEngine.redoAction();
				renderImageFromEngine();
			});
			
			//02_Add Shape Buttons
			addLineBtn.setOnMouseClicked(e ->{
				if(createNewShape(new Line())){
					appEngine.createNewShape(new VLine());
				}
			});
			addTriangleBtn.setOnMouseClicked(e ->{
				if(createNewShape(new Polygon())){
					appEngine.createNewShape(new VETriangle());
				}
			});
			addSquareBtn.setOnMouseClicked(e ->{
				if(createNewShape(new Rectangle(20, 20))){
					appEngine.createNewShape(new VSquare());
				}
			});
			addRectangleBtn.setOnMouseClicked(e ->{
				if(createNewShape(new Rectangle(10,20))){
					appEngine.createNewShape(new VRectangle());
				}
			});
			addEllipseBtn.setOnMouseClicked(e ->{
				if(createNewShape(new Ellipse(20,10))){
					appEngine.createNewShape(new VEllipse());
				}
			});
			addCircleBtn.setOnMouseClicked(e ->{
				if(createNewShape(new Ellipse(10,10))){
					appEngine.createNewShape(new VCircle());
				}
			});
			
			//02_Resize Controls
			fullResizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	            		double sizeIncrement=(double)new_val-(double)old_val;
 	            		if(applyFullResize(sizeIncrement)){
 	            			appEngine.modifyShapeFullSize(engineSelectedElement, sizeIncrement);
 	            		}
	            }
	        });
			widthResizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	            		double widthIncrement=(double)new_val-(double)old_val;
	            		if(applyWidthResize(widthIncrement)){
	            			appEngine.modifyShapeWidth(engineSelectedElement, widthIncrement);
	            		}
	            }
	        });
			heightResizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	            		double heightIncrement=(double)new_val-(double)old_val;
	            		if(applyHeightResize(heightIncrement)){
	            			appEngine.modifyShapeHeight(engineSelectedElement, heightIncrement);
	            		}
	            }
	        });
			//03_Border Control
			borderThicknessSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                Number old_val, Number new_val) {
	            	if(changeBorderThickness((double)new_val)){
	            		appEngine.modifyShapeBorderSize(engineSelectedElement, (double)new_val);
	            	}
	            }
	        });
			
			borderColorPicker.setOnAction(e ->{
				try{
					Shape shape=shapesArray.get(selectedElement);
		    		shape.setStroke(borderColorPicker.getValue());
		    		String newBorderColor=borderColorPicker.getValue().toString();
		    		appEngine.modifyShapeBorderColor(selectedElement, newBorderColor);
				}catch(Exception ex){}
			});
			//04_Shape Fill Control
			fillColorPicker.setOnAction(e ->{
				try{
					Shape shape=shapesArray.get(selectedElement);
		    		shape.setFill(fillColorPicker.getValue());
		    		String newFillColor=fillColorPicker.getValue().toString();
		    		appEngine.modifyShapeFillColor(selectedElement, newFillColor);
				}catch(Exception ex){}
			});
			//05_MISC Controls
			removeShapeBtn.setOnMouseClicked(e ->{
				if(removeElement()){
					appEngine.removeShape(engineSelectedElement);
				}
			});
			//06_More Attributes
		}
		
		
		public static void setWindowLayout(){
			HBox windowControls=new HBox();
			windowControls.getChildren().addAll(createNewImageBtn, saveImageBtn, loadImageBtn);
			windowControls.getChildren().addAll(undoActionBtn, redoActionBtn);
			windowControls.setSpacing(10);
			windowControls.setPadding(new Insets(20,10,20,10));
			
			HBox addShapesControls=new HBox();
			addShapesControls.getChildren().addAll(addLineBtn, addTriangleBtn, addSquareBtn, addRectangleBtn);
			addShapesControls.getChildren().addAll(addEllipseBtn, addCircleBtn);
			addShapesControls.setSpacing(10);
			addShapesControls.setPadding(new Insets(20,10,20,10));
			
			VBox resizeControls=new VBox();
			resizeControls.getChildren().addAll(resizeControlsLabel, fullResizeSlider, widthResizeSlider, heightResizeSlider);
			resizeControls.setSpacing(10);
			resizeControls.setPadding(new Insets(20,20,20,20));
			
			VBox borderControls=new VBox();
			borderControls.getChildren().addAll(borderControlsLabel, borderThicknessSlider, borderColorPicker);
			borderControls.setSpacing(10);
			borderControls.setPadding(new Insets(20,20,20,20));
			
			VBox fillElementControls=new VBox();
			fillElementControls.getChildren().addAll(fillControlsLabel, fillColorPicker);
			fillElementControls.setSpacing(10);
			fillElementControls.setPadding(new Insets(20,20,20,20));
			
			VBox removeElementControls=new VBox();
			removeElementControls.getChildren().addAll(miscControlsLabel, removeShapeBtn);
			removeElementControls.setSpacing(10);
			removeElementControls.setPadding(new Insets(20,20,20,20));
			
			canvas.setMinSize(600, 400);
			canvas.setClip(new Rectangle(3000,3000));
			canvas.setPadding(new Insets(30,30,30,30));
			
			HBox drawingCanvas=new HBox();
			drawingCanvas.getChildren().add(canvas);
			drawingCanvas.setStyle("-fx-background-color: white;");
			
			//-----------------------------------
			AnchorPane topPanel=new AnchorPane();
			topPanel.getChildren().addAll(windowControls, addShapesControls);
			topPanel.setLeftAnchor(windowControls, 20.0);
			topPanel.setRightAnchor(addShapesControls, 100.0);
			topPanel.setStyle("-fx-background-color: #292751;");
			
			VBox sidePanel=new VBox();
			sidePanel.getChildren().addAll(resizeControls, borderControls, fillElementControls, removeElementControls);
			sidePanel.setMinWidth(250);
			sidePanel.setMaxWidth(250);
			sidePanel.setStyle("-fx-background-color: #dddddd;");

			//-----------------------------------
			layout=new BorderPane();
			layout.setTop(topPanel);
			layout.setLeft(sidePanel);
			layout.setCenter(drawingCanvas);
			layout.setPrefSize(900, 550);

		}

	//--------------------------------------------------------------------------------
	//02_Constructor/InitializeApp----------------------------------------------------
	//--------------------------------------------------------------------------------
	
	//********************************************************************************
		
	//--------------------------------------------------------------------------------
	//03_Launch Application-----------------------------------------------------------
	//--------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//01_Initialize Application
			initializeApplication();
			primaryWindow=primaryStage;
		//02_Set the final Scene:
			Scene scene=new Scene(layout, 1100, 600);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.setMinHeight(550);
			primaryStage.setMinWidth(900);	
			primaryStage.show();
		
	}
	
	//--------------------------------------------------------------------------------
	//03_Launch Application-----------------------------------------------------------
	//--------------------------------------------------------------------------------
	
	//********************************************************************************
	
	//--------------------------------------------------------------------------------
	//Interface Methods---------------------------------------------------------------
	//--------------------------------------------------------------------------------
	
	//06_Adding Shapes------------------------------
	public static boolean createNewShape(Shape shape){
		//01_Identifying Shape
		if(identifyShapeForInitiation(shape)){
			int shapeId=shapesArray.size()-1;
			shape=shapesArray.get(shapeId);
				
			//02_Set Attributes
			shape.setStrokeWidth(3);
			shape.setStroke(Color.BLACK);
			shape.setFill(Color.YELLOW);
				
			//03_Add new shape to the Canvas
			canvas.getChildren().add(shape);
			shape.setTranslateX(70);
			shape.setTranslateY(70);
				
			//04_Set Mouse Events
			setShapeHighlightingEvent(shape, shapeId);
			setShapeDragEvent(shape, shapeId);
			
			return true;
		}
		return false;
		
	}
	//Remove Element Method------------------------
	private static boolean removeElement(){
		try{
			Shape shapeToRemove=shapesArray.get(selectedElement);
			canvas.getChildren().remove(shapeToRemove);
			shapesArray.set(selectedElement, null);
			engineSelectedElement=selectedElement;
			selectedElement=-1;
			return true;
		}catch(Exception ex){}
		return false;
	}
	//Full Resize Method---------------------------
	private static boolean applyFullResize(double sizeIncrement){
		try{
			Shape shape=shapesArray.get(selectedElement);
			engineSelectedElement=selectedElement;
			try{
				Line tmp=(Line)shape;
				double oldEndX=tmp.getEndX();
				double oldEndY=tmp.getEndY();
				double newEndX=oldEndX+sizeIncrement;
				double newEndY=(newEndX*oldEndY)/oldEndX;
				tmp.setEndX(newEndX);
				tmp.setEndY(newEndY);
				return true;
			}catch(Exception e){}
			try{
				Rectangle tmp=(Rectangle)shape;
				//A_It's a Square
				if(tmp.getWidth()==tmp.getHeight()){
					tmp.setWidth(tmp.getWidth()+sizeIncrement);
					tmp.setHeight(tmp.getHeight()+sizeIncrement);
					return true;
				}
				//B_It's a Rectangle
				else{
					double oldwidth=tmp.getWidth();
					double oldHeight=tmp.getHeight();
					double newWidth=oldwidth+sizeIncrement;
					double newHeight=(newWidth*oldHeight)/oldwidth;
					tmp.setWidth(newWidth);
					tmp.setHeight(newHeight);
					return true;
				}
				
			}catch(Exception e){}
			try{
				Ellipse tmp=(Ellipse)shape;
				double oldRadiusX=tmp.getRadiusX();
				double oldRadiusY=tmp.getRadiusY();
				double newRadiusX=oldRadiusX+sizeIncrement;
				double newRadiusY=(newRadiusX*oldRadiusY)/oldRadiusX;
				tmp.setRadiusX(newRadiusX);
				tmp.setRadiusY(newRadiusY);
				return true;
			}catch(Exception e){}
			try{
				Circle tmp=(Circle)shape;
				tmp.setRadius(tmp.getRadius()+sizeIncrement);
				return true;
			}catch(Exception e){}
			
		}catch(Exception ex){}
		return false;
	}
	//Full Resize Method---------------------------
	private static boolean applyWidthResize(double widthIncrement){
		try{
			Shape shape=shapesArray.get(selectedElement);
			engineSelectedElement=selectedElement;
			try{
				Line tmp=(Line)shape;
				tmp.setEndX(tmp.getEndX()+widthIncrement);
				return  true;
			}catch(Exception e){}
			try{
				Rectangle tmp=(Rectangle)shape;
				//A_It's a Square
				if(tmp.getWidth()==tmp.getHeight()){
					tmp.setWidth(tmp.getWidth()+widthIncrement);
					tmp.setHeight(tmp.getHeight()+widthIncrement);
					return  true;
				}
				//B_It's a Rectangle
				else{
					tmp.setWidth(tmp.getWidth()+widthIncrement);
					return  true;
				}
			}catch(Exception e){}
			try{
				Ellipse tmp=(Ellipse)shape;
				tmp.setRadiusX(tmp.getRadiusX()+widthIncrement);
				return  true;
			}catch(Exception e){}
			try{
				Circle tmp=(Circle)shape;
				tmp.setRadius(tmp.getRadius()+widthIncrement);
				return  true;
			}catch(Exception e){}
			
		}catch(Exception ex){}
		return false;

	}
	//Full Resize Method---------------------------
	private static boolean applyHeightResize(double heightIncrement){
		try{
			Shape shape=shapesArray.get(selectedElement);
			engineSelectedElement=selectedElement;
			try{
				Line tmp=(Line)shape;
				tmp.setEndY(tmp.getEndY()+heightIncrement);
				return true;
			}catch(Exception e){}
			try{
				Rectangle tmp=(Rectangle)shape;
				//A_It's a Square
				if(tmp.getWidth()==tmp.getHeight()){
					tmp.setWidth(tmp.getWidth()+heightIncrement);
					tmp.setHeight(tmp.getHeight()+heightIncrement);
					return true;
				}
				//B_It's a Rectangle
				else{
					tmp.setHeight(tmp.getHeight()+heightIncrement);
					return true;
				}
			}catch(Exception e){}
			try{
				Ellipse tmp=(Ellipse)shape;
				tmp.setRadiusY(tmp.getRadiusY()+heightIncrement);
				return true;
			}catch(Exception e){}
			try{
				Circle tmp=(Circle)shape;
				tmp.setRadius(tmp.getRadius()+heightIncrement);
				return true;
			}catch(Exception e){}
			
		}catch(Exception ex){}
		return false;
	}
	//Border
	private static boolean changeBorderThickness(double newValue){
		try{
			Shape shape=shapesArray.get(selectedElement);
			shape.setStrokeWidth(newValue);
			engineSelectedElement=selectedElement;
			return true;
		}catch(Exception e){}
		return false;
		
	}
	
	//-----------------------------------------------------------------------------
	//End Interface Methods--------------------------------------------------------
	//-----------------------------------------------------------------------------
	
	

	
	
	
	//-----------------------------------------------------------------------------
	//Private Methods--------------------------------------------------------------
	//-----------------------------------------------------------------------------
	private static boolean identifyShapeForInitiation(Shape shape){
		//01_Shape is a circle
		try{
			Ellipse tmp=(Ellipse)shape;
			//A_It's a Circle
			if(tmp.getRadiusX()==tmp.getRadiusY()){
				shapesArray.add(new Circle(50));
			}
			//B_It's an Ellipse
			else{
				shapesArray.add(new Ellipse(60,40));
			}
			return true;
		}catch(Exception ex){}
		//02_Shape is a Rectangle
		try{
			Rectangle tmp=(Rectangle)shape;
			//A_It's a Square
			if(tmp.getWidth()==tmp.getHeight()){
				shapesArray.add(new Rectangle(100,100));
			}
			//B_It's a Rectangle
			else{
				shapesArray.add(new Rectangle(200,100));
			}
			return true;
		}catch(Exception ex){}
		/*try{
			Line tmp=(Line)shape;
			shapesArray.add(new Line(10, 10, 70, 100));
			return true;
		}catch(Exception ex){
			
		}*/
		try{
			Polygon tmp=(Polygon)shape;
			double p1x=50.0; double p1y=50.0;
			double p2x=p1x-100; double p2y=p1y+200*Math.sin(60);
			double p3x=p1x+200*Math.cos(60); double p3y=p1y+200*Math.sin(60);
			/*double p2x=p1x-35; double p2y=p1y+70*Math.sin(60);
			double p3x=p1x+35; double p3y=p1y+70*Math.sin(60);*/
			tmp.getPoints().addAll(new Double[]{
					p1x, p1y, p2x, p2y, p3x, p3y
			});
			shapesArray.add(tmp);
			return true;
		}catch(Exception ex){}
		return false;
		
	}
	
	//----------------------------------------------------------------------
	private static void setShapeHighlightingEvent(Shape shape, int shapeId){
		//01_fix inner class variable issue
		final Shape tmpShape=shape;
		final int tmpShapeId=shapeId;
		//02_Select Element to perform operations
		shape.setOnMouseClicked(e ->{
			//0_Reset Resize Controls
			//01_Set Element to selected
			appEngine.modifyShapePosition(shapeId, newTranslateX, newTranslateY);
			if(e.getClickCount()==2){
				if(selectedElement!=tmpShapeId){
					try{
						Shape previousShape=shapesArray.get(selectedElement);
						previousShape.setStyle("-fx-opacity: 1.0");
						selectedElement=-1;
					}catch(Exception ex){
						fullResizeSlider.setValue(0);
						widthResizeSlider.setValue(0);
						heightResizeSlider.setValue(0);
					}
					finally{
						tmpShape.setStyle("-fx-opacity: 0.5");
						selectedElement=tmpShapeId;
						
						
						borderThicknessSlider.setValue(tmpShape.getStrokeWidth());
						borderColorPicker.setValue((Color) tmpShape.getStroke());
						fillColorPicker.setValue((Color) tmpShape.getFill());
					}
				}else{
					tmpShape.setStyle("-fx-opacity: 1.0");
					selectedElement=-1;
				}
			}
		});
		
	}
	//----------------------------------------------------------------------
	static double newTranslateX;
	static double newTranslateY;
	
	private static void setShapeDragEvent(Shape shape, int shapeId){
		//01_fix inner class variable issue
			//final Shape tmpShape=shape;
			//final int tmpShapeId=shapeId;
		//02_Set Move Element Event
		shape.setOnMouseDragged(e ->{
			 newTranslateX=shape.getTranslateX()+e.getX();
			 newTranslateY=shape.getTranslateY()+e.getY();
			shape.setTranslateX(newTranslateX);
			shape.setTranslateY(newTranslateY);
			
			
		});
		
		
	}
	
	
	
	
	
	//*********************************************************************
	//*********************************************************************
	public static void createNewImage(){
		//boolean answer=ConfirmBox.display("title", "Discard Changes?");
		if(!shapesArray.isEmpty()){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("New Image");
			alert.setHeaderText("Discard Changes?");
			//alert.setContentText("Discard Changes?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				try{
					shapesArray.clear();
					canvas.getChildren().clear();
					selectedElement=-1; engineSelectedElement=-1;
					appEngine=new VCanvas(600,400);
				}catch (Exception ex){}
			} else {
			    // ... user chose CANCEL or closed the dialog
			}
		}
		
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void saveImage(){
		//01_Instantiation
		FileChooser fileChooser = new FileChooser();
		
		//02_Set Dialog Configuration
			//A_Title
			fileChooser.setTitle("Save Image");
			//B_Default Directory
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			//C_Restrict File Types
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("XML", ".xml"),
					new FileChooser.ExtensionFilter("JSON", ".json")
			);

		//03_Show Dialog & Use File
		File chosenFile=fileChooser.showSaveDialog(primaryWindow);
		
		if(chosenFile!=null){
			if(getFileExtension(chosenFile).equalsIgnoreCase("xml")){
				appEngine.saveImageXML(chosenFile.getPath());
			}else if(getFileExtension(chosenFile).equalsIgnoreCase("json")){
				appEngine.saveImageJSON(chosenFile.getPath());
			}
        }
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void loadImage(){
		//01_Instantiation
		FileChooser fileChooser = new FileChooser();
		
		//02_Set Dialog Configuration
			//A_Title
			fileChooser.setTitle("Open Image");
			//B_Default Directory
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			//C_Restrict File Types
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("XML", ".xml"),
					new FileChooser.ExtensionFilter("JSON", ".json")
			);

		//03_Show Dialog & Use File
		File chosenFile=fileChooser.showOpenDialog(primaryWindow);
		
		if(chosenFile!=null){
			if(getFileExtension(chosenFile).equalsIgnoreCase("xml")){
				appEngine.loadImageXML(chosenFile.getPath());
				renderImageFromEngine();
			}else{
				//appEngine.loadImageJSON(chosenFile.getPath());
				//renderImageFromEngine();
			}
		
        }
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private static void renderImageFromEngine(){
		//01_Clear the canvas
		selectedElement=-1; engineSelectedElement=-1;
		shapesArray.clear();
		canvas.getChildren().clear();
		//02_render
		ArrayList<VShape> loadedImage=appEngine.getShapesContainer();
		
		for(int i=1; i<=loadedImage.size(); i++){
			VShape shape=loadedImage.get(i-1);
			try{
				VLine tmp=(VLine)shape;
				createNewShape(new Line());
				Line tmp2=(Line)shapesArray.get(shapesArray.size()-1);
				tmp2.setStartX(tmp.getStartX()); tmp2.setStartY(tmp.getStartY());
				tmp2.setEndX(tmp.getEndX()); tmp2.setEndY(tmp.getEndY());
			}catch(Exception ex){}
			try{
				VRectangle tmp=(VRectangle)shape;
				if(tmp.getWidth()==tmp.getHeight()){
					createNewShape(new Rectangle(100,100));
				}else{
					createNewShape(new Rectangle(200,100));
				}
				Rectangle tmp2=(Rectangle)shapesArray.get(shapesArray.size()-1);
				tmp2.setWidth(tmp.getWidth()); tmp2.setHeight(tmp.getHeight());
			}catch(Exception ex){}
			try{
				VEllipse tmp=(VEllipse)shape;
				createNewShape(new Ellipse(50,100));
				Ellipse tmp2=(Ellipse)shapesArray.get(shapesArray.size()-1);
				tmp2.setRadiusX(tmp.getMajorAxis()); tmp2.setRadiusY(tmp.getMinorAxis());
			}catch(Exception ex){}
			try{
				VCircle tmp=(VCircle)shape;
				createNewShape(new Ellipse(50,50));
				Circle tmp2=(Circle)shapesArray.get(shapesArray.size()-1);
				tmp2.setRadius(tmp.getMajorAxis());
			}catch(Exception ex){}
		
			Shape addedShape=shapesArray.get(shapesArray.size()-1);
			addedShape.setTranslateX(shape.getTranslateX());
			addedShape.setTranslateY(shape.getTranslateY());
			addedShape.setStrokeWidth(shape.getBorderSize());
			addedShape.setStroke(Paint.valueOf(shape.getBorderColor()));
			addedShape.setFill(Paint.valueOf(shape.getFillColor()));
			
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

}




















