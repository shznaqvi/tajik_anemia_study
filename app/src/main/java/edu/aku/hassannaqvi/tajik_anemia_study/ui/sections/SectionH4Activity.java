package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH4Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionH4Activity extends AppCompatActivity {
    private static final String TAG = "SectionH4Activity";
    ActivitySectionH4Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h4);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

      /*  bi.h401.setOnCheckedChangeListener((radioGroup, i) -> {


            if (i == bi.h401b.getId() || i == bi.h401c.getId() || i == bi.h401d.getId()) {
                bi.fldGrpCVh402.setVisibility(View.GONE);
                bi.fldGrpCVh403.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVh402);
                Clear.clearAllFields(bi.fldGrpCVh403);
            } else {
                bi.fldGrpCVh402.setVisibility(View.VISIBLE);
                bi.fldGrpCVh403.setVisibility(View.VISIBLE);
            }
        });*/

        // bi.h403d.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.h403check, !b));
        //   bi.h405d.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.h405check, !b));

       /* chLsnr(bi.h403a, bi.h403b, bi.h403c);
        chLsnr(bi.h403b, bi.h403a, bi.h403c);
        chLsnr(bi.h403c, bi.h403a, bi.h403b);*/

        //   rgLsnr(bi.h404, bi.h404b, new ViewGroup[]{bi.fldGrpCVh405});

    }

/*    private void chLsnr(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        cb1.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b || cb2.isChecked() || cb3.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVh404);
                Clear.clearAllFields(bi.fldGrpCVh405);
                bi.fldGrpCVh404.setVisibility(View.GONE);
                bi.fldGrpCVh405.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVh404.setVisibility(View.VISIBLE);
                bi.fldGrpCVh405.setVisibility(View.VISIBLE);
            }
        });
    }*/


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SH4, form.sH4toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, getString(R.string.upd_db) + e.getMessage());
            Toast.makeText(this, getString(R.string.upd_db) + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, getString(R.string.upd_db_error), Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionH5Activity.class).putExtra("complete", true));
        } else Toast.makeText(this, getString(R.string.fail_db_upd), Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
        // MainApp.form = new Form();

     /*   form.setUserName(MainApp.user.getUserName());
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setDeviceId(MainApp.deviceid);
        form.setAppver(MainApp.versionName + "." + MainApp.versionCode);*/

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