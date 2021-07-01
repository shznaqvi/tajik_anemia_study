package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;
import kotlin.collections.unsigned.UArraysKt;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt.rgLsnr;


public class SectionC2Activity extends AppCompatActivity {
    ActivitySectionC2Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
        rgLsnr(bi.c20301a, bi.c20301ab, new ViewGroup[]{bi.c20301bcheck});
        rgLsnr(bi.c20302a, bi.c20302ab, new ViewGroup[]{bi.c20302bcheck});
        rgLsnr(bi.c20303a, bi.c20303ab, new ViewGroup[]{bi.c20303bcheck});
        rgLsnr(bi.c20304a, bi.c20304ab, new ViewGroup[]{bi.c20304bcheck});
        rgLsnr(bi.c20305a, bi.c20305ab, new ViewGroup[]{bi.c20305bcheck});
        rgLsnr(bi.c20306a, bi.c20306ab, new ViewGroup[]{bi.c20306bcheck});
        rgLsnr(bi.c20307a, bi.c20307ab, new ViewGroup[]{bi.c20307bcheck});
        rgLsnr(bi.c20308a, bi.c20308ab, new ViewGroup[]{bi.c20308bcheck});
        rgLsnr(bi.c20309a, bi.c20309ab, new ViewGroup[]{bi.c20309bcheck});
        rgLsnr(bi.c20310a, bi.c20310ab, new ViewGroup[]{bi.c20310bcheck});
        rgLsnr(bi.c20311a, bi.c20311ab, new ViewGroup[]{bi.c20311bcheck});
        rgLsnr(bi.c20312a, bi.c20312ab, new ViewGroup[]{bi.c20312bcheck});
        rgLsnr(bi.c20313a, bi.c20313ab, new ViewGroup[]{bi.c20313bcheck});
        rgLsnr(bi.c20314a, bi.c20314ab, new ViewGroup[]{bi.c20314bcheck});
        rgLsnr(bi.c20315a, bi.c20315ab, new ViewGroup[]{bi.c20315bcheck});
        rgLsnr(bi.c20316a, bi.c20316ab, new ViewGroup[]{bi.c20316bcheck});
        rgLsnr(bi.c20317a, bi.c20317ab, new ViewGroup[]{bi.c20317bcheck});
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


/*
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

*/

}