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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH1Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionH1Activity extends AppCompatActivity {
    ActivitySectionH1Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h1);
        bi.setCallback(this);
        bi.h105.setText(MainApp.user.getUserName());
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


        form.setH101(bi.h101.getSelectedItem().toString());
        form.setH102(bi.h102.getSelectedItem().toString());
        form.setH103(bi.h103.getSelectedItem().toString());
        form.setH104(bi.h104.getSelectedItem().toString());
        form.setH105(bi.h105.getText().toString().isEmpty() ? "-1" : bi.h105.getText().toString());

        form.setH106d(bi.h106d.getText().toString().isEmpty() ? "-1" : bi.h106d.getText().toString());
        form.setH106m(bi.h106m.getText().toString().isEmpty() ? "-1" : bi.h106m.getText().toString());
        form.setH106y(bi.h106y.getText().toString().isEmpty() ? "-1" : bi.h106y.getText().toString());
        form.setH107h(bi.h107h.getText().toString().isEmpty() ? "-1" : bi.h107h.getText().toString());
        form.setH107m(bi.h107m.getText().toString().isEmpty() ? "-1" : bi.h107m.getText().toString());

        form.setH108(bi.h108.getText().toString().isEmpty() ? "-1" : bi.h108.getText().toString());
        form.setH109(bi.h109.getText().toString().isEmpty() ? "-1" : bi.h109.getText().toString());

        form.setH110(bi.h110a.isChecked() ? "1"
                : bi.h110b.isChecked() ? "2"
                : "-1");

        form.setH111(bi.h111a.isChecked() ? "1"
                : bi.h111b.isChecked() ? "2"
                : "-1");

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