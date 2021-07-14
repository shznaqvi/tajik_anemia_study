package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionW4Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionW4Activity extends AppCompatActivity {
    ActivitySectionW4Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_w4);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
        bi.w40198.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w401check, !b));
        bi.w40298.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w402check, !b));
        bi.w40398.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w403check, !b));
        bi.w40498.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w404check, !b));
        bi.w40598.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w405check, !b));
        bi.w40698.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w406check, !b));
        bi.w40798.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w407check, !b));
        bi.w40898.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w408check, !b));
        bi.w40998.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w409check, !b));
        bi.w41098.setOnCheckedChangeListener((compoundButton, b) -> Clear.clearAllFields(bi.w410check, !b));
    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SW4, form.sW4toString());
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
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

/*
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }*/


}