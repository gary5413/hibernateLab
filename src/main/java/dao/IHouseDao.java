package dao;

import model.HouseBean;

import java.util.List;

public interface IHouseDao {
    HouseBean insert(HouseBean houseBean);

    HouseBean selectById(int houdeid);

    List<HouseBean> selectAll();

    HouseBean update(int houseid, String houseName);

    void saveOrUpdate(HouseBean houseBean);

    boolean delete(int houseid);
}
