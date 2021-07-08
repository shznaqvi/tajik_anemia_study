package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH2bBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt.rgLsnr;


public class SectionH2bActivity extends AppCompatActivity {
    ActivitySectionH2bBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2b);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
        rgLsnr(bi.h210, bi.h210b, new ViewGroup[]{bi.fldGrpCVh211});
        rgLsnr(bi.h212, bi.h212b, new ViewGroup[]{bi.fldGrpCVh213});
        rgLsnr(bi.h214, bi.h214b, new ViewGroup[]{bi.fldGrpCVh215});
        rgLsnr(bi.h216, bi.h216b, new ViewGroup[]{bi.fldGrpCVh217});
        rgLsnr(bi.h218, bi.h218b, new ViewGroup[]{bi.fldGrpCVh219});
    }


    private boolean updateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsTable.COLUMN_SH1, form.sH1toString());
        if (updcount == 1) {
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

        form.setH209(bi.h209.getText().toString().isEmpty() ? "-1" : bi.h209.getText().toString());

        form.setH210(bi.h210a.isChecked() ? "1"
                : bi.h210b.isChecked() ? "2"
                : "-1");

        form.setH211t(bi.h211t.getText().toString().isEmpty() ? "-1" : bi.h211t.getText().toString());
        form.setH211m(bi.h211m.getText().toString().isEmpty() ? "-1" : bi.h211m.getText().toString());
        form.setH211f(bi.h211f.getText().toString().isEmpty() ? "-1" : bi.h211f.getText().toString());

        form.setH212(bi.h212a.isChecked() ? "1"
                : bi.h212b.isChecked() ? "2"
                : "-1");

        form.setH213t(bi.h213t.getText().toString().isEmpty() ? "-1" : bi.h213t.getText().toString());
        form.setH213m(bi.h213m.getText().toString().isEmpty() ? "-1" : bi.h213m.getText().toString());
        form.setH213f(bi.h213f.getText().toString().isEmpty() ? "-1" : bi.h213f.getText().toString());

        form.setH214(bi.h214a.isChecked() ? "1"
                : bi.h214b.isChecked() ? "2"
                : "-1");

        form.setH215t(bi.h215t.getText().toString().isEmpty() ? "-1" : bi.h215t.getText().toString());
        form.setH215m(bi.h215m.getText().toString().isEmpty() ? "-1" : bi.h215m.getText().toString());
        form.setH215f(bi.h215f.getText().toString().isEmpty() ? "-1" : bi.h215f.getText().toString());

        form.setH216(bi.h216a.isChecked() ? "1"
                : bi.h216b.isChecked() ? "2"
                : "-1");

        form.setH217t(bi.h217t.getText().toString().isEmpty() ? "-1" : bi.h217t.getText().toString());
        form.setH217m(bi.h217m.getText().toString().isEmpty() ? "-1" : bi.h217m.getText().toString());
        form.setH217f(bi.h217f.getText().toString().isEmpty() ? "-1" : bi.h217f.getText().toString());

        form.setH218(bi.h218a.isChecked() ? "1"
                : bi.h218b.isChecked() ? "2"
                : "-1");

        form.setH219t(bi.h219t.getText().toString().isEmpty() ? "-1" : bi.h219t.getText().toString());
        form.setH219m(bi.h219m.getText().toString().isEmpty() ? "-1" : bi.h219m.getText().toString());
        form.setH219f(bi.h219f.getText().toString().isEmpty() ? "-1" : bi.h219f.getText().toString());
        form.setH220a(bi.h220a.getText().toString().isEmpty() ? "-1" : bi.h220a.getText().toString());
        form.setH220b(bi.h220b.getText().toString().isEmpty() ? "-1" : bi.h220b.getText().toString());
        form.setH220c(bi.h220c.getText().toString().isEmpty() ? "-1" : bi.h220c.getText().toString());

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