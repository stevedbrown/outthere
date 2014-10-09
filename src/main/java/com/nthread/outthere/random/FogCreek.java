package com.nthread.outthere.random;

/*
 * Find a 9 letter string of characters that contains only letters from

acdegilmnoprstuw

such that the hash(the_string) is

956446786872726

if hash is defined by the following pseudo-code:

Int64 hash (String s) {
    Int64 h = 7
    String letters = "acdegilmnoprstuw"
    for(Int32 i = 0; i < s.length; i++) {
        h = (h * 37 + letters.indexOf(s[i]))
    }
    return h
}
948587826306453
956446786872726
 */
public class FogCreek {
	static String letters = "acdegilmnoprstuw";
			
	public static void main(String[] args) { 
		System.out.println("amo==>" + hash("amo"));

		//long num = 354839;//956446786872726l;
		long num = 956446786872726l;
		long carry = 7;
		String ret = "";
		while ( num > 0 ) { 
			System.out.println("num is " + num);
			if ( carry >= num ) 
				break;
			
			int curr = (int) (num % 37);
			num /= 37;
			System.out.println("cur:" + curr);
			System.out.println("...==>" + letters.charAt(curr));
			ret = letters.charAt(curr) + ret;
		}
		System.out.println("word is:" + ret);
	}
	

	static long hash (String s) {
	    long h = 7;
	    for(int i = 0; i < s.length(); i++) {
	    	System.out.println("hash:h=" + h + ", adding " + s.charAt(i) + "[" + letters.indexOf(s.charAt(i)) + "]");
	        h = (h * 37 + letters.indexOf(s.charAt(i)));;
	    }
	    return h;
	}

}
