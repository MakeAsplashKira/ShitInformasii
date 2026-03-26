import java.util.HashMap;
import java.util.Map;

public class CharDictionary {
    private static final char[] DICT = new char[115];


    private static final Map<Character, Integer> REVERSE_DICT = new HashMap<>();

    static {
        //
        DICT[0] = 'а';    DICT[1] = 'б';    DICT[2] = 'в';    DICT[3] = 'г';
        DICT[4] = 'д';    DICT[5] = 'е';    DICT[6] = 'ё';    DICT[7] = 'ж';
        DICT[8] = 'з';    DICT[9] = 'и';    DICT[10] = 'й';   DICT[11] = 'к';
        DICT[12] = 'л';   DICT[13] = 'м';   DICT[14] = 'н';   DICT[15] = 'о';
        DICT[16] = 'п';   DICT[17] = 'р';   DICT[18] = 'с';   DICT[19] = 'т';
        DICT[20] = 'у';   DICT[21] = 'ф';   DICT[22] = 'х';   DICT[23] = 'ц';
        DICT[24] = 'ч';   DICT[25] = 'ш';   DICT[26] = 'щ';   DICT[27] = 'ъ';
        DICT[28] = 'ы';   DICT[29] = 'ь';   DICT[30] = 'э';   DICT[31] = 'ю';
        DICT[32] = 'я';
        //
        DICT[33] = 'А';   DICT[34] = 'Б';   DICT[35] = 'В';   DICT[36] = 'Г';
        DICT[37] = 'Д';   DICT[38] = 'Е';   DICT[39] = 'Ё';   DICT[40] = 'Ж';
        DICT[41] = 'З';   DICT[42] = 'И';   DICT[43] = 'Й';   DICT[44] = 'К';
        DICT[45] = 'Л';   DICT[46] = 'М';   DICT[47] = 'Н';   DICT[48] = 'О';
        DICT[49] = 'П';   DICT[50] = 'Р';   DICT[51] = 'С';   DICT[52] = 'Т';
        DICT[53] = 'У';   DICT[54] = 'Ф';   DICT[55] = 'Х';   DICT[56] = 'Ц';
        DICT[57] = 'Ч';   DICT[58] = 'Ш';   DICT[59] = 'Щ';   DICT[60] = 'Ъ';
        DICT[61] = 'Ы';   DICT[62] = 'Ь';   DICT[63] = 'Э';   DICT[64] = 'Ю';
        DICT[65] = 'Я';
        //
        DICT[66] = '0';   DICT[67] = '1';   DICT[68] = '2';   DICT[69] = '3';
        DICT[70] = '4';   DICT[71] = '5';   DICT[72] = '6';   DICT[73] = '7';
        DICT[74] = '8';   DICT[75] = '9';
        //
        DICT[76] = ' ';
        //
        DICT[77] = '!';   DICT[78] = '"';   DICT[79] = '#';   DICT[80] = '$';
        DICT[81] = '%';   DICT[82] = '&';   DICT[83] = '\'';  DICT[84] = '(';
        DICT[85] = ')';   DICT[86] = '*';   DICT[87] = '+';   DICT[88] = ',';
        DICT[89] = '-';   DICT[90] = '.';   DICT[91] = '/';   DICT[92] = ':';
        DICT[93] = ';';   DICT[94] = '<';   DICT[95] = '=';   DICT[96] = '>';
        DICT[97] = '?';   DICT[98] = '@';   DICT[99] = '[';   DICT[100] = '\\';
        DICT[101] = ']';  DICT[102] = '^';  DICT[103] = '_';  DICT[104] = '`';
        DICT[105] = '{';  DICT[106] = '|';  DICT[107] = '}';  DICT[108] = '~';
        DICT[109] = '№';
        //
        DICT[110] = '\n';
        //
        DICT[111] = '«';   DICT[112] = '»';   DICT[113] = '—';   DICT[114] = '…';

        //заполнение обратного словаря
        for (int i = 0; i < DICT.length; i++) {
            REVERSE_DICT.put(DICT[i], i);
        }
    }

    private static final int DICT_SIZE = DICT.length;

    public static char getChar(int index) {
        if(index < 0 || index >= DICT_SIZE) {
            throw new IndexOutOfBoundsException("Индекс "+index+" вне диапозона [0-" + (DICT_SIZE -1) + "]");
        }
        return DICT[index];
    }
    public static Integer getIndex(char c) {
        return REVERSE_DICT.get(c);
    }
    public static boolean contains(char c) {
        return REVERSE_DICT.containsKey(c);
    }
    public static int getSize() {
        return DICT_SIZE;
    }
    public static char[] getDictionary() {
        return DICT.clone();
    }
}
