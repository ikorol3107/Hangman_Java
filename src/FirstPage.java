import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.image.BufferedImage ;
import java.io.File ;
import java.io.IOException ;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO ;
import javax.swing.* ;

public class  FirstPage extends JFrame {
  private static JFrame gameFrame = new JFrame( ) ;
  JPanel panel = new JPanel( ) ;  
  JPanel buttonPanel = new JPanel( ) ;
  JPanel namePanel = new JPanel( ) ;
  JPanel imagePanel = new JPanel( ) ; 
  CircleButton start = new CircleButton( "<html><h1><font color=\"white\">START" ) ;
  CircleButton exit = new CircleButton( "<html><h1><font color=\"white\">EXIT" ) ;
  Color myColor ;
  public FirstPage( String title ) throws IOException {
    gameFrame.setTitle( title ) ;
	init( ) ;
	addFirstPageListener( ) ;
   }
  public void init( ) throws IOException { 
    gameFrame.setSize( 800, 500 ) ; 
    gameFrame.setLocationRelativeTo( null ) ;
    gameFrame.setBackground( new Color( 250 , 241 , 212 ) ) ;
    gameFrame.setResizable( false ) ;
    gameFrame.setVisible( true ) ;
    gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
    Color myColor = new Color( 250 , 241 , 212 ) ;
    panel.setBackground( myColor ) ;
    namePanel.setBackground( myColor ) ;
    namePanel.setBounds( 20 , 10 , 770 , 150 ) ;
    buttonPanel.setBounds( 190 , 250 , 300 , 200 ) ;
    buttonPanel.setBackground( myColor ) ;
    start.setFocusPainted( false ) ;
    start.setPreferredSize( new Dimension( 200 , 70 ) ) ;
    start.setBackground( new Color( 148 , 215 , 152  ) ) ;
    exit.setPreferredSize( new Dimension( 200, 70 ) ) ;
    exit.setBackground( new Color( 158 , 165 , 154 ) ) ;
    buttonPanel.add( start ) ;
    buttonPanel.add( exit ) ;
    imagePanel.setBounds( 500 , 180 , 300 , 500 ) ;
    imagePanel.setBackground( myColor ) ;
    gameFrame.add( namePanel ) ;
    gameFrame.add( imagePanel ) ;
    gameFrame.add( buttonPanel ) ;
    gameFrame.add( panel ) ;
    drawImage( ) ;
   } 
  public void drawImage( ) throws IOException { 
	String imagePath = "images/skeleton.png" ;
	String imagePath1 = "images/name.png" ;
	BufferedImage myPicture = ImageIO.read( new File( imagePath ) ) ;
	BufferedImage myPicture1 = ImageIO.read( new File( imagePath1 ) ) ;
	JLabel picLabel = new JLabel( new ImageIcon( myPicture ) ) ;
	JLabel picLabel1 = new JLabel( new ImageIcon( myPicture1 ) ) ;
	imagePanel.add( picLabel ) ;
	imagePanel.revalidate( ) ;
	namePanel.add( picLabel1 ) ;
	namePanel.revalidate( ) ;
   }
  public static void sevisiblex( ) {
    gameFrame.setVisible( false ) ;
   }
  public void addFirstPageListener( ) {
	start.addActionListener( new newGameAction( ) ) ;
	start.addActionListener( new ActionListener( ) {
	  @Override
      public void actionPerformed( ActionEvent e ) {
    	GameMain.buildGallows( ) ;
	    sevisiblex( ) ;
	   }
	 } ) ;
	exit.addActionListener( new ActionListener( ) {
	  @Override
	  public void actionPerformed( ActionEvent e ) {
	    GameMain.buildGallows();
	    System.exit( 0 ) ;
	   }
	 } ) ;
   }
  class newGameAction implements ActionListener { 
    public void actionPerformed( ActionEvent e ) {
	  try {
		GameHold gameDraw = new GameHold( "Hangman" ) ;
	   } catch ( IOException e2 ) {
		   // TODO Auto-generated catch block
		   e2.printStackTrace( ) ;
		  }
	 } 
   }
 }