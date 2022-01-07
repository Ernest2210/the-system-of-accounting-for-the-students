import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PdfCreater {
    private static final String FONT = "fonts/arial.ttf";
    private static BaseFont bf;
    private static Font font1;
    private static void addTableHeader(PdfPTable table){
        Stream.of(" ", "5", "4", "3", "2", "Н/А", "Качество", "Успеваемость", "Ср. балл").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle,font1));
            table.addCell(header);
        });
    }

    private static void addRows(PdfPTable table, ArrayList<String> fives, ArrayList<String> fours, ArrayList<String> threes, ArrayList<String> twos, ArrayList<String> notCert, ArrayList<String> quality, ArrayList<String> acadPerf, ArrayList<String> avarScore){
        for(int i = 0; i < 5; i++){
            if (i != 4){
                Chunk c = new Chunk((i+1) + " чет", font1);
                PdfPCell cell = new PdfPCell(new Phrase(c));
                table.addCell(cell);
            }else {
                Chunk c = new Chunk("год", font1);
                PdfPCell cell = new PdfPCell(new Phrase(c));
                table.addCell(cell);
            }
            table.addCell(fives.get(i));
            table.addCell(fours.get(i));
            table.addCell(threes.get(i));
            table.addCell(twos.get(i));
            table.addCell(notCert.get(i));
            table.addCell(quality.get(i));
            table.addCell(acadPerf.get(i));
            table.addCell(avarScore.get(i));
        }
    }

    public static void createPdfFile(ArrayList<GUITables> tables, File file){
        try {
            bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        font1 = new Font(bf, 10, Font.NORMAL);
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        for (int i = 0; i < tables.size(); i++){
            PdfPTable table = new PdfPTable(9);
            addTableHeader(table);
            addRows(table, tables.get(i).fives, tables.get(i).fours, tables.get(i).threes, tables.get(i).twos, tables.get(i).notCertified, tables.get(i).quality, tables.get(i).academicPerformance, tables.get(i).averageScore);

            try {
                Chunk chunk1 = new Chunk("ФИО: "+ tables.get(i).nameOfTeacher + " | Предмет: "+ tables.get(i).lesson + " | Класс: "+ tables.get(i).grade + " | Кол-во учеников: " + tables.get(i).numberOfStudents, font1);
                document.add(new Paragraph(chunk1));
                document.add(new Paragraph(" "));
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        document.close();
    }
}
