package reportDaoImpl;

import reportDao.GeneralReportDao;
import entity.GeneralReport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GeneralReportDaoImpl implements GeneralReportDao {
    EntityManagerFactory emf;

    public EntityManager getEntityManger() {
        return emf.createEntityManager();
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public GeneralReport save(GeneralReport generalReport) {
        getEntityManger().persist(generalReport);
        return generalReport;
    }
}
