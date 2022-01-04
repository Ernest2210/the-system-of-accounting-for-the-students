import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class GUITables {
    private String grade;
    private String lesson;
    private String nameOfTeacher;
    private ArrayList<String> fives;
    private ArrayList<String> fours;
    private ArrayList<String> threes;
    private ArrayList<String> twos;
    private ArrayList<String> notCertified; //неатестованы
    private ArrayList<String> quality; //качество
    private ArrayList<String> academicPerformance; //успеваемость
    private ArrayList<String> averageScore; //ср. юалл

    public JPanel tablePanel;
    public JLabel FIOLabel;
    public JTextField FIOTextField;
    public JLabel lessonLabel;
    public JTextField lessonTextField;
    public JLabel gradeLabel;
    public JTextField gradeTextField;

    private ArrayList<JTextField> fivesTextFields;
    private ArrayList<JTextField> foursTextFields;
    private ArrayList<JTextField> threesTextFields;
    private ArrayList<JTextField> twosTextFields;
    private ArrayList<JLabel> notCertifiedTextFields; //неатестованы
    private ArrayList<JLabel> qualityTextFields; //качество
    private ArrayList<JLabel> academicPerformanceTextFields; //успеваемость
    private ArrayList<JLabel> averageScoreTextFields; //ср. юалл

    public GUITables(){
        grade = "";
        lesson = "";
        nameOfTeacher = "";
        fives = new ArrayList<>();
        fours = new ArrayList<>();
        threes = new ArrayList<>();
        twos = new ArrayList<>();
        notCertified = new ArrayList<>();
        quality = new ArrayList<>();
        academicPerformance = new ArrayList<>();
        averageScore = new ArrayList<>();
        tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(GUI.width, 200));
        tablePanel.setMaximumSize(new Dimension(1000000000, 200));
        tablePanel.setLayout(new BorderLayout());

        tablePanel.setBorder(new EmptyBorder(0,0,5,0));

        tablePanel.setBackground(Color.BLACK);

        FIOLabel = new JLabel("ФИО:");
        FIOTextField = new JTextField(20);
        FIOTextField.setText(nameOfTeacher);
        lessonLabel = new JLabel("Предмет:");
        lessonTextField = new JTextField(20);
        lessonTextField.setText(lesson);
        gradeLabel = new JLabel("Класс:");
        gradeTextField = new JTextField(3);
        gradeTextField.setText(grade);
        fivesTextFields = new ArrayList<>();
        foursTextFields = new ArrayList<>();
        threesTextFields = new ArrayList<>();
        twosTextFields = new ArrayList<>();
        notCertifiedTextFields = new ArrayList<>();
        qualityTextFields = new ArrayList<>();
        academicPerformanceTextFields = new ArrayList<>();
        averageScoreTextFields = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            JTextField j1 = new JTextField(3);
            j1.setText("0");
            fivesTextFields.add(j1);
            JTextField j2 = new JTextField(3);
            j2.setText("0");
            foursTextFields.add(j2);
            JTextField j3 = new JTextField(3);
            j3.setText("0");
            threesTextFields.add(j3);
            JTextField j4 = new JTextField(3);
            j4.setText("0");
            twosTextFields.add(j4);
            JLabel l1 = new JLabel("0");
            l1.setHorizontalAlignment(SwingConstants.CENTER);
            notCertifiedTextFields.add(l1);
            JLabel l2 = new JLabel("0");
            l2.setHorizontalAlignment(SwingConstants.CENTER);
            qualityTextFields.add(l2);
            JLabel l3 = new JLabel("0");
            l3.setHorizontalAlignment(SwingConstants.CENTER);
            academicPerformanceTextFields.add(l3);
            JLabel l4 = new JLabel("0");
            l4.setHorizontalAlignment(SwingConstants.CENTER);
            averageScoreTextFields.add(l4);
        }
    }

    public void printEmptyTable(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(FIOLabel);
        topPanel.add(FIOTextField);
        topPanel.add(lessonLabel);
        topPanel.add(lessonTextField);
        topPanel.add(gradeLabel);
        topPanel.add(gradeTextField);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6,10));
        centerPanel.add(new JLabel(" "));
        JLabel l1 = new JLabel("5");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        l1 = new JLabel("4");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        l1 = new JLabel("3");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        l1 = new JLabel("2");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        l1 = new JLabel("Н/А");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        centerPanel.add(l1);

        l1 = new JLabel("Качество");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        centerPanel.add(l1);

        l1 = new JLabel("Успеваемость");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        centerPanel.add(l1);
        l1 = new JLabel("Ср. балл");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        centerPanel.add(l1);
        for(int i = 0; i < 5; i++){
            if  (i  <   4){
                centerPanel.add(new JLabel(Integer.toString(i+1) + " чет"));
            }else{
                centerPanel.add(new JLabel("год"));
            }
            centerPanel.add(fivesTextFields.get(i));
            centerPanel.add(foursTextFields.get(i));
            centerPanel.add(threesTextFields.get(i));
            centerPanel.add(twosTextFields.get(i));
            centerPanel.add(notCertifiedTextFields.get(i));
            centerPanel.add(qualityTextFields.get(i));
            centerPanel.add(academicPerformanceTextFields.get(i));
            centerPanel.add(averageScoreTextFields.get(i));
        }

        tablePanel.add(topPanel, BorderLayout.NORTH);
        tablePanel.add(centerPanel, BorderLayout.CENTER);

        GUI.scrollPanel.add(tablePanel);
    }



    // Getters and Setters

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }
    public void setFives(ArrayList<String> fives) {
        this.fives = fives;
    }
    public void setFours(ArrayList<String> fours) {
        this.fours = fours;
    }
    public void setThrees(ArrayList<String> threes) {
        this.threes = threes;
    }
    public void setTwos(ArrayList<String> twos) {
        this.twos = twos;
    }
    public void setNotCertified(ArrayList<String> notCertified) {
        this.notCertified = notCertified;
    }
    public void setQuality(ArrayList<String> quality) {
        this.quality = quality;
    }
    public void setAcademicPerformance(ArrayList<String> academicPerformance) {
        this.academicPerformance = academicPerformance;
    }
    public void setAverageScore(ArrayList<String> averageScore) {
        this.averageScore = averageScore;
    }
    public String getLesson() {
        return lesson;
    }
    public String getNameOfTeacher() {
        return nameOfTeacher;
    }
    public ArrayList<String> getFives() {
        return fives;
    }
    public ArrayList<String> getFours() {
        return fours;
    }
    public ArrayList<String> getThrees() {
        return threes;
    }
    public ArrayList<String> getTwos() {
        return twos;
    }
    public ArrayList<String> getNotCertified() {
        return notCertified;
    }
    public ArrayList<String> getQuality() {
        return quality;
    }
    public ArrayList<String> getAcademicPerformance() {
        return academicPerformance;
    }
    public ArrayList<String> getAverageScore() {
        return averageScore;
    }
}
