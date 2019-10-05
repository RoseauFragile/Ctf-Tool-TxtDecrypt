package model.tools;

public class ToolsCrack {
	public static double getScoreLetter(char charAt) {
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
