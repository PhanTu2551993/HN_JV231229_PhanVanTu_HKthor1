package ra.model;

import java.util.Scanner;

public class Singer {
    private static int nextID = 1;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer(){
        this.singerId = nextID++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public static int getNextID() {
        return nextID;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputSingerData(Scanner scanner){
//        Nhập tên ca sĩ
        System.out.println("Nhập tên ca sĩ :");
        while (true){
            singerName = scanner.nextLine();
            if (!singerName.isEmpty()){
                break;
            }else {
                System.err.println("Tên ca sĩ không được để trống. Vui lòng nhập lại:");
            }
        }
//        Nhập tuổi ca sĩ
        System.out.println("Nhập tuổi ca sĩ :");
        while (true){
            age = Integer.parseInt(scanner.nextLine());
            if (age > 0){
                break;
            }else {
                System.err.println("Nhập sai tuổi. Vui lòng nhập lại:");
            }
        }
//        Nhập quốc tịch
        System.out.println("Nhập quốc tịch ca sĩ :");
        while (true){
            nationality = scanner.nextLine();
            if (!nationality.isEmpty()){
                break;
            }else {
                System.err.println("Không được để trống quốc tịch. Vui lòng nhập lại:");
            }
        }
//        Nhập giới tính
        System.out.println("Nhập giới tính ca sĩ (true: Nam) hoặc (false: Nữ) :");
            gender = Boolean.parseBoolean(scanner.nextLine());

//      Nhập thể loại
        System.out.println("Nhập thể loại nhạc ca sĩ :");
        while (true){
            genre = scanner.nextLine();
            if (!genre.isEmpty()){
                break;
            }else {
                System.err.println("Không được để thể loại nhạc. Vui lòng nhập lại:");
            }
        }
    }

//              Hiển thị
    public void displaySingerData(){
        System.out.println("Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + (gender? "Nam":"Nữ") +
                ", genre='" + genre + '\'' +
                '}');
        System.out.println("****************************************");
    }
}
