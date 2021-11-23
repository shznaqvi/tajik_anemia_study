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
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.SamplesTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;

public class Samples extends BaseObservable {

    private final String TAG = "Samples";
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
    private String subjectName = StringUtils.EMPTY;
    private String sampleType = StringUtils.EMPTY;
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
    private String e101 = StringUtils.EMPTY;
    private String e102 = StringUtils.EMPTY;
    private String e103 = StringUtils.EMPTY;
    private String e104 = StringUtils.EMPTY;
    private String e105 = StringUtils.EMPTY;
    private String e106 = StringUtils.EMPTY;
    private String e107 = StringUtils.EMPTY;
    private String e108 = StringUtils.EMPTY;
    private String e109 = StringUtils.EMPTY;
    private String e110 = StringUtils.EMPTY;
    private String e111 = StringUtils.EMPTY;


    public Samples() {
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


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
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
    public String getE101() {
        return e101;
    }

    public void setE101(String e101) {
        this.e101 = e101;
        notifyPropertyChanged(BR.e101);
    }

    @Bindable
    public String getE102() {
        return e102;
    }

    public void setE102(String e102) {
        this.e102 = e102;
        this.cluster = e102;
        notifyPropertyChanged(BR.e102);
    }

    @Bindable
    public String getE103() {
        return e103;
    }

    public void setE103(String e103) {
        this.e103 = e103;
        this.hhid = e103;
        notifyPropertyChanged(BR.e103);
    }

    @Bindable
    public String getE104() {
        return e104;
    }

    public void setE104(String e104) {
        this.e104 = e104;
        this.subjectName = e104;
        notifyPropertyChanged(BR.e104);
    }

    @Bindable
    public String getE105() {
        return e105;
    }

    public void setE105(String e105) {
        this.e105 = e105;
        setSampleType(!e105.equals("") ? "3" : this.sampleType);
        setE106(e105.equals("1") ? this.e106 : "");
        setE101(e105.equals("1") ? this.e101 : "");
        setE107(e105.equals("1") ? this.e107 : "");
        setE108(e105.equals("1") ? this.e108 : "");
        notifyPropertyChanged(BR.e105);
    }

    @Bindable
    public String getE106() {
        return e106;
    }

    public void setE106(String e106) {
        this.e106 = e106;
        notifyPropertyChanged(BR.e106);
    }

    @Bindable
    public String getE107() {
        return e107;
    }

    public void setE107(String e107) {
        this.e107 = e107;
        notifyPropertyChanged(BR.e107);
    }

    @Bindable
    public String getE108() {
        return e108;
    }

    public void setE108(String e108) {
        this.e108 = e108;
        notifyPropertyChanged(BR.e018);
    }

    @Bindable
    public String getE109() {
        return e109;
    }

    public void setE109(String e109) {
        this.e109 = e109;
        setSampleType(!e109.equals("") ? "4" : this.sampleType);
        setE107(e109.equals("1") ? this.e107 : "");
        setE101(e109.equals("1") ? this.e101 : "");
        setE108(e109.equals("1") ? this.e108 : "");
        notifyPropertyChanged(BR.e109);
    }

    @Bindable
    public String getE110() {
        return e110;
    }

    public void setE110(String e110) {
        this.e110 = e110;
        notifyPropertyChanged(BR.e110);
    }

    @Bindable
    public String getE111() {
        return e111;
    }

    public void setE111(String e111) {
        this.e111 = e111;
        notifyPropertyChanged(BR.e111);
    }


    public Samples Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_UUID));
        this.cluster = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_USERNAME));
        this.subjectName = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_SUBJECTNAME));
        this.sampleType = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_SAMPLE_TYPE));
        this.sysDate = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(SamplesTable.COLUMN_S1)));
        return this;
    }


    public void s1Hydrate(String string) throws JSONException {

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
                this.e108 = json.getString("e108");
                this.e109 = json.getString("e109");
                this.e110 = json.getString("e110");
                this.e111 = json.getString("e111");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public String s1toString() throws JSONException {
        JSONObject json = new JSONObject();


        json.put("e101", e101)
                .put("e102", e102)
                .put("e103", e103)
                .put("e104", e104)
                .put("e105", e105)
                .put("e106", e106)
                .put("e107", e107)
                .put("e108", e108)
                .put("e109", e109)
                .put("e110", e110)
                .put("e111", e111);

        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(SamplesTable.COLUMN_ID, this.id);
            json.put(SamplesTable.COLUMN_UID, this.uid);
            json.put(SamplesTable.COLUMN_UUID, this.uuid);
            json.put(SamplesTable.COLUMN_CLUSTER, this.cluster);
            json.put(SamplesTable.COLUMN_HHID, this.hhid);
            json.put(SamplesTable.COLUMN_USERNAME, this.userName);
            json.put(SamplesTable.COLUMN_SUBJECTNAME, this.subjectName);
            json.put(SamplesTable.COLUMN_SAMPLE_TYPE, this.sampleType);
            json.put(SamplesTable.COLUMN_SYSDATE, this.sysDate);
            json.put(SamplesTable.COLUMN_DEVICEID, this.deviceId);
            json.put(SamplesTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(SamplesTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(SamplesTable.COLUMN_SYNCED, this.synced);
            //  json.put(SamplesTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(SamplesTable.COLUMN_S1, new JSONObject(s1toString()));
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "toJSONObject: " + e.getMessage());
            return null;
        }
    }

}
