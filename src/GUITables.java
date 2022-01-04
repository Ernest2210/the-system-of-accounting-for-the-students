import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;

public class GUITables {
    private String grade;
    private String lesson;
    private String nameOfTeacher;
    private String numberOfStudents;
    private ArrayList<String> fives;
    private ArrayList<String> fours;
    private ArrayList<String> threes;
    private ArrayList<String> twos;

    //Нужно ли хранить??
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
    public JLabel numOfStudLabel;
    public JTextField numOfStudTextField;

    private ArrayList<JTextField> fivesTextFields;
    private ArrayList<JTextField> foursTextFields;
    private ArrayList<JTextField> threesTextFields;
    private ArrayList<JTextField> twosTextFields;
    private ArrayList<JTextField> notCertifiedTextFields; //неатестованы
    private ArrayList<JLabel> qualityTextFields; //качество
    private ArrayList<JLabel> academicPerformanceTextFields; //успеваемость
    private ArrayList<JLabel> averageScoreTextFields; //ср. юалл

    public double calculateAverangeScore(String Sfive, String Sfour, String Sthree, String Stwo){
        double f = Double.parseDouble(Sfive);
        double fo = Double.parseDouble(Sfour) ;
        double th = Double.parseDouble(Sthree);
        double tw = Double.parseDouble(Stwo);
        double sum = f+fo+th+tw;
        double res = 0;
        if(sum != 0){
            res = (f * 5 + fo * 4 + th * 3 + tw * 2) / sum;
        }
        return res;
    }

    public int calculateAcademicPerformace(String Sfive, String Sfour, String Sthree){
        double f = Double.parseDouble(Sfive);
        double fo = Double.parseDouble(Sfour);
        double th = Double.parseDouble(Sthree);
        double res = 0;
        if(Double.parseDouble(numberOfStudents) != 0){
            res = (f + fo + th) / Double.parseDouble(numberOfStudents) * 100;
        }
        int r = (int) res;
        return r;
    }

    public int calculateQuality(String Sfive, String Sfour){
        double f = Double.parseDouble(Sfive);
        double fo = Double.parseDouble(Sfour);
        double res = 0;
        if (Double.parseDouble(numberOfStudents) != 0){
            res = (f + fo) / Double.parseDouble(numberOfStudents) * 100;
        }
        int r = (int) res;
        return r;
    }

    public GUITables(String _FIO, String _lesson, String _grade, String num,
                     ArrayList<String> _fives,
                     ArrayList<String> _fours, ArrayList<String> _threes,
                     ArrayList<String> _twos, ArrayList<String> notCert){
        grade = _grade;
        lesson = _lesson;
        nameOfTeacher = _FIO;
        fives = _fives;
        fours = _fours;
        threes = _threes;
        twos = _twos;
        notCertified = notCert;
        numberOfStudents = num;

        quality = new ArrayList<>();

        for(int i = 0; i < 5; i ++){
            int r = calculateQuality(fives.get(i), fours.get(i));
            quality.add(Integer.toString(r));
        }

        academicPerformance = new ArrayList<>();

        for(int i = 0; i < 5; i ++){
            int r = calculateAcademicPerformace(fives.get(i), fours.get(i), threes.get(i));
            academicPerformance.add(Integer.toString(r));
        }

        averageScore = new ArrayList<>();

        for(int i = 0; i < 5; i ++){
            double res = calculateAverangeScore(fives.get(i), fours.get(i), threes.get(i), twos.get(i));
            averageScore.add(Double.toString(res));
        }

        tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(GUI.width, 200));
        tablePanel.setMaximumSize(new Dimension(1000000000, 200));
        tablePanel.setLayout(new BorderLayout());

        tablePanel.setBorder(new EmptyBorder(0,0,5,0));

        tablePanel.setBackground(Color.BLACK);

        FIOLabel = new JLabel("ФИО:");
        FIOTextField = new JTextField(20);
        FIOTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                nameOfTeacher = FIOTextField.getText();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                nameOfTeacher = FIOTextField.getText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        FIOTextField.setText(nameOfTeacher);


        lessonLabel = new JLabel("Предмет:");
        lessonTextField = new JTextField(20);
        lessonTextField.setText(lesson);
        lessonTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lesson = lessonTextField.getText();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                lesson = lessonTextField.getText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        gradeLabel = new JLabel("Класс:");
        gradeTextField = new JTextField(3);
        gradeTextField.setText(grade);
        gradeTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                grade = gradeTextField.getText();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                grade = gradeTextField.getText();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });


        numOfStudLabel = new JLabel("Кол. учеников");

        numOfStudTextField =new JTextField(3);
        numOfStudTextField.setText(numberOfStudents);
        numOfStudTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (Main.isNumeric(numOfStudTextField.getText())){
                    numberOfStudents = numOfStudTextField.getText();
                }else{
                    numberOfStudents = "0";
                }
                for(int j = 0; j < 5; j++){
                    int qu = calculateQuality(fives.get(j), fours.get(j));
                    int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                    double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                    qualityTextFields.get(j).setText(Integer.toString(qu));
                    academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                    averageScoreTextFields.get(j).setText(Double.toString(av));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (Main.isNumeric(numOfStudTextField.getText())){
                    numberOfStudents = numOfStudTextField.getText();
                }else{
                    numberOfStudents = "0";
                }
                for(int j = 0; j < 5; j++){
                    int qu = calculateQuality(fives.get(j), fours.get(j));
                    int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                    double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                    qualityTextFields.get(j).setText(Integer.toString(qu));
                    academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                    averageScoreTextFields.get(j).setText(Double.toString(av));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });




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
            j1.setText(fives.get(i));
            j1.setName(Integer.toString(i));
            //Отслеживание изменений в JTextField и изменение показателей
            j1.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j1.getName())){
                            if (Main.isNumeric(j1.getText())){
                                fives.set(j, j1.getText());
                            }else{
                                fives.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j1.getName())){
                            if (Main.isNumeric(j1.getText())){
                                fives.set(j, j1.getText());
                            }else{
                                fives.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {}
            });
            fivesTextFields.add(j1);
            JTextField j2 = new JTextField(3);
            j2.setText(fours.get(i));
            j2.setName(Integer.toString(i));
            //Отслеживание изменений в JTextField и изменение показателей
            j2.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j2.getName())){
                            if (Main.isNumeric(j2.getText())){
                                fours.set(j, j2.getText());
                            }else{
                                fours.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j2.getName())){
                            if (Main.isNumeric(j2.getText())){
                                fours.set(j, j2.getText());
                            }else{
                                fours.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {}
            });
            foursTextFields.add(j2);
            JTextField j3 = new JTextField(3);
            j3.setText(threes.get(i));
            j3.setName(Integer.toString(i));
            //Отслеживание изменений в JTextField и изменение показателей
            j3.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j3.getName())){
                            if (Main.isNumeric(j3.getText())){
                                threes.set(j, j3.getText());
                            }else{
                                threes.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j3.getName())){
                            if (Main.isNumeric(j3.getText())){
                                threes.set(j, j3.getText());
                            }else{
                                threes.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {}
            });
            threesTextFields.add(j3);
            JTextField j4 = new JTextField(3);
            j4.setText(twos.get(i));
            j4.setName(Integer.toString(i));
            //Отслеживание изменений в JTextField и изменение показателей
            j4.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j4.getName())){
                            if (Main.isNumeric(j4.getText())){
                                twos.set(j, j4.getText());
                            }else{
                                twos.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    for(int j = 0; j < 5; j++){
                        String h = fivesTextFields.get(j).getName();
                        if(h.equals(j4.getName())){
                            if (Main.isNumeric(j4.getText())){
                                twos.set(j, j4.getText());
                            }else{
                                twos.set(j,"0");
                            }
                            int qu = calculateQuality(fives.get(j), fours.get(j));
                            int ac = calculateAcademicPerformace(fives.get(j), fours.get(j), threes.get(j));
                            double av = calculateAverangeScore(fives.get(j), fours.get(j), threes.get(j), twos.get(j));
                            qualityTextFields.get(j).setText(Integer.toString(qu));
                            academicPerformanceTextFields.get(j).setText(Integer.toString(ac));
                            averageScoreTextFields.get(j).setText(Double.toString(av));
                            break;
                        }
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {}
            });
            twosTextFields.add(j4);
            JTextField l5 = new JTextField(3);
            l5.setText(notCertified.get(i));
            notCertifiedTextFields.add(l5);
            JLabel l2 = new JLabel(quality.get(i));
            l2.setHorizontalAlignment(SwingConstants.CENTER);
            qualityTextFields.add(l2);
            JLabel l3 = new JLabel(academicPerformance.get(i));
            l3.setHorizontalAlignment(SwingConstants.CENTER);
            academicPerformanceTextFields.add(l3);
            JLabel l4 = new JLabel(averageScore.get(i));
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
        topPanel.add(numOfStudLabel);
        topPanel.add(numOfStudTextField);

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

        l1 = new JLabel("Качество");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);

        l1 = new JLabel("Успеваемость");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(l1);
        l1 = new JLabel("Ср. балл");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
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
