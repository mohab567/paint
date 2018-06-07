package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.RunGame;
import model.Player;
import model.Player1;
import model.Player2;
import model.Shape;

public class GUI {

    private static GUI instance = null;
    public static DrawingArea canvas;
    private JFrame frame;
    JPanel bar;
    RunGame R;
    List<Shape> shapes;
    BufferedImage crown1Img;
    BufferedImage crown2Img;
    BufferedImage background;
    public static GUI getInstance() {
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    private GUI() {
        // TODO Auto-generated constructor stub
        canvas = new DrawingArea();
        bar = new JPanel();
        JButton pause = new JButton("START");
        pause.setBackground(new Color(51,51,0));
        pause.setSize(1000, 1000);
        bar.add(pause);
        bar.setBackground(new Color(250,125,125));

        canvas.setVisible(true);
        R = new RunGame(0.01);
        shapes = R.platesToRender();
        
        try {
			crown2Img = ImageIO.read(new File("img/clown2.png"));
			crown1Img = ImageIO.read(new File("img/clown1.png"));
			background = ImageIO.read(new File("img/backgroundImage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    private class DrawingArea extends JPanel implements MouseListener,
            MouseMotionListener, KeyListener {

    
    	
        public DrawingArea() {

            setBackground(new Color(255,204,153));
            setSize(500, 800);
            addMouseMotionListener(this);
            addMouseListener(this);
            addKeyListener(this);
            // setFocusable(true);
            // setFocusTraversalKeysEnabled(false);
        }
       /* private void paintStacks(Graphics g,List<Shape> m ,int x){
    		
    		for(int i=0 ; i<m.size(); i++){
                g.drawImage(m.get(i).getImg(), x, m.get(i).getPosition().y, 120, 40, this);
                System.out.println( m.get(i)
                        .getPosition().y);
    		}
    	}*/
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        	
           // paintStacks(g,Player1.getInstance().getStack1(),(int)Player1.getInstance().getxAxis()-75);
           //paintStacks(g,Player1.getInstance().getStack2(),(int)Player1.getInstance().getxAxis()+75);
            //paintStacks(g,Player2.getInstance().getStack1(),(int)Player2.getInstance().getxAxis()-75);
          // paintStacks(g,Player2.getInstance().getStack2(),(int)Player2.getInstance().getxAxis()+75);
                g.drawImage(background,-20, 0, 1400, 700, this);
                g.drawImage(crown1Img, (int)Player1.getInstance().getxAxis(), 200, 500, 500, this);
                g.drawImage(crown2Img, (int)Player2.getInstance().getxAxis(), 200, 500, 500, this);
                
          
            for (int i = 0; i < shapes.size(); i++) {
                BufferedImage img = shapes.get(i).getImg();
                g.drawImage(img, shapes.get(i).getPosition().x, shapes.get(i)
                        .getPosition().y, 120, 40, this);
            }
          List<List <Shape>> s = new ArrayList<List <Shape>>();
            s.add(Player1.getInstance().getStack1());
            s.add(Player1.getInstance().getStack2());
            s.add(Player2.getInstance().getStack1());
            s.add(Player2.getInstance().getStack2());
            List<Integer> l = new ArrayList<Integer>();
            l.add((int)Player1.getInstance().getxAxis()-75);
            l.add((int)Player1.getInstance().getxAxis()+75);
            l.add((int)Player2.getInstance().getxAxis()-75);
            l.add((int)Player2.getInstance().getxAxis()+75);
            List <Shape> m;
            int location;
            for(int j=0; j<s.size();j++){
            	m=s.get(j);
            	location=l.get(j);
            for(int i=0 ; i<m.size(); i++){
            	
                g.drawImage(m.get(i).getImg(),location , m.get(i).getPosition().y, 120, 40, this);
                System.out.println( m.get(i)
                        .getPosition().y);
    		}
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub

            Point curPt = e.getPoint();
            Player1.getInstance().setxAxis(curPt.x);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            int code = e.getKeyCode();
            double pos = Player2.getInstance().getxAxis();
            if (code == KeyEvent.VK_RIGHT) {
                Player2.getInstance().setxAxis(pos+10);
            } else if (code == KeyEvent.VK_LEFT) {
                Player2.getInstance().setxAxis(pos-10);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

    public void run() {
        frame = new JFrame("Circus Of Plates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        pane.add(bar, BorderLayout.NORTH);
        pane.add(canvas);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);

    }

    public void up() {
        R.run();
        canvas.revalidate();
        canvas.repaint();
        //
    }
}
