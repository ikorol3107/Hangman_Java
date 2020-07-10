import java.awt.* ;
import java.awt.image.BufferedImage ;
import java.io.File ;
import java.io.IOException ;
import java.awt.event.* ;
import javax.imageio.ImageIO ;
import javax.swing.* ;
import java.util.* ;

public class Hangman extends JPanel {
  private static String wordToGuess ;
  private static String imagePath ;
  private static int moveCount = 0 ;
  private static int wrongPressedButtons = 0 ;
  private static char[] rightPressedButtons ;
  private static char[] wordToGuessArray ;
  private static char alphabet[ ] = { 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 
		  							  'H' , 'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 
		  							  'O' , 'P' , 'Q' , 'R' , 'S' , 'T' , 'U' , 
		  							  'V' , 'W' , 'X' , 'Y' , 'Z' } ;
  boolean guessed = false ;
  RandomName randomName ;
  Color myColor ;
  JPanel chooseLevel = new JPanel( ) ;
  JPanel gallowsPanel = new JPanel( ) ;
  JPanel alphabetPanel = new JPanel( ) ;
  JPanel wordPanel = new JPanel( ) ;
  JPanel stepsToLosePanel = new JPanel( ) ;
  JPanel resultPanel = new JPanel( ) ;
  JLabel chooseLevelLabel = new JLabel( "Neues Spiel mit dem Thema starten:" ) ;
  JLabel stepsToLoselLabel ;
  JLabel winLabel = new JLabel( "Herzliche Glückwunsche! Du hast gewonnen!" ) ;
  JLabel losingLabel = new JLabel( "Hoopla! Du hast verloren!" ) ;
  JLabel wordToGuessLabel = new JLabel( ) ;
  JLabel gallowsLabel ;
  CircleButton startLevel = new CircleButton( "<html><h3><font color=\"white\">START" ) ;
  JComboBox levelForm ;
  Font SmallFontTR = new Font( "Sansserif" , Font.BOLD , 10 ) ;
	
  public Hangman( ) throws IOException {
    this.setLayout( null ) ; 
	Color myColor = new Color( 250 , 241 , 212 ) ;
	chooseLevelLabel.setFont(new Font( "Sansserif" , Font.BOLD , 16 ) ) ; 
	chooseLevelLabel.setForeground( new Color( 148 , 215 , 152  ) ) ;
	chooseLevelLabel.setBounds( 50 , 20 , 350 , 35 ) ;
	wordToGuessLabel = new JLabel( "Word to guess: " ) ;
	wordToGuessLabel.setFont(new Font( "Sansserif" , Font.PLAIN , 16 ) ) ; 
	wordToGuessLabel.setBounds( 290 , 230 , 200 , 100 ) ;
	this.add( chooseLevelLabel ) ;
	this.add( wordToGuessLabel ) ;
	levelForm = new JComboBox( ) ;
	levelForm.addItem( "Auto" ) ;
	levelForm.addItem( "Natur" ) ;
	levelForm.addItem( "Arbeit" ) ;
	levelForm.setPrototypeDisplayValue( "Maaaaaaximum size" ) ;
	chooseLevel.setBounds( 50 , 65 , 300 , 40 ) ;
	chooseLevel.setFont( new Font( "Sansserif" , Font.PLAIN , 16 ) ) ;
	chooseLevel.setBackground( myColor ) ;
	chooseLevel.setBorder( null ) ;
	chooseLevel.add( levelForm ) ;
	startLevel.setFocusPainted( false ) ;
	startLevel.setPreferredSize( new Dimension( 80 , 30 ) ) ;
	startLevel.setBackground(new Color( 148 , 215 , 152  ) ) ;
	chooseLevel.add( startLevel ) ;
	this.add( chooseLevel ) ;
	alphabetPanel.setBounds( 45 , 350 , 665 , 80 ) ;
	alphabetPanel.setBackground( myColor ) ;
	this.add( alphabetPanel ) ;
	wordPanel.setBounds( 45 , 300 , 600 , 50 ) ;
	wordPanel.setBackground( myColor ) ;
	this.add( wordPanel ) ;
	stepsToLosePanel.setBounds( 170 , 220 , 350 , 80 ) ;
	stepsToLosePanel.setBackground( myColor ) ;
	this.add( stepsToLosePanel ) ;
	gallowsPanel.setBounds( 545 , 50 , 150 , 300 ) ;
	gallowsPanel.setBackground( myColor ) ;
	this.add( gallowsPanel ) ;
	resultPanel.setBounds( 40 , 370 , 700 , 65 ) ;
	resultPanel.setBackground( myColor ) ;
	this.add( resultPanel ) ;
	winLabel.setFont( new Font( "Sansserif" , Font.BOLD , 32 ) ) ; 
	winLabel.setForeground( new Color( 148 , 215 , 152  ) ) ;
	losingLabel.setFont( new Font( "Sansserif" , Font.BOLD , 32 ) ) ; 
	losingLabel.setForeground( Color.DARK_GRAY ) ;
	rightPressedButtons = new char[ 0 ] ;
	RandomName randomName = new RandomName( ) ;
	wordToGuess = randomName.getResult( ) ;
	drawTextField( guessed , ' ' ) ;
	alphabetDesk( ) ;
	//Choose and draw random word to guess
	startLevel.addActionListener( new ActionListener( ) {
	  public void actionPerformed( ActionEvent e ) {
	    String userChose = ( String )levelForm.getSelectedItem( ) ;
		RandomName randomName = new RandomName( userChose ) ;
		wordToGuess = randomName.getResult( ) ;
		System.out.println( wordToGuess ) ;
	      try {
		    reset( ) ;
		   } catch ( IOException e2 ) {
			   // TODO Auto-generated catch block
			   e2.printStackTrace();
		      }
		  try {
			drawTextField( guessed , ' ' ) ;
		   } catch (IOException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace( ) ;
			  }
		} 
	 } ) ;
   }
  public void reset( ) throws IOException {
    moveCount = 0 ;
	alphabetPanel.removeAll( ) ;
	alphabetPanel.setVisible( true ) ;
	rightPressedButtons = new char[ 0 ] ; 
	wrongPressedButtons = 0 ;
	stepsToLosePanel.removeAll( ) ;
	gallowsPanel.removeAll( ) ;
	resultPanel.removeAll( ) ;
	repaint( ) ;
	alphabetDesk( ) ;
   }
  public void checkForLoss( ) {
    stepsToLosePanel.removeAll( ) ;
	int steps = 6 - wrongPressedButtons ;
	JLabel stepsToLoselLabel = new JLabel( "Noch " + steps + " Fehler bis zum Strick" ) ;
	stepsToLoselLabel.setFont(new Font( "Sansserif" , Font.PLAIN , 16 ) ) ;
	stepsToLosePanel.add( stepsToLoselLabel ) ;
	if( wrongPressedButtons == 6 ) {
	  GameMain.fail( ) ;
	  alphabetPanel.setVisible( false ) ;
	  resultPanel.add( losingLabel ) ;
	 }
   }
  public void drawGallows( ) throws IOException {
    gallowsPanel.removeAll( ) ;
	String imagePath = "images/0.png" ;
	if( guessed == false ) {
	  GameMain.buildGallows( ) ;
	  wrongPressedButtons++ ;
	 }
	switch( wrongPressedButtons  ) {
	  case 0 :
	    imagePath = "images/0.png" ;
	    break ;
	  case 1 :
		imagePath = "images/1.png" ;
		break ;
	  case 2 :
		imagePath = "images/2.png" ;
		break ;
	  case 3 :
		imagePath = "images/3.png" ;
		break ;
	  case 4 :
		imagePath = "images/4.png" ;
		break ;
	  case 5 :
		imagePath = "images/5.png" ;
		break ;
	  case 6 :
		imagePath = "images/6.png" ;
		break ;
	  default :
		imagePath = "images/6.png" ;
	 }
	BufferedImage myPicture = ImageIO.read( new File( imagePath ) ) ;
	JLabel picLabel = new JLabel( new ImageIcon( myPicture ) ) ;
	gallowsPanel.setSize( new Dimension( myPicture.getWidth( ) , myPicture.getHeight( ) ) ) ;
	gallowsPanel.add( picLabel ) ;
	gallowsPanel.revalidate( ) ;
	repaint( ) ;
   }
  //determines the players choice
  class ListenerAction implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
	  moveCount++ ;
	  guessed = false ;
	  JButton btn = ( JButton ) e.getSource( ) ;
	  btn.setEnabled( false ) ;
	  String string = wordToGuess.toUpperCase( ) ;
	  for( int i = 0 ; i < wordToGuess.length( ) ; i++ ) {
	    if( string.charAt( i ) == e.getActionCommand( ).charAt( 0 ) ) {
		  char[ ] newArray = Arrays.copyOf( rightPressedButtons , rightPressedButtons.length + 1 ) ;
		  newArray[ newArray.length - 1 ] = string.charAt( i ) ;
		  rightPressedButtons = newArray ;
		  guessed = true ;
		  try {
			drawTextField ( guessed , string.charAt( i ) ) ;
		   } catch ( IOException e1 ) {
			 // TODO Auto-generated catch block
			   e1.printStackTrace() ;
			  } 
	     }
       }
	  try {
		System.out.println( guessed ) ;
		drawGallows( ) ;
		checkForLoss( ) ;
	   } catch ( IOException e2 ) {
		  // TODO Auto-generated catch block
		   e2.printStackTrace( ) ;
		  }
	  System.out.println( "moveCount: " + moveCount ) ;
     }
   }
  public void drawTextField( boolean guessed , char letter ) throws IOException {
    wordPanel.removeAll( ) ;
	wordToGuessArray = new char[ wordToGuess.length( ) ] ;
	if( rightPressedButtons.length == wordToGuess.length( ) ) {
		GameMain.success( ) ;
		alphabetPanel.setVisible( false ) ;
		resultPanel.add( winLabel ) ;
	 }
	for ( int i = 0 ; i < wordToGuess.length( ) ; i++ ) {
	  JButton letterButton = new JButton( "" ) ;
	  letterButton.setFont( SmallFontTR ) ;
	  letterButton.setPreferredSize( new Dimension( 45 , 27 ) ) ;
	  letterButton.setEnabled( false ) ;
	  String string = wordToGuess.toUpperCase( ) ;
	  String letterToGuess = "" ;
	  letterToGuess += string.charAt( i ) ;
	  letterButton.setName( letterToGuess ) ;
	  wordToGuessArray[ i ] = string.charAt( i ) ;
	  wordPanel.add( letterButton ) ;	
	  if( guessed == true ) { 
		GameMain.rightButton( ) ;
	    for( char rpb : rightPressedButtons ) {
		  if( wordToGuessArray[ i ] == rpb ) {
		    letterButton.setText( letterToGuess ) ;
		   }
		 }
	   }
      wordPanel.revalidate( ) ;
	  repaint( ) ;
     }
   }  
  public void alphabetDesk( ) {
    for ( int i = 0 ; i < alphabet.length ; i++ ) {
  	  JButton button = new JButton( ) ;
  	  button.addActionListener( new ListenerAction( ) ) ;
  	  String string = Character.toString( alphabet[ i ] ) ;
  	  button.setText( string ) ;
      button.setPreferredSize( new Dimension( 46 , 27 ) ) ;
      alphabetPanel.add( button ) ;
     }
	}
  @Override
  public void paintComponent( Graphics g ) {
	Graphics2D g1 = ( Graphics2D ) g ;
	g1.setColor( new Color( 250 , 241 , 212 ) ) ;
	g1.fillRect( 0 , 0 , getWidth() ,getHeight( ) ) ;
   }
 }

