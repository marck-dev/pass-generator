package app;

import java.util.ArrayList;

public class Main {
  private static final String LENGTH_SHORT = "-l";
  private static final String LENGTH_LARGE = "--length";
  private static final int ANIMATION_TIME = 200;
  private static void help(){
    String[] msg = {"\t\t========| PASSWORD GENERATOR |========\n",
		"\t\t\t-> Marck C. Guzman ==> marck.guzman.dev@gmail.com\n",
		"command: pass-gen ["+ LENGTH_SHORT +" | "+ LENGTH_LARGE +"] <value>\n ",
		"\t" + LENGTH_SHORT +", "+ LENGTH_LARGE +" <intValue>\t\tSet the length of password"
    };
//    animate the output
	for ( String line : msg )
	  for ( char car : line.toCharArray() ) {
		System.out.print( car );
		try {
		  Thread.sleep( ANIMATION_TIME );
		} catch ( InterruptedException e ) {
		  e.printStackTrace();
		}
	  }
  }
  public static void main( String... a ){
	help();
	System.out.print( "hellos" );
  }
}
