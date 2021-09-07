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
import edu.aku.hassannaqvi.tajik_anemia_study.models.Child;


public class SectionH2dActivity extends AppCompatActivity {
    ActivitySectionH2dBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2d);
        bi.setCallback(this);

        if (MainApp.child == null)
            MainApp.child = new Child();  // MUST and ONLY for every insertNewRecord() NOT with UpdateDB();
        bi.setChild(MainApp.child);

        // Always declair db in onCreate()
        db = MainApp.appInfo.dbHelper;

        setupSkips();
    }


    private void setupSkips() {

    }


    private boolean insertNewRecord() {
        long rowId = 0;
        try {
            rowId = db.addChildList(MainApp.child);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.db_excp_error), Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.child.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.child.setUid(MainApp.child.getDeviceId() + MainApp.child.getId());
            db.updatesChildListColumn(TableContracts.ChildListTable.COLUMN_UID, MainApp.child.getUid());
            return true;
        } else {
            Toast.makeText(this, getString(R.string.upd_db_error), Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (insertNewRecord()) {
            setResult(RESULT_OK);
            finish();
            //  startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, getString(R.string.fail_db_upd), Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {

        // NEVER USE IT IN SAVEDRAFT()
        // MainApp.child = new Child();

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
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false;

        if (Integer.parseInt(MainApp.child.getAge()) < 6) {
            Validator.emptyCustomTextBox(this, bi.h231m, "Child is younger than 6-months. Please enter a child 6-months or older");
            return false;
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }

/*

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/


}