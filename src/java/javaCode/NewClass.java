
package javaCode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class NewClass {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("Hi everyone");
        
        String text = "à¦?à§?à¦¨à§? à¦¨à¦¿à¦°à§?à¦¦à¦¿à¦·à§?à¦? à¦¸à¦®à§?à§?, à¦¸à¦¾à¦§à¦¾à¦°à¦£à¦¤ à¦?à¦? à¦¬à¦?à¦°à§? à¦?à§?à¦¨à§? à¦¦à§?à¦¶à§?à¦° à¦?à¦¨à¦?à¦£ à¦®à§?à¦? à¦¯à§? à¦ªà¦°à¦¿à¦®à¦¾à¦£ à¦?à§?à§?à¦¾à¦¨à§?à¦¤ à¦¦à§?à¦°à¦¬à§?à¦¯ à¦¬à¦¾ à¦¸à§?à¦¬à¦¾ à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦?à¦°à§?, à¦¤à¦¾à¦° à¦?à¦°à§?à¦¥à¦®à§?à¦²à§?à¦¯à¦?à§? à¦®à§?à¦? à¦?à¦¾à¦¤à§?à§? à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦²à§?à¥¤ à¦?à¦¾à¦¤à§?à§? à¦?à§?à¦ªà¦¾à¦¦à¦¨à§?à¦° à¦®à¦§à§?à¦¯à§? à¦¦à§?à¦¶à§?à¦° à¦?à¦­à§?à¦¯à¦¨à§?à¦¤à¦°à§? à¦¬à¦¸à¦¬à¦¾à¦¸à¦?à¦¾à¦°à§? à¦? à¦?à¦°à§?à¦®à¦°à¦¤ à¦¬à¦¿à¦¦à§?à¦¶à¦¿ à¦¬à§?à¦¯à¦?à§?à¦¤à¦¿ à¦? à¦¸à¦?à¦¸à§?à¦¥à¦¾à¦° à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦¾ à¦?à§? à¦?à¦¨à§?à¦¤à¦°à§?à¦­à§?à¦?à§?à¦¤ à¦¹à¦¬à§? à¦¨à¦¾à¥¤ à¦¤à¦¬à§? à¦¬à¦¿à¦¦à§?à¦¶à§? à¦¬à¦¸à¦¬à¦¾à¦¸à¦?à¦¾à¦°à§? à¦? à¦?à¦°à§?à¦®à¦°à¦¤ à¦¦à§?à¦¶à¦¿ à¦¨à¦¾à¦?à¦°à¦¿à¦?, à¦¸à¦?à¦¸à§?à¦¥à¦¾ à¦? à¦ªà§?à¦°à¦¤à¦¿à¦·à§?à¦ à¦¾à¦¨à§?à¦° à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦¾ à¦?à§? à¦?à¦¨à§?à¦¤à¦°à§?à¦­à§?à¦?à§?à¦¤ à¦¹à¦¬à§?à¥¤ à¦¸à§?à¦¤à¦°à¦¾à¦? à¦¬à¦¾à¦?à¦²à¦¾à¦¦à§?à¦¶à§?à¦° à¦¨à¦¾à¦?à¦°à¦¿à¦?à§?à¦°à¦¾ à¦¯à§? à¦¯à§?à¦?à¦¾à¦¨à§?à¦? à¦¥à¦¾à¦?à§?à¦?, à¦¤à¦¾à¦¦à§?à¦° à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦¾ à¦?à§? à¦?à¦¿à¦?à¦¨à¦ªà¦¿à¦¤à§?";
        String con = URLDecoder.decode(text, "UTF-8");
        
        System.out.println(text);
        System.out.println(con);
    }
}
