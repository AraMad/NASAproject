package ua.arina.nasaproject.utils.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ua.arina.nasaproject.R;

/**
 * Created by Arina on 06.01.2017
 */

public class DataBaseManager {

    private final String TAG = getClass().getSimpleName();

    private final Context applicationContext;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase dataBase;

    public DataBaseManager(Context context){
        applicationContext = context;
        dataBaseHelper = new DataBaseHelper(applicationContext);
    }

    public boolean openDataBase() {
        try {
            dataBase = dataBaseHelper.getWritableDatabase();
            return true;
        } catch (SQLiteException e) {
            try {
                dataBase = dataBaseHelper.getReadableDatabase();
                e.printStackTrace();
                return true;
            } catch (SQLiteException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    public void closeDataBase() {
        if (dataBaseHelper != null) {
            dataBaseHelper.close();
        }
    }

    /*public String getJSONStringByCityName(String city) {
        Cursor cursor;

        try {
            cursor = dataBase.query(applicationContext.getString(R.string.TABLE_NAME),
                    new String[] {applicationContext.getString(R.string.DATA_STRING_COLUMN)},
                    applicationContext.getString(R.string.KEY_CITY_COLUMN) + " = '" + city + "'",
                    null, null, null, null);
            cursor.moveToFirst();
            String JSON_string = cursor.getString(cursor.getColumnIndexOrThrow(applicationContext.getString(R.string.DATA_STRING_COLUMN)));
            cursor.close();
            return JSON_string;
        } catch (Exception e){
            Log.i(TAG, e.toString());
        }

        return null;
    }*/

    public void addNewRowToBase(String city, String data_string) {

        try {
            /*dataBase.execSQL("INSERT INTO " + applicationContext.getString(R.string.TABLE_NAME)
                    + " (" + applicationContext.getString(R.string.KEY_CITY_COLUMN) +", "
                    + applicationContext.getString(R.string.DATA_STRING_COLUMN) + ", "
                    + applicationContext.getString(R.string.TIME_UPDATE_COLUMN) + ") VALUES ("
                    + "'" + city + "'" + ", '" + data_string + "', " + System.currentTimeMillis() + ");");*/
        } catch (Exception e){
            Log.i(TAG, e.toString());
            e.printStackTrace();
        }

    }

    private class DataBaseHelper extends SQLiteOpenHelper {

        private final String DATABASE_CREATE_COMMAND;

        public DataBaseHelper(Context context) {
            super(context, context.getString(R.string.data_base_name), null,
                    context.getResources().getInteger(R.integer.data_base_version));

            DATABASE_CREATE_COMMAND = "CREATE TABLE "; /*+ context.getString(R.string.TABLE_NAME)
                    + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + context.getString(R.string.KEY_CITY_COLUMN) + " TEXT NOT NULL, "
                    + context.getString(R.string.DATA_STRING_COLUMN) + " TEXT, "
                    + context.getString(R.string.TIME_UPDATE_COLUMN) + " NUMERIC);";*/
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_COMMAND);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
