package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:41
 */
public class BM85 {
    public String solve (String IP) {
        return validIPAddress(IP);
    }

    public String validIPAddress(String queryIP) {
        String[] ipv4 = queryIP.split("\\.", -1);
        String[] ipv6 = queryIP.split(":", -1);
        if (ipv4.length == 4) {
            for (int i = 0; i < ipv4.length; i++) {
                if (!isSegIPv4(ipv4[i])) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (ipv6.length == 8) {
            for (int i = 0; i < ipv6.length; i++) {
                if (!isSegIPv6(ipv6[i])) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isSegIPv4(String str) {
        if (str.length() == 0 ||
                str.length() > 3 ||
                (str.length() > 1 && str.charAt(0) == '0')) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        int i = Integer.parseInt(str);
        if (i > 255 || i < 0) {
            return false;
        }
        return true;

    }

    private boolean isSegIPv6(String str) {
        if (str.length() < 1 || str.length() > 4) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch) &&
                    (!(ch >= 'A' && ch <= 'F') && !(ch >= 'a' && ch <= 'f'))) {
                return false;
            }
        }

        return true;
    }
}
