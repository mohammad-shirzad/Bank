package entity;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    List<Report> reports = new ArrayList<>();

    public void add(Report report) {
        reports.add(report);
    }

    private void execute() {
        for (Report r : reports
                ) {

        }
    }
}
