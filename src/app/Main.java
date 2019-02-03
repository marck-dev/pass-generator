package app;

import java.util.ArrayList;
import java.util.Arrays;

import app.core.Generator;

public class Main {
  private static final String LENGTH_SHORT = "-l";
  private static final String LENGTH_LARGE = "--length";
  private static final int ANIMATION_TIME = 40;
  private static void help(){
    String[] msg = {"\t\t===========| PASSWORD GENERATOR |===========\n",
		"\t\tMarck C. Guzman : marck.guzman.dev@gmail.com\n\n",
		"command: pass-gen ["+ LENGTH_SHORT +" | "+ LENGTH_LARGE +"] <value>:\n ",
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
		if( a.length == 0 || a.length < 2 ){
			help();
			return;
		}
		ArrayList<String> args = new ArrayList<String>(Arrays.asList( a ));
		if( args.contains( LENGTH_LARGE ) || args.contains(  LENGTH_SHORT ) ){
			try {
				int length = Integer.parseInt( args.get(1) );
				Generator gen = new Generator.Builder().generateBaseNum().setLength( length ).build();
				gen.toClipboard();
				System.out.println( "Copy to clipboard.");
				System.out.println( "\n\n\tPassword: " + gen.getPass() );
			}catch (NumberFormatException e) {
				System.out.println( "\n\n!Wrong value, length must be number" );
			}
		}
  }
}
