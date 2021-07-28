package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionC3Activity extends AppCompatActivity {
    ActivitySectionC3Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {
/*
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

        rgLsnr(bi.c322, bi.c322b, new ViewGroup[]{bi.fldGrpCVc323});*/

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SC3, form.sC3toString());
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
/*

        form.setC301(bi.c301a.isChecked() ? "1"
                : bi.c301b.isChecked() ? "2"
                : "-1");

        form.setC302(bi.c302a.isChecked() ? "1"
                : bi.c302b.isChecked() ? "2"
                : "-1");

        form.setC303(bi.c303a.isChecked() ? "1"
                : bi.c303b.isChecked() ? "2"
                : bi.c303c.isChecked() ? "3"
                : bi.c303d.isChecked() ? "4"
                : bi.c303e.isChecked() ? "5"
                : bi.c303f.isChecked() ? "6"
                : bi.c303g.isChecked() ? "7"
                : bi.c303h.isChecked() ? "8"
                : bi.c30396.isChecked() ? "96"
                : "-1");
        form.setC30396x(bi.c30396x.getText().toString());

        form.setC304(bi.c304961.isChecked() ? "961"
                : bi.c304962.isChecked() ? "962"
                : bi.c304963.isChecked() ? "963"
                : "-1");

        form.setC304961x(bi.c304961x.getText().toString());
        form.setC304962x(bi.c304962x.getText().toString());
        form.setC304963x(bi.c304963x.getText().toString());

        form.setC305a(bi.c305a.isChecked() ? "1" : "-1");
        form.setC305b(bi.c305b.isChecked() ? "2" : "-1");
        form.setC305c(bi.c305c.isChecked() ? "3" : "-1");
        form.setC305d(bi.c305d.isChecked() ? "4" : "-1");
        form.setC305e(bi.c305e.isChecked() ? "5" : "-1");
        form.setC305f(bi.c305f.isChecked() ? "6" : "-1");
        form.setC305g(bi.c305g.isChecked() ? "7" : "-1");
        form.setC305h(bi.c305h.isChecked() ? "8" : "-1");
        form.setC305i(bi.c305i.isChecked() ? "9" : "-1");
        form.setC305j(bi.c305j.isChecked() ? "10" : "-1");
        form.setC30596(bi.c30596.isChecked() ? "96" : "-1");

        form.setC30596x(bi.c30596x.getText().toString());
        form.setC306(bi.c306a.isChecked() ? "1"
                : bi.c306b.isChecked() ? "2"
                : "-1");

        form.setC307(bi.c307a.isChecked() ? "1"
                : bi.c307b.isChecked() ? "2"
                : "-1");

        form.setC308(bi.c308a.isChecked() ? "1"
                : bi.c308b.isChecked() ? "2"
                : bi.c308c.isChecked() ? "3"
                : bi.c308d.isChecked() ? "4"
                : bi.c308e.isChecked() ? "5"
                : bi.c308f.isChecked() ? "6"
                : bi.c308g.isChecked() ? "7"
                : bi.c308h.isChecked() ? "8"
                : bi.c30896.isChecked() ? "96"
                : "-1");

        form.setC30896x(bi.c30896x.getText().toString());

        form.setC309(bi.c309961.isChecked() ? "961"
                : bi.c309962.isChecked() ? "962"
                : bi.c309963.isChecked() ? "963"
                : "-1");

        form.setC309961x(bi.c309961x.getText().toString());
        form.setC309962x(bi.c309962x.getText().toString());
        form.setC309963x(bi.c309963x.getText().toString());

        form.setC310a(bi.c310a.isChecked() ? "1" : "-1");
        form.setC310b(bi.c310b.isChecked() ? "2" : "-1");
        form.setC310c(bi.c310c.isChecked() ? "3" : "-1");
        form.setC310d(bi.c310d.isChecked() ? "4" : "-1");
        form.setC310e(bi.c310e.isChecked() ? "5" : "-1");
        form.setC310f(bi.c310f.isChecked() ? "6" : "-1");
        form.setC310g(bi.c310g.isChecked() ? "7" : "-1");
        form.setC31096(bi.c31096.isChecked() ? "96" : "-1");

        form.setC31096x(bi.c31096x.getText().toString());
        form.setC311(bi.c311a.isChecked() ? "1"
                : bi.c311b.isChecked() ? "2"
                : "-1");

        form.setC312(bi.c312a.isChecked() ? "1"
                : bi.c312b.isChecked() ? "2"
                : "-1");

        form.setC313(bi.c313a.isChecked() ? "1"
                : bi.c313b.isChecked() ? "2"
                : bi.c313c.isChecked() ? "3"
                : bi.c313d.isChecked() ? "4"
                : bi.c313e.isChecked() ? "5"
                : bi.c313f.isChecked() ? "6"
                : bi.c313g.isChecked() ? "7"
                : bi.c313h.isChecked() ? "8"
                : bi.c31396.isChecked() ? "96"
                : "-1");

        form.setC31396x(bi.c31396x.getText().toString());

        form.setC314(bi.c314961.isChecked() ? "961"
                : bi.c314962.isChecked() ? "962"
                : bi.c314963.isChecked() ? "963"
                : "-1");

        form.setC314961x(bi.c314961x.getText().toString());
        form.setC314962x(bi.c314962x.getText().toString());
        form.setC314963x(bi.c314963x.getText().toString());

        form.setC315a(bi.c315a.isChecked() ? "1" : "-1");
        form.setC315b(bi.c315b.isChecked() ? "2" : "-1");
        form.setC315c(bi.c315c.isChecked() ? "3" : "-1");
        form.setC315d(bi.c315d.isChecked() ? "4" : "-1");
        form.setC315e(bi.c315e.isChecked() ? "5" : "-1");
        form.setC315f(bi.c315f.isChecked() ? "6" : "-1");
        form.setC315g(bi.c315g.isChecked() ? "7" : "-1");
        form.setC315h(bi.c315h.isChecked() ? "8" : "-1");
        form.setC31596(bi.c31596.isChecked() ? "96" : "-1");

        form.setC31596x(bi.c31596x.getText().toString());

        form.setC316(bi.c316a.isChecked() ? "1"
                : bi.c316b.isChecked() ? "2"
                : bi.c31698.isChecked() ? "98"
                : "-1");

        form.setC317(bi.c317a.isChecked() ? "1"
                : bi.c317b.isChecked() ? "2"
                : "-1");

        form.setC318(bi.c318a.isChecked() ? "1"
                : bi.c318b.isChecked() ? "2"
                : bi.c31898.isChecked() ? "98"
                : "-1");

        form.setC319(bi.c319a.isChecked() ? "1"
                : bi.c319b.isChecked() ? "2"
                : bi.c31998.isChecked() ? "98"
                : "-1");

        form.setC320(bi.c320.getText().toString());

        form.setC321(bi.c321a.isChecked() ? "1"
                : bi.c321b.isChecked() ? "2"
                : bi.c321c.isChecked() ? "3"
                : bi.c321d.isChecked() ? "4"
                : bi.c321e.isChecked() ? "5"
                : "-1");

        form.setC322(bi.c322a.isChecked() ? "1"
                : bi.c322b.isChecked() ? "2"
                : "-1");

        form.setC323(bi.c323m.isChecked() ? "1"
                : bi.c323d.isChecked() ? "2"
                : "-1");

        form.setC323mx(bi.c323mx.getText().toString());
        form.setC323dx(bi.c323dx.getText().toString());
*/

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


   /* @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }*/


}