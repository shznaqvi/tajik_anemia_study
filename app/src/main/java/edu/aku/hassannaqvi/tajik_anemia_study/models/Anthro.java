package edu.aku.hassannaqvi.tajik_anemia_study.models;

import android.database.Cursor;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.tajik_anemia_study.BR;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.AnthroTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;

public class Anthro extends BaseObservable {

    private final String TAG = "Anthro";
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
    private String subjectName = StringUtils.EMPTY;

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
    private String d101 = StringUtils.EMPTY;
    private String d102 = StringUtils.EMPTY;
    private String d103 = StringUtils.EMPTY;
    private String d104 = StringUtils.EMPTY;
    private String d105 = StringUtils.EMPTY;
    private String d106 = StringUtils.EMPTY;
    private String d107 = StringUtils.EMPTY;
    private String d108 = StringUtils.EMPTY;
    private String d109 = StringUtils.EMPTY;
    private String d110 = StringUtils.EMPTY;


    public Anthro() {
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

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
    public String getD101() {
        return d101;
    }

    public void setD101(String d101) {
        this.d101 = d101;
        notifyPropertyChanged(BR.d101);
    }

    @Bindable
    public String getD102() {
        return d102;
    }

    public void setD102(String d102) {
        this.d102 = d102;
        notifyPropertyChanged(BR.d102);
    }

    @Bindable
    public String getD103() {
        return d103;
    }

    public void setD103(String d103) {
        this.d103 = d103;
        notifyPropertyChanged(BR.d103);
    }

    @Bindable
    public String getD104() {
        return d104;
    }

    public void setD104(String d104) {
        this.d104 = d104;
        notifyPropertyChanged(BR.d104);
    }

    @Bindable
    public String getD105() {
        return d105;
    }

    public void setD105(String d105) {
        this.d105 = d105;
        notifyPropertyChanged(BR.d105);
    }

    @Bindable
    public String getD106() {
        return d106;
    }

    public void setD106(String d106) {
        this.d106 = d106;
        notifyPropertyChanged(BR.d106);
    }

    @Bindable
    public String getD107() {
        return d107;
    }

    public void setD107(String d107) {
        this.d107 = d107;
        notifyPropertyChanged(BR.d107);
    }

    @Bindable
    public String getD108() {
        return d108;
    }

    public void setD108(String d108) {
        this.d108 = d108;
        notifyPropertyChanged(BR.d108);
    }

    @Bindable
    public String getD109() {
        return d109;
    }

    public void setD109(String d109) {
        this.d109 = d109;
        notifyPropertyChanged(BR.d109);
    }

    @Bindable
    public String getD110() {
        return d110;
    }

    public void setD110(String d110) {
        this.d110 = d110;
        notifyPropertyChanged(BR.d110);
    }


    public Anthro Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_UUID));
        this.cluster = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_SYSDATE));
        this.subjectName = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_SUBJECTNAME));
        this.deviceId = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(AnthroTable.COLUMN_S1)));

        return this;
    }


    public void s1Hydrate(String string) throws JSONException {

        if (string != null) {

            JSONObject json = null;
            json = new JSONObject(string);
            this.d101 = json.getString("d101");
            this.d102 = json.getString("d102");
            this.d103 = json.getString("d103");
            this.d104 = json.getString("d104");
            this.d105 = json.getString("d105");
                this.d106 = json.getString("d106");
                this.d107 = json.getString("d107");
                this.d108 = json.getString("d108");
                this.d109 = json.getString("d109");
                this.d110 = json.getString("d110");

        }
    }


    public String s1toString() throws JSONException {
        JSONObject json = new JSONObject();

        json.put("d101", d101)
                .put("d102", d102)
                .put("d103", d103)
                .put("d104", d104)
                .put("d105", d105)
                .put("d106", d106)
                .put("d107", d107)
                .put("d108", d108)
                    .put("d109", d109)
                    .put("d110", d110);

        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(AnthroTable.COLUMN_ID, this.id);
        json.put(AnthroTable.COLUMN_UID, this.uid);
        json.put(AnthroTable.COLUMN_UUID, this.uuid);
        json.put(AnthroTable.COLUMN_CLUSTER, this.cluster);
        json.put(AnthroTable.COLUMN_HHID, this.hhid);
        json.put(AnthroTable.COLUMN_SUBJECTNAME, this.subjectName);
        json.put(AnthroTable.COLUMN_USERNAME, this.userName);
            json.put(AnthroTable.COLUMN_SYSDATE, this.sysDate);
            json.put(AnthroTable.COLUMN_DEVICEID, this.deviceId);
            json.put(AnthroTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(AnthroTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(AnthroTable.COLUMN_SYNCED, this.synced);
            //  json.put(AnthroTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(AnthroTable.COLUMN_S1, new JSONObject(s1toString()));
            return json;

    }
}
