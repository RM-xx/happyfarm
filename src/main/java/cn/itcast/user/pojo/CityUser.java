package cn.itcast.user.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cityuser")
public class CityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    private String name;

    private String password;

    private String land1;

    private String land1Endtime;

    private String land2;

    private String land2Endtime;

    private String land3;

    private String land3Endtime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLand1() {
        return land1;
    }

    public void setLand1(String land1) {
        this.land1 = land1;
    }

    public String getLand1Endtime() {
        return land1Endtime;
    }

    public void setLand1Endtime(String land1Endtime) {
        this.land1Endtime = land1Endtime;
    }

    public String getLand2() {
        return land2;
    }

    public void setLand2(String land2) {
        this.land2 = land2;
    }

    public String getLand2Endtime() {
        return land2Endtime;
    }

    public void setLand2Endtime(String land2Endtime) {
        this.land2Endtime = land2Endtime;
    }

    public String getLand3() {
        return land3;
    }

    public void setLand3(String land3) {
        this.land3 = land3;
    }

    public String getLand3Endtime() {
        return land3Endtime;
    }

    public void setLand3Endtime(String land3Endtime) {
        this.land3Endtime = land3Endtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", land1=" + land1 +
                ", land1Endtime=" + land1Endtime +
                ", land2=" + land2 +
                ", land2Endtime=" + land2Endtime +
                ", land3=" + land3 +
                ", land3Endtime=" + land3Endtime +
                '}';
    }
}
