/*
 * Copyright (c) 2019 Marck C. Guzmán
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package app.core;



import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class Generator {
  private String pass;

  private Generator( int randomBase, int length ) {
    StringBuilder pass = new StringBuilder();
	for ( int i = 0; i < length; i++ ) {
		int intCar = ( int ) Math.floor( ( ( ( randomBase + Math.pow( randomBase, i ) ) % 74 ) + 48 ) % 74 + 48);
		if ( intCar == 96 )
		  intCar = ( ( intCar / 2 ) * i + 48 ) % 74;
		if( intCar > 122 )
		  intCar = (intCar % 74) + 48;
		if ( intCar < 48 )
		  intCar += 48;
		char car = (char) intCar ;
		pass.append( car );
	}
	this.pass = pass.toString();
  }

  public String getPass(){
    return pass;
  }

  public Generator toClipboard(){
	StringSelection stringSelection = new StringSelection( getPass() );
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents( stringSelection, null );
  return this;
  }

  public static final class Builder{
	private int randomBase;
	private int length;

	public Builder generateBaseNum() {
	  try {
		this.randomBase = SecureRandom.getInstance( "SHA1PRNG" ).nextInt();
	  } catch ( NoSuchAlgorithmException e ) {
		e.printStackTrace();
	  }
	  return this;
	}

	public Builder setLength( int length ) {
	  this.length = length;
	  return this;
	}

	public Generator build(){
	  return new Generator( randomBase, length );
	}
  }
	public static void main(String... a){
     System.out.print( "Hello" );
	}
}
