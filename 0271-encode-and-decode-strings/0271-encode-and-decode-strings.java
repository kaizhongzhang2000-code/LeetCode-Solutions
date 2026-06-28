public class Codec {

// ç¼ç ï¼å° List<String> è½¬æä¸ä¸ªå¤§ String
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // æ ¼å¼ï¼é¿åº¦ + "#" + åå­ç¬¦ä¸²
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // è§£ç ï¼å°å¤§ String è¿åæ List<String>
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0; // å¨å±æé
        
        while (i < s.length()) {
            // 1. æ¾å°å½åå­ç¬¦ä¸²é¿åº¦ä¿¡æ¯åé¢çåéç¬¦ '#'
            int delimiterIndex = s.indexOf('#', i);
            
            // 2. è§£æåºé¿åº¦æ°å­
            int size = Integer.parseInt(s.substring(i, delimiterIndex));
            
            // 3. æ ¹æ®é¿åº¦ï¼ç²¾åæªåçå®å­ç¬¦ä¸²
            int stringStart = delimiterIndex + 1;
            String str = s.substring(stringStart, stringStart + size);
            result.add(str);
            
            // 4. å°æéè·³è¿å½åå­ç¬¦ä¸²ï¼åå¤è§£æä¸ä¸ä¸ª
            i = stringStart + size;
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));