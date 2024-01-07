
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(LowerCase(str));
    }

    
    public static String LowerCase(String s) {
        String lower = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 91 && s.charAt(i) >= 65) {
                lower += (char)(s.charAt(i) + 32);
            } else {
                lower += s.charAt(i);
            }
        }
        return lower;
    }
}
