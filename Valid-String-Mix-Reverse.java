/*
Given three string values S1, S2 and S3, find if S3 is a reversed valid mix of the first two string values S1 and S2. The third string value S3 is said to be a reversed valid 
mix of the first S1 string and the second S2 string, if it can be formed by interleaving the characters of the first string and the second string in a way that maintains the 
left to the right order of occurrence of the characters for S1 and S2 each string from the end of S3 to the start of S3. The program must print YES if it is a valid mix. Else
the program must print NO as the output.

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
yummy
tasty
ytymmusaty

Output:
YES

Explanation:
The order of occurrence of yummy and tasty is preserved in ytymmusaty from the end to start.
Hence the output YES is printed.

Example Input/Output 2:
Input:
HEN
NECK
KNECHEN

Output:
YES

Example Input/Output 3:
Input:
HEN
NECK
KNCeHEN

Output:
NO
*/
import java.util.*;
public class Hello {

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.next(), str2=sc.next(), mix=sc.next();
		if (isValidMix(str1, str2, mix, 0, 0 , mix.length()-1)) {
		    System.out.print("YES");
		}
		else {
		    System.out.print("NO");
		}
	}
	
	private static boolean isValidMix(String str1, String str2, String mix, int index1, int index2, int mixIndex) {
	    while(mixIndex>=0) {
	        if (index1<str1.length() && index2<str2.length() && str1.charAt(index1)==mix.charAt(mixIndex) && str2.charAt(index2)==mix.charAt(mixIndex)) {
	            if (isValidMix(str1, str2, mix, index1+1, index2, mixIndex-1)) {
	                return true;
	            }
	            else {
	                return isValidMix(str1, str2, mix, index1, index2+1, mixIndex-1);
	            }
	        }
	        else if(index1<str1.length() && str1.charAt(index1)==mix.charAt(mixIndex)) {
	            index1++;
	            mixIndex--;
	        }
	        else if(index2<str2.length() && str2.charAt(index2)==mix.charAt(mixIndex)) {
	            index2++;
	            mixIndex--;
	        }
	        else {
	            return false;
	        }
	    }
	    return true;
	}
}
