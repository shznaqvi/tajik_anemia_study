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
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.PregnancyTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt;

public class Pregnancy extends BaseObservable {

    private final String TAG = "Pregnancy";
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
    private String w113 = StringUtils.EMPTY;
    private String w114d = StringUtils.EMPTY;
    private String w114m = StringUtils.EMPTY;
    private String w114y = StringUtils.EMPTY;
    private String w115 = StringUtils.EMPTY;
    private String w116 = StringUtils.EMPTY;
    private String w117y = StringUtils.EMPTY;
    private String w117m = StringUtils.EMPTY;
    private String w117d = StringUtils.EMPTY;
    private String w118y = StringUtils.EMPTY;
    private String w118m = StringUtils.EMPTY;
    private String w118d = StringUtils.EMPTY;


    public Pregnancy() {
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
    public String getW113() {
        return w113;
    }

    public void setW113(String w113) {
        this.w113 = w113;
        notifyPropertyChanged(BR.w113);
    }

    @Bindable
    public String getW114d() {
        return w114d;
    }

    public void setW114d(String w114d) {
        this.w114d = w114d;
        setAge();
        notifyPropertyChanged(BR.w114d);
    }

    @Bindable
    public String getW114m() {
        return w114m;
    }

    public void setW114m(String w114m) {
        this.w114m = w114m;
        setAge();
        notifyPropertyChanged(BR.w114m);
    }

    @Bindable
    public String getW114y() {
        return w114y;
    }

    public void setW114y(String w114y) {
        this.w114y = w114y;
        setAge();
        notifyPropertyChanged(BR.w114y);
    }

    public void setAge() {
        if ((this.w114y.length() == 4
                || !this.w114m.isEmpty()
                || !this.w114d.isEmpty())
                && (this.w115.equals("1")
                || this.w115.equals("3")
                || this.w115.equals("4"))
                && this.w116.equals("1")) {
            long x = DateUtilsKt.ageInDaysByDOB(this.w114y + "-" + this.w114m + "-" + this.w114d);
            setW117y(String.valueOf(x > 365 ? x / 365 : 0));
            setW117m(String.valueOf(((x % 365) / 30) > 0 ? ((x % 365) / 30) : 0));
            setW117d(String.valueOf(((x % 365) % 30) > 0 ? ((x % 365) % 30) : 0));
        } else {
            setW117y("");
            setW117m("");
            setW117d("");
        }
    }

    @Bindable
    public String getW115() {
        return w115;
    }

    public void setW115(String w115) {
        this.w115 = w115;
        setW116(w115.equals("1") ? this.w116
                : w115.equals("3") ? this.w116
                : w115.equals("4") ? this.w116
                : "");
        setAge();
        notifyPropertyChanged(BR.w115);
    }

    @Bindable
    public String getW116() {
        return w116;
    }

    public void setW116(String w116) {
        this.w116 = w116;
        setW117d(w116.equals("1") ? this.w117d : "");
        setW117m(w116.equals("1") ? this.w117m : "");
        setW117y(w116.equals("1") ? this.w117y : "");
        setW118d(w116.equals("2") ? this.w118d : "");
        setW118m(w116.equals("2") ? this.w118m : "");
        setW118y(w116.equals("2") ? this.w118y : "");
        setAge();
        notifyPropertyChanged(BR.w116);
    }

    @Bindable
    public String getW117y() {
        return w117y;
    }

    public void setW117y(String w117y) {
        this.w117y = w117y;
        notifyPropertyChanged(BR.w117y);
    }

    @Bindable
    public String getW117m() {
        return w117m;
    }

    public void setW117m(String w117m) {
        this.w117m = w117m;
        notifyPropertyChanged(BR.w117m);
    }

    @Bindable
    public String getW117d() {
        return w117d;
    }

    public void setW117d(String w117d) {
        this.w117d = w117d;
        notifyPropertyChanged(BR.w117d);
    }

    @Bindable
    public String getW118y() {
        return w118y;
    }

    public void setW118y(String w118y) {
        this.w118y = w118y;
        notifyPropertyChanged(BR.w118y);
    }

    @Bindable
    public String getW118m() {
        return w118m;
    }

    public void setW118m(String w118m) {
        this.w118m = w118m;
        notifyPropertyChanged(BR.w118m);
    }

    @Bindable
    public String getW118d() {
        return w118d;
    }

    public void setW118d(String w118d) {
        this.w118d = w118d;
        notifyPropertyChanged(BR.w118d);
    }


    public Pregnancy Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_UUID));
        this.muid = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_MUID));
        this.cluster = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(PregnancyTable.COLUMN_S1)));

        return this;
    }


    public void s1Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String s1toString() throws JSONException {
        JSONObject json = new JSONObject();


        json.put("w113", w113)
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
                .put("w118d", w118d);

        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(PregnancyTable.COLUMN_ID, this.id);
            json.put(PregnancyTable.COLUMN_UID, this.uid);
            json.put(PregnancyTable.COLUMN_UUID, this.uuid);
            json.put(PregnancyTable.COLUMN_MUID, this.muid);
            json.put(PregnancyTable.COLUMN_CLUSTER, this.cluster);
            json.put(PregnancyTable.COLUMN_HHID, this.hhid);
            json.put(PregnancyTable.COLUMN_USERNAME, this.userName);
            json.put(PregnancyTable.COLUMN_SYSDATE, this.sysDate);
            json.put(PregnancyTable.COLUMN_DEVICEID, this.deviceId);
            json.put(PregnancyTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(PregnancyTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(PregnancyTable.COLUMN_SYNCED, this.synced);
            //  json.put(PregnancyTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(PregnancyTable.COLUMN_S1, new JSONObject(s1toString()));
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "toJSONObject: " + e.getMessage());
            return null;
        }
    }
}
