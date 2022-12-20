package model;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class HouseBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "houseid")
    private Integer houseId;
    @Column(name = "housename")
    private String houseName;
    /*
    1.必須要有一個預設建構子
    2.不要使用final宣告
    3.必須要有primary key
     建議實作 serializable介面
     */
    public HouseBean() {
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}
