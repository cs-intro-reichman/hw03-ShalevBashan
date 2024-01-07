public class uniquechars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniquechars(str));
    }


    public static String uniquechars(String s) {
        String u = "";
        int cnt = 0;
        u += s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            cnt = 0;
            if (s.charAt(i) == 32) {
                u += (char)(s.charAt(i)); 
            } else {
                for (int j = 0; j < u.length(); j++) {
                    if ((s.charAt(i)) == u.charAt(j)) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    u += (char)(s.charAt(i));
                }
            }
        }
        return u;
    }
}
