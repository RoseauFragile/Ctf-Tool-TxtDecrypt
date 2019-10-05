package model.tools;

public class ToolsCrack {
	public static double getScoreLetterFrench(char charAt) {
		switch(charAt) {
		case 'a':
			return 7.11;
		case 'b':
			return 1.14;
		case 'c':
			return 3.18;
		case 'd':
			return 3.67;
		case 'e':
			return 12.10;
		case 'f':
			return 1.11;
		case 's':
			return 6.51;
		case 't':
			return 5.92;
		case 'i':
			return 6.59;
		case 'r':
			return 6.07;
		case 'n':
			return 6.39;
		case 'u':
			return 4.49;
		case 'l':
			return 4.96;
		case 'o':
			return 5.02;
		case 'm':
			return 2.62;
		case 'p':
			return 2.49;
		case 'v':
			return 1.11;
		case 'g':
			return 1.23;
		case 'h':
			return 1.11;
		case 'q':
			return 0.65;
		case 'y':
			return 0.46;
		case 'x':
			return 0.38;
		case 'j':
			return 0.34;
		case 'k':
			return 0.29;
		case 'w':
			return 0.17;
		case 'z':
			return 0.15;
		default:
			return 0.01;
		}
	}
	
	public static double getScoreLetterEnglish(char charAt) {
		switch(charAt) {
		case 'a':
			return 8.17;
		case 'b':
			return 1.29;
		case 'c':
			return 2.78;
		case 'd':
			return 4.25;
		case 'e':
			return 12.70;
		case 'f':
			return 2.23;
		case 's':
			return 6.33;
		case 't':
			return 9.06;
		case 'i':
			return 6.97;
		case 'r':
			return 5.99;
		case 'n':
			return 6.75;
		case 'u':
			return 2.76;
		case 'l':
			return 4.03;
		case 'o':
			return 7.51;
		case 'm':
			return 2.41;
		case 'p':
			return 1.93;
		case 'v':
			return 0.98;
		case 'g':
			return 2.02;
		case 'h':
			return 6.09;
		case 'q':
			return 0.10;
		case 'y':
			return 1.97;
		case 'x':
			return 0.15;
		case 'j':
			return 0.15;
		case 'k':
			return 0.77;
		case 'w':
			return 2.63;
		case 'z':
			return 0.07;
		default:
			return 0.01;
		}
	}
	
	public static int hammingDist(byte[] bs, byte[] bs2) 
	{ 
	    int hammingDist = 0;

        for (int pos = 0; pos < bs.length; ++pos) {
        	hammingDist = hammingDist + distanceByte(bs[pos],bs2[pos]);
        }
	    return hammingDist;
	}
	
    private static int distanceByte(byte x, byte y) {
        int dist = 0;
        byte val = (byte) (x ^ y);
        while (val != 0) {
            ++dist;
            val &= val - 1;
        }
        return dist;
    }
}
