public class VigenerCipher {

    public static final int ENCRYPT_MODE = 0;
    public static final int DECRYPT_MODE = 1;

    public static String process(String text, String keyword, int mode) {
        if (text == null || text.isEmpty() || keyword == null || keyword.isEmpty()) {
            return text;
        }

        int sign = (mode == DECRYPT_MODE) ? -1:1;

        StringBuilder result = new StringBuilder(text.length());
        int keywordLength = keyword.length();
        int keywordIndex = 0;
        int dictSize = CharDictionary.getSize();

        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);

            Integer textIndex = CharDictionary.getIndex(textChar);

            if (textIndex != null) {
                char keyChar = keyword.charAt(keywordIndex % keywordLength);
                Integer keyIndex = CharDictionary.getIndex(keyChar);

                if(keyIndex != null) {
                    int newIndex = (textIndex + (sign * keyIndex)) % CharDictionary.getSize();

                    if(newIndex < 0) {
                        newIndex += dictSize;
                    }
                    result.append(CharDictionary.getChar(newIndex));
                } else {
                    result.append(textChar);
                }
                keywordIndex++;
            } else {
                result.append(textChar);
            }
        }
        return result.toString();
    }
    public static String encrypt(String text, String keyword) {
        return process(text, keyword, ENCRYPT_MODE);
    }
    public static String decrypt(String text, String keyword) {
        return process(text, keyword, DECRYPT_MODE);
    }

}
