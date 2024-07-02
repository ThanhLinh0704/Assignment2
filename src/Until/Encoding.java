package Until;

import java.security.MessageDigest;
import java.util.Base64;

public class Encoding {

    /**
     * Generates a SHA-1 hash for the given string with added salt.
     * @param str The input string to hash.
     * @return The SHA-1 hash encoded in Base64.
     */
    public String toSHA1(String str) {
        String salt = "sagsatjgi@AawgsNB;fjeaidLDfajewgadsngae;fadfjeag12314faef";
        String res = null;

        str = str + salt;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            res = Base64.getEncoder().encodeToString(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
