package dao;

import model.HouseBean;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HouseDao implements IHouseDao {
    /*
    dao 設定與取得Session 但不建立與關閉
     */
    private Session session;

    public HouseDao(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public HouseBean insert(HouseBean houseBean){
        HouseBean bean = session.get(HouseBean.class, houseBean.getHouseId());
        if(bean==null){
            session.save(houseBean);
            return houseBean;
        }
        return null;
    }
    @Override
    public HouseBean selectById(int houdeid){
        return session.get(HouseBean.class,houdeid);
    }
    @Override
    public List<HouseBean> selectAll(){
        Query<HouseBean> query = session.createQuery("from HouseBean ", HouseBean.class);
        return query.list();
    }
    @Override
    public HouseBean update(int houseid, String houseName){
        HouseBean houseBean = session.get(HouseBean.class, houseid);
        if(houseBean!=null){
            houseBean.setHouseName(houseName);
        }
        return houseBean;
    }
    @Override
    public void saveOrUpdate(HouseBean houseBean){
        session.saveOrUpdate(houseBean);
    }
    @Override
    public boolean delete(int houseid){
        HouseBean houseBean = session.get(HouseBean.class, houseid);
        if(houseBean!=null){
            session.delete(houseBean);
            return true;
        }
        return false;
    }
}
