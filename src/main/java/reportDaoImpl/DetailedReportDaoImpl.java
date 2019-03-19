package reportDaoImpl;

import reportDao.DetailedReportDao;
import entity.DetailedReport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DetailedReportDaoImpl implements DetailedReportDao {
    EntityManagerFactory emf;

    public EntityManager getEntityManger() {
        return emf.createEntityManager();
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public DetailedReport save(DetailedReport detailedReport) {
        getEntityManger().persist(detailedReport);
        return detailedReport;
    }
}
