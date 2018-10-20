package tk.roccodev.beezig.installer.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


/*
 * 
 * Skidded from 5zig :^) - too lazy
 * 
 */

public enum ChatColor
{
    BLACK('0', "black", 0), 
    DARK_BLUE('1', "dark_blue", 170), 
    DARK_GREEN('2', "dark_green", 43520), 
    DARK_AQUA('3', "dark_aqua", 43690), 
    DARK_RED('4', "dark_red", 11141120), 
    DARK_PURPLE('5', "dark_purple", 11141290), 
    GOLD('6', "gold", 16755200), 
    GRAY('7', "gray", 11184810), 
    DARK_GRAY('8', "dark_gray", 5592405), 
    BLUE('9', "blue", 5592575), 
    GREEN('a', "green", 5635925), 
    AQUA('b', "aqua", 5636095), 
    RED('c', "red", 16733525), 
    LIGHT_PURPLE('d', "light_purple", 16733695), 
    YELLOW('e', "yellow", 16777045), 
    WHITE('f', "white", 16777215), 
    MAGIC('k', "obfuscated"), 
    BOLD('l', "bold"), 
    STRIKETHROUGH('m', "strikethrough"), 
    UNDERLINE('n', "underline"), 
    ITALIC('o', "italic"), 
    RESET('r', "reset");
    
    public static final char COLOR_CHAR = '§';
    public static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";
    public static final Pattern STRIP_COLOR_PATTERN;
    private static final Map<Character, ChatColor> BY_CHAR;
    private final char code;
    private final String toString;
    private final String name;
    private final int color;
    
    private ChatColor(final char code, final String name) {
        this(code, name, -1);
    }
    
    private ChatColor(final char code, final String name, final int color) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.toString = new String(new char[] { '§', code });
    }
    
    public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }
        return ChatColor.STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }
    
    public static String translateAlternateColorCodes(final char altColorChar, final String textToTranslate) {
        final char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; ++i) {
            if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
                b[i] = '§';
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }
    
    public static ChatColor getByChar(final char code) {
        return ChatColor.BY_CHAR.get(code);
    }
    
    public String getName() {
        return this.name;
    }
    
    public char getCode() {
        return this.code;
    }
    
    public int getColor() {
        return this.color;
    }
    
    @Override
    public String toString() {
        return this.toString;
    }
    
    static {
        STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
        BY_CHAR = new HashMap<Character, ChatColor>();
        for (final ChatColor colour : values()) {
            ChatColor.BY_CHAR.put(colour.code, colour);
        }
    }
}
