import java.util.Arrays;

public class EncryptorTester
{
    public static void main(String[] args)
    {
        // --------------------------------
        // ---- TEST PART A: fillBlock ----
        // --------------------------------
        System.out.println("---- TESTING PART A ----");
        Encryptor encryptor1 = new Encryptor(3, 5);
        encryptor1.fillBlock("Meet at noon");

        String[][] expected1 = {
                {"M", "e", "e", "t", " "},
                {"a", "t", " ", "n", "o"},
                {"o", "n", "A", "A", "A"}};

        String[][] actual1 = encryptor1.getLetterBlock();

        if (testArr(expected1, actual1))
        {
            System.out.println("\nTest 1 PASSED!");
        }
        else
        {
            System.out.println("\n*** Test 1 FAILED! ***");
            System.out.println("EXPECTED:");
            print2DArray(expected1);
            System.out.println("\nACTUAL:");
            print2DArray(actual1);
        }

        Encryptor encryptor2 = new Encryptor(3, 5);
        encryptor2.fillBlock("Meet at midnight");

        String[][] expected2 = {{"M", "e", "e", "t", " "},
                {"a", "t", " ", "m", "i"},
                {"d", "n", "i", "g", "h"}};

        String[][] actual2 = encryptor2.getLetterBlock();

        if (testArr(expected2, actual2))
        {
            System.out.println("\nTest 2 PASSED!");
        }
        else
        {
            System.out.println("\n*** Test 2 FAILED! ***");
            System.out.println("EXPECTED:");
            print2DArray(expected2);
            System.out.println("\nACTUAL:");
            print2DArray(actual2);
        }

        Encryptor encryptor3 = new Encryptor(4, 3);
        encryptor3.fillBlock("That's me!");

        String[][] expected3 = {{"T", "h", "a"},
                {"t", "'", "s"},
                {" ", "m", "e"},
                {"!", "A", "A"}};

        String[][] actual3 = encryptor3.getLetterBlock();

        if (testArr(expected3, actual3))
        {
            System.out.println("\nTest 3 PASSED!");
        }
        else
        {
            System.out.println("\n*** Test 3 FAILED! ***");
            System.out.println("EXPECTED:");
            print2DArray(expected3);
            System.out.println("\nACTUAL:");
            print2DArray(actual3);
        }

        Encryptor encryptor = new Encryptor(3, 4);
        encryptor.fillBlock("hello");

        String[][] expected4 = {{"h", "e", "l", "l"},
                {"o", "A", "A", "A"},
                {"A", "A", "A", "A"}};

        String[][] actual4 = encryptor.getLetterBlock();

        if (testArr(expected4, actual4))
        {
            System.out.println("\nTest 4 PASSED!");
        }
        else
        {
            System.out.println("\n*** Test 4 FAILED! ***");
            System.out.println("EXPECTED:");
            print2DArray(expected4);
            System.out.println("\nACTUAL:");
            print2DArray(actual4);
        }

        // UNCOMMENT THE SECTIONS BELOW TO TEST EACH PART

    // -----------------------------------
    //   ---- TEST PART B: encryptBlock ----
    //   -----------------------------------
    System.out.println("\n---- TESTING PART B ----");
    Encryptor encryptor4 = new Encryptor(2, 3);
    encryptor4.fillBlock("ABCDEF");
    String actualEncryptedBlock1 = encryptor4.encryptBlock();
    String expectedEncryptedBlock1 = "ADBECF";
    if (actualEncryptedBlock1.equals(expectedEncryptedBlock1))
    {
      System.out.println("\nTest 1 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 1 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncryptedBlock1);
      System.out.println("  ACTUAL: " + actualEncryptedBlock1);
    }
    encryptor4.fillBlock("Meet a");
    String actualEncryptedBlock2 = encryptor4.encryptBlock();
    String expectedEncryptedBlock2 = "Mte ea";
    if (actualEncryptedBlock2.equals(expectedEncryptedBlock2))
    {
      System.out.println("\nTest 2 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 2 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncryptedBlock2);
      System.out.println("  ACTUAL: " + actualEncryptedBlock2);
    }
    
    Encryptor encryptor5 = new Encryptor(4, 2);
    encryptor5.fillBlock("ABCDEFGHIJK");
    String actualEncryptedBlock3 = encryptor5.encryptBlock();
    String expectedEncryptedBlock3 = "ACEGBDFH";
    if (actualEncryptedBlock3.equals(expectedEncryptedBlock3))
    {
      System.out.println("\nTest 3 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 3 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncryptedBlock3);
      System.out.println("  ACTUAL: " + actualEncryptedBlock3);
    }


    // -------------------------------------
    // ---- TEST PART C: encryptMessage ----
    // -------------------------------------
    System.out.println("\n---- TESTING PART C ----");
    Encryptor encryptorTest = new Encryptor(2, 3);
    String actualEncrypted1 = encryptorTest.encryptMessage("Meet at midnight");
    String expectedEncrypted1 = "Mte eati dmnitgAhA";
    if (actualEncrypted1.equals(expectedEncrypted1))
    {
      System.out.println("\nTest 1 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 1 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncrypted1);
      System.out.println("  ACTUAL: " + actualEncrypted1);
    }
    
    String actualEncrypted2 = encryptorTest.encryptMessage("Let's go outside. Are you OK with that?");
    String expectedEncrypted2 = "L'est goou tsei.d A ryeouK  Owi tthhaAtA?A";
    if (actualEncrypted2.equals(expectedEncrypted2))
    {
      System.out.println("\nTest 2 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 2 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncrypted2);
      System.out.println("  ACTUAL: " + actualEncrypted2);
    }
    
    Encryptor encryptorTester = new Encryptor(4, 3);
    String actualEncrypted3 = encryptorTester.encryptMessage("I saw this REALLY great show on Netflix about a family that moves to a small town");
    String expectedEncrypted3 = "Iats wh s iRELgaAYrtL e swneh  tooNfl o iauaxbt fi aalttmyh metaoso v  smloAa wAltnA";
    if (actualEncrypted3.equals(expectedEncrypted3))
    {
      System.out.println("\nTest 3 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 3 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncrypted3);
      System.out.println("  ACTUAL: " + actualEncrypted3);
    }
    
    Encryptor encryptorTesterB = new Encryptor(5, 6);
    String actualEncrypted4 = encryptorTesterB.encryptMessage("Eeny, meeny, miny, moe, catch a tiger by the toe. If he hollers, let him go, eeny, meeny, miny, moe.");
    String expectedEncrypted4 = "Em  ceemmaneiotynnec,yy,h ,,  arh.e  e  tb Ihiytfog o letehlee eertgnes oyn,h,,y i  ,lmem mmAAAioAAAneAAAy.AAA,AAAA AAAA";
    if (actualEncrypted4.equals(expectedEncrypted4))
    {
      System.out.println("\nTest 4 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 4 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncrypted4);
      System.out.println("  ACTUAL: " + actualEncrypted4);
    }
    
    Encryptor encryptorTesterC = new Encryptor(2, 4);
    String actualEncrypted5 = encryptorTesterC.encryptMessage("ABCD EFGH ABCD EFGH ABCD EFGH ABCD EFGH!");
    String expectedEncrypted5 = "A BECFDGHC DA BEFAGBHC D HE FAGBCFDG HE!";
    if (actualEncrypted5.equals(expectedEncrypted5))
    {
      System.out.println("\nTest 5 PASSED!");
    }
    else
    {
      System.out.println("\n*** Test 5 FAILED! ***");
      System.out.println("EXPECTED: " + expectedEncrypted5);
      System.out.println("  ACTUAL: " + actualEncrypted5);
    }

    // -------------------------------------
    // ---- TEST PART D: decryptMessage ----
    // -------------------------------------
    System.out.println("\n---- TESTING PART D ----");
    Encryptor encryptorTest2 = new Encryptor(2, 3);
    String actualDecrypted1 = encryptorTest2.decryptMessage("Mte eati dmnitgAhA");
    String expectedDecrypted1 = "Meet at midnight";
    if (actualDecrypted1.equals(expectedDecrypted1))
    {
      System.out.println("\nTest 1 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 1 FAILED! ***");
      System.out.println("EXPECTED: " + expectedDecrypted1);
      System.out.println("  ACTUAL: " + actualDecrypted1);
    }
    
    String actualDecrypted2 = encryptorTest2.decryptMessage("L'est goou tsei.d A ryeouK  Owi tthhaAtA?A");
    String expectedDecrypted2 = "Let's go outside. Are you OK with that?";
    if (actualDecrypted2.equals(expectedDecrypted2))
    {
      System.out.println("\nTest 2 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 2 FAILED! ***");
      System.out.println("EXPECTED: " + expectedDecrypted2);
      System.out.println("  ACTUAL: " + actualDecrypted2);
    }
    
    Encryptor encryptorTester5 = new Encryptor(4, 3);
    String actualDecrypted3 = encryptorTester5.decryptMessage("Iats wh s iRELgaAYrtL e swneh  tooNfl o iauaxbt fi aalttmyh metaoso v  smloAa wAltnA");
    String expectedDecrypted3 = "I saw this REALLY great show on Netflix about a family that moves to a small town";
    if (actualDecrypted3.equals(expectedDecrypted3))
    {
      System.out.println("\nTest 3 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 3 FAILED! ***");
      System.out.println("EXPECTED: " + expectedDecrypted3);
      System.out.println("  ACTUAL: " + actualDecrypted3);
    }
    
    Encryptor encryptorTesterD = new Encryptor(5, 6);
    String actualDecrypted5 = encryptorTesterD.decryptMessage("Em  ceemmaneiotynnec,yy,h ,,  arh.e  e  tb Ihiytfog o letehlee eertgnes oyn,h,,y i  ,lmem mmAAAioAAAneAAAy.AAA,AAAA AAAA");
    String expectedDecrypted5 = "Eeny, meeny, miny, moe, catch a tiger by the toe. If he hollers, let him go, eeny, meeny, miny, moe.";
    if (actualDecrypted5.equals(expectedDecrypted5))
    {
      System.out.println("\nTest 4 PASSED!");    
    }
    else
    {
      System.out.println("\n*** Test 4 FAILED! ***");
      System.out.println("EXPECTED: " + expectedDecrypted5);
      System.out.println("  ACTUAL: " + actualDecrypted5);
    }
    
    Encryptor encryptorTesterM = new Encryptor(2, 4);
    String actualDecrypted6 = encryptorTesterM.decryptMessage("A BECFDGHC DA BEFAGBHC D HE FAGBCFDG HE!");
    String expectedDecrypted6 = "ABCD EFGH ABCD EFGH ABCD EFGH ABCD EFGH!";
    if (actualDecrypted6.equals(expectedDecrypted6))
    {
      System.out.println("\nTest 5 PASSED!");
    }
    else
    {
      System.out.println("\n*** Test 5 FAILED! ***");
      System.out.println("EXPECTED: " + expectedDecrypted6);
      System.out.println("  ACTUAL: " + actualDecrypted6);
    }

    // Encrypt
        Encryptor a = new Encryptor(3,4);
        System.out.println(a.encryptMessage("What are you doing next weekend?"));
        Encryptor b = new Encryptor(6,5);
        System.out.println(b.encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again."));
        Encryptor c = new Encryptor(3,2);
        System.out.println(c.decryptMessage("Ti hsiscn ofietdnia!Bl e nto helo okotAu!A"));
        Encryptor d = new Encryptor(5,5);
        System.out.println(d.decryptMessage("Tite hsocmi presa es  stsaneregtd see J  nfaBidomonee  d ftm.cuhe alisBr,ssaieecgllstelft!  -rAwsduA"));
        Encryptor e = new Encryptor(6,5);
        System.out.println(e.decryptMessage("Meottai ooufdsl rtdcsrnelh e r etWwht hhiihmselgro.nlhen    sld tmc egoehsne  otttcbous oacHusAAkoloAA?ploAA eynAA f !AA"));
        Encryptor f = new Encryptor(9,8);
        System.out.println(f.decryptMessage("Io ihscnongeoesofn rnn  do.cac poir rprirfnmTyhyso gahpyp ce tit,tteniis  siea o,pc gpttr rotirihmkonhneoeancveasn toee le iiwsro nononstrrtffn atttencxlseoe oitl x rfwp.yptanonh ,l,nar eI a  tmardoiiai stennnlvk ealyit real  zid rcaaaeeeatkinudsc e ndt  icxtt hpcpitoeaoaahp  xcrrnehbptceo tc t  sriird pisinoyoirn gfnpetettio.tssvehnr i eereamEonlnf lannoftert eetoite tl  unondhlctltrceeioode.en gn -r  iiitabcFbenbe eeoustlnw pr annn  patlsc uusne ,rsssedcr ycueuoheaphasdmnantel o is imla-ecoeoey rnc eyoIsotrkr rts  yeaai idtpytntibeht e hslceigdam er oe l.p ymnnbg otpests  r-dtshstb d iaoehuaeeoguset snnets ,wic   ik egrswpneflnyciogyolephesearsi dmi te lr.edcisale ,eooonsqA rmnud uncapar ai obulcsrranlt ekeeut naceehrhrtsr  eooe iymw vrcclpeikiiiaytstedzpn  shyeei dta  ddeeehgtp brribthuAyi puoosA gtit reAtioe uirAhn nnnzsAeartoae.A testudAAooc  t AA"));



    }

    public static void print2DArray(String[][] arr)
    {
        for (String[] row : arr)
        {
            for (String val : row)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static boolean testArr(String[][] expected, String[][] actual)
    {
        if (expected.length != actual.length)
        {
            return false;
        }

        if (expected[0].length != actual[0].length)
        {
            return false;
        }

        for (int row = 0; row < expected.length; row++)
        {
            for (int col = 0; col < expected[0].length; col++)
            {
                String expElement = expected[row][col];
                String actElement = actual[row][col];
                if (!expElement.equals(actElement))
                {
                    return false;
                }
            }
        }
        return true;
    }
}