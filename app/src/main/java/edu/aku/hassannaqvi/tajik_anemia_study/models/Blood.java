package edu.aku.hassannaqvi.tajik_anemia_study.models;

import android.database.Cursor;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.tajik_anemia_study.BR;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.BloodTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;

public class Blood extends BaseObservable {

    private final String TAG = "Blood";
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
    private String e101 = StringUtils.EMPTY;
    private String e102 = StringUtils.EMPTY;
    private String e103 = StringUtils.EMPTY;
    private String e104 = StringUtils.EMPTY;
    private String e105 = StringUtils.EMPTY;
    private String e106 = StringUtils.EMPTY;
    private String e107 = StringUtils.EMPTY;
    private String e018 = StringUtils.EMPTY;
    private String e109 = StringUtils.EMPTY;
    private String e110 = StringUtils.EMPTY;
    private String e111 = StringUtils.EMPTY;
    private String e112 = StringUtils.EMPTY;
    private String e113 = StringUtils.EMPTY;
    private String e114 = StringUtils.EMPTY;
    private String e115 = StringUtils.EMPTY;
    private String e116 = StringUtils.EMPTY;
    private String e117 = StringUtils.EMPTY;
    private String e118 = StringUtils.EMPTY;
    private String e119 = StringUtils.EMPTY;


    public Blood() {
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
        notifyPropertyChanged(BR.e102);
    }

    @Bindable
    public String getE103() {
        return e103;
    }

    public void setE103(String e103) {
        this.e103 = e103;
        notifyPropertyChanged(BR.e103);
    }

    @Bindable
    public String getE104() {
        return e104;
    }

    public void setE104(String e104) {
        this.e104 = e104;
        notifyPropertyChanged(BR.e104);
    }

    @Bindable
    public String getE105() {
        return e105;
    }

    public void setE105(String e105) {
        this.e105 = e105;
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
    public String getE018() {
        return e018;
    }

    public void setE018(String e018) {
        this.e018 = e018;
        notifyPropertyChanged(BR.e018);
    }

    @Bindable
    public String getE109() {
        return e109;
    }

    public void setE109(String e109) {
        this.e109 = e109;
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

    @Bindable
    public String getE112() {
        return e112;
    }

    public void setE112(String e112) {
        this.e112 = e112;
        notifyPropertyChanged(BR.e112);
    }

    @Bindable
    public String getE113() {
        return e113;
    }

    public void setE113(String e113) {
        this.e113 = e113;
        notifyPropertyChanged(BR.e113);
    }

    @Bindable
    public String getE114() {
        return e114;
    }

    public void setE114(String e114) {
        this.e114 = e114;
        notifyPropertyChanged(BR.e114);
    }

    @Bindable
    public String getE115() {
        return e115;
    }

    public void setE115(String e115) {
        this.e115 = e115;
        notifyPropertyChanged(BR.e115);
    }

    @Bindable
    public String getE116() {
        return e116;
    }

    public void setE116(String e116) {
        this.e116 = e116;
        notifyPropertyChanged(BR.e116);
    }

    @Bindable
    public String getE117() {
        return e117;
    }

    public void setE117(String e117) {
        this.e117 = e117;
        notifyPropertyChanged(BR.e117);
    }

    @Bindable
    public String getE118() {
        return e118;
    }

    public void setE118(String e118) {
        this.e118 = e118;
        notifyPropertyChanged(BR.e118);
    }

    @Bindable
    public String getE119() {
        return e119;
    }

    public void setE119(String e119) {
        this.e119 = e119;
        notifyPropertyChanged(BR.e119);
    }



    public Blood Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_UID));
        this.uuid = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_UUID));
        this.cluster = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_CLUSTER));
        this.hhid = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_HHID));
        this.userName = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_SYNCED_DATE));

        s1Hydrate(cursor.getString(cursor.getColumnIndex(BloodTable.COLUMN_S1)));

        return this;
    }


    public void s1Hydrate(String string) throws JSONException {

        if (string != null) {

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

        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(BloodTable.COLUMN_ID, this.id);
        json.put(BloodTable.COLUMN_UID, this.uid);
        json.put(BloodTable.COLUMN_UUID, this.uuid);
        json.put(BloodTable.COLUMN_CLUSTER, this.cluster);
        json.put(BloodTable.COLUMN_HHID, this.hhid);
        json.put(BloodTable.COLUMN_USERNAME, this.userName);
        json.put(BloodTable.COLUMN_SYSDATE, this.sysDate);
            json.put(BloodTable.COLUMN_DEVICEID, this.deviceId);
            json.put(BloodTable.COLUMN_DEVICETAGID, this.deviceTag);
            json.put(BloodTable.COLUMN_ISTATUS, this.iStatus);
            //  json.put(BloodTable.COLUMN_SYNCED, this.synced);
            //  json.put(BloodTable.COLUMN_SYNCED_DATE, this.syncDate);

            json.put(BloodTable.COLUMN_S1, new JSONObject(s1toString()));
            return json;

    }
}
