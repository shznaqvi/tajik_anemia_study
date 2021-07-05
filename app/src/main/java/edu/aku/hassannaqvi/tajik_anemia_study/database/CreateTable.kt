package edu.aku.hassannaqvi.tajik_anemia_study.database

import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.*
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.PROJECT_NAME

object CreateTable {

    const val DATABASE_NAME = "$PROJECT_NAME.db"
    const val DATABASE_COPY = "${PROJECT_NAME}_copy.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_S1 + " TEXT,"
            + FormsTable.COLUMN_S2 + " TEXT,"
            + FormsTable.COLUMN_S3 + " TEXT,"
            + FormsTable.COLUMN_S4 + " TEXT,"
            + FormsTable.COLUMN_S5 + " TEXT"
            + " );"
            )


    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT"
            + " );"
            )


    const val SQL_CREATE_CLUSTERS = ("CREATE TABLE "
            + ClustersTable.TABLE_NAME + "("
            + ClustersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ClustersTable.COLUMN_DISTRICT_NAME + " TEXT,"
            + ClustersTable.COLUMN_DISTRICT_CODE + " TEXT,"
            + ClustersTable.COLUMN_CITY_NAME + " TEXT,"
            + ClustersTable.COLUMN_CITY_CODE + " TEXT,"
            + ClustersTable.COLUMN_CLUSTER_NO + " TEXT"
            + " );"
            )


    const val SQL_CREATE_RANDOM = ("CREATE TABLE "
            + RandomTable.TABLE_NAME + "("
            + RandomTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + RandomTable.COLUMN_SNO + " TEXT,"
            + RandomTable.COLUMN_CLUSTER_NO + " TEXT,"
            + RandomTable.COLUMN_HH_NO + " TEXT,"
            + RandomTable.COLUMN_HEAD_HH + " TEXT"
            + " );"
            )

    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )
    const val SQL_CREATE_ZSTANDARD = "CREATE TABLE " + ZScoreTable.TABLE_NAME + " (" +
            ZScoreTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ZScoreTable.COLUMN_SEX + " TEXT, " +
            ZScoreTable.COLUMN_AGE + " TEXT, " +
            ZScoreTable.COLUMN_MEASURE + " TEXT, " +
            ZScoreTable.COLUMN_L + " TEXT, " +
            ZScoreTable.COLUMN_M + " TEXT, " +
            ZScoreTable.COLUMN_S + " TEXT, " +
            ZScoreTable.COLUMN_CAT + " TEXT " +
            ");"

}