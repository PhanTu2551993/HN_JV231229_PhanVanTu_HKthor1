package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    private static Singer[] singers = new Singer[100];
    private static Song[] songs = new Song[1000];

    private static int singerLength = 0;
    private static int songLength = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***********************MUSIC-MANAGEMENT*************************");
            System.out.println("1. QUẢN LÝ CA SĨ");
            System.out.println("2. QUẢN LÝ BÀI HÁT");
            System.out.println("3. TÌM KIẾM BÀI HÁT");
            System.out.println("0. Thoát");
            System.out.println("Mời lựa chọn (0/1/2/3): ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                    case 1:
                        MusicManagement.menuSinger(sc);
                        break;
                    case 2:
                        MusicManagement.menuSong(sc);
                        break;
                    case 3:
                        MusicManagement.menuSearch(sc);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            } while (true);
        }

        public static void menuSinger(Scanner scanner){
            do {
                System.out.println("**********************SINGER-MANAGEMENT************************");
                System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
                System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
                System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
                System.out.println("4. Xóa ca sĩ theo mã id");
                System.out.println("5. Quay lai");
                System.out.println("Mời lựa chọn (1/2/3/4/5): ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addSinger(scanner);
                        break;
                    case 2:
                        showAllSinger();
                        break;
                    case 3:
                        changeInfoSinger(scanner);
                        break;
                    case 4:
                        deleteSinger(scanner);
                        break;
                    case 5:
                        return;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            } while (true);
        }
//        Thêm ca sĩ
        public static void addSinger(Scanner scanner){
            System.out.println("Ban muốn thêm bao nhiêu ca sĩ :");
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = singerLength; i < singerLength + n; i++) {
                System.out.println("Nhập thông tin cho ca sĩ thứ " + (i + 1) + ":");
                singers[i] = new Singer();
                singers[i].inputSingerData(scanner);
            }
            singerLength += n;
        }

//        Hiển thị danh sách ca sĩ

    public static void showAllSinger(){
        for (int i = 0; i < singerLength; i++) {
            if (singers[i] != null) {
                singers[i].displaySingerData();
            }
        }

    }

//    thay đổi thông tin ca sĩ
    public static void changeInfoSinger(Scanner scanner){
        boolean checkID = false;
        do {
            System.out.println("Nhập ID ca sĩ muốn thay đổi thông tin: ");
            int inputSingerId = Integer.parseInt(scanner.nextLine());
            if (inputSingerId > 0) {
                checkID = true;
                boolean check = false;
                for (int i = 0; i < singerLength; i++) {
                    if (singers[i] != null && singers[i].getSingerId() == inputSingerId){
                        check =true;
                        singers[i].inputSingerData(scanner);
                    }
                }
                if (!check){
                    System.err.println("Không có ID ca sĩ này ");
                }
            } else {
                System.err.println("Mã ID nhập không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!checkID);
    }

//    Xóa ca sĩ theo mã ID

    public static void deleteSinger(Scanner scanner){
        System.out.println("Nhập ID ca sĩ cần xóa:");
        int delSingerId = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < singerLength; i++) {
            if (singers[i] != null && singers[i].getSingerId() == delSingerId) {
                check = true;
                for (int j = i; j < singerLength - 1; j++) {
                    singers[j] = singers[j + 1];
                }
                singerLength--;
                System.out.println("Đã xóa ca sĩ có ID: " + delSingerId);
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy ca sĩ có ID: " + delSingerId);
        }
    }

        public static void menuSong(Scanner scanner){
            do {
                System.out.println("**********************SONG-MANAGEMENT************************");
                System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
                System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
                System.out.println("3. Thay đổi thông tin bài hát theo mã id");
                System.out.println("4. Xóa bài hát theo mã id");
                System.out.println("5. Quay lai");
                System.out.println("Mời lựa chọn (1/2/3/4/5): ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addSong(scanner);
                        break;
                    case 2:
                        showAllSong();
                        break;
                    case 3:
                        changeInfoSong(scanner);
                        break;
                    case 4:
                        deleteSong(scanner);
                        break;
                    case 5:
                        return;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            } while (true);
        }
//        Thêm bài hát
    public static void addSong(Scanner scanner){
        System.out.println("Ban muốn thêm bao nhiêu bài hát :");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = songLength; i < songLength + n; i++) {
            System.out.println("Nhập thông tin cho bài hát thứ " + (i + 1) + ":");
            songs[i] = new Song();
            songs[i].inputSongData(scanner,singers,songLength);
        }
        songLength += n;
    }

//        Hiển thị danh sách bài hát

    public static void showAllSong(){
        for (int i = 0; i < songLength; i++) {
            if (songs[i] != null) {
                songs[i].displaySongData();
            }
        }

    }

    //    thay đổi thông tin bài hat
    public static void changeInfoSong(Scanner scanner){
        boolean checkID = false;
        do {
            System.out.println("Nhập ID bài hát muốn thay đổi thông tin: ");
            String newSongId =scanner.nextLine();
            if (newSongId.length() == 4 && newSongId.charAt(0) == 'S' ) {
                checkID = true;
                boolean check = false;
                for (int i = 0; i < songLength; i++) {
                    if (songs[i] != null && songs[i].getSongId().equals(newSongId)){
                        check =true;
                        songs[i].inputSongData(scanner,singers,songLength);
                    }
                }
                if (!check){
                    System.err.println("Không có ID bài hát này ");
                }
            } else {
                System.err.println("Mã ID nhập không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!checkID);
    }

//    Xóa bài hát  theo mã ID

    public static void deleteSong(Scanner scanner){
        System.out.println("Nhập ID bai hát cần xóa:");
        String delSongId = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < songLength; i++) {
            if (songs[i] != null && songs[i].getSongId().equals(delSongId)) {
                check = true;
                for (int j = i; j < songLength - 1; j++) {
                    songs[j] = songs[j + 1];
                }
                songLength--;
                System.out.println("Đã xóa bài hát có ID: " + delSongId);
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy bài hát có ID: " + delSongId);
        }
    }
    public static void menuSearch(Scanner scanner){
        do {
                System.out.println("**********************SEARCH-MANAGEMENT************************");
                System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
                System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại");
                System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
                System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất");
                System.out.println("5. Quay lai");
                System.out.println("Mời lựa chọn (1/2/3/4/5): ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tên ca sĩ hoặc thể loại bài hát:");
                        String input = scanner.nextLine();
                        for (int i = 0; i < songs.length; i++) {
                            if (songs[i] != null && (songs[i].getSinger().getSingerName().equalsIgnoreCase(input) || songs[i].getSinger().getGenre().equalsIgnoreCase(input))) {
                                songs[i].displaySongData();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Nhập tên ca sĩ theo tên hoặc thể loại bài hát : ");
                        String input1 = scanner.nextLine();
                        for (int i = 0; i < singers.length; i++) {
                            if (singers[i]!=null && (singers[i].getSingerName().equalsIgnoreCase(input1)) || singers[i].getGenre().equalsIgnoreCase(input1)){
                                singers[i].displaySingerData();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Nhập tên ca sĩ theo tên hoặc thể loại bài hát : ");
                        String inputSearch = scanner.nextLine();
                        for (int i = 0; i < singers.length; i++) {
                            if (singers[i]!=null && (singers[i].getSingerName().equalsIgnoreCase(inputSearch)) || singers[i].getGenre().equalsIgnoreCase(inputSearch)){
                                singers[i].displaySingerData();
                            }
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
        } while (true);
    }

}
