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
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.ChildListTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;

public class Child extends BaseObservable {

    private final String TAG = "Child";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String uuid = StringUtils.EMPTY;
    private String muid = StringUtils.EMPTY;
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


    public Child() {
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

    public String getMuid() {
        return muid;
    }

    public void setMuid(String muid) {
        this.muid = muid;
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


    public Child Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_UUID));
        this.muid = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_MUID));
        this.cluster = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(ChildListTable.COLUMN_S1)));

        return this;
    }

    public void s1Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String s1toString() throws JSONException {
        JSONObject json = new JSONObject();


        json.put("h228", h228)
                .put("h229", h229)
                .put("h230d", h230d)
                .put("h230m", h230m)
                .put("h230y", h230y)
                .put("h231y", h231y)
                .put("h231m", h231m)
                    .put("h231d", h231d)
                    .put("h232", h232)
                    .put("h233", h233);

        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(ChildListTable.COLUMN_ID, this.id);
            json.put(ChildListTable.COLUMN_UID, this.uid);
            json.put(ChildListTable.COLUMN_UUID, this.uuid);
            json.put(ChildListTable.COLUMN_MUID, this.muid);
            json.put(ChildListTable.COLUMN_CLUSTER, this.cluster);
            json.put(ChildListTable.COLUMN_HHID, this.hhid);
            json.put(ChildListTable.COLUMN_USERNAME, this.userName);
            json.put(ChildListTable.COLUMN_SYSDATE, this.sysDate);
            json.put(ChildListTable.COLUMN_DEVICEID, this.deviceId);
            json.put(ChildListTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(ChildListTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(ChildListTable.COLUMN_SYNCED, this.synced);
            //  json.put(ChildListTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(ChildListTable.COLUMN_S1, new JSONObject(s1toString()));
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "toJSONObject: " + e.getMessage());
            return null;
        }
    }
}
