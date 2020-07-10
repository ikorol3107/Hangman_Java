
import java.awt.* ;
import java.io.IOException ;
import javax.swing.* ;

public class GameHold {
  private static JFrame gameFrame = new JFrame( ) ;
  public GameHold( String title ) throws IOException {
    gameFrame.setTitle( title ) ;
    call( ) ;
    build( ) ;
   }
  public static void sevisiblex( ) {
    gameFrame.setVisible( false ) ;
   }
  private void build( ) {
    gameFrame.setSize( 800, 500 ) ; 
    gameFrame.setLocationRelativeTo( null ) ;
    gameFrame.setBackground(new Color( 250 , 241 , 212 ) ) ;
    gameFrame.setResizable( false ) ;
    gameFrame.setVisible( true ) ;
    gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
   } 
  public void call( ) throws IOException {
    Hangman hangman = new Hangman( ) ;
    gameFrame.getContentPane().add( hangman ) ;
   }
 }




