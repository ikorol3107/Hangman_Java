import java.io.File ;
import java.io.IOException ;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameMain {
  static AudioInputStream audioInputStream ;
  static Clip clip ;
  public static void main( String[] args ) throws IOException {
  FirstPage firstPageNew = new FirstPage( "Hangman" ) ;
   }
  public static void success( ) {
    try {
	  AudioInputStream input = AudioSystem.getAudioInputStream( new File( "sounds/sio.wav" ).getAbsoluteFile( ) ) ;
	  Clip c = AudioSystem.getClip( ) ;
	  c.open( input ) ;
	  c.start( ) ;
     } catch( Exception ex ) {
	     System.out.println( "Error with playing sound." ) ;
	     ex.printStackTrace( ) ;
	   }
   }
  public static void rightButton( ) {
	try {
      AudioInputStream input = AudioSystem.getAudioInputStream( new File( "sounds/success.wav" ).getAbsoluteFile( ) ) ;
	  Clip c = AudioSystem.getClip( ) ;
	  c.open( input ) ;
	  c.start( ) ;
     } 
	catch( Exception ex ) {
	  System.out.println( "Error with playing sound." ) ;
	  ex.printStackTrace( ) ;
	 }
   }
  public static void fail( ) {
    try {
	  AudioInputStream input = AudioSystem.getAudioInputStream( new File( "sounds/fail.wav" ).getAbsoluteFile( ) ) ;
	  Clip c = AudioSystem.getClip( ) ;
	  c.open( input ) ;
	  c.start( ) ;
	 } catch( Exception ex ) {
	     System.out.println( "Error with playing sound." ) ;
	     ex.printStackTrace( ) ;
	   }
   }
  public static void buildGallows( ) {
    try {
      AudioInputStream input = AudioSystem.getAudioInputStream( new File( "sounds/button17.wav" ).getAbsoluteFile( ) ) ;
      Clip c = AudioSystem.getClip( ) ;
	  c.open( input ) ;
	  c.start( ) ;
	 } catch( Exception ex ) {
	     System.out.println( "Error with playing sound." ) ;
	     ex.printStackTrace( ) ;
	   }
   }
 }

