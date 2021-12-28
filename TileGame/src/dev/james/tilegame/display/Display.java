package dev.james.tilegame.display;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display 
{
	private JFrame frame; 
	private Canvas canvas; 
	
	private String title; 
	private int width, height; 
	
	public Display (String title, int width, int height) 
	{
		this.title = title; 
		this.width = width; 
		this.height = height;
		createDisplay();
	} 
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height)); 
		canvas.setMaximumSize(new Dimension(width, height)); 
		canvas.setMinimumSize(new Dimension(width, height)); 
		canvas.setFocusable(false); //makes jframe is only thing that has focus.
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() //getter allows access to canvas in other classes
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame; 
	}
	
}
