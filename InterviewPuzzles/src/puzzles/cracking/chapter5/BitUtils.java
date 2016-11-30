package puzzles.cracking.chapter5;

/**
 * This class provides a collection of utility 
 * methods for bitwise operations.
 * 
 * @author Troy Whorten
 */
public class BitUtils {

	/**
	 * Sets the ith bit of the provided integer to 1
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
	 * Gets the ith bit from an integer.  The value is 
	 * right shifted i-1 positions and AND'ed with 1.
	 * 
	 * @param value, where the bit is coming from
	 * @param i, the position of the bit
	 * @return 1 or 0
	 */
	public static int getBit(int value, int i){
		return 1 & (value >> (i));
	}
	
	/**
	 * Clears the ith bit from an integer.  A mask of all
	 * ones is generated, except a 0 in the ith position. This is
	 * AND'ed with teh origin value
	 * 
	 * @param value, where the bit is to be cleared from
	 * @param i, the position of the bit
	 * @return the modified value
	 */
	public static int clearBit(int value, int i){
		int mask = andMask(i);
		return value & mask;
	}
	
	/**
	 * Sets the ith value to the value of bit, which should be 1 or 0.
	 * 
	 * @param value, where the bit is coming from
	 * @param i, the position of the bit
	 * @param bit, the value to update to. Odd = 1, Even = 0
	 * @return the modified value
	 */
	public static int updateBit(int value, int i, int bit){
		bit = bit & 1; 
			
		return clearBit(value, i) | (bit << (i));
	}
	
	/**
	 * Creates a mask with 1s from the 0 to ith bits.
	 * 
	 * <p>i = 3:  00001111
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
	 * <p>i = 4:  11110000
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
	 * <p>i = 3:   00001000
	 * 
	 * @param i position of the set bit
	 * @return the value of the mask
	 */
	public static int orMask(int i){
		return 1 << (i);
	}
	
	/**
	 * All bits are ones, except one zero
	 * at postion i
	 * 
	 * <p>i = 3:   11110111
	 * 
	 * @param i position of the set bit
	 * @return the value of the mask
	 */
	public static int andMask(int i){
		return ~(1 << (i));
	}
	
	
	/**
	 * Converts an integer into a String representation
	 * of binary.  Numbers in the byte range [-128, 127] are shortened
	 * to one octet.  Numbers in the short range [-32768, 32767] are shortened
	 * to two octets.  Otherwise, four octets are returned.
	 * 
	 * @param value the number to be stringified
	 * @return the string of 1s and 0s
	 */
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
	
	public static int fromBitString(String bits){
		if(bits == null || bits.length() == 0){
			return 0;
		}
		
		int parsed = 0;
		for(char bit : bits.toCharArray()){
			if(bit != ' '){
				parsed <<= 1;
				parsed += bit == '1' ? 1 : 0;
			}
		}
		
		return parsed;
	}	
}
