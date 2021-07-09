package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt.rgLsnr;


public class SectionC1Activity extends AppCompatActivity {
    ActivitySectionC1Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
        rgLsnr(bi.c101, bi.c101b, new ViewGroup[]{bi.fldGrpCVc102});
        rgLsnr(bi.c106b, bi.c106bb, bi.c106b98, new ViewGroup[]{bi.fldGrpCVc106c});
        rgLsnr(bi.c106d, bi.c106db, bi.c106d98, new ViewGroup[]{bi.fldGrpCVc106e, bi.fldGrpCVc106f});
        rgLsnr(bi.c106g, bi.c106gb, bi.c106g98, new ViewGroup[]{bi.fldGrpCVc106h, bi.fldGrpCVc106i});
        rgLsnr(bi.c106m, bi.c106mb, bi.c106m98, new ViewGroup[]{bi.fldGrpCVc106n});
        rgLsnr(bi.c106p, bi.c106pb, bi.c106p98, new ViewGroup[]{bi.fldGrpCVc106q});
        rgLsnr(bi.c107a, bi.c107ab, bi.c107a98, new ViewGroup[]{bi.fldGrpCVc107bt});
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


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.c108a.isChecked() && (!bi.c107aa.isChecked() || !bi.c107ra.isChecked())) {
            bi.fldGrpCVc107a.setFocusable(true);
            bi.fldGrpCVc107r.setFocusable(true);
            Toast.makeText(this, "Invalid Response", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


/*
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/


}