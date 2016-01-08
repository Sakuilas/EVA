package eva.eva.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import eva.eva.dao.DatabaseSchema.Rating;
import eva.eva.dao.DatabaseSchema.Student;

/**
 * Updated by Lukas on 08.01.2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "eva.db";
    public static final String SQL_CREATE_TABLE_STUDENT =
            "CREATE TABLE " + Student.TABLE_NAME + " (" +
                    Student._ID + "INTEGER PRIMARY KEY," +
                    Student.COLUMN_NAME_USERNAME + " TEXT," +
                    Student.COLUMN_NAME_PASSWORT + " TEXT" + ");";


    public static final String SQL_CREATE_TABLE_RATING =
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

    public static final String SQL_DROP_TABLE_RATING = "DROP TABLE IF EXISTS " + Rating.TABLE_NAME + ";";
    public static final String SQL_DROP_TABLE_STUDENT = "DROP TABLE IF EXISTS " + Student.TABLE_NAME + ";";

    public static DatabaseHelper instance = null;
    public Context ctx;


    public DatabaseHelper(Context context) {
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

        String ROW2 = "INSERT INTO " + Student.TABLE_NAME + " Values (1 , 'Lukas', 'password');";
        String ROW3 = "INSERT INTO " + Student.TABLE_NAME + " Values (2 , 'Stephan', 'password');";
        String ROW4 = "INSERT INTO " + Student.TABLE_NAME + " Values (3 , 'Norman', 'password');";
        String ROW5 = "INSERT INTO " + Rating.TABLE_NAME + " (" + Rating._ID + ", " + Rating.COLUMN_NAME_MOTIVATION + ", " + Rating.COLUMN_NAME_TEAMFAEHIGKEIT + ", " + Rating.COLUMN_NAME_KOMMUNIKATION + ", " + Rating.COLUMN_NAME_KNOWHOW + ", " + Rating.COLUMN_STUDENTB_FK + ", " + Rating.COLUMN_STUDENT_FK + ")" +
                " Values " +
                "(1, 3, 3, 3, 3, 1, 1, 1)," +
                "(2, 3, 3, 3, 3, 1, 1, 2)," +
                "(3, 3, 3, 3, 3, 1, 1, 3),";

        db.execSQL(ROW2);
        db.execSQL(ROW3);
        db.execSQL(ROW4);
        db.execSQL(ROW5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_RATING);
        db.execSQL(SQL_DROP_TABLE_STUDENT);
        onCreate(db);
    }
}
