import java.io.BufferedReader ;
import java.io.File ;
import java.io.FileNotFoundException ;
import java.io.FileReader ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

public class RandomName {
  String file ;
  String userChoose ;
  String result = "" ;
  public RandomName( ) {
	this.userChoose = "Auto" ;
	chooseRandomWord( ) ;
   }
  public RandomName( String userChoose ) {
    this.userChoose = userChoose ;
	chooseRandomWord( ) ;
   }
  public void setResult( String res ) {
	result = res ;
   }
  public String getResult( ) {
	return result ;
   }
  public  void chooseRandomWord( ) {
	if( userChoose == "Natur" ) {
	  file = "words/natur.txt" ; 
	 } 
	else if( userChoose == "Arbeit" ) {
	  file = "words/arbeit.txt" ; 
	 } 
	else {
	  file = "words/Auto.txt" ;
	 }
	int count = 2 ;  
	List<String> wordsList = new ArrayList<>( ) ; 
	try {
	  BufferedReader br = new BufferedReader( new FileReader( new File( file ) ) ) ;
	  String read ;
	  while ( ( read = br.readLine( ) ) != null ) {
        wordsList.add( read ) ; 
	   }
	 }
	 catch( FileNotFoundException e ) {
       System.out.println( "File not found." ) ;
	  }
	 catch( IOException e ) {
	   System.out.println( "I/O error." ) ;
	  }
     while( --count > 0 ) { 
	   setResult( wordsList.get( ( int )( Math.random( ) * wordsList.size( ) ) ) ) ;
	   System.out.println( getResult( ) ) ;
	  }
   }
 }

