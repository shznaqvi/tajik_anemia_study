package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH2aBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionH2aActivity extends AppCompatActivity {
    ActivitySectionH2aBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2a);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
    }


    private boolean updateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_S1, form.s1toString());
        if (updcount == 1) {
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

        form.setH201(bi.h201.getText().toString().isEmpty() ? "-1" : bi.h201.getText().toString());

        form.setH202(bi.h202a.isChecked() ? "1"
                : bi.h202b.isChecked() ? "2"
                : "-1");

        form.setH203d(bi.h203d.getText().toString().isEmpty() ? "-1" : bi.h203d.getText().toString());
        form.setH203m(bi.h203m.getText().toString().isEmpty() ? "-1" : bi.h203m.getText().toString());
        form.setH203y(bi.h203y.getText().toString().isEmpty() ? "-1" : bi.h203y.getText().toString());

        form.setH204(bi.h204.getText().toString().isEmpty() ? "-1" : bi.h204.getText().toString());

        form.setH205(bi.h205a.isChecked() ? "1"
                : bi.h205b.isChecked() ? "2"
                : bi.h205c.isChecked() ? "3"
                : bi.h205d.isChecked() ? "4"
                : bi.h205e.isChecked() ? "5"
                : "-1");

        form.setH206(bi.h206a.isChecked() ? "1"
                : bi.h206b.isChecked() ? "2"
                : bi.h206c.isChecked() ? "3"
                : bi.h206d.isChecked() ? "4"
                : bi.h206e.isChecked() ? "5"
                : bi.h206f.isChecked() ? "6"
                : bi.h206g.isChecked() ? "7"
                : bi.h206h.isChecked() ? "8"
                : bi.h206i.isChecked() ? "9"
                : bi.h206j.isChecked() ? "10"
                : bi.h20698.isChecked() ? "98"
                : "-1");

        form.setH207(bi.h207a.isChecked() ? "1"
                : bi.h207b.isChecked() ? "2"
                : bi.h207c.isChecked() ? "3"
                : bi.h207d.isChecked() ? "4"
                : bi.h207e.isChecked() ? "5"
                : bi.h207f.isChecked() ? "6"
                : bi.h207g.isChecked() ? "7"
                : bi.h207h.isChecked() ? "8"
                : bi.h207i.isChecked() ? "9"
                : bi.h20798.isChecked() ? "98"
                : "-1");

        form.setH208(bi.h208a.isChecked() ? "1"
                : bi.h208b.isChecked() ? "2"
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