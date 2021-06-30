package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionW1bBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionW1bActivity extends AppCompatActivity {
    ActivitySectionW1bBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_w1b);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.setId(String.valueOf(updcount));
        if (updcount > 0) {
            form.setUid(form.getDeviceId() + form.getId());
            db.updatesFormColumn(TableContracts.FormsTable.COLUMN_UID, form.getUid());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue() {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {
        MainApp.form = new Form();

        form.setUserName(MainApp.user.getUserName());
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setDeviceId(MainApp.deviceid);
        form.setAppver(MainApp.versionName + "." + MainApp.versionCode);

    }


    public void btnEnd() {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}