//James Stark
//910065590
//CSCI3063_029211S

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Window extends JFrame 
{
	//define necessary variables
	protected int x = 1;
	protected int turnCounter = 0;
	protected Random rand = new Random();
	protected int stratNumber = 0;
	protected Boolean playerMove = false;
	protected Boolean selectionMade = false;
	protected Boolean isWinner = false;
	protected Boolean isLoser = false;
	protected Boolean isDraw = false;
	//define boolean to show whether if info is open
	protected Boolean infoOpen = false;
	//define booleans to show player's spaces
	protected Boolean xOnTopLeft = false;
	protected Boolean xOnTopRight = false;
	protected Boolean xOnTopCenter = false;
	protected Boolean xOnMidLeft = false;
	protected Boolean xOnMidRight = false;
	protected Boolean xOnMidCenter = false;
	protected Boolean xOnBottomLeft = false;
	protected Boolean xOnBottomRight = false;
	protected Boolean xOnBottomCenter = false;
	//define booleans to show computer player's spaces
	protected Boolean oOnTopLeft = false;
	protected Boolean oOnTopRight = false;
	protected Boolean oOnTopCenter = false;
	protected Boolean oOnMidLeft = false;
	protected Boolean oOnMidRight = false;
	protected Boolean oOnMidCenter = false;
	protected Boolean oOnBottomLeft = false;
	protected Boolean oOnBottomRight = false;
	protected Boolean oOnBottomCenter = false;
	//Initialize the buttons
	protected final JButton infoButton = new JButton("info");
	protected final JButton PlayerFirstButton = new JButton("First");
	protected final JButton ComputerFirstButton = new JButton("Second");
	protected final JButton TopLeftButton = new JButton("[1,1]");
	protected final JButton TopCenterButton = new JButton("[1,2]");
	protected final JButton TopRightButton = new JButton("[1,3]");
	protected final JButton MidLeftButton = new JButton("[2,1]");
	protected final JButton MidCenterButton = new JButton("[2,2]");
	protected final JButton MidRightButton = new JButton("[2,3]");
	protected final JButton BottomLeftButton = new JButton("[3,1]");
	protected final JButton BottomCenterButton = new JButton("[3,2]");
	protected final JButton BottomRightButton = new JButton("[3,3]");
	
	//Constructor
	Window()
	{
		//set window size, close operation, and title
		final int WINDOW_WIDTH = 1280;   
		final int WINDOW_HEIGHT = 720;  
		this.setTitle("Tic Tac Toe");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//initialize the used jpanel
		final JPanel panel = new JPanel();
		this.add(panel);
		
		//initialize the info text that appears when the info button is pressed
		final JTextArea infoText = new JTextArea();
		infoText.setEditable(false);
		
		//add the buttons and infoText
		panel.add(infoButton);
		panel.add(infoText);
		panel.add(PlayerFirstButton);
		panel.add(ComputerFirstButton);
		panel.add(TopLeftButton);
		panel.add(TopCenterButton);
		panel.add(TopRightButton);
		panel.add(MidLeftButton);
		panel.add(MidCenterButton);
		panel.add(MidRightButton);
		panel.add(BottomLeftButton);
		panel.add(BottomCenterButton);
		panel.add(BottomRightButton);
		
		//set all gameplay buttons to invisible
		TopLeftButton.setVisible(false);
		TopCenterButton.setVisible(false);
		TopRightButton.setVisible(false);
		MidLeftButton.setVisible(false);
		MidCenterButton.setVisible(false);
		MidRightButton.setVisible(false);
		BottomLeftButton.setVisible(false);
		BottomCenterButton.setVisible(false);
		BottomRightButton.setVisible(false);
		
		//define what happens when the info button is pressed
		infoButton.addActionListener(new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            	if(infoOpen == false) {
            		infoText.setText("Created by James Stark\nCompleted on 12/4/2021\n" 
            				+ "In order to beat tic tac toe, get three in a row");
            		infoOpen = true;
            	} else
            	{
            		infoText.setText("");
            		infoOpen = false;
            	}
            }
        });
		
		//define what happens when the PlayerFirstButton is pressed
		PlayerFirstButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent evt)
		    {    
		        selectionMade = true;
		        playerMove = true;   
		        PlayerFirstButton.setVisible(false);
		        ComputerFirstButton.setVisible(false);
		    }
		});
		
		//define what happens when the ComputerFirstButton is pressed
		ComputerFirstButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt)
			{    
				selectionMade = true;
				playerMove = false;  
				PlayerFirstButton.setVisible(false);
		        ComputerFirstButton.setVisible(false);
			}
		});
		
		//define what happens when the TopLeftButton is pressed
		TopLeftButton.addActionListener(new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            	xOnTopLeft = true;
            	panel.remove(TopLeftButton);
            	repaint();
            	playerMove = false;
            }
        });
		
		//define what happens when the TopCenterButton is pressed
		TopCenterButton.addActionListener(new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent evt)
            {
            	xOnTopCenter = true;
            	panel.remove(TopCenterButton);
            	repaint();
            	playerMove = false;
            }
        });
		
		//define what happens when the TopRightButton is pressed
		TopRightButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
		        xOnTopRight = true;
		        panel.remove(TopRightButton);
		        repaint();
		        playerMove = false;
			}
		});
				
		//define what happens when the MidLeftButton is pressed
		MidLeftButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				xOnMidLeft = true;
				panel.remove(MidLeftButton);
				repaint();
				playerMove = false;
			}
		});
		
		//define what happens when the MidCenterButton is pressed
		MidCenterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				xOnMidCenter = true;
				panel.remove(MidCenterButton);
				repaint();
				playerMove = false;
			}
		});
		
		//define what happens when the MidRightButton is pressed
		MidRightButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				xOnMidRight = true;
				panel.remove(MidRightButton);
				repaint();
				playerMove = false;
			}
		});
		
		//define what happens when the BottomLeftButton is pressed
		BottomLeftButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				xOnBottomLeft = true;
				panel.remove(BottomLeftButton);
				repaint();
				playerMove = false;
			}
		});
		
		//define what happens when the BottomCenterButton is pressed
		BottomCenterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				xOnBottomCenter = true;
				panel.remove(BottomCenterButton);
				repaint();
				playerMove = false;
			}
		});
		
		//define what happens when the BottomRightButton is pressed
		BottomRightButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				xOnBottomRight = true;
				panel.remove(BottomRightButton);
				repaint();
				playerMove = false;
			}
		});
		
		while(selectionMade == false)
		{
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		infoButton.setVisible(true);
		TopLeftButton.setVisible(true);
		TopCenterButton.setVisible(true);
		TopRightButton.setVisible(true);
		MidLeftButton.setVisible(true);
		MidCenterButton.setVisible(true);
		MidRightButton.setVisible(true);
		BottomLeftButton.setVisible(true);
		BottomCenterButton.setVisible(true);
		BottomRightButton.setVisible(true);
		
		//add Buttons to the frame and panel
		
		
		while(isWinner == false && isLoser == false && isDraw == false)
		{
			if(playerMove == false)
			{
				computerMove();
				repaint();
			}
			while(playerMove == true)
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gameConditionCheck();
			
			computerMove();
			gameConditionCheck();
			repaint();
			playerMove = true;
		}
		
		infoButton.setVisible(false);
		TopLeftButton.setVisible(false);
		TopCenterButton.setVisible(false);
		TopRightButton.setVisible(false);
		MidLeftButton.setVisible(false);
		MidCenterButton.setVisible(false);
		MidRightButton.setVisible(false);
		BottomLeftButton.setVisible(false);
		BottomCenterButton.setVisible(false);
		BottomRightButton.setVisible(false);
		
		if(isWinner == true)
		{
			infoText.setText("You Win!");
		}else
		if(isLoser == true)
		{
			infoText.setText("You Lose");
		}else
		if(isDraw == true)
		{
			infoText.setText("It's a draw");
		}
		
		infoText.setVisible(true);
	}
	
	//paint the window
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		BufferedImage XImage = null;
		try {
		    XImage = ImageIO.read(new File("src/X.png"));
		} catch (IOException e) {	
			System.exit(0);
		}
		XImage = resize(XImage,100,100);
		
		BufferedImage OImage = null;
		try {
		    OImage = ImageIO.read(new File("src/O.png"));
		} catch (IOException e) {	
			System.exit(0);
		}
		OImage = resize(OImage,100,100);
		
		g2.setStroke(new BasicStroke(12));
		
		g2.drawLine(500, 100, 500, 600);
		g2.drawLine(700, 100, 700, 600);
		
		g2.drawLine(350, 250, 850, 250);
		g2.drawLine(350, 450, 850, 450);
		
		if(xOnTopLeft == true)
			g2.drawImage(XImage, 370, 110, null);
		if(xOnTopCenter == true)
			g2.drawImage(XImage, 550, 110, null);
		if(xOnTopRight == true)
			g2.drawImage(XImage, 730, 110, null);
		if(xOnMidLeft == true)
			g2.drawImage(XImage, 370, 300, null);
		if(xOnMidCenter == true)
			g2.drawImage(XImage, 550, 300, null);
		if(xOnMidRight == true)
			g2.drawImage(XImage, 730, 300, null);
		if(xOnBottomLeft == true)
			g2.drawImage(XImage, 370, 490, null);
		if(xOnBottomCenter == true)
			g2.drawImage(XImage, 550, 490, null);
		if(xOnBottomRight == true)
			g2.drawImage(XImage, 730, 490, null);
		
		if(oOnTopLeft == true)
			g2.drawImage(OImage, 370, 110, null);
		if(oOnTopCenter == true)
			g2.drawImage(OImage, 550, 110, null);
		if(oOnTopRight == true)
			g2.drawImage(OImage, 730, 110, null);
		if(oOnMidLeft == true)
			g2.drawImage(OImage, 370, 300, null);
		if(oOnMidCenter == true)
			g2.drawImage(OImage, 550, 300, null);
		if(oOnMidRight == true)
			g2.drawImage(OImage, 730, 300, null);
		if(oOnBottomLeft == true)
			g2.drawImage(OImage, 370, 490, null);
		if(oOnBottomCenter == true)
			g2.drawImage(OImage, 550, 490, null);
		if(oOnBottomRight == true)
			g2.drawImage(OImage, 730, 490, null);
	}
	
	//method to resize buffered images, provided by user Ocracoke on Stack Overflow
	// at https://stackoverflow.com/questions/9417356/bufferedimage-resize
	public static BufferedImage resize(BufferedImage img, int newW, int newH)
	{ 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
	
	//method to check if there is a draw or a winner
	public void gameConditionCheck()
	{
		
		if(xOnTopLeft == true && xOnTopCenter == true && xOnTopRight == true)
		{
			isWinner = true;
		} else
		if(oOnTopLeft == true && oOnTopCenter == true && oOnTopRight == true)
		{
			isLoser = true;
		}else
		if(xOnMidLeft == true && xOnMidCenter == true && xOnMidRight == true)
		{
			isWinner = true;
		}else
		if(oOnMidLeft == true && oOnMidCenter == true && oOnMidRight == true)
		{
			isLoser = true;
		}else
		if(xOnBottomLeft == true && xOnBottomCenter == true && xOnBottomRight == true)
		{
			isWinner = true;
		}else
		if(oOnBottomLeft == true && oOnBottomCenter == true && oOnBottomRight == true)
		{
			isLoser = true;
		}else
		if(xOnTopLeft == true && xOnMidLeft == true && xOnBottomLeft == true)
		{
			isWinner = true;
		}else
		if(oOnTopLeft == true && oOnMidLeft == true && oOnBottomLeft == true)
		{
			isLoser = true;
		}else
		if(xOnTopCenter == true && xOnMidCenter == true && xOnBottomCenter == true)
		{
			isWinner = true;
		}else
		if(oOnTopCenter == true && oOnMidCenter == true && oOnBottomCenter == true)
		{
			isLoser = true;
		}else
		if(xOnTopRight == true && xOnMidRight == true && xOnBottomRight == true)
		{
			isWinner = true;
		}else
		if(oOnTopRight == true && oOnMidRight == true && oOnBottomRight == true)
		{
			isLoser = true;
		}else
		if(xOnTopLeft == true && xOnMidCenter == true && xOnBottomRight == true)
		{
			isWinner = true;
		}else
		if(oOnTopLeft == true && oOnMidCenter == true && oOnBottomRight == true)
		{
			isLoser = true;
		}else
		if(xOnBottomLeft == true && xOnMidCenter == true && xOnTopRight == true)
		{
			isWinner = true;
		}else
		if(oOnBottomLeft == true && oOnMidCenter == true && oOnTopRight == true)
		{
			isLoser = true;
		} else
		if((xOnTopLeft == true || oOnTopLeft == true) && 
				(xOnTopCenter == true || oOnTopCenter == true) &&
				(xOnTopRight == true || oOnTopRight == true) && 
				(xOnMidLeft == true || oOnMidLeft == true) && 
				(xOnMidCenter == true || oOnMidCenter == true) && 
				(xOnMidRight == true || oOnMidRight == true) && 
				(xOnBottomLeft == true || oOnBottomLeft == true) && 
				(xOnBottomCenter == true || oOnBottomCenter == true) && 
				(xOnBottomRight == true || oOnBottomRight == true))
		{
			isDraw = true;
		}
		
	}

	//method to handle the the computers move
	public void computerMove()
	{
		
		if(xOnMidCenter == false && oOnMidCenter == false)
		{
			oOnMidCenter = true;
			MidCenterButton.setVisible(false);
		}else
		if(xOnTopLeft == false && oOnTopLeft == false)
		{
			oOnTopLeft = true;
			TopLeftButton.setVisible(false);
		}else
		if(xOnBottomLeft == false && oOnBottomLeft == false)
		{
			oOnBottomLeft = true;
			BottomLeftButton.setVisible(false);
		}else
		if(xOnTopRight == false && oOnTopRight == false)
		{
			oOnTopRight = true;
			TopRightButton.setVisible(false);
		}else
		if(xOnBottomRight == false && oOnBottomRight == false)
		{
			oOnBottomRight = true;
			BottomRightButton.setVisible(false);
		}else
		if(xOnMidLeft == false && oOnMidLeft == false)
		{
			oOnMidLeft = true;
			MidLeftButton.setVisible(false);
		}else
		if(xOnTopCenter == false && oOnTopCenter == false)
		{
			oOnTopCenter = true;
			TopCenterButton.setVisible(false);
		}else
		if(xOnMidRight == false && oOnMidRight == false)
		{
			oOnMidRight = true;
			MidRightButton.setVisible(false);
		}else
		if(xOnBottomCenter == false && oOnBottomCenter == false)
		{
			oOnBottomCenter = true;
			BottomCenterButton.setVisible(false);
		}
		
		playerMove = true;
	}
}