package OU4;

import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args)
	{
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
		
		// mata in två naturliga heltal
		Scanner in = new Scanner (System.in);
		out.println ("två naturliga heltal:");
		String tal1 = in.next ();
		String tal2 = in.next ();
		out.println ();
		in.close();
		
		// addera heltalen och visa resultatet
		String summa = addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');
		
		// subtrahera heltalen och visa resultatet
		String differens = subtrahera (tal1, tal2);
		visa (tal1, tal2, differens, '-');
	}
	
	// addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
	// summa som en teckensträng.
	public static String addera (String tal1, String tal2)
	{
        int siffra1 = 0;
        int siffra2 = 0;
        int carry = 0;
        int length1 = tal1.length() - 1;
        int length2 = tal2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int summa = 0;
        int siffra = 0;
        
        while (length1 >= 0 && length2 >= 0) {
            siffra1 = tal1.charAt(length1) - 48;
            siffra2 = tal2.charAt(length2) - 48;

            summa = carry + siffra1 + siffra2;
            siffra = summa % 10;
            builder.insert(0, siffra);
            carry = summa/10;
            length1 --;
            length2 --;
        }
        while (length1 >= 0) {
            siffra1 = tal1.charAt(length1) - 48;
            summa = carry + siffra1;
            siffra = summa % 10;
            builder.insert(0, siffra);
            carry = summa/10;
            length1 --;
        }
        while (length2 >= 0) {
            siffra2 = tal2.charAt(length2) - 48;
            summa = carry + siffra2;
            siffra = summa % 10;
            builder.insert(0, siffra);
            carry = summa/10;
            length2 --;
        }
        return builder.toString();
	}
	
	// subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
	// deras differens som en teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.
	public static String subtrahera (String tal1, String tal2)
	{
        int siffra1 = 0;
        int siffra2 = 0;
        int diff = 0;
        int length1 = tal1.length() - 1;
        int length2 = tal2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        
        while (length1 >= 0 && length2 >= 0) {
            siffra1 = tal1.charAt(length1) - 48;
            siffra2 = tal2.charAt(length2) - 48;
            diff = siffra1-siffra2-carry;

            if (diff < 0) {
                diff+=10;
                carry=1;
            }
            else
                carry=0;

            builder.insert(0, diff);
            length1 --;
            length2 --;
        }
        while (length1 >= 0) {
            siffra1 = tal1.charAt(length1) - 48;
            diff = siffra1-carry;

            if (diff < 0) {
                diff+=10;
                carry=1;
            }
            else
                carry=0;
            builder.insert(0, diff);
            length1 --;
        }
        while (length2 >= 0) {
            builder.append("Tal 1 måste vara större än tal 2");
        }
        return builder.toString();
	}

	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
	// utförd i samband med hetalen
	public static void visa (String tal1, String tal2, String resultat, char operator)
	{
		// sätt en lämplig längd på heltalen och resultatet
		int len1 = tal1.length ();
		int len2 = tal2.length ();
		int len = resultat.length ();
		int maxLen = Math.max (Math.max (len1, len2), len);
		tal1 = sattLen (tal1, maxLen - len1);
		tal2 = sattLen (tal2, maxLen - len2);
		resultat = sattLen (resultat, maxLen - len);
		
		// visa heltalen och resultatet
		out.println (" " + tal1);
		out.println ("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print ("-");
		out.println ();
		out.println (" " + resultat + "\n");
	}
	
	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen (String s, int antal)
	{
		StringBuilder sb = new StringBuilder (s);
		for (int i = 0; i < antal; i++)
			sb.insert (0, " ");
		return sb.toString ();
	}
}