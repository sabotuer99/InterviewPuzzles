package puzzles.cracking.chapter5;

/**
 * This class provides a collection of utility 
 * methods for bitwise operations.
 * 
 * @author Troy Whorten
 */
public class BitUtils {

	/**
	 * This method sets the <em>i<em>th bit of the
	 * provided integer to 1
	 * 
	 * <p>This is done by creating a mask consisting of
	 * 1 at the appropriate position, with all other digits 
	 * being 0.  This mask is then OR'ed with the origin value.
	 * </p>
	 * 
	 * @param value the value in which the bit will be set
	 * @param i the position of the bit to set
	 * @return the value with the ith bit set
	 */
	public static int setBit(int value, int i){
		int mask = orMask(i);
		return value | mask;
	}
	
	/**
	 * Gets the ith bit from an integer.
	 * 
	 * @param value, where the bit is coming from
	 * @param i, the position of the bit
	 * @return 1 or 0
	 */
	public static int getBit(int value, int i){
		return 1 & (value >> (i-1));
	}
	
	/**
	 * Creates a mask with 1s from the 0 to ith bits.
	 * 
	 * <p>i = 4:  00001111
	 * 
	 * @param i the number of 1s in the mask
	 * @return the value of the mask
	 */
	public static int rightMask(int i){
		return ~(-1 << i);
	}
	
	/**
	 * Creates a mask with 1s from the ith to last bits.
	 *
	 * <p>i = 5:  11110000
	 * 
	 * @param i the number of 1s in the mask
	 * @return the value of the mask
	 */
	public static int leftMask(int i){
		return -1 << i;
	}

	/**
	 * Sets a bit at position i, with the rest
	 * zeros
	 * 
	 * <p>i = 4:   00001000
	 * 
	 * @param i position of the set bit
	 * @return the value of the mask
	 */
	public static int orMask(int i){
		return 1 << (i-1);
	}
	
	/**
	 * All bits are ones, except one zero
	 * at postion i
	 * 
	 * <p>i = 4:   11110111
	 * 
	 * @param i position of the set bit
	 * @return the value of the mask
	 */
	public static int andMask(int i){
		return ~(1 << (i-1));
	}
	
	public static String toBitString(int value){
		int x = value;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 32; i++){
			if(i%8 == 0){
				sb.append(" ");
			}
			sb.append(x & 1);
			x >>>= 1;
		}
		String base = sb.reverse().toString().trim();
		
		if(value <= Byte.MAX_VALUE && value >= Byte.MIN_VALUE){
			return base.substring(27);
		} else if(value <= Short.MAX_VALUE && value >= Short.MIN_VALUE){
			return base.substring(18);
		} else {
			return base;
		}
	}
	
}
