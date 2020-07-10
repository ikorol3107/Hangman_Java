import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Graphics ;
import javax.swing.JButton ;

public class CircleButton extends JButton {
  public CircleButton( String text ) {
    super( text ) ;
	setPreferredSize( new Dimension( 200 , 70 ) ) ;
	setContentAreaFilled( false ) ;
   }
  @Override
  protected void paintComponent( Graphics g ) {
    if( getModel( ).isArmed( ) ) {
	  g.setColor( new Color( 190 , 215 , 152  ) ) ;
	  setForeground( Color.DARK_GRAY ) ;
	 }
	else {
	  g.setColor( getBackground( ) ) ;
	 }
	g.fillRoundRect( 0 , 0 , getSize( ).width - 1 , getSize( ).height - 1 , 13 , 13 ) ;
	super.paintComponent( g ) ;
   }
  @Override
  protected void paintBorder( Graphics g ) {
	g.setColor( getBackground( ) ) ;
	g.drawRoundRect( 0 , 0 , getSize( ).width - 1 , getSize( ).height - 1 , 13 , 13 ) ;
   }
 }

