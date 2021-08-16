package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH3aBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionH3aActivity extends AppCompatActivity {
    private static final String TAG = "SectionH3aActivity";
    ActivitySectionH3aBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h3a);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {
    /*    bi.h303.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVh304t1.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVh304t1);
            if (i == bi.h303a.getId() || i == bi.h303b.getId()) {
                bi.fldGrpCVh304t1.setVisibility(View.GONE);
            }
        });

        rgLsnr(bi.h305, bi.h305b, new ViewGroup[]{bi.fldGrpCVh306});

        bi.h307.setOnCheckedChangeListener((radioGroup, i) -> {
            bi.fldGrpCVh308.setVisibility(View.VISIBLE);
            bi.fldGrpCVh309title.setVisibility(View.VISIBLE);
            Clear.clearAllFields(bi.fldGrpCVh308);
            Clear.clearAllFields(bi.fldGrpCVh309title);
            if (i == bi.h307h.getId() || i == bi.h307i.getId()) {
                bi.fldGrpCVh308.setVisibility(View.GONE);
                bi.fldGrpCVh309title.setVisibility(View.GONE);
            }
        });

        rgLsnr(bi.h308, bi.h308b, new ViewGroup[]{bi.fldGrpCVh309title});*/
    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SH3A, form.sH3atoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "updateDB: " + e.getMessage());
            Toast.makeText(this, "updateDB: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
            startActivity(new Intent(this, SectionH3bActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {
        //   MainApp.form = new Form();

    /*    form.setUserName(MainApp.user.getUserName());
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setDeviceId(MainApp.deviceid);
        form.setAppver(MainApp.versionName + "." + MainApp.versionCode);
*/
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


/*    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }*/


}