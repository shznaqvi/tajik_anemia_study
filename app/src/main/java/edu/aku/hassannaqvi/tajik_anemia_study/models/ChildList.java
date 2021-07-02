package edu.aku.hassannaqvi.tajik_anemia_study.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.tajik_anemia_study.BR;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;

public class ChildList extends BaseObservable {

    private final String TAG = "ChildList";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;

    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;

    // SECTION VARIABLES
    private String s1 = StringUtils.EMPTY;

    // FIELD VARIABLES
    private String h228 = StringUtils.EMPTY;
    private String h229 = StringUtils.EMPTY;
    private String h230d = StringUtils.EMPTY;
    private String h230m = StringUtils.EMPTY;
    private String h230y = StringUtils.EMPTY;
    private String h231y = StringUtils.EMPTY;
    private String h231m = StringUtils.EMPTY;
    private String h231d = StringUtils.EMPTY;
    private String h232 = StringUtils.EMPTY;
    private String h233 = StringUtils.EMPTY;


    public ChildList() {
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }


    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }





    @Bindable
    public String getH228() {
        return h228;
    }

    public void setH228(String h228) {
        this.h228 = h228;
        notifyPropertyChanged(BR.h228);
    }

    @Bindable
    public String getH229() {
        return h229;
    }

    public void setH229(String h229) {
        this.h229 = h229;
        notifyPropertyChanged(BR.h229);
    }

    @Bindable
    public String getH230d() {
        return h230d;
    }

    public void setH230d(String h230d) {
        this.h230d = h230d;
        notifyPropertyChanged(BR.h230d);
    }

    @Bindable
    public String getH230m() {
        return h230m;
    }

    public void setH230m(String h230m) {
        this.h230m = h230m;
        notifyPropertyChanged(BR.h230m);
    }

    @Bindable
    public String getH230y() {
        return h230y;
    }

    public void setH230y(String h230y) {
        this.h230y = h230y;
        notifyPropertyChanged(BR.h230y);
    }

    @Bindable
    public String getH231y() {
        return h231y;
    }

    public void setH231y(String h231y) {
        this.h231y = h231y;
        notifyPropertyChanged(BR.h231y);
    }

    @Bindable
    public String getH231m() {
        return h231m;
    }

    public void setH231m(String h231m) {
        this.h231m = h231m;
        notifyPropertyChanged(BR.h231m);
    }

    @Bindable
    public String getH231d() {
        return h231d;
    }

    public void setH231d(String h231d) {
        this.h231d = h231d;
        notifyPropertyChanged(BR.h231d);
    }

    @Bindable
    public String getH232() {
        return h232;
    }

    public void setH232(String h232) {
        this.h232 = h232;
        notifyPropertyChanged(BR.h232);
    }

    @Bindable
    public String getH233() {
        return h233;
    }

    public void setH233(String h233) {
        this.h233 = h233;
        notifyPropertyChanged(BR.h233);
    }




    public ChildList Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S1)));
        s2Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S2)));
        s3Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S3)));
        s4Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S4)));
        s5Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S5)));

        return this;
    }

    public void s1Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.h101 = json.getString("h101");
                this.h102 = json.getString("h102");
                this.h103 = json.getString("h103");
                this.h104 = json.getString("h104");
                this.h105 = json.getString("h105");
                this.h106d = json.getString("h106d");
                this.h106m = json.getString("h106m");
                this.h106y = json.getString("h106y");
                this.h107h = json.getString("h107h");
                this.h107m = json.getString("h107m");
                this.h108 = json.getString("h108");
                this.h109 = json.getString("h109");
                this.h110 = json.getString("h110");
                this.h111 = json.getString("h111");
                this.h112 = json.getString("h112");
                this.h11296x = json.getString("h11296x");
                this.h201 = json.getString("h201");
                this.h202 = json.getString("h202");
                this.h203d = json.getString("h203d");
                this.h203m = json.getString("h203m");
                this.h203y = json.getString("h203y");
                this.h204 = json.getString("h204");
                this.h205 = json.getString("h205");
                this.h206 = json.getString("h206");
                this.h207 = json.getString("h207");
                this.h208 = json.getString("h208");
                this.h209 = json.getString("h209");
                this.h210 = json.getString("h210");
                this.h211t = json.getString("h211t");
                this.h211m = json.getString("h211m");
                this.h211f = json.getString("h211f");
                this.h212 = json.getString("h212");
                this.h213t = json.getString("h213t");
                this.h213m = json.getString("h213m");
                this.h213f = json.getString("h213f");
                this.h214 = json.getString("h214");
                this.h215t = json.getString("h215t");
                this.h215m = json.getString("h215m");
                this.h215f = json.getString("h215f");
                this.h216 = json.getString("h216");
                this.h217t = json.getString("h217t");
                this.h217m = json.getString("h217m");
                this.h217f = json.getString("h217f");
                this.h218 = json.getString("h218");
                this.h219t = json.getString("h219t");
                this.h219m = json.getString("h219m");
                this.h219f = json.getString("h219f");
                this.h220a = json.getString("h220a");
                this.h220b = json.getString("h220b");
                this.h220c = json.getString("h220c");
                this.h221 = json.getString("h221");
                this.h222d = json.getString("h222d");
                this.h222m = json.getString("h222m");
                this.h222y = json.getString("h222y");
                this.h223 = json.getString("h223");
                this.h224 = json.getString("h224");
                this.h225 = json.getString("h225");
                this.h226t = json.getString("h226t");
                this.h226m = json.getString("h226m");
                this.h226f = json.getString("h226f");
                this.h227 = json.getString("h227");
                this.h228 = json.getString("h228");
                this.h229 = json.getString("h229");
                this.h230d = json.getString("h230d");
                this.h230m = json.getString("h230m");
                this.h230y = json.getString("h230y");
                this.h231y = json.getString("h231y");
                this.h231m = json.getString("h231m");
                this.h231d = json.getString("h231d");
                this.h232 = json.getString("h232");
                this.h233 = json.getString("h233");
                this.h301 = json.getString("h301");
                this.h30196x = json.getString("h30196x");
                this.h302 = json.getString("h302");
                this.h30296x = json.getString("h30296x");
                this.h303 = json.getString("h303");
                this.h30396x = json.getString("h30396x");
                this.h304 = json.getString("h304");
                this.h305 = json.getString("h305");
                this.h306 = json.getString("h306");
                this.h30696x = json.getString("h30696x");
                this.h307 = json.getString("h307");
                this.h30796x = json.getString("h30796x");
                this.h308 = json.getString("h308");
                this.h309 = json.getString("h309");
                this.h310 = json.getString("h310");
                this.h31096x = json.getString("h31096x");
                this.h311a = json.getString("h311a");
                this.h311b = json.getString("h311b");
                this.h311c = json.getString("h311c");
                this.h311d = json.getString("h311d");
                this.h311e = json.getString("h311e");
                this.h311f = json.getString("h311f");
                this.h311g = json.getString("h311g");
                this.h311h = json.getString("h311h");
                this.h311i = json.getString("h311i");
                this.h311j = json.getString("h311j");
                this.h311k = json.getString("h311k");
                this.h311l = json.getString("h311l");
                this.h311m = json.getString("h311m");
                this.h311n = json.getString("h311n");
                this.h311o = json.getString("h311o");
                this.h311p = json.getString("h311p");
                this.h311q = json.getString("h311q");
                this.h311r = json.getString("h311r");
                this.h311s = json.getString("h311s");
                this.h312a = json.getString("h312a");
                this.h312b = json.getString("h312b");
                this.h312c = json.getString("h312c");
                this.h312d = json.getString("h312d");
                this.h312e = json.getString("h312e");
                this.h312f = json.getString("h312f");
                this.h312g = json.getString("h312g");
                this.h313 = json.getString("h313");
                this.h313a = json.getString("h313a");
                this.h313b = json.getString("h313b");
                this.h313c = json.getString("h313c");
                this.h313d = json.getString("h313d");
                this.h313e = json.getString("h313e");
                this.h313f = json.getString("h313f");
                this.h31396 = json.getString("h31396");
                this.h31396x = json.getString("h31396x");
                this.h314 = json.getString("h314");
                this.h31496x = json.getString("h31496x");
                this.h315 = json.getString("h315");
                this.h31596x = json.getString("h31596x");
                this.h316 = json.getString("h316");
                this.h317 = json.getString("h317");
                this.h31796x = json.getString("h31796x");
                this.h318 = json.getString("h318");
                this.h31896x = json.getString("h31896x");
                this.h319 = json.getString("h319");
                this.h31996x = json.getString("h31996x");
                this.h320 = json.getString("h320");
                this.h321 = json.getString("h321");
                this.h322 = json.getString("h322");
                this.h322ax = json.getString("h322ax");
                this.h322bx = json.getString("h322bx");
                this.h323 = json.getString("h323");
                this.h324 = json.getString("h324");
                this.h3241 = json.getString("h3241");
                this.h3241x = json.getString("h3241x");
                this.h3242 = json.getString("h3242");
                this.h3242x = json.getString("h3242x");
                this.h3243 = json.getString("h3243");
                this.h3243x = json.getString("h3243x");
                this.h3244 = json.getString("h3244");
                this.h3244x = json.getString("h3244x");
                this.h3245 = json.getString("h3245");
                this.h3245x = json.getString("h3245x");
                this.h3246 = json.getString("h3246");
                this.h3246x = json.getString("h3246x");
                this.h3247 = json.getString("h3247");
                this.h3247x = json.getString("h3247x");
                this.h401 = json.getString("h401");
                this.h402 = json.getString("h402");
                this.h403 = json.getString("h403");
                this.h403a = json.getString("h403a");
                this.h403b = json.getString("h403b");
                this.h403c = json.getString("h403c");
                this.h403d = json.getString("h403d");
                this.h404 = json.getString("h404");
                this.h405 = json.getString("h405");
                this.h405a = json.getString("h405a");
                this.h405b = json.getString("h405b");
                this.h405c = json.getString("h405c");
                this.h405d = json.getString("h405d");
                this.h406f = json.getString("h406f");
                this.h406a = json.getString("h406a");
                this.h406b = json.getString("h406b");
                this.h406c = json.getString("h406c");
                this.h406d = json.getString("h406d");
                this.h406e = json.getString("h406e");
                this.h501 = json.getString("h501");
                this.h50196x = json.getString("h50196x");
                this.h502 = json.getString("h502");
                this.h503 = json.getString("h503");
                this.h601 = json.getString("h601");
                this.h602 = json.getString("h602");
                this.h603 = json.getString("h603");
                this.h604 = json.getString("h604");
                this.h605 = json.getString("h605");
                this.h606 = json.getString("h606");
                this.h607 = json.getString("h607 ");
                this.h608 = json.getString("h608");
                this.h609 = json.getString("h609");
                this.h610 = json.getString("h610");
                this.h611 = json.getString("h611");
                this.h612 = json.getString("h612");
                this.h613 = json.getString("h613");
                this.h614 = json.getString("h614");
                this.h615 = json.getString("h615");
                this.h616 = json.getString("h616");
                this.h617 = json.getString("h617");
                this.h618 = json.getString("h618");
                this.h701 = json.getString("h701");
                this.h701q = json.getString("h701q");
                this.h701s = json.getString("h701s");
                this.h702 = json.getString("h702");
                this.h702q = json.getString("h702q");
                this.h702s = json.getString("h702s");
                this.h703 = json.getString("h703");
                this.h703q = json.getString("h703q");
                this.h703s = json.getString("h703s");
                this.h704 = json.getString("h704");
                this.h704q = json.getString("h704q");
                this.h704s = json.getString("h704s");
                this.h705 = json.getString("h705");
                this.h705q = json.getString("h705q");
                this.h705s = json.getString("h705s");
                this.h706 = json.getString("h706");
                this.h706q = json.getString("h706q");
                this.h706s = json.getString("h706s");
                this.h707 = json.getString("h707");
                this.h707q = json.getString("h707q");
                this.h707s = json.getString("h707s");
                this.h708 = json.getString("h708");
                this.h708q = json.getString("h708q");
                this.h708s = json.getString("h708s");
                this.h709 = json.getString("h709");
                this.h709q = json.getString("h709q");
                this.h709s = json.getString("h709s");
                this.h710 = json.getString("h710");
                this.h710q = json.getString("h710q");
                this.h710s = json.getString("h710s");
                this.h711 = json.getString("h711");
                this.h711q = json.getString("h711q");
                this.h711s = json.getString("h711s");
                this.h712 = json.getString("h712");
                this.h712q = json.getString("h712q");
                this.h712s = json.getString("h712s");
                this.h713a = json.getString("h713a");
                this.h713b = json.getString("h713b");
                this.h713c = json.getString("h713c");
                this.h713d = json.getString("h713d");
                this.h714a = json.getString("h714a");
                this.h714b = json.getString("h714b");
                this.h714c = json.getString("h714c");
                this.h714d = json.getString("h714d");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s2Hydrate(String string) {
        Log.d(TAG, "s2Hydrate: " + string);
        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.w101d = json.getString("w101d");
                this.w101m = json.getString("w101m");
                this.w101y = json.getString("w101y");
                this.w102 = json.getString("w102");
                this.w103 = json.getString("w103");
                this.w104 = json.getString("w104");
                this.w105 = json.getString("w105");
                this.w106 = json.getString("w106");
                this.w107 = json.getString("w107");
                this.w108 = json.getString("w108");
                this.w109 = json.getString("w109");
                this.w110 = json.getString("w110");
                this.w111 = json.getString("w111");
                this.w112 = json.getString("w112");
                this.w113 = json.getString("w113");
                this.w114d = json.getString("w114d");
                this.w114m = json.getString("w114m");
                this.w114y = json.getString("w114y");
                this.w115 = json.getString("w115");
                this.w116 = json.getString("w116");
                this.w117y = json.getString("w117y");
                this.w117m = json.getString("w117m");
                this.w117d = json.getString("w117d");
                this.w118y = json.getString("w118y");
                this.w118m = json.getString("w118m");
                this.w118d = json.getString("w118d");
                this.w201 = json.getString("w201");
                this.w202 = json.getString("w202");
                this.w202a = json.getString("w202a");
                this.w202b = json.getString("w202b");
                this.w202c = json.getString("w202c");
                this.w202d = json.getString("w202d");
                this.w202e = json.getString("w202e");
                this.w202f = json.getString("w202f");
                this.w202g = json.getString("w202g");
                this.w202h = json.getString("w202h");
                this.w20296 = json.getString("w20296");
                this.w20296x = json.getString("w20296x");
                this.w203 = json.getString("w203");
                this.w203961x = json.getString("w203961x");
                this.w203962x = json.getString("w203962x");
                this.w203963x = json.getString("w203963x");
                this.w204 = json.getString("w204");
                this.w204wx = json.getString("w204wx");
                this.w204mx = json.getString("w204mx");
                this.w205 = json.getString("w205");
                this.w205ax = json.getString("w205ax");
                this.w206 = json.getString("w206");
                this.w20696x = json.getString("w20696x");
                this.w20601 = json.getString("w20601");
                this.w20602 = json.getString("w20602");
                this.w20603 = json.getString("w20603");
                this.w20604 = json.getString("w20604");
                this.w20605 = json.getString("w20605");
                this.w20606 = json.getString("w20606");
                this.w20607 = json.getString("w20607");
                this.w20608 = json.getString("w20608");
                this.w207 = json.getString("w207");
                this.w208 = json.getString("w208");
                this.w209 = json.getString("w209");
                this.w20996x = json.getString("w20996x");
                this.w210 = json.getString("w210");
                this.w210961 = json.getString("w210961");
                this.w210961x = json.getString("w210961x");
                this.w210962 = json.getString("w210962");
                this.w210962x = json.getString("w210962x");
                this.w210963 = json.getString("w210963");
                this.w210963x = json.getString("w210963x");
                this.w211 = json.getString("w211");
                this.w212 = json.getString("w212");
                this.w212mx = json.getString("w212mx");
                this.w212dx = json.getString("w212dx");
                this.w213 = json.getString("w213");
                this.w214 = json.getString("w214");
                this.w21496x = json.getString("w21496x");
                this.w215 = json.getString("w215");
                this.w215961 = json.getString("w215961");
                this.w215961x = json.getString("w215961x");
                this.w215962 = json.getString("w215962");
                this.w215962x = json.getString("w215962x");
                this.w215963 = json.getString("w215963");
                this.w215963x = json.getString("w215963x");
                this.w216 = json.getString("w216");
                this.w217 = json.getString("w217");
                this.w217mx = json.getString("w217mx");
                this.w217dx = json.getString("w217dx");
                this.w218 = json.getString("w218");
                this.w219 = json.getString("w219");
                this.w220 = json.getString("w220");
                this.w221 = json.getString("w221");
                this.w221mx = json.getString("w221mx");
                this.w221dx = json.getString("w221dx");
                this.w222 = json.getString("w222");
                this.w22296x = json.getString("w22296x");
                this.w223 = json.getString("w223");
                this.w223a = json.getString("w223a");
                this.w223b = json.getString("w223b");
                this.w223c = json.getString("w223c");
                this.w223d = json.getString("w223d");
                this.w223e = json.getString("w223e");
                this.w223f = json.getString("w223f");
                this.w223g = json.getString("w223g");
                this.w223h = json.getString("w223h");
                this.w224 = json.getString("w224");
                this.w225 = json.getString("w225");
                this.w226 = json.getString("w226");
                this.w301 = json.getString("w301");
                this.w30196x = json.getString("w30196x");
                this.w302 = json.getString("w302");
                this.w302a = json.getString("w302a");
                this.w302b = json.getString("w302b");
                this.w302c = json.getString("w302c");
                this.w302d = json.getString("w302d");
                this.w302e = json.getString("w302e");
                this.w302f = json.getString("w302f");
                this.w302g = json.getString("w302g");
                this.w30296 = json.getString("w30296");
                this.w30296x = json.getString("w30296x");
                this.w30299 = json.getString("w30299");
                this.w303 = json.getString("w303");
                this.w303961x = json.getString("w303961x");
                this.w303962x = json.getString("w303962x");
                this.w303963x = json.getString("w303963x");
                this.w304 = json.getString("w304");
                this.w305 = json.getString("w305");
                this.w306 = json.getString("w306");
                this.w307 = json.getString("w307");
                this.w307ax = json.getString("w307ax");
                this.w307bx = json.getString("w307bx");
                this.w308 = json.getString("w308");
                this.w309 = json.getString("w309");
                this.w310 = json.getString("w310");
                this.w311 = json.getString("w311");
                this.w311hx = json.getString("w311hx");
                this.w311dx = json.getString("w311dx");
                this.w312 = json.getString("w312");
                this.w313 = json.getString("w313");
                this.w313a = json.getString("w313a");
                this.w313b = json.getString("w313b");
                this.w313c = json.getString("w313c");
                this.w313d = json.getString("w313d");
                this.w313e = json.getString("w313e");
                this.w31396 = json.getString("w31396");
                this.w31396x = json.getString("w31396x");
                this.w31398 = json.getString("w31398");
                this.w314 = json.getString("w314");
                this.w314961x = json.getString("w314961x");
                this.w314962x = json.getString("w314962x");
                this.w314963x = json.getString("w314963x");
                this.w315 = json.getString("w315");
                this.w316 = json.getString("w316");
                this.w316a = json.getString("w316a");
                this.w316b = json.getString("w316b");
                this.w316c = json.getString("w316c");
                this.w316d = json.getString("w316d");
                this.w316e = json.getString("w316e");
                this.w316f = json.getString("w316f");
                this.w316g = json.getString("w316g");
                this.w316h = json.getString("w316h");
                this.w31696 = json.getString("w31696");
                this.w31696x = json.getString("w31696x");
                this.w317 = json.getString("w317");
                this.w317hx = json.getString("w317hx");
                this.w317dx = json.getString("w317dx");
                this.w317wx = json.getString("w317wx");
                this.w318 = json.getString("w318");
                this.w319 = json.getString("w319");
                this.w319a = json.getString("w319a");
                this.w319b = json.getString("w319b");
                this.w319c = json.getString("w319c");
                this.w319d = json.getString("w319d");
                this.w319e = json.getString("w319e");
                this.w319f = json.getString("w319f");
                this.w319g = json.getString("w319g");
                this.w319h = json.getString("w319h");
                this.w31996 = json.getString("w31996");
                this.w31996x = json.getString("w31996x");
                this.w320 = json.getString("w320");
                this.w321 = json.getString("w321");
                this.w321a = json.getString("w321a");
                this.w321b = json.getString("w321b");
                this.w321c = json.getString("w321c");
                this.w321d = json.getString("w321d");
                this.w321e = json.getString("w321e");
                this.w321f = json.getString("w321f");
                this.w321g = json.getString("w321g");
                this.w321h = json.getString("w321h");
                this.w32196 = json.getString("w32196");
                this.w32196x = json.getString("w32196x");
                this.w322 = json.getString("w322");
                this.w322hx = json.getString("w322hx");
                this.w322dx = json.getString("w322dx");
                this.w322wx = json.getString("w322wx");
                this.w323 = json.getString("w323");
                this.w324 = json.getString("w324");
                this.w324a = json.getString("w324a");
                this.w324b = json.getString("w324b");
                this.w324c = json.getString("w324c");
                this.w324d = json.getString("w324d");
                this.w32496 = json.getString("w32496");
                this.w32496x = json.getString("w32496x");
                this.w325 = json.getString("w325");
                this.w326 = json.getString("w326");
                this.w327 = json.getString("w327");
                this.w32796x = json.getString("w32796x");
                this.w401 = json.getString("w401");
                this.w401a = json.getString("w401a");
                this.w401b = json.getString("w401b");
                this.w401c = json.getString("w401c");
                this.w401d = json.getString("w401d");
                this.w401e = json.getString("w401e");
                this.w401f = json.getString("w401f");
                this.w401g = json.getString("w401g");
                this.w40198 = json.getString("w40198");
                this.w402 = json.getString("w402");
                this.w402a = json.getString("w402a");
                this.w402b = json.getString("w402b");
                this.w402c = json.getString("w402c");
                this.w402d = json.getString("w402d");
                this.w402e = json.getString("w402e");
                this.w402f = json.getString("w402f");
                this.w402g = json.getString("w402g");
                this.w40298 = json.getString("w40298");
                this.w403 = json.getString("w403");
                this.w403a = json.getString("w403a");
                this.w403b = json.getString("w403b");
                this.w403c = json.getString("w403c");
                this.w403d = json.getString("w403d");
                this.w403e = json.getString("w403e");
                this.w403f = json.getString("w403f");
                this.w403g = json.getString("w403g");
                this.w40398 = json.getString("w40398");
                this.w404 = json.getString("w404");
                this.w404a = json.getString("w404a");
                this.w404b = json.getString("w404b");
                this.w404c = json.getString("w404c");
                this.w404d = json.getString("w404d");
                this.w404e = json.getString("w404e");
                this.w404f = json.getString("w404f");
                this.w404g = json.getString("w404g");
                this.w40498 = json.getString("w40498");
                this.w405 = json.getString("w405");
                this.w405a = json.getString("w405a");
                this.w405b = json.getString("w405b");
                this.w405c = json.getString("w405c");
                this.w405d = json.getString("w405d");
                this.w405e = json.getString("w405e");
                this.w405f = json.getString("w405f");
                this.w405g = json.getString("w405g");
                this.w40598 = json.getString("w40598");
                this.w406 = json.getString("w406");
                this.w406a = json.getString("w406a");
                this.w406b = json.getString("w406b");
                this.w406c = json.getString("w406c");
                this.w406d = json.getString("w406d");
                this.w406e = json.getString("w406e");
                this.w406f = json.getString("w406f");
                this.w406g = json.getString("w406g");
                this.w40698 = json.getString("w40698");
                this.w407 = json.getString("w407");
                this.w407a = json.getString("w407a");
                this.w407b = json.getString("w407b");
                this.w407c = json.getString("w407c");
                this.w407d = json.getString("w407d");
                this.w407e = json.getString("w407e");
                this.w407f = json.getString("w407f");
                this.w407g = json.getString("w407g");
                this.w40798 = json.getString("w40798");
                this.w408 = json.getString("w408");
                this.w408a = json.getString("w408a");
                this.w408b = json.getString("w408b");
                this.w408c = json.getString("w408c");
                this.w408d = json.getString("w408d");
                this.w408e = json.getString("w408e");
                this.w408f = json.getString("w408f");
                this.w408g = json.getString("w408g");
                this.w40898 = json.getString("w40898");
                this.w409 = json.getString("w409");
                this.w409a = json.getString("w409a");
                this.w409b = json.getString("w409b");
                this.w409c = json.getString("w409c");
                this.w409d = json.getString("w409d");
                this.w409e = json.getString("w409e");
                this.w409f = json.getString("w409f");
                this.w409g = json.getString("w409g");
                this.w40998 = json.getString("w40998");
                this.w410 = json.getString("w410");
                this.w410a = json.getString("w410a");
                this.w410b = json.getString("w410b");
                this.w410c = json.getString("w410c");
                this.w410d = json.getString("w410d");
                this.w410e = json.getString("w410e");
                this.w410f = json.getString("w410f");
                this.w410g = json.getString("w410g");
                this.w41098 = json.getString("w41098");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s3Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.c101 = json.getString("c101");
                this.c102 = json.getString("c102");
                this.c103 = json.getString("c103");
                this.c104 = json.getString("c104");
                this.c105 = json.getString("c105");
                this.c106a = json.getString("c106a");
                this.c106b = json.getString("c106b");
                this.c106ca = json.getString("c106ca");
                this.c106d = json.getString("c106d");
                this.c106ea = json.getString("c106ea");
                this.c106f = json.getString("c106f");
                this.c106g = json.getString("c106g");
                this.c106ha = json.getString("c106ha");
                this.c106i = json.getString("c106i");
                this.c106j = json.getString("c106j");
                this.c106k = json.getString("c106k");
                this.c106l = json.getString("c106l");
                this.c106m = json.getString("c106m");
                this.c106n = json.getString("c106n");
                this.c106o = json.getString("c106o");
                this.c106p = json.getString("c106p");
                this.c106q = json.getString("c106q");
                this.c107a = json.getString("c107a");
                this.c107b = json.getString("c107b");
                this.c107c = json.getString("c107c");
                this.c107d = json.getString("c107d");
                this.c107e = json.getString("c107e");
                this.c107f = json.getString("c107f");
                this.c107g = json.getString("c107g");
                this.c107h = json.getString("c107h");
                this.c107j = json.getString("c107j");
                this.c107i = json.getString("c107i");
                this.c107k = json.getString("c107k");
                this.c107l = json.getString("c107l");
                this.c107m = json.getString("c107m");
                this.c107n = json.getString("c107n");
                this.c107o = json.getString("c107o");
                this.c107p = json.getString("c107p");
                this.c107q = json.getString("c107q");
                this.c107r = json.getString("c107r");
                this.c107s = json.getString("c107s");
                this.c108 = json.getString("c108");
                this.c109 = json.getString("c109");
                this.c201 = json.getString("c201");
                this.c202 = json.getString("c202");
                this.c20301a = json.getString("c20301a");
                this.c20301b = json.getString("c20301b");
                this.c20301ba = json.getString("c20301ba");
                this.c20301bb = json.getString("c20301bb");
                this.c20301bc = json.getString("c20301bc");
                this.c20301bd = json.getString("c20301bd");
                this.c20301be = json.getString("c20301be");
                this.c20301bf = json.getString("c20301bf");
                this.c20301bg = json.getString("c20301bg");
                this.c20302a = json.getString("c20302a");
                this.c20302b = json.getString("c20302b");
                this.c20302ba = json.getString("c20302ba");
                this.c20302bb = json.getString("c20302bb");
                this.c20302bc = json.getString("c20302bc");
                this.c20302bd = json.getString("c20302bd");
                this.c20302be = json.getString("c20302be");
                this.c20302bf = json.getString("c20302bf");
                this.c20302bg = json.getString("c20302bg");
                this.c20303a = json.getString("c20303a");
                this.c20303b = json.getString("c20303b");
                this.c20303ba = json.getString("c20303ba");
                this.c20303bb = json.getString("c20303bb");
                this.c20303bc = json.getString("c20303bc");
                this.c20303bd = json.getString("c20303bd");
                this.c20303be = json.getString("c20303be");
                this.c20303bf = json.getString("c20303bf");
                this.c20303bg = json.getString("c20303bg");
                this.c20304a = json.getString("c20304a");
                this.c20304b = json.getString("c20304b");
                this.c20304ba = json.getString("c20304ba");
                this.c20304bb = json.getString("c20304bb");
                this.c20304bc = json.getString("c20304bc");
                this.c20304bd = json.getString("c20304bd");
                this.c20304be = json.getString("c20304be");
                this.c20304bf = json.getString("c20304bf");
                this.c20304bg = json.getString("c20304bg");
                this.c20305a = json.getString("c20305a");
                this.c20305b = json.getString("c20305b");
                this.c20305ba = json.getString("c20305ba");
                this.c20305bb = json.getString("c20305bb");
                this.c20305bc = json.getString("c20305bc");
                this.c20305bd = json.getString("c20305bd");
                this.c20305be = json.getString("c20305be");
                this.c20305bf = json.getString("c20305bf");
                this.c20305bg = json.getString("c20305bg");
                this.c20306a = json.getString("c20306a");
                this.c20306b = json.getString("c20306b");
                this.c20306ba = json.getString("c20306ba");
                this.c20306bb = json.getString("c20306bb");
                this.c20306bc = json.getString("c20306bc");
                this.c20306bd = json.getString("c20306bd");
                this.c20306be = json.getString("c20306be");
                this.c20306bf = json.getString("c20306bf");
                this.c20306bg = json.getString("c20306bg");
                this.c20307a = json.getString("c20307a");
                this.c20307b = json.getString("c20307b");
                this.c20307ba = json.getString("c20307ba");
                this.c20307bb = json.getString("c20307bb");
                this.c20307bc = json.getString("c20307bc");
                this.c20307bd = json.getString("c20307bd");
                this.c20307be = json.getString("c20307be");
                this.c20307bf = json.getString("c20307bf");
                this.c20307bg = json.getString("c20307bg");
                this.c20308a = json.getString("c20308a");
                this.c20308b = json.getString("c20308b");
                this.c20308ba = json.getString("c20308ba");
                this.c20308bb = json.getString("c20308bb");
                this.c20308bc = json.getString("c20308bc");
                this.c20308bd = json.getString("c20308bd");
                this.c20308be = json.getString("c20308be");
                this.c20308bf = json.getString("c20308bf");
                this.c20308bg = json.getString("c20308bg");
                this.c20309a = json.getString("c20309a");
                this.c20309b = json.getString("c20309b");
                this.c20309ba = json.getString("c20309ba");
                this.c20309bb = json.getString("c20309bb");
                this.c20309bc = json.getString("c20309bc");
                this.c20309bd = json.getString("c20309bd");
                this.c20309be = json.getString("c20309be");
                this.c20309bf = json.getString("c20309bf");
                this.c20309bg = json.getString("c20309bg");
                this.c20310a = json.getString("c20310a");
                this.c20310b = json.getString("c20310b");
                this.c20310ba = json.getString("c20310ba");
                this.c20310bb = json.getString("c20310bb");
                this.c20310bc = json.getString("c20310bc");
                this.c20310bd = json.getString("c20310bd");
                this.c20310be = json.getString("c20310be");
                this.c20310bf = json.getString("c20310bf");
                this.c20310bg = json.getString("c20310bg");
                this.c20311a = json.getString("c20311a");
                this.c20311b = json.getString("c20311b");
                this.c20311ba = json.getString("c20311ba");
                this.c20311bb = json.getString("c20311bb");
                this.c20311bc = json.getString("c20311bc");
                this.c20311bd = json.getString("c20311bd");
                this.c20311be = json.getString("c20311be");
                this.c20311bf = json.getString("c20311bf");
                this.c20311bg = json.getString("c20311bg");
                this.c20312a = json.getString("c20312a");
                this.c20312b = json.getString("c20312b");
                this.c20312ba = json.getString("c20312ba");
                this.c20312bb = json.getString("c20312bb");
                this.c20312bc = json.getString("c20312bc");
                this.c20312bd = json.getString("c20312bd");
                this.c20312be = json.getString("c20312be");
                this.c20312bf = json.getString("c20312bf");
                this.c20312bg = json.getString("c20312bg");
                this.c20313a = json.getString("c20313a");
                this.c20313b = json.getString("c20313b");
                this.c20313ba = json.getString("c20313ba");
                this.c20313bb = json.getString("c20313bb");
                this.c20313bc = json.getString("c20313bc");
                this.c20313bd = json.getString("c20313bd");
                this.c20313be = json.getString("c20313be");
                this.c20313bf = json.getString("c20313bf");
                this.c20313bg = json.getString("c20313bg");
                this.c20314a = json.getString("c20314a");
                this.c20314b = json.getString("c20314b");
                this.c20314ba = json.getString("c20314ba");
                this.c20314bb = json.getString("c20314bb");
                this.c20314bc = json.getString("c20314bc");
                this.c20314bd = json.getString("c20314bd");
                this.c20314be = json.getString("c20314be");
                this.c20314bf = json.getString("c20314bf");
                this.c20314bg = json.getString("c20314bg");
                this.c20315a = json.getString("c20315a");
                this.c20315b = json.getString("c20315b");
                this.c20315ba = json.getString("c20315ba");
                this.c20315bb = json.getString("c20315bb");
                this.c20315bc = json.getString("c20315bc");
                this.c20315bd = json.getString("c20315bd");
                this.c20315be = json.getString("c20315be");
                this.c20315bf = json.getString("c20315bf");
                this.c20315bg = json.getString("c20315bg");
                this.c20316a = json.getString("c20316a");
                this.c20316b = json.getString("c20316b");
                this.c20316ba = json.getString("c20316ba");
                this.c20316bb = json.getString("c20316bb");
                this.c20316bc = json.getString("c20316bc");
                this.c20316bd = json.getString("c20316bd");
                this.c20316be = json.getString("c20316be");
                this.c20316bf = json.getString("c20316bf");
                this.c20316bg = json.getString("c20316bg");
                this.c20317a = json.getString("c20317a");
                this.c20317b = json.getString("c20317b");
                this.c20317ba = json.getString("c20317ba");
                this.c20317bb = json.getString("c20317bb");
                this.c20317bc = json.getString("c20317bc");
                this.c20317bd = json.getString("c20317bd");
                this.c20317be = json.getString("c20317be");
                this.c20317bf = json.getString("c20317bf");
                this.c20317bg = json.getString("c20317bg");
                this.c204 = json.getString("c204");
                this.c301 = json.getString("c301");
                this.c302 = json.getString("c302");
                this.c303 = json.getString("c303");
                this.c30396x = json.getString("c30396x");
                this.c304 = json.getString("c304");
                this.c304961x = json.getString("c304961x");
                this.c304962x = json.getString("c304962x");
                this.c304963x = json.getString("c304963x");
                this.c305 = json.getString("c305");
                this.c305a = json.getString("c305a");
                this.c305b = json.getString("c305b");
                this.c305c = json.getString("c305c");
                this.c305d = json.getString("c305d");
                this.c305e = json.getString("c305e");
                this.c305f = json.getString("c305f");
                this.c305g = json.getString("c305g");
                this.c305h = json.getString("c305h");
                this.c305i = json.getString("c305i");
                this.c305j = json.getString("c305j");
                this.c30596 = json.getString("c30596");
                this.c30596x = json.getString("c30596x");
                this.c306 = json.getString("c306");
                this.c307 = json.getString("c307");
                this.c308 = json.getString("c308");
                this.c30896x = json.getString("c30896x");
                this.c309 = json.getString("c309");
                this.c309961x = json.getString("c309961x");
                this.c309962x = json.getString("c309962x");
                this.c309963x = json.getString("c309963x");
                this.c310 = json.getString("c310");
                this.c310a = json.getString("c310a");
                this.c310b = json.getString("c310b");
                this.c310c = json.getString("c310c");
                this.c310d = json.getString("c310d");
                this.c310e = json.getString("c310e");
                this.c310f = json.getString("c310f");
                this.c310g = json.getString("c310g");
                this.c31096 = json.getString("c31096");
                this.c31096x = json.getString("c31096x");
                this.c311 = json.getString("c311");
                this.c312 = json.getString("c312");
                this.c313 = json.getString("c313");
                this.c31396x = json.getString("c31396x");
                this.c314 = json.getString("c314");
                this.c314961x = json.getString("c314961x");
                this.c314962x = json.getString("c314962x");
                this.c314963x = json.getString("c314963x");
                this.c315 = json.getString("c315");
                this.c315a = json.getString("c315a");
                this.c315b = json.getString("c315b");
                this.c315c = json.getString("c315c");
                this.c315d = json.getString("c315d");
                this.c315e = json.getString("c315e");
                this.c315f = json.getString("c315f");
                this.c315g = json.getString("c315g");
                this.c315h = json.getString("c315h");
                this.c31596 = json.getString("c31596");
                this.c31596x = json.getString("c31596x");
                this.c316 = json.getString("c316");
                this.c317 = json.getString("c317");
                this.c318 = json.getString("c318");
                this.c319 = json.getString("c319");
                this.c320 = json.getString("c320");
                this.c321 = json.getString("c321");
                this.c322 = json.getString("c322");
                this.c323 = json.getString("c323");
                this.c323mx = json.getString("c323mx");
                this.c323dx = json.getString("c323dx");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s4Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.d101 = json.getString("d101");
                this.d102 = json.getString("d102");
                this.d103 = json.getString("d103");
                this.d104 = json.getString("d104");
                this.d105 = json.getString("d105");
                this.d106 = json.getString("d106");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s5Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.e101 = json.getString("e101");
                this.e102 = json.getString("e102");
                this.e103 = json.getString("e103");
                this.e104 = json.getString("e104");
                this.e105 = json.getString("e105");
                this.e106 = json.getString("e106");
                this.e107 = json.getString("e107");
                this.e018 = json.getString("e018");
                this.e109 = json.getString("e109");
                this.e110 = json.getString("e110");
                this.e111 = json.getString("e111");
                this.e112 = json.getString("e112");
                this.e113 = json.getString("e113");
                this.e114 = json.getString("e114");
                this.e115 = json.getString("e115");
                this.e116 = json.getString("e116");
                this.e117 = json.getString("e117");
                this.e118 = json.getString("e118");
                this.e119 = json.getString("e119");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String s1toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("h101", h101)
                    .put("h102", h102)
                    .put("h103", h103)
                    .put("h104", h104)
                    .put("h105", h105)
                    .put("h106d", h106d)
                    .put("h106m", h106m)
                    .put("h106y", h106y)
                    .put("h107h", h107h)
                    .put("h107m", h107m)
                    .put("h108", h108)
                    .put("h109", h109)
                    .put("h110", h110)
                    .put("h111", h111)
                    .put("h112", h112)
                    .put("h11296x", h11296x)
                    .put("h201", h201)
                    .put("h202", h202)
                    .put("h203d", h203d)
                    .put("h203m", h203m)
                    .put("h203y", h203y)
                    .put("h204", h204)
                    .put("h205", h205)
                    .put("h206", h206)
                    .put("h207", h207)
                    .put("h208", h208)
                    .put("h209", h209)
                    .put("h210", h210)
                    .put("h211t", h211t)
                    .put("h211m", h211m)
                    .put("h211f", h211f)
                    .put("h212", h212)
                    .put("h213t", h213t)
                    .put("h213m", h213m)
                    .put("h213f", h213f)
                    .put("h214", h214)
                    .put("h215t", h215t)
                    .put("h215m", h215m)
                    .put("h215f", h215f)
                    .put("h216", h216)
                    .put("h217t", h217t)
                    .put("h217m", h217m)
                    .put("h217f", h217f)
                    .put("h218", h218)
                    .put("h219t", h219t)
                    .put("h219m", h219m)
                    .put("h219f", h219f)
                    .put("h220a", h220a)
                    .put("h220b", h220b)
                    .put("h220c", h220c)
                    .put("h221", h221)
                    .put("h222d", h222d)
                    .put("h222m", h222m)
                    .put("h222y", h222y)
                    .put("h223", h223)
                    .put("h224", h224)
                    .put("h225", h225)
                    .put("h226t", h226t)
                    .put("h226m", h226m)
                    .put("h226f", h226f)
                    .put("h227", h227)
                    .put("h228", h228)
                    .put("h229", h229)
                    .put("h230d", h230d)
                    .put("h230m", h230m)
                    .put("h230y", h230y)
                    .put("h231y", h231y)
                    .put("h231m", h231m)
                    .put("h231d", h231d)
                    .put("h232", h232)
                    .put("h233", h233)
                    .put("h301", h301)
                    .put("h30196x", h30196x)
                    .put("h302", h302)
                    .put("h30296x", h30296x)
                    .put("h303", h303)
                    .put("h30396x", h30396x)
                    .put("h304", h304)
                    .put("h305", h305)
                    .put("h306", h306)
                    .put("h30696x", h30696x)
                    .put("h307", h307)
                    .put("h30796x", h30796x)
                    .put("h308", h308)
                    .put("h309", h309)
                    .put("h310", h310)
                    .put("h31096x", h31096x)
                    .put("h311a", h311a)
                    .put("h311b", h311b)
                    .put("h311c", h311c)
                    .put("h311d", h311d)
                    .put("h311e", h311e)
                    .put("h311f", h311f)
                    .put("h311g", h311g)
                    .put("h311h", h311h)
                    .put("h311i", h311i)
                    .put("h311j", h311j)
                    .put("h311k", h311k)
                    .put("h311l", h311l)
                    .put("h311m", h311m)
                    .put("h311n", h311n)
                    .put("h311o", h311o)
                    .put("h311p", h311p)
                    .put("h311q", h311q)
                    .put("h311r", h311r)
                    .put("h311s", h311s)
                    .put("h312a", h312a)
                    .put("h312b", h312b)
                    .put("h312c", h312c)
                    .put("h312d", h312d)
                    .put("h312e", h312e)
                    .put("h312f", h312f)
                    .put("h312g", h312g)
                    .put("h313", h313)
                    .put("h313a", h313a)
                    .put("h313b", h313b)
                    .put("h313c", h313c)
                    .put("h313d", h313d)
                    .put("h313e", h313e)
                    .put("h313f", h313f)
                    .put("h31396", h31396)
                    .put("h31396x", h31396x)
                    .put("h314", h314)
                    .put("h31496x", h31496x)
                    .put("h315", h315)
                    .put("h31596x", h31596x)
                    .put("h316", h316)
                    .put("h317", h317)
                    .put("h31796x", h31796x)
                    .put("h318", h318)
                    .put("h31896x", h31896x)
                    .put("h319", h319)
                    .put("h31996x", h31996x)
                    .put("h320", h320)
                    .put("h321", h321)
                    .put("h322", h322)
                    .put("h322ax", h322ax)
                    .put("h322bx", h322bx)
                    .put("h323", h323)
                    .put("h324", h324)
                    .put("h3241", h3241)
                    .put("h3241x", h3241x)
                    .put("h3242", h3242)
                    .put("h3242x", h3242x)
                    .put("h3243", h3243)
                    .put("h3243x", h3243x)
                    .put("h3244", h3244)
                    .put("h3244x", h3244x)
                    .put("h3245", h3245)
                    .put("h3245x", h3245x)
                    .put("h3246", h3246)
                    .put("h3246x", h3246x)
                    .put("h3247", h3247)
                    .put("h3247x", h3247x)
                    .put("h401", h401)
                    .put("h402", h402)
                    .put("h403", h403)
                    .put("h403a", h403a)
                    .put("h403b", h403b)
                    .put("h403c", h403c)
                    .put("h403d", h403d)
                    .put("h404", h404)
                    .put("h405", h405)
                    .put("h405a", h405a)
                    .put("h405b", h405b)
                    .put("h405c", h405c)
                    .put("h405d", h405d)
                    .put("h406f", h406f)
                    .put("h406a", h406a)
                    .put("h406b", h406b)
                    .put("h406c", h406c)
                    .put("h406d", h406d)
                    .put("h406e", h406e)
                    .put("h501", h501)
                    .put("h50196x", h50196x)
                    .put("h502", h502)
                    .put("h503", h503)
                    .put("h601", h601)
                    .put("h602", h602)
                    .put("h603", h603)
                    .put("h604", h604)
                    .put("h605", h605)
                    .put("h606", h606)
                    .put("h607 ", h607)
                    .put("h608", h608)
                    .put("h609", h609)
                    .put("h610", h610)
                    .put("h611", h611)
                    .put("h612", h612)
                    .put("h613", h613)
                    .put("h614", h614)
                    .put("h615", h615)
                    .put("h616", h616)
                    .put("h617", h617)
                    .put("h618", h618)
                    .put("h701", h701)
                    .put("h701q", h701q)
                    .put("h701s", h701s)
                    .put("h702", h702)
                    .put("h702q", h702q)
                    .put("h702s", h702s)
                    .put("h703", h703)
                    .put("h703q", h703q)
                    .put("h703s", h703s)
                    .put("h704", h704)
                    .put("h704q", h704q)
                    .put("h704s", h704s)
                    .put("h705", h705)
                    .put("h705q", h705q)
                    .put("h705s", h705s)
                    .put("h706", h706)
                    .put("h706q", h706q)
                    .put("h706s", h706s)
                    .put("h707", h707)
                    .put("h707q", h707q)
                    .put("h707s", h707s)
                    .put("h708", h708)
                    .put("h708q", h708q)
                    .put("h708s", h708s)
                    .put("h709", h709)
                    .put("h709q", h709q)
                    .put("h709s", h709s)
                    .put("h710", h710)
                    .put("h710q", h710q)
                    .put("h710s", h710s)
                    .put("h711", h711)
                    .put("h711q", h711q)
                    .put("h711s", h711s)
                    .put("h712", h712)
                    .put("h712q", h712q)
                    .put("h712s", h712s)
                    .put("h713a", h713a)
                    .put("h713b", h713b)
                    .put("h713c", h713c)
                    .put("h713d", h713d)
                    .put("h714a", h714a)
                    .put("h714b", h714b)
                    .put("h714c", h714c)
                    .put("h714d", h714d);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public String s2toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("w101d", w101d)
                    .put("w101m", w101m)
                    .put("w101y", w101y)
                    .put("w102", w102)
                    .put("w103", w103)
                    .put("w104", w104)
                    .put("w105", w105)
                    .put("w106", w106)
                    .put("w107", w107)
                    .put("w108", w108)
                    .put("w109", w109)
                    .put("w110", w110)
                    .put("w111", w111)
                    .put("w112", w112)
                    .put("w113", w113)
                    .put("w114d", w114d)
                    .put("w114m", w114m)
                    .put("w114y", w114y)
                    .put("w115", w115)
                    .put("w116", w116)
                    .put("w117y", w117y)
                    .put("w117m", w117m)
                    .put("w117d", w117d)
                    .put("w118y", w118y)
                    .put("w118m", w118m)
                    .put("w118d", w118d)
                    .put("w201", w201)
                    .put("w202", w202)
                    .put("w202a", w202a)
                    .put("w202b", w202b)
                    .put("w202c", w202c)
                    .put("w202d", w202d)
                    .put("w202e", w202e)
                    .put("w202f", w202f)
                    .put("w202g", w202g)
                    .put("w202h", w202h)
                    .put("w20296", w20296)
                    .put("w20296x", w20296x)
                    .put("w203", w203)
                    .put("w203961x", w203961x)
                    .put("w203962x", w203962x)
                    .put("w203963x", w203963x)
                    .put("w204", w204)
                    .put("w204wx", w204wx)
                    .put("w204mx", w204mx)
                    .put("w205", w205)
                    .put("w205ax", w205ax)
                    .put("w206", w206)
                    .put("w20696x", w20696x)
                    .put("w20601", w20601)
                    .put("w20602", w20602)
                    .put("w20603", w20603)
                    .put("w20604", w20604)
                    .put("w20605", w20605)
                    .put("w20606", w20606)
                    .put("w20607", w20607)
                    .put("w20608", w20608)
                    .put("w207", w207)
                    .put("w208", w208)
                    .put("w209", w209)
                    .put("w20996x", w20996x)
                    .put("w210", w210)
                    .put("w210961", w210961)
                    .put("w210961x", w210961x)
                    .put("w210962", w210962)
                    .put("w210962x", w210962x)
                    .put("w210963", w210963)
                    .put("w210963x", w210963x)
                    .put("w211", w211)
                    .put("w212", w212)
                    .put("w212mx", w212mx)
                    .put("w212dx", w212dx)
                    .put("w213", w213)
                    .put("w214", w214)
                    .put("w21496x", w21496x)
                    .put("w215", w215)
                    .put("w215961", w215961)
                    .put("w215961x", w215961x)
                    .put("w215962", w215962)
                    .put("w215962x", w215962x)
                    .put("w215963", w215963)
                    .put("w215963x", w215963x)
                    .put("w216", w216)
                    .put("w217", w217)
                    .put("w217mx", w217mx)
                    .put("w217dx", w217dx)
                    .put("w218", w218)
                    .put("w219", w219)
                    .put("w220", w220)
                    .put("w221", w221)
                    .put("w221mx", w221mx)
                    .put("w221dx", w221dx)
                    .put("w222", w222)
                    .put("w22296x", w22296x)
                    .put("w223", w223)
                    .put("w223a", w223a)
                    .put("w223b", w223b)
                    .put("w223c", w223c)
                    .put("w223d", w223d)
                    .put("w223e", w223e)
                    .put("w223f", w223f)
                    .put("w223g", w223g)
                    .put("w223h", w223h)
                    .put("w224", w224)
                    .put("w225", w225)
                    .put("w226", w226)
                    .put("w301", w301)
                    .put("w30196x", w30196x)
                    .put("w302", w302)
                    .put("w302a", w302a)
                    .put("w302b", w302b)
                    .put("w302c", w302c)
                    .put("w302d", w302d)
                    .put("w302e", w302e)
                    .put("w302f", w302f)
                    .put("w302g", w302g)
                    .put("w30296", w30296)
                    .put("w30296x", w30296x)
                    .put("w30299", w30299)
                    .put("w303", w303)
                    .put("w303961x", w303961x)
                    .put("w303962x", w303962x)
                    .put("w303963x", w303963x)
                    .put("w304", w304)
                    .put("w305", w305)
                    .put("w306", w306)
                    .put("w307", w307)
                    .put("w307ax", w307ax)
                    .put("w307bx", w307bx)
                    .put("w308", w308)
                    .put("w309", w309)
                    .put("w310", w310)
                    .put("w311", w311)
                    .put("w311hx", w311hx)
                    .put("w311dx", w311dx)
                    .put("w312", w312)
                    .put("w313", w313)
                    .put("w313a", w313a)
                    .put("w313b", w313b)
                    .put("w313c", w313c)
                    .put("w313d", w313d)
                    .put("w313e", w313e)
                    .put("w31396", w31396)
                    .put("w31396x", w31396x)
                    .put("w31398", w31398)
                    .put("w314", w314)
                    .put("w314961x", w314961x)
                    .put("w314962x", w314962x)
                    .put("w314963x", w314963x)
                    .put("w315", w315)
                    .put("w316", w316)
                    .put("w316a", w316a)
                    .put("w316b", w316b)
                    .put("w316c", w316c)
                    .put("w316d", w316d)
                    .put("w316e", w316e)
                    .put("w316f", w316f)
                    .put("w316g", w316g)
                    .put("w316h", w316h)
                    .put("w31696", w31696)
                    .put("w31696x", w31696x)
                    .put("w317", w317)
                    .put("w317hx", w317hx)
                    .put("w317dx", w317dx)
                    .put("w317wx", w317wx)
                    .put("w318", w318)
                    .put("w319", w319)
                    .put("w319a", w319a)
                    .put("w319b", w319b)
                    .put("w319c", w319c)
                    .put("w319d", w319d)
                    .put("w319e", w319e)
                    .put("w319f", w319f)
                    .put("w319g", w319g)
                    .put("w319h", w319h)
                    .put("w31996", w31996)
                    .put("w31996x", w31996x)
                    .put("w320", w320)
                    .put("w321", w321)
                    .put("w321a", w321a)
                    .put("w321b", w321b)
                    .put("w321c", w321c)
                    .put("w321d", w321d)
                    .put("w321e", w321e)
                    .put("w321f", w321f)
                    .put("w321g", w321g)
                    .put("w321h", w321h)
                    .put("w32196", w32196)
                    .put("w32196x", w32196x)
                    .put("w322", w322)
                    .put("w322hx", w322hx)
                    .put("w322dx", w322dx)
                    .put("w322wx", w322wx)
                    .put("w323", w323)
                    .put("w324", w324)
                    .put("w324a", w324a)
                    .put("w324b", w324b)
                    .put("w324c", w324c)
                    .put("w324d", w324d)
                    .put("w32496", w32496)
                    .put("w32496x", w32496x)
                    .put("w325", w325)
                    .put("w326", w326)
                    .put("w327", w327)
                    .put("w32796x", w32796x)
                    .put("w401", w401)
                    .put("w401a", w401a)
                    .put("w401b", w401b)
                    .put("w401c", w401c)
                    .put("w401d", w401d)
                    .put("w401e", w401e)
                    .put("w401f", w401f)
                    .put("w401g", w401g)
                    .put("w40198", w40198)
                    .put("w402", w402)
                    .put("w402a", w402a)
                    .put("w402b", w402b)
                    .put("w402c", w402c)
                    .put("w402d", w402d)
                    .put("w402e", w402e)
                    .put("w402f", w402f)
                    .put("w402g", w402g)
                    .put("w40298", w40298)
                    .put("w403", w403)
                    .put("w403a", w403a)
                    .put("w403b", w403b)
                    .put("w403c", w403c)
                    .put("w403d", w403d)
                    .put("w403e", w403e)
                    .put("w403f", w403f)
                    .put("w403g", w403g)
                    .put("w40398", w40398)
                    .put("w404", w404)
                    .put("w404a", w404a)
                    .put("w404b", w404b)
                    .put("w404c", w404c)
                    .put("w404d", w404d)
                    .put("w404e", w404e)
                    .put("w404f", w404f)
                    .put("w404g", w404g)
                    .put("w40498", w40498)
                    .put("w405", w405)
                    .put("w405a", w405a)
                    .put("w405b", w405b)
                    .put("w405c", w405c)
                    .put("w405d", w405d)
                    .put("w405e", w405e)
                    .put("w405f", w405f)
                    .put("w405g", w405g)
                    .put("w40598", w40598)
                    .put("w406", w406)
                    .put("w406a", w406a)
                    .put("w406b", w406b)
                    .put("w406c", w406c)
                    .put("w406d", w406d)
                    .put("w406e", w406e)
                    .put("w406f", w406f)
                    .put("w406g", w406g)
                    .put("w40698", w40698)
                    .put("w407", w407)
                    .put("w407a", w407a)
                    .put("w407b", w407b)
                    .put("w407c", w407c)
                    .put("w407d", w407d)
                    .put("w407e", w407e)
                    .put("w407f", w407f)
                    .put("w407g", w407g)
                    .put("w40798", w40798)
                    .put("w408", w408)
                    .put("w408a", w408a)
                    .put("w408b", w408b)
                    .put("w408c", w408c)
                    .put("w408d", w408d)
                    .put("w408e", w408e)
                    .put("w408f", w408f)
                    .put("w408g", w408g)
                    .put("w40898", w40898)
                    .put("w409", w409)
                    .put("w409a", w409a)
                    .put("w409b", w409b)
                    .put("w409c", w409c)
                    .put("w409d", w409d)
                    .put("w409e", w409e)
                    .put("w409f", w409f)
                    .put("w409g", w409g)
                    .put("w40998", w40998)
                    .put("w410", w410)
                    .put("w410a", w410a)
                    .put("w410b", w410b)
                    .put("w410c", w410c)
                    .put("w410d", w410d)
                    .put("w410e", w410e)
                    .put("w410f", w410f)
                    .put("w410g", w410g)
                    .put("w41098", w41098);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public String s3toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("c101", c101)
                    .put("c102", c102)
                    .put("c103", c103)
                    .put("c104", c104)
                    .put("c105", c105)
                    .put("c106a", c106a)
                    .put("c106b", c106b)
                    .put("c106ca", c106ca)
                    .put("c106d", c106d)
                    .put("c106ea", c106ea)
                    .put("c106f", c106f)
                    .put("c106g", c106g)
                    .put("c106ha", c106ha)
                    .put("c106i", c106i)
                    .put("c106j", c106j)
                    .put("c106k", c106k)
                    .put("c106l", c106l)
                    .put("c106m", c106m)
                    .put("c106n", c106n)
                    .put("c106o", c106o)
                    .put("c106p", c106p)
                    .put("c106q", c106q)
                    .put("c107a", c107a)
                    .put("c107b", c107b)
                    .put("c107c", c107c)
                    .put("c107d", c107d)
                    .put("c107e", c107e)
                    .put("c107f", c107f)
                    .put("c107g", c107g)
                    .put("c107h", c107h)
                    .put("c107j", c107j)
                    .put("c107i", c107i)
                    .put("c107k", c107k)
                    .put("c107l", c107l)
                    .put("c107m", c107m)
                    .put("c107n", c107n)
                    .put("c107o", c107o)
                    .put("c107p", c107p)
                    .put("c107q", c107q)
                    .put("c107r", c107r)
                    .put("c107s", c107s)
                    .put("c108", c108)
                    .put("c109", c109)
                    .put("c201", c201)
                    .put("c202", c202)
                    .put("c20301a", c20301a)
                    .put("c20301b", c20301b)
                    .put("c20301ba", c20301ba)
                    .put("c20301bb", c20301bb)
                    .put("c20301bc", c20301bc)
                    .put("c20301bd", c20301bd)
                    .put("c20301be", c20301be)
                    .put("c20301bf", c20301bf)
                    .put("c20301bg", c20301bg)
                    .put("c20302a", c20302a)
                    .put("c20302b", c20302b)
                    .put("c20302ba", c20302ba)
                    .put("c20302bb", c20302bb)
                    .put("c20302bc", c20302bc)
                    .put("c20302bd", c20302bd)
                    .put("c20302be", c20302be)
                    .put("c20302bf", c20302bf)
                    .put("c20302bg", c20302bg)
                    .put("c20303a", c20303a)
                    .put("c20303b", c20303b)
                    .put("c20303ba", c20303ba)
                    .put("c20303bb", c20303bb)
                    .put("c20303bc", c20303bc)
                    .put("c20303bd", c20303bd)
                    .put("c20303be", c20303be)
                    .put("c20303bf", c20303bf)
                    .put("c20303bg", c20303bg)
                    .put("c20304a", c20304a)
                    .put("c20304b", c20304b)
                    .put("c20304ba", c20304ba)
                    .put("c20304bb", c20304bb)
                    .put("c20304bc", c20304bc)
                    .put("c20304bd", c20304bd)
                    .put("c20304be", c20304be)
                    .put("c20304bf", c20304bf)
                    .put("c20304bg", c20304bg)
                    .put("c20305a", c20305a)
                    .put("c20305b", c20305b)
                    .put("c20305ba", c20305ba)
                    .put("c20305bb", c20305bb)
                    .put("c20305bc", c20305bc)
                    .put("c20305bd", c20305bd)
                    .put("c20305be", c20305be)
                    .put("c20305bf", c20305bf)
                    .put("c20305bg", c20305bg)
                    .put("c20306a", c20306a)
                    .put("c20306b", c20306b)
                    .put("c20306ba", c20306ba)
                    .put("c20306bb", c20306bb)
                    .put("c20306bc", c20306bc)
                    .put("c20306bd", c20306bd)
                    .put("c20306be", c20306be)
                    .put("c20306bf", c20306bf)
                    .put("c20306bg", c20306bg)
                    .put("c20307a", c20307a)
                    .put("c20307b", c20307b)
                    .put("c20307ba", c20307ba)
                    .put("c20307bb", c20307bb)
                    .put("c20307bc", c20307bc)
                    .put("c20307bd", c20307bd)
                    .put("c20307be", c20307be)
                    .put("c20307bf", c20307bf)
                    .put("c20307bg", c20307bg)
                    .put("c20308a", c20308a)
                    .put("c20308b", c20308b)
                    .put("c20308ba", c20308ba)
                    .put("c20308bb", c20308bb)
                    .put("c20308bc", c20308bc)
                    .put("c20308bd", c20308bd)
                    .put("c20308be", c20308be)
                    .put("c20308bf", c20308bf)
                    .put("c20308bg", c20308bg)
                    .put("c20309a", c20309a)
                    .put("c20309b", c20309b)
                    .put("c20309ba", c20309ba)
                    .put("c20309bb", c20309bb)
                    .put("c20309bc", c20309bc)
                    .put("c20309bd", c20309bd)
                    .put("c20309be", c20309be)
                    .put("c20309bf", c20309bf)
                    .put("c20309bg", c20309bg)
                    .put("c20310a", c20310a)
                    .put("c20310b", c20310b)
                    .put("c20310ba", c20310ba)
                    .put("c20310bb", c20310bb)
                    .put("c20310bc", c20310bc)
                    .put("c20310bd", c20310bd)
                    .put("c20310be", c20310be)
                    .put("c20310bf", c20310bf)
                    .put("c20310bg", c20310bg)
                    .put("c20311a", c20311a)
                    .put("c20311b", c20311b)
                    .put("c20311ba", c20311ba)
                    .put("c20311bb", c20311bb)
                    .put("c20311bc", c20311bc)
                    .put("c20311bd", c20311bd)
                    .put("c20311be", c20311be)
                    .put("c20311bf", c20311bf)
                    .put("c20311bg", c20311bg)
                    .put("c20312a", c20312a)
                    .put("c20312b", c20312b)
                    .put("c20312ba", c20312ba)
                    .put("c20312bb", c20312bb)
                    .put("c20312bc", c20312bc)
                    .put("c20312bd", c20312bd)
                    .put("c20312be", c20312be)
                    .put("c20312bf", c20312bf)
                    .put("c20312bg", c20312bg)
                    .put("c20313a", c20313a)
                    .put("c20313b", c20313b)
                    .put("c20313ba", c20313ba)
                    .put("c20313bb", c20313bb)
                    .put("c20313bc", c20313bc)
                    .put("c20313bd", c20313bd)
                    .put("c20313be", c20313be)
                    .put("c20313bf", c20313bf)
                    .put("c20313bg", c20313bg)
                    .put("c20314a", c20314a)
                    .put("c20314b", c20314b)
                    .put("c20314ba", c20314ba)
                    .put("c20314bb", c20314bb)
                    .put("c20314bc", c20314bc)
                    .put("c20314bd", c20314bd)
                    .put("c20314be", c20314be)
                    .put("c20314bf", c20314bf)
                    .put("c20314bg", c20314bg)
                    .put("c20315a", c20315a)
                    .put("c20315b", c20315b)
                    .put("c20315ba", c20315ba)
                    .put("c20315bb", c20315bb)
                    .put("c20315bc", c20315bc)
                    .put("c20315bd", c20315bd)
                    .put("c20315be", c20315be)
                    .put("c20315bf", c20315bf)
                    .put("c20315bg", c20315bg)
                    .put("c20316a", c20316a)
                    .put("c20316b", c20316b)
                    .put("c20316ba", c20316ba)
                    .put("c20316bb", c20316bb)
                    .put("c20316bc", c20316bc)
                    .put("c20316bd", c20316bd)
                    .put("c20316be", c20316be)
                    .put("c20316bf", c20316bf)
                    .put("c20316bg", c20316bg)
                    .put("c20317a", c20317a)
                    .put("c20317b", c20317b)
                    .put("c20317ba", c20317ba)
                    .put("c20317bb", c20317bb)
                    .put("c20317bc", c20317bc)
                    .put("c20317bd", c20317bd)
                    .put("c20317be", c20317be)
                    .put("c20317bf", c20317bf)
                    .put("c20317bg", c20317bg)
                    .put("c204", c204)
                    .put("c301", c301)
                    .put("c302", c302)
                    .put("c303", c303)
                    .put("c30396x", c30396x)
                    .put("c304", c304)
                    .put("c304961x", c304961x)
                    .put("c304962x", c304962x)
                    .put("c304963x", c304963x)
                    .put("c305", c305)
                    .put("c305a", c305a)
                    .put("c305b", c305b)
                    .put("c305c", c305c)
                    .put("c305d", c305d)
                    .put("c305e", c305e)
                    .put("c305f", c305f)
                    .put("c305g", c305g)
                    .put("c305h", c305h)
                    .put("c305i", c305i)
                    .put("c305j", c305j)
                    .put("c30596", c30596)
                    .put("c30596x", c30596x)
                    .put("c306", c306)
                    .put("c307", c307)
                    .put("c308", c308)
                    .put("c30896x", c30896x)
                    .put("c309", c309)
                    .put("c309961x", c309961x)
                    .put("c309962x", c309962x)
                    .put("c309963x", c309963x)
                    .put("c310", c310)
                    .put("c310a", c310a)
                    .put("c310b", c310b)
                    .put("c310c", c310c)
                    .put("c310d", c310d)
                    .put("c310e", c310e)
                    .put("c310f", c310f)
                    .put("c310g", c310g)
                    .put("c31096", c31096)
                    .put("c31096x", c31096x)
                    .put("c311", c311)
                    .put("c312", c312)
                    .put("c313", c313)
                    .put("c31396x", c31396x)
                    .put("c314", c314)
                    .put("c314961x", c314961x)
                    .put("c314962x", c314962x)
                    .put("c314963x", c314963x)
                    .put("c315", c315)
                    .put("c315a", c315a)
                    .put("c315b", c315b)
                    .put("c315c", c315c)
                    .put("c315d", c315d)
                    .put("c315e", c315e)
                    .put("c315f", c315f)
                    .put("c315g", c315g)
                    .put("c315h", c315h)
                    .put("c31596", c31596)
                    .put("c31596x", c31596x)
                    .put("c316", c316)
                    .put("c317", c317)
                    .put("c318", c318)
                    .put("c319", c319)
                    .put("c320", c320)
                    .put("c321", c321)
                    .put("c322", c322)
                    .put("c323", c323)
                    .put("c323mx", c323mx)
                    .put("c323dx", c323dx);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public String s4toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("d101", d101)
                    .put("d102", d102)
                    .put("d103", d103)
                    .put("d104", d104)
                    .put("d105", d105)
                    .put("d106", d106);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public String s5toString() {
        JSONObject json = new JSONObject();

        try {
            json.put("e101", e101)
                    .put("e102", e102)
                    .put("e103", e103)
                    .put("e104", e104)
                    .put("e105", e105)
                    .put("e106", e106)
                    .put("e107", e107)
                    .put("e018", e018)
                    .put("e109", e109)
                    .put("e110", e110)
                    .put("e111", e111)
                    .put("e112", e112)
                    .put("e113", e113)
                    .put("e114", e114)
                    .put("e115", e115)
                    .put("e116", e116)
                    .put("e117", e117)
                    .put("e118", e118)
                    .put("e119", e119);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsTable.COLUMN_ID, this.id);
            json.put(FormsTable.COLUMN_UID, this.uid);
            json.put(FormsTable.COLUMN_USERNAME, this.userName);
            json.put(FormsTable.COLUMN_SYSDATE, this.sysDate);
            json.put(FormsTable.COLUMN_DEVICEID, this.deviceId);
            json.put(FormsTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(FormsTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(FormsTable.COLUMN_SYNCED, this.synced);
            //  json.put(FormsTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(FormsTable.COLUMN_S1, new JSONObject(s1toString()));
            //Log.d(TAG, "toJSONObject: "+new JSONObject(s2toString()));
            json.put(FormsTable.COLUMN_S2, new JSONObject(s2toString()));
            json.put(FormsTable.COLUMN_S3, new JSONObject(s3toString()));
            json.put(FormsTable.COLUMN_S4, new JSONObject(s4toString()));
            json.put(FormsTable.COLUMN_S5, new JSONObject(s5toString()));


            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "toJSONObject: " + e.getMessage());
            return null;
        }
    }
}
