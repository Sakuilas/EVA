package eva.eva.dao;

import android.provider.BaseColumns;

/**
 * Created by Norman on 15.12.2015.
 */
public final class DatabaseSchema {

    /**
     * Private constructor for DatabaseSchema to prevent instantiation
     */
    private DatabaseSchema() {

    }

    /**
     * Defines the columns for student table
     */
    public static abstract class Student implements BaseColumns {
        public static final String TABLE_NAME = "studenten";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORT = "passwort";
        public static final String COLUMN_ADDRESS_FK = "address_fk";
    }

    /**
     * Defines the columns for rating table
     */
    public static abstract class Rating implements BaseColumns {
        public static final String TABLE_NAME = "rating";
        public static final String COLUMN_NAME_MOTIVATION = "motivation";
        public static final String COLUMN_NAME_TEAMFAEHIGKEIT = "teamfaehigkeit";
        public static final String COLUMN_NAME_KOMMUNIKATION = "kommunikation";
        public static final String COLUMN_NAME_KNOWHOW = "knowhow";
        public static final String COLUMN_STUDENTB_FK = "bewerter";
        public static final String COLUMN_STUDENT_FK = "bewerteter";

    }
}