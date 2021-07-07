package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionW3Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt.rgLsnr;


public class SectionW3Activity extends AppCompatActivity {
    ActivitySectionW3Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_w3);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.w306.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVw307.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVw307);
            if (i == bi.w306b.getId() || i == bi.w30698.getId()) {
                bi.fldGrpCVw307.setVisibility(View.GONE);

            }
        });

        chLsnr(bi.w313c, bi.w313d, bi.w313e, bi.w31398);
        chLsnr(bi.w313d, bi.w313c, bi.w313e, bi.w31398);
        chLsnr(bi.w313d, bi.w313e, bi.w313c, bi.w31398);
        chLsnr(bi.w313d, bi.w313e, bi.w31398, bi.w313c);

        rgLsnr(bi.w315, bi.w315b, new ViewGroup[]{bi.fldGrpCVw316, bi.fldGrpCVw317, bi.fldGrpCVw318t, bi.fldGrpCVw319});
        rgLsnr(bi.w320, bi.w320b, new ViewGroup[]{bi.fldGrpCVw321, bi.fldGrpCVw322, bi.fldGrpCVw323t, bi.fldGrpCVw324, bi.fldGrpCVw325, bi.fldGrpCVw326, bi.fldGrpCVw327});
    }

    private void chLsnr(CheckBox cb1, CheckBox cb2, CheckBox cb3, CheckBox cb4) {
        cb1.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVw314);
                bi.fldGrpCVw314.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVw314.setVisibility(View.VISIBLE);
            }
        });
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


    public void btnContinue(View view) {
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


/*
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/


}