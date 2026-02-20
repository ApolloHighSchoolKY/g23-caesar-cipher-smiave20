/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

    //THIS IS AN ARRAY!!!!!
    //NOT A 2D ARRAY!!!!!
	private char[] alphabet;
	private char[] shifted;
	private int shift;

    //populate the alphabet with a loop either using the ASCII table or make a string with the alphabet and take 
    //chars from it like tictactoe
    //look at that position in alphabet, then the same one in shifted. If it's there (letter), concatenate.
    //Else, concatenate but don't encrypt.(" ")

    //Defualt Constructer: Assigns Defualt Values.
    public CaesarCipher() 
    {
        alphabet = new char[26];
        String alpha = "abcdefghijklmopqrstuvwxyz";
        int charPos = 0;

        for(int i = 0; i < alphabet.length; i++)
        {
            //At position (i) in the Array, term equals term in (String alpha)
            alphabet[i] = alpha.charAt(charPos);
            charPos++;
        }
        shift = 0;

    }

    //Modified Constructer: assigns values to all instances variables, and instantiates all objects
    //make a string with the alphabet and take chars from it like tictactoe
    public CaesarCipher(int num)
    {
        //Assigning values to an instances field.
        alphabet = new char[26];
        String alpha = "abcdefghijklmopqrstuvwxyz";

        for(int i = 0; i < alphabet.length; i++)
        {
            //At position (i) in the Array, term equals term in (String alpha)
            alphabet[i] = alpha.charAt(i);
        }

        //Assigning value to an instances variable.
        shift = num;
        shifter(num);
    }
    /*
            (pos + 2) % 4 
            pos - is the position looking to shift
            2 - What Is This 2??? (Number of letters shifting)????
            4 - is the total
    */
     //Take the letter, and look for it in alpha. Then that position that the letter is located at in alpha, look at shifted at that position.
     //and print out the letter form shifted.
    
    //look at that position in alphabet, then the same one in shifted. If it's there (letter), concatenate.
    //Else, concatenate but don't encrypt.(" ")
    public String encrypt(String message)
    {
        //Is This Right??? 
        //shift = (i + 13) % 26;
        String output = " ";

        for(int i = 0; i < message.length(); i++)
        {
            int index = -1;

            for(int alpha = 0; alpha < alphabet.length; alpha++)
            {
                 //Take the letter in the message, and look for it in alphabet.
                if(message.charAt(i) == alphabet[alpha])
                    index = alpha;
            }
           if(index == -1)
            output += message.charAt(i);
           else
                output += shifted[index];
        }
            return output;
    }

    //Whatever the message is that is encrpted, look at shift array first for that letter. 
    //then go to alpha at that position in shifted, return that letter in alpha.
    public String decrypt(String message)
    {
         String output = " ";

        for(int i = 0; i < message.length(); i++)
        {
            int index = -1;

            for(int alpha = 0; alpha < alphabet.length; alpha++)
            {
                 //Take the letter in the message, and look for it in alphabet.
                if(message.charAt(i) == shifted[alpha])
                    index = alpha;
            }
           if(index == -1)
            output += message.charAt(i);
           else
                output += alphabet[index];
        }
            return output;
    }

    //Reuses a CC if you want to change your encryption.
    public void shifter(int num)
    {
       //Assigning values to an instances field.
        shifted = new char[26];

        for(int i = 0; i < shifted.length; i++)
        {
            shifted[i] = alphabet[(i + num) % 26];
        }
    }


}