package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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

        bi.c106b.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc106c.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc106c);
            if (i == bi.c106bb.getId() || i == bi.c106b98.getId()) {
                bi.fldGrpCVc106c.setVisibility(View.GONE);
            }
        });

        bi.c106d.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc106e.setVisibility(View.VISIBLE);
            bi.fldGrpCVc106f.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc106e);
            Clear.clearAllFields(bi.fldGrpCVc106f);
            if (i == bi.c106db.getId() || i == bi.c106d98.getId()) {
                bi.fldGrpCVc106e.setVisibility(View.GONE);
                bi.fldGrpCVc106f.setVisibility(View.GONE);
            }
        });

        bi.c106g.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc106h.setVisibility(View.VISIBLE);
            bi.fldGrpCVc106i.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc106h);
            Clear.clearAllFields(bi.fldGrpCVc106i);
            if (i == bi.c106gb.getId() || i == bi.c106g98.getId()) {
                bi.fldGrpCVc106h.setVisibility(View.GONE);
                bi.fldGrpCVc106i.setVisibility(View.GONE);
            }
        });

        bi.c106m.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc106n.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc106n);
            if (i == bi.c106mb.getId() || i == bi.c106m98.getId()) {
                bi.fldGrpCVc106n.setVisibility(View.GONE);
            }
        });

        bi.c106p.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc106q.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc106q);
            if (i == bi.c106pb.getId() || i == bi.c106p98.getId()) {
                bi.fldGrpCVc106q.setVisibility(View.GONE);
            }
        });

        bi.c107a.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc107bt.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc107bt);
            if (i == bi.c107ab.getId() || i == bi.c107a98.getId()) {
                bi.fldGrpCVc107bt.setVisibility(View.GONE);
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
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.c108a.isChecked() && (!bi.c107aa.isChecked() || !bi.c107ra.isChecked())) {
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