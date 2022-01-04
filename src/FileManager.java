import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    public static void saveFile(String directory, String fileName, ArrayList<GUITables> tables) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < tables.size(); i++){
            stringBuffer.append("<_table_>");
            stringBuffer.append("<_name_>");
            stringBuffer.append(tables.get(i).nameOfTeacher);
            stringBuffer.append("</_name_>");
            stringBuffer.append("<_lesson_>");
            stringBuffer.append(tables.get(i).grade);
            stringBuffer.append("</_lesson_>");
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
