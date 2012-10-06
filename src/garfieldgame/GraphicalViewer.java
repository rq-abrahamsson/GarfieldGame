package garfieldgame;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class GraphicalViewer extends JComponent implements BoardListener {
	
	GameBoard gameBoard;
	
	public GraphicalViewer (GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void boardChanged(){
            //System.out.println("ska repainta");
		repaint();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(gameBoard.getWidth(), gameBoard.getHeight());
	}
	
	public void insertNewGameBoard(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void paintComponent(final Graphics g){
            //System.out.println("ritar ut");
            Graphics2D g2 = (Graphics2D)g;
            //Rita ut spelplanen
            paintBackground(g2);
            //paintPlayer(g2);
            paintObstacle(g2);
            paintPowerbottle(g2);
        
	}
        private void paintBackground(Graphics2D g2){
        final Area background = new Area(new Rectangle2D.Float(
				0,0,gameBoard.getWidth(),gameBoard.getHeight()));
		/*h�r g�r det att �ndra v�rdet p� 100 f�r att flytta bakgrunden*/
            g2.setPaint(new Color(0,0,30));
            g2.fill(background);
            final Area floorArea = new Area(new Rectangle2D.Float(
                                    0,gameBoard.getHeight()-100,gameBoard.getWidth(),100));
            g2.setPaint(new Color(0,0,255));
            g2.fill(floorArea);    
        }
	
	private void paintPlayer(Graphics2D g2){
		//Rita ut spelaren
		final Area playerArea = new Area(new Rectangle2D.Float(
				gameBoard.getPlayer().getXCoord(),gameBoard.getPlayer().getYCoord(),
				gameBoard.getPlayer().getWidth(),gameBoard.getPlayer().getHeight()));		
		g2.setPaint(new Color(255,69,0));
		g2.fill(playerArea);
	}
	
	private void paintObstacle(Graphics2D g2){
		//Rita ut hinder
		final Area obstacleArea = new Area(new Rectangle2D.Float(
				gameBoard.getCurrentObstacle().getXCoordMap(),gameBoard.getCurrentObstacle().getYCoord(),
				gameBoard.getCurrentObstacle().getWidth(),gameBoard.getCurrentObstacle().getHeight()));
		g2.setPaint(new Color(100,100,100));
		g2.fill(obstacleArea);
		
	}
	
	private void paintPowerbottle(Graphics2D g2){
		//Rita ut energiflaska
		final Area powerbottleArea = new Area(new Rectangle2D.Float(
				gameBoard.getCurrentPowerbottle().getXCoordMap(),gameBoard.getCurrentPowerbottle().getYCoord(),gameBoard.getCurrentPowerbottle().getWidth(),gameBoard.getCurrentPowerbottle().getHeight()));
		g2.setPaint(new Color(210,105,30));
		g2.fill(powerbottleArea);
	}
	
}
