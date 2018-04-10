package com.auribises.myapp;

import android.net.Uri;

/**
 * Created by ishantkumar on 09/04/18.
 */

public class Util {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "feedbacks.db";

    public static final String TAB_NAME = "Feedback";

    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_RATING = "RATING";

    public static final String CREATE_TAB_QUERY = "create table Feedback(" +
            "_ID integer primary key autoincrement," +
            "NAME varchar(256)," +
            "PHONE varchar(256)," +
            "EMAIL varchar(256)," +
            "RATING real" +
            ")";

    public static final Uri URI = Uri.parse("content://com.auribises.myapp.feedbackcp/Feedback");
}
