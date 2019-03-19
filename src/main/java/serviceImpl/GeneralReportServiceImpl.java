package serviceImpl;

import reportDao.GeneralReportDao;
import entity.GeneralReport;
import service.GeneralReportService;

public class GeneralReportServiceImpl implements GeneralReportService {
    private GeneralReportDao generalReportDao;

    public void setGeneralReportDao(GeneralReportDao generalReportDao) {
        this.generalReportDao = generalReportDao;
    }

    @Override
    public GeneralReport saveGeneralReport(GeneralReport generalReport) {
        return generalReportDao.save(generalReport);
    }
}
