import java.util.*;

public class AsciiConversion{

	void asciiConversion(String string){
		int stringBitSize = string.length()*8;
		int temp = string.length();
		int numBlocks = (int) Math.ceil(stringBitSize/64.);
		char character;
		int ascii;
		String asciiBinaryString;

		String testECBPlontax1 = "I LOVE SECURITY";
		String testECBPlontax2 = "GO GATORS";
		String testECBstring = "ABCDEFGH";
		
		int[][] stringArray = new int[numBlocks][64];
		// int[] stringHolder = new int[numBlocks];

		// for(int i=0; i<string.length(); i++){
		// }

		for(int k=0, charCount = 0; k<numBlocks; k++, charCount+=8, temp-=8){	
			if((temp-charCount) < 0){
				for(int i=0, count = 7; i<temp; i++, count+=8){
					character = string.charAt(i+charCount);

					ascii = (int) character;

					asciiBinaryString = Integer.toBinaryString(ascii);
					for(int j=0; j<8;j++){
						if(j<asciiBinaryString.length()){
							stringArray[k][count-j] = (int)asciiBinaryString.charAt(asciiBinaryString.length()-1-j)-'0';
						}
					}
				}
			}else{
				for(int i=0, count = 7; i<8; i++, count+=8){
					character = string.charAt(i);

					ascii = (int) character;

					asciiBinaryString = Integer.toBinaryString(ascii);
					for(int j=0; j<8;j++){
						if(j<asciiBinaryString.length()){
							stringArray[k][count-j] = (int)asciiBinaryString.charAt(asciiBinaryString.length()-1-j)-'0';
						}
					}
				}
			}

			for(int i=0; i<64; i++){
				System.out.print(stringArray[k][i]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		AsciiConversion c = new AsciiConversion();
		String string = "I LOVE SECURITY";
		
		c.asciiConversion(string);	
	}
}