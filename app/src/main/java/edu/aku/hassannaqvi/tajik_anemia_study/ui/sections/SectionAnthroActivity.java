package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionAnthroBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;


public class SectionAnthroActivity extends AppCompatActivity {
    ActivitySectionAnthroBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_anthro);
        bi.setCallback(this);
        bi.setAnthro(MainApp.anthro);
        setupSkips();
    }


    private void setupSkips() {

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.addAnthro(MainApp.anthro);
        MainApp.anthro.setId(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.anthro.setUid(MainApp.anthro.getDeviceId() + MainApp.anthro.getId());
            db.updatesFormColumn(TableContracts.FormsTable.COLUMN_UID, MainApp.anthro.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, R.string.fail_db, Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {

        MainApp.anthro.setUuid(MainApp.form.getUid());
        MainApp.anthro.setUserName(MainApp.user.getUserName());
        MainApp.anthro.setSysDate(MainApp.form.getSysDate());
        MainApp.anthro.setDeviceId(MainApp.deviceid);
        MainApp.anthro.setAppver(MainApp.versionName + "." + MainApp.versionCode);

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.backPress, Toast.LENGTH_SHORT).show();
    }


}