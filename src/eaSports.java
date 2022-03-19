public class eaSports {
    public static void main(String[] args) {
        Encryptor a1 = new Encryptor(3, 3);
        String a = a1.encryptMessage("abcdefghi", 2);
        System.out.println(a);
        // Use original value for shift (value used in line 4)
        System.out.println(a1.decryptMessage(a, 2));
    }
}
