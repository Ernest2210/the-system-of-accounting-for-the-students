import java.util.ArrayList;

public class Main{
    public static boolean isFileSaved = true;
    public static final String FILEFORMAT = "std";
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GUI.start();
    }
}
