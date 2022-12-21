package service;

import model.HouseBean;
import dao.HouseDao;
import org.hibernate.Session;

import java.util.List;

public class HouseService implements IHouseService {
    private HouseDao houseDao;

    public HouseService(Session session) {
         houseDao = new HouseDao(session);
    }

    @Override
    public HouseBean insert(HouseBean houseBean) {
//        這裡可以寫開交易
        return houseDao.insert(houseBean);
//         關交易
    }

    @Override
    public HouseBean selectById(int houdeid) {
        return houseDao.selectById(houdeid);
    }

    @Override
    public List<HouseBean> selectAll() {
        return houseDao.selectAll();
    }

    @Override
    public HouseBean update(int houseid, String houseName) {
        return houseDao.update(houseid, houseName);
    }

    @Override
    public void saveOrUpdate(HouseBean houseBean) {
        houseDao.saveOrUpdate(houseBean);
    }

    @Override
    public boolean delete(int houseid) {
        return houseDao.delete(houseid);
    }
}
