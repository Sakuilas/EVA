package eva.eva.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import eva.eva.dao.DatabaseSchema.Rating;
import eva.eva.dao.DatabaseSchema.Student;

/**
 * Created by Norman on 15.12.2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eva.db";
    private static final String SQL_CREATE_TABLE_STUDENT =
            "CREATE TABLE " + Student.TABLE_NAME + " (" +
                    Student._ID + "INTEGER PRIMARY KEY," +
                    Student.COLUMN_NAME_USERNAME + " TEXT," +
                    Student.COLUMN_NAME_PASSWORT + " TEXT" + ");";


    private static final String SQL_CREATE_TABLE_RATING =
            "CREATE TABLE " + Rating.TABLE_NAME + " (" +
                    Rating._ID + " INTEGER PRIMARY KEY," +
                    Rating.COLUMN_NAME_MOTIVATION + " INTEGER," +
                    Rating.COLUMN_NAME_TEAMFAEHIGKEIT + " INTEGER," +
                    Rating.COLUMN_NAME_KOMMUNIKATION + " INTEGER," +
                    Rating.COLUMN_NAME_KNOWHOW + " INTEGER," +
                    Rating.COLUMN_STUDENTB_FK + " INTEGER," +
                    "FOREIGN KEY(" + Rating.COLUMN_STUDENT_FK + ") REFERENCES " + Student.TABLE_NAME + "(" + Student._ID + ")" +
                    Rating.COLUMN_STUDENT_FK + "INTEGER" +
                    "FOREIGN KEY(" + Rating.COLUMN_STUDENT_FK + ") REFERENCES " + Student.TABLE_NAME + "(" + Student._ID + ")" +
                    ");";

    private static final String SQL_DROP_TABLE_RATING = "DROP TABLE IF EXISTS " + Rating.TABLE_NAME + ";";
    private static final String SQL_DROP_TABLE_STUDENT = "DROP TABLE IF EXISTS " + Student.TABLE_NAME + ";";

    private static DatabaseHelper instance = null;
    private Context ctx;


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.ctx = context;
    }

    public static DatabaseHelper getInstance(Context ctx) {
        if (instance == null) {
            return new DatabaseHelper(ctx.getApplicationContext());
        }
        return instance;
    }

    /**
     * Called when database gets created for first time and used to create tables
     *
     * @param db the database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_STUDENT);
        db.execSQL(SQL_CREATE_TABLE_RATING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_RATING);
        db.execSQL(SQL_DROP_TABLE_STUDENT);
        onCreate(db);
    }
}
