package com.common.utils.date;

import java.sql.Timestamp;
import java.util.Date;

public class CurrentDateTime {
    public static Timestamp getCurrentDateTime() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }
}
