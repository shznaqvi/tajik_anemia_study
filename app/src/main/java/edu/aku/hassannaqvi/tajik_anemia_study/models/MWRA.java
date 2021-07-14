package edu.aku.hassannaqvi.tajik_anemia_study.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;

import edu.aku.hassannaqvi.tajik_anemia_study.BR;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.MWRAListTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;

public class MWRA extends BaseObservable {

    private final String TAG = "MWRA";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String uuid = StringUtils.EMPTY;
    private String cluster = StringUtils.EMPTY;
    private String hhid = StringUtils.EMPTY;
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
    private String h221 = StringUtils.EMPTY;
    private String h222d = StringUtils.EMPTY;
    private String h222m = StringUtils.EMPTY;
    private String h222y = StringUtils.EMPTY;
    private String h223 = StringUtils.EMPTY;
    private String h224 = StringUtils.EMPTY;
    private String h225 = StringUtils.EMPTY;
    private String h226t = StringUtils.EMPTY;
    private String h226m = StringUtils.EMPTY;
    private String h226f = StringUtils.EMPTY;
    private String h227 = StringUtils.EMPTY;
    //Not saving in DB
    private final LocalDate localDate = null;
    private final boolean exist = false;
    private boolean expanded;


    public MWRA() {
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Bindable
    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
        notifyPropertyChanged(BR.cluster);
    }

    @Bindable
    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
        notifyPropertyChanged(BR.hhid);
    }

    @Bindable
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        notifyPropertyChanged(BR.expanded);
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
    public String getH221() {
        return h221;
    }

    public void setH221(String h221) {
        this.h221 = h221;
        notifyPropertyChanged(BR.h221);
    }

    @Bindable
    public String getH222d() {
        return h222d;
    }

    public void setH222d(String h222d) {
        this.h222d = h222d;
        notifyPropertyChanged(BR.h222d);
    }

    @Bindable
    public String getH222m() {
        return h222m;
    }

    public void setH222m(String h222m) {
        this.h222m = h222m;
        notifyPropertyChanged(BR.h222m);
    }

    @Bindable
    public String getH222y() {
        return h222y;
    }

    public void setH222y(String h222y) {
        this.h222y = h222y;
        notifyPropertyChanged(BR.h222y);
    }

    @Bindable
    public String getH223() {
        return h223;
    }

    public void setH223(String h223) {
        this.h223 = h223;
        notifyPropertyChanged(BR.h223);
    }

    @Bindable
    public String getH224() {
        return h224;
    }

    public void setH224(String h224) {
        this.h224 = h224;
        notifyPropertyChanged(BR.h224);
    }

    @Bindable
    public String getH225() {
        return h225;
    }

    public void setH225(String h225) {
        this.h225 = h225;
        notifyPropertyChanged(BR.h225);
    }

    @Bindable
    public String getH226t() {
        return h226t;
    }

    public void setH226t(String h226t) {
        this.h226t = h226t;
        notifyPropertyChanged(BR.h226t);
    }

    @Bindable
    public String getH226m() {
        return h226m;
    }

    public void setH226m(String h226m) {
        this.h226m = h226m;
        notifyPropertyChanged(BR.h226m);
    }

    @Bindable
    public String getH226f() {
        return h226f;
    }

    public void setH226f(String h226f) {
        this.h226f = h226f;
        notifyPropertyChanged(BR.h226f);
    }

    @Bindable
    public String getH227() {
        return h227;
    }

    public void setH227(String h227) {
        this.h227 = h227;
        notifyPropertyChanged(BR.h227);
    }


    public MWRA Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_UUID));
        this.cluster = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(MWRAListTable.COLUMN_S1)));

        return this;
    }

    public void s1Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String s1toString() throws JSONException {
        JSONObject json = new JSONObject();


        json.put("h221", h221)
                .put("h222d", h222d)
                .put("h222m", h222m)
                .put("h222y", h222y)
                .put("h223", h223)
                .put("h224", h224)
                .put("h225", h225)
                    .put("h226t", h226t)
                    .put("h226m", h226m)
                    .put("h226f", h226f)
                    .put("h227", h227);

        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(MWRAListTable.COLUMN_ID, this.id);
            json.put(MWRAListTable.COLUMN_UID, this.uid);
            json.put(MWRAListTable.COLUMN_UUID, this.uuid);
            json.put(MWRAListTable.COLUMN_CLUSTER, this.cluster);
            json.put(MWRAListTable.COLUMN_HHID, this.hhid);
            json.put(MWRAListTable.COLUMN_USERNAME, this.userName);
            json.put(MWRAListTable.COLUMN_SYSDATE, this.sysDate);
            json.put(MWRAListTable.COLUMN_DEVICEID, this.deviceId);
            json.put(MWRAListTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(MWRAListTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(MWRAListTable.COLUMN_SYNCED, this.synced);
            //  json.put(MWRAListTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(MWRAListTable.COLUMN_S1, new JSONObject(s1toString()));
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "toJSONObject: " + e.getMessage());
            return null;
        }
    }
}
