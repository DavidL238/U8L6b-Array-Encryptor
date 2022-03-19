import java.lang.reflect.Array;
import java.util.Arrays;

public class Encryptor
{

    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int p = 0; p < numCols; p++) {
                if (count < str.length()) {
                    letterBlock[i][p] = str.substring(count, count+1);
                }
                else {
                    letterBlock[i][p] = "A";
                }
                count++;
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String rtn = "";
        for (int i = 0; i < numCols; i++) {
            for (int p = 0; p < numRows; p++) {
                rtn = rtn + letterBlock[p][i];
            }
        }
        return rtn;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String a = message;
        String sub = "";
        while (a.length() > numRows * numCols) {
            fillBlock(a.substring(0, numRows * numCols));
            sub = sub + encryptBlock();
            a = a.substring(numRows*numCols);
        }
        fillBlock(a);
        sub = sub + encryptBlock();
        return sub;

    }

    /** Encrypts a message and Shifts the columns before returning the encrypted String
     *
     * @param message the string to be encrypted
     * @param shift the number of columns the block will shift (leftwards)
     * @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message, int shift) {
        String a = message;
        String sub = "";
        while (a.length() > numRows * numCols) {
            fillBlock(a.substring(0, numRows * numCols));
            switchMajor(letterBlock);
            for (int i = 0; i < shift; i++) {
                shiftColumn(letterBlock, true);
            }
            switchMajor(letterBlock);
            sub = sub + encryptBlock();
            a = a.substring(numRows*numCols);
        }
        fillBlock(a);
        switchMajor(letterBlock);
        for (int i = 0; i < shift; i++) {
            shiftColumn(letterBlock, true);
        }
        switchMajor(letterBlock);
        sub = sub + encryptBlock();
        return sub;
    }

    public String[][] switchMajor(String[][] input) {
        String[][] rtnStr = new String[input[0].length][input.length];
        for (int i = 0; i < input[0].length; i++) {
            for (int p = 0; p < input.length; p++) {
                rtnStr[i][p] = input[p][i];
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int p = 0; p < input[i].length; p++) {
                input[i][p] = rtnStr[i][p];
            }
        }
        return input;
    }

    public void shiftColumn(String[][] input, boolean encrypt) {
        String[][] temp = switchMajor(input).clone();
        String[] firstCol = temp[0].clone();
        switchMajor (input);
            for (int c = 0; c < input[0].length; c++) {
                if (c < input[0].length - 1) {
                    for (int r = 0; r < input.length; r++) {
                        input[r][c] = input[r][c + 1];
                    }
                } else {
                    for (int z = 0; z < input.length; z++) {
                        input[z][c] = firstCol[z];
                    }
                }
            }
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String msg = "";
        String a = encryptedMessage;
        while (a.length() > 0) {
            String[][] decrypt = new String[numRows][numCols];
            for (int i = 0; i < numCols; i++) {
                for (int p = 0; p < numRows; p++) {
                    if (a.length() > 0) {
                        decrypt[p][i] = a.substring(0, 1);
                        a = a.substring(1);
                    }
                    else {
                        return null;
                    }
                }
            }
            for (String[] row : decrypt) {
                for (String str : row) {
                    msg = msg + str;
                }
            }
        }
        for (int i = msg.length()-1; i > 0; i--) {
            if (!(msg.charAt(i) == 'A')) {
                break;
            }
            else {
                msg = msg.substring(0, i);
            }
        }
        return msg;
    }

    public String decryptMessage(String encryptedMessage, int shift)
    {
        String msg = "";
        String a = encryptedMessage;
        while (a.length() > 0) {
            String[][] decrypt = new String[numRows][numCols];
            for (int i = 0; i < numCols; i++) {
                for (int p = 0; p < numRows; p++) {
                    if (a.length() > 0) {
                        decrypt[p][i] = a.substring(0, 1);
                        a = a.substring(1);
                    }
                    else {
                        return null;
                    }
                }
            }
            switchMajor(decrypt);
            for (int i = 0; i < numCols - shift; i++) {
                shiftColumn(decrypt, false);
            }
            switchMajor(decrypt);
            for (String[] row : decrypt) {
                for (String str : row) {
                    msg = msg + str;
                }
            }
        }
        for (int i = msg.length()-1; i > 0; i--) {
            if (!(msg.charAt(i) == 'A')) {
                break;
            }
            else {
                msg = msg.substring(0, i);
            }
        }
        return msg;
    }
    
}