package edu.aku.hassannaqvi.tajik_anemia_study.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import org.json.JSONArray;

import java.io.File;
import java.util.List;

import edu.aku.hassannaqvi.tajik_anemia_study.BuildConfig;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Anthro;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Blood;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Child;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.models.MWRA;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Pregnancy;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Samples;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Stool;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Users;


public class MainApp extends Application {

    public static final String PROJECT_NAME = "Tajik_Anemia_Study";
    public static final String DIST_ID = null;
    public static final String SYNC_LOGIN = "sync_login";
    //    public static final String _IP = "https://vcoe1.aku.edu";// .LIVE server
    public static final String _IP = "http://cls-pae-fp51764";// .TEST server
    //public static final String _IP = "http://43.245.131.159:8080";// .TEST server
    public static final String _HOST_URL = MainApp._IP + "/anemia_study_tj/api/";// .TEST server;
    public static final String _SERVER_URL = "sync.php";
    public static final String _SERVER_GET_URL = "getData.php";
    public static final String _PHOTO_UPLOAD_URL = _HOST_URL + "uploads.php";
    public static final String _UPDATE_URL = MainApp._IP + "/anemia_study_tj/app/";

    //COUNTRIES
    public static int PAKISTAN = 1;
    public static int TAJIKISTAN = 3;

    public static File sdDir;
    public static String[] downloadData;
    public static Form form;
    public static MWRA mwra;
    public static Child child;
    public static Anthro anthro;
    public static Blood blood;
    //public static Samples samples;
    public static Stool stool;
    public static Pregnancy preg;
    public static int pregSr = 1;
    public static Samples samples;
    public static String DeviceURL = "devices.php";
    public static AppInfo appInfo;
    public static Users user;
    public static Boolean admin = false;
    public static List<JSONArray> uploadData;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences sharedPref;
    public static String deviceid;
    public static int versionCode = BuildConfig.VERSION_CODE;
    public static String versionName = BuildConfig.VERSION_NAME;
    public static int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 2;
    public static long TWO_MINUTES = 1000 * 60 * 2;
    public static boolean permissionCheck = false;
    public static int idType = 0;
    public static boolean mwraComplete;
    public static boolean childComplete;
    public static boolean pregComplete;
    public static List<MWRA> mwraList;
    public static List<Child> childList;
    public static List<Pregnancy> pregList;
    public static int mwraCount = 0;
    public static int childCount = 0;
    public static int pregCount = 0;
    public static String selectedFemale = "";
    public static String selectedChild = "";
    public static String selectedPreg = "";
    public static int mwraCountComplete = 0;
    public static int childCountComplete = 0;
    public static int pregCountComplete = 0;
    public static List<String> subjectNames;
    public static List<String> childAge;

    public static TableContracts.ChildListTable childListTable;


    public static void hideSystemUI(View decorView) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            deviceId = Settings.Secure.getString(
                    context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } else {
           /* final TelephonyManager mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (mTelephony.getDeviceId() != null) {
                deviceId = mTelephony.getDeviceId();
            } else {
                deviceId = Settings.Secure.getString(
                        context.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
            }*/
        }
        return "deviceId";
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Initiate DateTime
        //Initializ App info
        appInfo = new AppInfo(this);
        sharedPref = getSharedPreferences(PROJECT_NAME, MODE_PRIVATE);
        editor = sharedPref.edit();
        deviceid = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

    }

}
