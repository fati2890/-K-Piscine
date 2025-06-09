public class IPValidator {


    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public boolean ValidateIpv4Address(String ip) {
        int num;
        String[] parts = ip.split("\\.");
        int lastOctet = Integer.parseInt(parts[3]);

        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (!isNumeric(part)) {
                return false;
            }
            try {
                num = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }
            if (num < 0 || num > 255) {
                return false;
            }
        }

        if (lastOctet == 0 || lastOctet == 255) {
            return false;
        }

        return true;
    }



}
