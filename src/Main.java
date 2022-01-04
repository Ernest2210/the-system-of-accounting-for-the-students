import java.util.ArrayList;

public class Main{
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GUI.start();
        ArrayList<String> five = new ArrayList<>();
        ArrayList<String> four = new ArrayList<>();
        ArrayList<String> three = new ArrayList<>();
        ArrayList<String> two = new ArrayList<>();
        ArrayList<String> notcert = new ArrayList<>();
        five.add("12");
        five.add("10");
        five.add("15");
        five.add("8");
        five.add("10");

        four.add("8");
        four.add("10");
        four.add("1");
        four.add("15");
        four.add("10");

        three.add("5");
        three.add("5");
        three.add("6");
        three.add("2");
        three.add("5");

        two.add("0");
        two.add("0");
        two.add("3");
        two.add("0");
        two.add("0");

        notcert.add("0");
        notcert.add("0");
        notcert.add("0");
        notcert.add("0");
        notcert.add("0");

        GUI.printTables("Тимерханова Нафида Фоатовна", "Математика", "11Б", "25", five, four, three,two,notcert);
        GUI.printEmptyTable();
        GUI.printEmptyTable();
    }
}
