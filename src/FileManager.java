import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static ArrayList<GUITables> readFile(File file) throws IOException {
        ArrayList<GUITables> tables = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            StringBuffer string = new StringBuffer(bufferedReader.readLine());
            int startTable = string.indexOf("<_table_>");
            string = string.delete(startTable,startTable+9);
            int endTable = string.indexOf("</_table_>");
            string = string.delete(endTable, endTable+10);
            int startName = string.indexOf("<_name_>");
            int endName = string.indexOf("</_name_>");
            StringBuffer name = new StringBuffer(string.substring(startName+8, endName));
            string = string.delete(startName, endName+9);
            //System.out.println(name);

            int start = string.indexOf("<_lesson_>");
            int end = string.indexOf("</_lesson_>");
            StringBuffer lesson = new StringBuffer(string.substring(start+10, end));
            string = string.delete(start, end+11);
            //System.out.println(lesson);

            start = string.indexOf("<_grade_>");
            end = string.indexOf("</_grade_>");
            StringBuffer grade = new StringBuffer(string.substring(start+9, end));
            string = string.delete(start, end+10);
            //System.out.println(grade);

            start = string.indexOf("<_count_>");
            end = string.indexOf("</_count_>");
            StringBuffer count = new StringBuffer(string.substring(start+9, end));
            string = string.delete(start, end+10);
            //System.out.println(count);

            start = string.indexOf("<_fives_>");
            end = string.indexOf("</_fives_>");
            String fivesString = new StringBuffer(string.substring(start+9, end)).toString();
            string = string.delete(start, end+10);
            String[] fivesStrings = fivesString.split(" ");
            ArrayList<String> fives = new ArrayList<>();
            for (int i = 0; i<5; i++){
                fives.add(fivesStrings[i]);
            }
            //System.out.println(fives);

            start = string.indexOf("<_fours_>");
            end = string.indexOf("</_fours_>");
            String foursString = new StringBuffer(string.substring(start+9, end)).toString();
            string = string.delete(start, end+10);
            String[] foursStrings = foursString.split(" ");
            ArrayList<String> fours = new ArrayList<>();
            for (int i = 0; i<5; i++){
                fours.add(foursStrings[i]);
            }
            //System.out.println(fours);

            start = string.indexOf("<_threes_>");
            end = string.indexOf("</_threes_>");
            String threesString = new StringBuffer(string.substring(start+10, end)).toString();
            string = string.delete(start, end+11);
            String[] threesStrings = threesString.split(" ");
            ArrayList<String> threes = new ArrayList<>();
            for (int i = 0; i<5; i++){
                threes.add(threesStrings[i]);
            }
            //System.out.println(threes);

            start = string.indexOf("<_twos_>");
            end = string.indexOf("</_twos_>");
            String twosString = new StringBuffer(string.substring(start+8, end)).toString();
            string = string.delete(start, end+9);
            String[] twosStrings = twosString.split(" ");
            ArrayList<String> twos = new ArrayList<>();
            for (int i = 0; i<5; i++){
                twos.add(twosStrings[i]);
            }
            //System.out.println(twos);

            start = string.indexOf("<_notcert_>");
            end = string.indexOf("</_notcert_>");
            String nocertString = new StringBuffer(string.substring(start+11, end)).toString();
            string = string.delete(start, end+12);
            String[] nocertStrings = nocertString.split(" ");
            ArrayList<String> nocert = new ArrayList<>();
            for (int i = 0; i<5; i++){
                nocert.add(nocertStrings[i]);
            }
            //System.out.println(nocert);
            tables.add(new GUITables(name.toString(), lesson.toString(), grade.toString(), count.toString(), fives, fours, threes, twos, nocert));
        }
        System.out.println(tables.size());
        return tables;
    }
    public static void saveFile(String directory, String fileName, ArrayList<GUITables> tables) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < tables.size(); i++){
            stringBuffer.append("<_table_>");
            stringBuffer.append("<_name_>");
            stringBuffer.append(tables.get(i).nameOfTeacher);
            stringBuffer.append("</_name_>");
            stringBuffer.append("<_lesson_>");
            stringBuffer.append(tables.get(i).lesson);
            stringBuffer.append("</_lesson_>");
            stringBuffer.append("<_grade_>");
            stringBuffer.append(tables.get(i).grade);
            stringBuffer.append("</_grade_>");
            stringBuffer.append("<_count_>");
            stringBuffer.append(tables.get(i).numberOfStudents);
            stringBuffer.append("</_count_>");
            stringBuffer.append("<_fives_>");
            for(int j = 0; j<4; j++){
                stringBuffer.append(tables.get(i).fives.get(j));
                stringBuffer.append(" ");
            }
            stringBuffer.append(tables.get(i).fives.get(4));
            stringBuffer.append("</_fives_>");

            stringBuffer.append("<_fours_>");
            for(int j = 0; j<4; j++){
                stringBuffer.append(tables.get(i).fours.get(j));
                stringBuffer.append(" ");
            }
            stringBuffer.append(tables.get(i).fours.get(4));
            stringBuffer.append("</_fours_>");

            stringBuffer.append("<_threes_>");
            for(int j = 0; j<4; j++){
                stringBuffer.append(tables.get(i).threes.get(j));
                stringBuffer.append(" ");
            }
            stringBuffer.append(tables.get(i).threes.get(4));
            stringBuffer.append("</_threes_>");

            stringBuffer.append("<_twos_>");
            for(int j = 0; j<4; j++){
                stringBuffer.append(tables.get(i).twos.get(j));
                stringBuffer.append(" ");
            }
            stringBuffer.append(tables.get(i).twos.get(4));
            stringBuffer.append("</_twos_>");

            stringBuffer.append("<_notcert_>");
            for(int j = 0; j<4; j++){
                stringBuffer.append(tables.get(i).notCertified.get(j));
                stringBuffer.append(" ");
            }
            stringBuffer.append(tables.get(i).notCertified.get(4));
            stringBuffer.append("</_notcert_>");
            stringBuffer.append("</_table_>\n");
        }
        File file = new File(directory, fileName);
        if (!(file.exists())){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
