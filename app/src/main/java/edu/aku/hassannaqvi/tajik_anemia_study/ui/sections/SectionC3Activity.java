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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt.rgLsnr;


public class SectionC3Activity extends AppCompatActivity {
    ActivitySectionC3Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.c301.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc302.setVisibility(View.VISIBLE);
            bi.fldGrpCVc303.setVisibility(View.VISIBLE);
            bi.fldGrpCVc304.setVisibility(View.VISIBLE);
            bi.fldGrpCVc305.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc302);
            Clear.clearAllFields(bi.fldGrpCVc303);
            Clear.clearAllFields(bi.fldGrpCVc304);
            Clear.clearAllFields(bi.fldGrpCVc305);
            if (i == bi.c301b.getId()) {
                bi.fldGrpCVc302.setVisibility(View.GONE);
                bi.fldGrpCVc303.setVisibility(View.GONE);
                bi.fldGrpCVc304.setVisibility(View.GONE);
                bi.fldGrpCVc305.setVisibility(View.GONE);
            }
        });

        bi.c302.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc303.setVisibility(View.VISIBLE);
            bi.fldGrpCVc304.setVisibility(View.VISIBLE);
            bi.fldGrpCVc305.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc303);
            Clear.clearAllFields(bi.fldGrpCVc304);
            Clear.clearAllFields(bi.fldGrpCVc305);
            if (i == bi.c302a.getId()) {
                bi.fldGrpCVc303.setVisibility(View.GONE);
            } else if (i == bi.c302b.getId()) {
                bi.fldGrpCVc304.setVisibility(View.GONE);
                bi.fldGrpCVc305.setVisibility(View.GONE);
            }
        });

        rgLsnr(bi.c306, bi.c306b, new ViewGroup[]{bi.fldGrpCVc307, bi.fldGrpCVc308, bi.fldGrpCVc309, bi.fldGrpCVc310});

        bi.c307.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc308.setVisibility(View.VISIBLE);
            bi.fldGrpCVc309.setVisibility(View.VISIBLE);
            bi.fldGrpCVc310.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc308);
            Clear.clearAllFields(bi.fldGrpCVc309);
            Clear.clearAllFields(bi.fldGrpCVc310);
            if (i == bi.c307a.getId()) {
                bi.fldGrpCVc308.setVisibility(View.GONE);
            } else if (i == bi.c307b.getId()) {
                bi.fldGrpCVc309.setVisibility(View.GONE);
                bi.fldGrpCVc310.setVisibility(View.GONE);
            }
        });

        rgLsnr(bi.c311, bi.c311b, new ViewGroup[]{bi.fldGrpCVc312, bi.fldGrpCVc313, bi.fldGrpCVc314, bi.fldGrpCVc315});

        rgLsnr(bi.c312, bi.c312a, new ViewGroup[]{bi.fldGrpCVc313});
        bi.c312.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc313.setVisibility(View.VISIBLE);
            bi.fldGrpCVc314.setVisibility(View.VISIBLE);
            bi.fldGrpCVc315.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc313);
            Clear.clearAllFields(bi.fldGrpCVc314);
            Clear.clearAllFields(bi.fldGrpCVc315);
            if (i == bi.c312a.getId()) {
                bi.fldGrpCVc313.setVisibility(View.GONE);
            } else if (i == bi.c312b.getId()) {
                bi.fldGrpCVc314.setVisibility(View.GONE);
                bi.fldGrpCVc315.setVisibility(View.GONE);
            }
        });

        bi.c316.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVc317.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVc317);
            if (i == bi.c316b.getId() || i == bi.c31698.getId()) {
                bi.fldGrpCVc317.setVisibility(View.GONE);
            }
        });

        rgLsnr(bi.c319, bi.c319b, new ViewGroup[]{bi.fldGrpCVc320t});

        rgLsnr(bi.c322, bi.c322b, new ViewGroup[]{bi.fldGrpCVc323});

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