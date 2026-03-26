import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    public static String shift(String text, int shift) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        int dictSize = CharDictionary.getSize();
        //нормализация для корректного сдвига
        shift = shift % dictSize;
        if (shift < 0) {
            shift += dictSize;
        }

        StringBuilder result = new StringBuilder(text.length());

        for (char c : text.toCharArray()) {
            // Ищем символ в словаре
            Integer index = CharDictionary.getIndex(c);

            if (index != null) {
                // найден символ
                int newIndex = (index + shift) % dictSize;
                result.append(CharDictionary.getChar(newIndex));
            } else {
                // не найден символ
                result.append(c);
            }
        }

        return result.toString();
    }
}