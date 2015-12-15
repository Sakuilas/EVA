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



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, VORNAME TEXT, BEWERTUNG INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(db);
    }
}
