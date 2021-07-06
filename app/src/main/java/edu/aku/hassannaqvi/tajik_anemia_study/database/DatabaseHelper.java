package edu.aku.hassannaqvi.tajik_anemia_study.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.AnthroTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.BloodTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.ChildListTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.ClustersTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.MWRAListTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.PregnancyTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.RandomTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.StoolTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.UsersTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.VersionTable;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.ZScoreTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Anthro;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Blood;
import edu.aku.hassannaqvi.tajik_anemia_study.models.ChildList;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Clusters;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.models.MWRAList;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Pregnancy;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Random;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Stool;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Users;
import edu.aku.hassannaqvi.tajik_anemia_study.models.VersionApp;
import edu.aku.hassannaqvi.tajik_anemia_study.models.ZStandard;

import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_ANTHRO;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_BLOOD;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_CHILDLIST;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_CLUSTERS;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_MWRALIST;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_PREGNANCY;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_RANDOM;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_STOOL;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_VERSIONAPP;
import static edu.aku.hassannaqvi.tajik_anemia_study.database.CreateTable.SQL_CREATE_ZSTANDARD;



/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_CLUSTERS);
        db.execSQL(SQL_CREATE_RANDOM);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_MWRALIST);
        db.execSQL(SQL_CREATE_CHILDLIST);
        db.execSQL(SQL_CREATE_ANTHRO);
        db.execSQL(SQL_CREATE_BLOOD);
        db.execSQL(SQL_CREATE_STOOL);
        db.execSQL(SQL_CREATE_PREGNANCY);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_ZSTANDARD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }


    //ADDITION in DB
    public Long addForm(Form form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsTable.COLUMN_USERNAME, form.getUserName());
        values.put(FormsTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(FormsTable.COLUMN_S1, form.getS1());
        values.put(FormsTable.COLUMN_S2, form.getS2());
        values.put(FormsTable.COLUMN_S3, form.getS3());
        values.put(FormsTable.COLUMN_S4, form.getS4());
        values.put(FormsTable.COLUMN_S5, form.getS5());
        values.put(FormsTable.COLUMN_ISTATUS, form.getiStatus());

        values.put(FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsTable.COLUMN_APPVERSION, form.getAppver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMWRAList(MWRAList mwra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MWRAListTable.COLUMN_PROJECT_NAME, mwra.getProjectName());
        values.put(MWRAListTable.COLUMN_UID, mwra.getUid());
        values.put(MWRAListTable.COLUMN_UUID, mwra.getUuid());
        values.put(MWRAListTable.COLUMN_CLUSTER, mwra.getCluster());
        values.put(MWRAListTable.COLUMN_HHID, mwra.getHhid());
        values.put(MWRAListTable.COLUMN_USERNAME, mwra.getUserName());
        values.put(MWRAListTable.COLUMN_SYSDATE, mwra.getSysDate());
        values.put(MWRAListTable.COLUMN_S1, mwra.getS1());

        values.put(MWRAListTable.COLUMN_DEVICEID, mwra.getDeviceId());
        values.put(MWRAListTable.COLUMN_DEVICETAGID, mwra.getDeviceTag());
        values.put(MWRAListTable.COLUMN_APPVERSION, mwra.getAppver());
        values.put(MWRAListTable.COLUMN_ISTATUS, mwra.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MWRAListTable.TABLE_NAME,
                MWRAListTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildList(ChildList child) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ChildListTable.COLUMN_PROJECT_NAME, child.getProjectName());
        values.put(ChildListTable.COLUMN_UID, child.getUid());
        values.put(ChildListTable.COLUMN_UUID, child.getUuid());
        values.put(ChildListTable.COLUMN_CLUSTER, child.getCluster());
        values.put(ChildListTable.COLUMN_HHID, child.getHhid());
        values.put(ChildListTable.COLUMN_USERNAME, child.getUserName());
        values.put(ChildListTable.COLUMN_SYSDATE, child.getSysDate());
        values.put(ChildListTable.COLUMN_S1, child.getS1());

        values.put(MWRAListTable.COLUMN_DEVICEID, child.getDeviceId());
        values.put(MWRAListTable.COLUMN_DEVICETAGID, child.getDeviceTag());
        values.put(MWRAListTable.COLUMN_APPVERSION, child.getAppver());
        values.put(MWRAListTable.COLUMN_ISTATUS, child.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ChildListTable.TABLE_NAME,
                ChildListTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addAnthro(Anthro anthro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AnthroTable.COLUMN_PROJECT_NAME, anthro.getProjectName());
        values.put(AnthroTable.COLUMN_UID, anthro.getUid());
        values.put(AnthroTable.COLUMN_UUID, anthro.getUuid());
        values.put(AnthroTable.COLUMN_CLUSTER, anthro.getCluster());
        values.put(AnthroTable.COLUMN_HHID, anthro.getHhid());
        values.put(AnthroTable.COLUMN_USERNAME, anthro.getUserName());
        values.put(AnthroTable.COLUMN_SYSDATE, anthro.getSysDate());
        values.put(AnthroTable.COLUMN_S1, anthro.getS1());

        values.put(AnthroTable.COLUMN_DEVICEID, anthro.getDeviceId());
        values.put(AnthroTable.COLUMN_DEVICETAGID, anthro.getDeviceTag());
        values.put(AnthroTable.COLUMN_APPVERSION, anthro.getAppver());
        values.put(AnthroTable.COLUMN_ISTATUS, anthro.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                AnthroTable.TABLE_NAME,
                AnthroTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addBlood(Blood blood) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BloodTable.COLUMN_PROJECT_NAME, blood.getProjectName());
        values.put(BloodTable.COLUMN_UID, blood.getUid());
        values.put(BloodTable.COLUMN_UUID, blood.getUuid());
        values.put(BloodTable.COLUMN_CLUSTER, blood.getCluster());
        values.put(BloodTable.COLUMN_HHID, blood.getHhid());
        values.put(BloodTable.COLUMN_USERNAME, blood.getUserName());
        values.put(BloodTable.COLUMN_SYSDATE, blood.getSysDate());
        values.put(BloodTable.COLUMN_S1, blood.getS1());

        values.put(BloodTable.COLUMN_DEVICEID, blood.getDeviceId());
        values.put(BloodTable.COLUMN_DEVICETAGID, blood.getDeviceTag());
        values.put(BloodTable.COLUMN_APPVERSION, blood.getAppver());
        values.put(BloodTable.COLUMN_ISTATUS, blood.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                BloodTable.TABLE_NAME,
                BloodTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addStool(Stool stool) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StoolTable.COLUMN_PROJECT_NAME, stool.getProjectName());
        values.put(StoolTable.COLUMN_UID, stool.getUid());
        values.put(StoolTable.COLUMN_UUID, stool.getUuid());
        values.put(StoolTable.COLUMN_CLUSTER, stool.getCluster());
        values.put(StoolTable.COLUMN_HHID, stool.getHhid());
        values.put(StoolTable.COLUMN_USERNAME, stool.getUserName());
        values.put(StoolTable.COLUMN_SYSDATE, stool.getSysDate());
        values.put(StoolTable.COLUMN_S1, stool.getS1());

        values.put(StoolTable.COLUMN_DEVICEID, stool.getDeviceId());
        values.put(StoolTable.COLUMN_DEVICETAGID, stool.getDeviceTag());
        values.put(StoolTable.COLUMN_APPVERSION, stool.getAppver());
        values.put(StoolTable.COLUMN_ISTATUS, stool.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                StoolTable.TABLE_NAME,
                StoolTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addPregnancy(Pregnancy preg) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PregnancyTable.COLUMN_PROJECT_NAME, preg.getProjectName());
        values.put(PregnancyTable.COLUMN_UID, preg.getUid());
        values.put(PregnancyTable.COLUMN_UUID, preg.getUuid());
        values.put(PregnancyTable.COLUMN_CLUSTER, preg.getCluster());
        values.put(PregnancyTable.COLUMN_HHID, preg.getHhid());
        values.put(PregnancyTable.COLUMN_USERNAME, preg.getUserName());
        values.put(PregnancyTable.COLUMN_SYSDATE, preg.getSysDate());
        values.put(PregnancyTable.COLUMN_S1, preg.getS1());

        values.put(PregnancyTable.COLUMN_DEVICEID, preg.getDeviceId());
        values.put(PregnancyTable.COLUMN_DEVICETAGID, preg.getDeviceTag());
        values.put(PregnancyTable.COLUMN_APPVERSION, preg.getAppver());
        values.put(PregnancyTable.COLUMN_ISTATUS, preg.getiStatus());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                PregnancyTable.TABLE_NAME,
                PregnancyTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //UPDATE in DB
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.form.getiStatus());

        // Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesMWRAListColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = MWRAListTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mwraList.getId())};

        return db.update(MWRAListTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesChildListColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildListTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.childList.getId())};

        return db.update(ChildListTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesAnthroColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = AnthroTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.anthro.getId())};

        return db.update(AnthroTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesBloodColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = BloodTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.blood.getId())};

        return db.update(BloodTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesStoolColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = StoolTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.stool.getId())};

        return db.update(StoolTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesPregColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = PregnancyTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.preg.getId())};

        return db.update(PregnancyTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    /*
     * Functions that dealing with table data
     * */
    public boolean doLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UsersTable.COLUMN_ID,
                UsersTable.COLUMN_USERNAME,
                UsersTable.COLUMN_PASSWORD,
                UsersTable.COLUMN_FULLNAME,
        };
        String whereClause = UsersTable.COLUMN_USERNAME + "=? AND " + UsersTable.COLUMN_PASSWORD + "=?";
        String[] whereArgs = {username, password};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users loggedInUser = null;
        try {
            c = db.query(
                    UsersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                loggedInUser = new Users().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        MainApp.user = loggedInUser;
        return c.getCount() > 0;
    }


    public ArrayList<Form> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form forms = new Form();
                forms.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndex(FormsTable.COLUMN_USERNAME)));
                allForms.add(forms);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }


    // istatus examples: (1) or (1,9) or (1,3,5)
    public Form getFormByAssessNo(String uid, String istatus) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_UID + "=? AND " +
                FormsTable.COLUMN_ISTATUS + " in " + istatus;

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Form allFC = null;
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public int updateTemp(String assessNo, String temp) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_TSF305, temp);
        values.put(FormsTable.COLUMN_SYSDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()) + "-Updated");
        values.put(FormsTable.COLUMN_ISTATUS, "1");
        values.put(FormsTable.COLUMN_SYNCED, (byte[]) null);

        String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? AND " + FormsTable.COLUMN_ISTATUS + " =? ";
        // String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? ";
        String[] selectionArgs = {assessNo, "9"};
        // String[] selectionArgs = {assessNo};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }*/


    public int syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }

    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncClusters(JSONArray clusterList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ClustersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < clusterList.length(); i++) {

                JSONObject json = clusterList.getJSONObject(i);

                Clusters cluster = new Clusters();
                cluster.sync(json);
                ContentValues values = new ContentValues();

                values.put(ClustersTable.COLUMN_DISTRICT_NAME, cluster.getDistrictName());
                values.put(ClustersTable.COLUMN_DISTRICT_CODE, cluster.getDistrictCode());
                values.put(ClustersTable.COLUMN_CITY_NAME, cluster.getCityName());
                values.put(ClustersTable.COLUMN_CITY_CODE, cluster.getCityCode());
                values.put(ClustersTable.COLUMN_CLUSTER_NO, cluster.getClusterNo());
                long rowID = db.insert(ClustersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncClusters(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncRandom(JSONArray list) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RandomTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < list.length(); i++) {

                JSONObject json = list.getJSONObject(i);

                Random ran = new Random();
                ran.sync(json);
                ContentValues values = new ContentValues();
                values.put(RandomTable.COLUMN_SNO, ran.getSno());
                values.put(RandomTable.COLUMN_CLUSTER_NO, ran.getClusterNo());
                values.put(RandomTable.COLUMN_HH_NO, ran.getHhno());
                values.put(RandomTable.COLUMN_HEAD_HH, ran.getHeadhh());
                long rowID = db.insert(RandomTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncRandom(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    //get UnSyncedTables
    public JSONArray getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        //whereClause = null;
        whereClause = FormsTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        JSONArray allForms = new JSONArray();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                /** WorkManager Upload
                 /*Form fc = new Form();
                 allFC.add(fc.Hydrate(c));*/
                Log.d(TAG, "getUnsyncedForms: " + c.getCount());
                Form form = new Form();
                allForms.put(form.Hydrate(c).toJSONObject());


            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedForms: " + allForms.toString().length());
        Log.d(TAG, "getUnsyncedForms: " + allForms);
        return allForms;
    }

    public JSONArray getUnsyncedMWRAList() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = MWRAListTable.COLUMN_SYNCED + " is null ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = MWRAListTable.COLUMN_ID + " ASC";
        JSONArray all = new JSONArray();
        try {
            c = db.query(
                    MWRAListTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedMWRAList: " + c.getCount());
                MWRAList mwra = new MWRAList();
                all.put(mwra.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedMWRAList: " + all.toString().length());
        Log.d(TAG, "getUnsyncedMWRAList: " + all);
        return all;
    }

    public JSONArray getUnsyncedChildList() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = ChildListTable.COLUMN_SYNCED + " is null ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = ChildListTable.COLUMN_ID + " ASC";
        JSONArray all = new JSONArray();
        try {
            c = db.query(
                    ChildListTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedChildList: " + c.getCount());
                ChildList child = new ChildList();
                all.put(child.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedChildList: " + all.toString().length());
        Log.d(TAG, "getUnsyncedChildList: " + all);
        return all;
    }

    public JSONArray getUnsyncedAnthro() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = AnthroTable.COLUMN_SYNCED + " is null ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = AnthroTable.COLUMN_ID + " ASC";
        JSONArray all = new JSONArray();
        try {
            c = db.query(
                    AnthroTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedAnthro: " + c.getCount());
                Anthro anthro = new Anthro();
                all.put(anthro.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedAnthro: " + all.toString().length());
        Log.d(TAG, "getUnsyncedAnthro: " + all);
        return all;
    }

    public JSONArray getUnsyncedBlood() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = BloodTable.COLUMN_SYNCED + " is null ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = BloodTable.COLUMN_ID + " ASC";
        JSONArray all = new JSONArray();
        try {
            c = db.query(
                    BloodTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedBlood: " + c.getCount());
                Blood blood = new Blood();
                all.put(blood.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedBlood: " + all.toString().length());
        Log.d(TAG, "getUnsyncedBlood: " + all);
        return all;
    }

    public JSONArray getUnsyncedStool() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = StoolTable.COLUMN_SYNCED + " is null ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = StoolTable.COLUMN_ID + " ASC";
        JSONArray all = new JSONArray();
        try {
            c = db.query(
                    StoolTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedStool: " + c.getCount());
                Stool stool = new Stool();
                all.put(stool.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedStool: " + all.toString().length());
        Log.d(TAG, "getUnsyncedStool: " + all);
        return all;
    }

    public JSONArray getUnsyncedPreg() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = PregnancyTable.COLUMN_SYNCED + " is null ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = PregnancyTable.COLUMN_ID + " ASC";
        JSONArray all = new JSONArray();
        try {
            c = db.query(
                    PregnancyTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Log.d(TAG, "getUnsyncedPreg: " + c.getCount());
                Pregnancy preg = new Pregnancy();
                all.put(preg.Hydrate(c).toJSONObject());
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        Log.d(TAG, "getUnsyncedPreg: " + all.toString().length());
        Log.d(TAG, "getUnsyncedPreg: " + all);
        return all;
    }


    //update SyncedTables
    public void updateSyncedforms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public List<String> getLMS(int age, int gender, String catA, String catB) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d(TAG, "getLMS: " + age + " | " + gender + " | " + catA + " | " + catB);
        Cursor c = db.rawQuery("SELECT l,m,s " +
                        "FROM " + ZScoreTable.TABLE_NAME + " " +
                        "WHERE " + ZScoreTable.COLUMN_AGE + "=? " +
                        "AND "
                        + ZScoreTable.COLUMN_SEX + "=?" +
                        "AND "
                        + ZScoreTable.COLUMN_CAT + " IN (?,?)"
                ,
                new String[]{String.valueOf(age), String.valueOf(gender), catA, catB});
        List<String> lms = null;
        while (c.moveToNext()) {
            lms = new ArrayList<>();
            lms.add(c.getString(c.getColumnIndex(ZScoreTable.COLUMN_L)));
            Log.d(TAG, "getLMS: L -> " + c.getString(c.getColumnIndex(ZScoreTable.COLUMN_L)));
            lms.add(c.getString(c.getColumnIndex(ZScoreTable.COLUMN_M)));
            Log.d(TAG, "getLMS: M -> " + c.getString(c.getColumnIndex(ZScoreTable.COLUMN_M)));
            lms.add(c.getString(c.getColumnIndex(ZScoreTable.COLUMN_S)));
            Log.d(TAG, "getLMS: S -> " + c.getString(c.getColumnIndex(ZScoreTable.COLUMN_S)));

        }
        return lms;
    }

    public List<String> getWHLMS(Double height, int gender, String catA) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT l,m,s " +
                        "FROM " + ZScoreTable.TABLE_NAME +
                        " WHERE " + ZScoreTable.COLUMN_MEASURE + "=?" +
                        " AND " + ZScoreTable.COLUMN_SEX + "=?" +
                        " AND " + ZScoreTable.COLUMN_CAT + "=?"
                ,
                new String[]{String.valueOf(height), String.valueOf(gender), catA});
        List<String> whlms = new ArrayList<>();
        Log.d(TAG, "getWHLMS: height " + height);
        Log.d(TAG, "getWHLMS: " + c.getCount());
        while (c.moveToNext()) {
            whlms = new ArrayList<>();
            whlms.add(c.getString(c.getColumnIndex(ZScoreTable.COLUMN_L)));
            whlms.add(c.getString(c.getColumnIndex(ZScoreTable.COLUMN_M)));
            whlms.add(c.getString(c.getColumnIndex(ZScoreTable.COLUMN_S)));

        }
        c.close();
        return whlms;
    }


    public int syncZStandard(JSONArray zsList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ZScoreTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < zsList.length(); i++) {

                JSONObject jsonObjectzs = zsList.getJSONObject(i);

                ZStandard Zstandard = new ZStandard();
                Zstandard.Sync(jsonObjectzs);
                ContentValues values = new ContentValues();

                values.put(ZScoreTable.COLUMN_SEX, Zstandard.getSex());
                values.put(ZScoreTable.COLUMN_AGE, Zstandard.getAge());
                values.put(ZScoreTable.COLUMN_MEASURE, Zstandard.getMeasure());
                values.put(ZScoreTable.COLUMN_L, Zstandard.getL());
                values.put(ZScoreTable.COLUMN_M, Zstandard.getM());
                values.put(ZScoreTable.COLUMN_S, Zstandard.getS());
                values.put(ZScoreTable.COLUMN_CAT, Zstandard.getCat());
                long rowID = db.insert(ZScoreTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncZStandard(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }
}