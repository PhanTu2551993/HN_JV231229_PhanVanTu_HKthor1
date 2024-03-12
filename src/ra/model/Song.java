package ra.model;

import java.util.Date;
import java.util.Scanner;
public class Song {


    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song(){
        this.createdDate = new Date();
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWrWriter() {
        return songWriter;
    }

    public void setSongWrWriter(String songWrWriter) {
        this.songWriter = songWrWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputSongData(Scanner scanner,Singer[] singers,int length){
        System.out.println("Nhập mã bài hát (4 ký tự, bắt đầu bằng 'S'): ");
        while (true){
            songId=scanner.nextLine();
            if (songId.startsWith("S") && songId.length()==4){
                break;
            }
            System.out.println("Nhập lại do khong hop  le");
        }
        System.out.println("Nhập tên bài hát (không được để trống): ");
        while (true) {

            this.songName = scanner.nextLine();
            if (!this.songName.isEmpty()) {
                break;
            }
            System.out.println("Tên bài hát không hợp lệ. Hãy nhập lại.");
        }
//        nhập mô tả b hát

        System.out.println("Nhập mô tả bài hát:");
        descriptions = scanner.nextLine();

//        Nhập ca sĩ

        System.out.println("Nhập ca sĩ :");
        if (Singer.getNextID() == 1) {
            System.err.println("Hiện không có ca sĩ nào. Bạn cần thêm ca sĩ trước.");
            return;
        } else {
            System.out.println("Chọn ca sĩ từ danh sách sau:");
            for (int i = 0; i < length; i++) {
                if (singers[i] != null) {
                    System.out.println((i + 1) + ". " + singers[i].getSingerName());
                }
            }
            int singerChoice = Integer.parseInt(scanner.nextLine());
            this.singer = singers[singerChoice - 1];
        }
//         Nhập người sáng tác

        System.out.println("Nhập người sáng tác :");
        while (true){
            songWriter = scanner.nextLine();
            if (!songWriter.isEmpty()){
                break;
            }else {
                System.err.println("Tên người sáng tác không được để trống. Vui lòng nhập lại:");
            }
        }
//        nhập trạng thái
        System.out.println("Nhập trạng thái ");
        songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

//    Hiển thị

public void displaySongData(){
    System.out.println("Song{" +
            "songId='" + songId + '\'' +
            ", songName='" + songName + '\'' +
            ", descriptions='" + descriptions + '\'' +
            ", songWriter='" + songWriter + '\'' +
            ", createdDate=" + createdDate +
            ", songStatus=" + songStatus +
            '}');
    }
}
