package serviceImpl;

import reportDao.DetailedReportDao;
import entity.DetailedReport;
import service.DetailedReportService;

public class DetailedReportServiceImpl implements DetailedReportService {
    DetailedReportDao detailedReportDao;

    public void setDetailedReportDao(DetailedReportDao detailedReportDao) {
        this.detailedReportDao = detailedReportDao;
    }

    @Override
    public DetailedReport saveDetailedReport(DetailedReport detailedReport) {
        return detailedReportDao.save(detailedReport);
    }
}
