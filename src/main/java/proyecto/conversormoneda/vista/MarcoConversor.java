package proyecto.conversormoneda.vista;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public  class MarcoConversor extends JFrame {

	private static final long serialVersionUID = -1812447090313520228L;
   public MarcoConversor() {
	  
	   setBounds(getScreenDimension()[0]/4,getScreenDimension()[1]/4 , 1000, 300);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   add(new LaminaPrincipal());
	   setTitle("Conversor de Divisa");
 }
   private int [] getScreenDimension() {
	   Toolkit getScreenDefault = Toolkit.getDefaultToolkit();
	   int x = getScreenDefault.getScreenSize().width;
	   int y = getScreenDefault.getScreenSize().height;
	   int[] dimension= {x,y};
	   return  dimension;
   }
}
