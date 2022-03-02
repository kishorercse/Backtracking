/*
Given 3 string values S1, S2 and S3, find if S3 is a valid mix of the first two string values S1 and S2. The third string value S3 is said to be a mix of the first S1 string
and the second S2 string, if it can be formed by interleaving the characters of the first string and the second string in a way that maintains the left to the right order of
occurrence of the characters for S1 and S2 each string. The program must print YES if it is a valid mix. Else the program must print NO as the output.

Boundary Condition(s):
1 <= Length of S1, S2 <= 1000

Input Format:
The first line contains the string S1.
The second line contains the string S2.
The third line contains the string S3.

Output Format:
The first line contains either YES or NO.

Example Input/Output 1:
Input:
mno
xyz
xmnyzo

Output:
YES

Explanation:
The order of occurrence of xyz and mno is preserved in xmnyzo.
Hence the output YES is printed.

Example Input/Output 2:
Input:
MANO
KON
MAKNOON

Output:
YES

Example Input/Output 3:
Input:
MANO
KON
MAKOONN

Output:
NO
*/
import java.util.*;
public class Hello {

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.next(), str2=sc.next(), mix=sc.next();
		if (str1.length()+str2.length()==mix.length() && isValidMix(str1, str2, mix, 0, 0 , 0)) {
		    System.out.print("YES");
		}
		else {
		    System.out.print("NO");
		}

	}
	
	private static boolean isValidMix(String str1, String str2, String mix, int index1, int index2, int mixIndex) {
	    while(mixIndex<mix.length()) {
	        
	        if (index1<str1.length() && index2<str2.length() && str1.charAt(index1)==mix.charAt(mixIndex) && str2.charAt(index2)==mix.charAt(mixIndex)) {
	            
	            if (isValidMix(str1, str2, mix, index1+1, index2, mixIndex+1)) {
	                return true;
	            }
	            else {
	                return isValidMix(str1, str2, mix, index1, index2+1, mixIndex+1);
	            }
	            
	        }
	        else if(index1<str1.length() && str1.charAt(index1)==mix.charAt(mixIndex)) {
	            mixIndex++;
	            index1++;
	        }
	        else if(index2<str2.length() && str2.charAt(index2)==mix.charAt(mixIndex)) {
	            mixIndex++;
	            index2++;
	        }
	        else {
	            return false;
	        }
	    }
	    return true;
	}
}
