package moduls;


import org.hibernate.annotations.OrderBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NgheNhac {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String nameBaiHat;
    String nameNgheSy;
    String theLoai;
    String fileMusic;

    public NgheNhac() {
    }

    public NgheNhac(int id,String nameBaiHat, String nameNgheSy, String theLoai, String fileMusic) {
        this.id = id;
        this.nameBaiHat = nameBaiHat;
        this.nameNgheSy = nameNgheSy;
        this.theLoai = theLoai;
        this.fileMusic = fileMusic;
    }

    public String getNameBaiHat() {
        return nameBaiHat;
    }

    public void setNameBaiHat(String nameBaiHat) {
        this.nameBaiHat = nameBaiHat;
    }

    public String getNameNgheSy() {
        return nameNgheSy;
    }

    public void setNameNgheSy(String nameNgheSy) {
        this.nameNgheSy = nameNgheSy;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(String fileMusic) {
        this.fileMusic = fileMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
