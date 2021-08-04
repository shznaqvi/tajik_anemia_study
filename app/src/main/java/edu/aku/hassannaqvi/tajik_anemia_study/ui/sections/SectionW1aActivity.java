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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionW1aBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.lists.PregnancyListActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionW1aActivity extends AppCompatActivity {
    ActivitySectionW1aBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_w1a);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {
       /* rgLsnr(bi.w103, bi.w103b, new ViewGroup[]{bi.fldGrpCVw104, bi.fldGrpCVw105t, bi.fldGrpCVw106,bi.fldGrpCVw107t,bi.fldGrpCVw108t,bi.fldGrpCVw109t,bi.fldGrpCVw110t,bi.fldGrpCVw111t,bi.fldGrpCVw112});*/

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SW1A, form.sW1atoString());
        if (updcount > 0) {
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
            finish();
            startActivity(new Intent(this, PregnancyListActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {
        //  MainApp.form = new Form();
/*

        form.setUserName(MainApp.user.getUserName());
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setDeviceId(MainApp.deviceid);
        form.setAppver(MainApp.versionName + "." + MainApp.versionCode);
*/

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
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