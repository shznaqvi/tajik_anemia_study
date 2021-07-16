package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH2dBinding;



public class SectionH2dActivity extends AppCompatActivity {
    ActivitySectionH2dBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2d);
        bi.setCallback(this);
        bi.setChild(MainApp.child);
        db = MainApp.appInfo.dbHelper;

        setupSkips();
    }


    private void setupSkips() {

    }


    private boolean updateDB() {
        long updcount = 0;
        try {
            updcount = db.addChildList(MainApp.child);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Database Exception... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.child.setId(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.child.setUid(MainApp.child.getDeviceId() + MainApp.child.getId());
            db.updatesChildListColumn(TableContracts.ChildListTable.COLUMN_UID, MainApp.child.getUid());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            setResult(RESULT_OK);
            finish();
            //  startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {


        MainApp.child.setUserName(MainApp.user.getUserName());
        MainApp.child.setSysDate(MainApp.form.getSysDate());
        MainApp.child.setAge(MainApp.child.getAge());
        MainApp.child.setDeviceId(MainApp.deviceid);
        MainApp.child.setAppver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.child.setUuid(MainApp.form.getUid());
        MainApp.child.setMuid(MainApp.mwra.getUid());
        MainApp.child.setCluster(MainApp.form.getCluster());
        MainApp.child.setHhid(MainApp.form.getHhid());
        //MainApp.child.setiStatus("1");

    }


    public void btnEnd(View view) {
        setResult(RESULT_CANCELED);
        finish();
        // startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

/*

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/


}