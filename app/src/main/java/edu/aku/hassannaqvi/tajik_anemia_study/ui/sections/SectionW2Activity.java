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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionW2Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;


public class SectionW2Activity extends AppCompatActivity {
    private static final String TAG = "SectionW2Activity";
    ActivitySectionW2Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_w2);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {
/*

        rgLsnr(bi.w201, bi.w201b, new ViewGroup[]{bi.fldGrpCVw202, bi.fldGrpCVw203, bi.fldGrpCVw204, bi.fldGrpCVw205, bi.fldGrpCVw206, bi.fldGrpCVw20601});
        rgLsnr(bi.w207, bi.w207b, new ViewGroup[]{bi.fldGrpCVw208, bi.fldGrpCVw209, bi.fldGrpCVw210, bi.fldGrpCVw211, bi.fldGrpCVw212,});
        rgLsnr(bi.w213, bi.w213b, new ViewGroup[]{bi.fldGrpCVw214, bi.fldGrpCVw215, bi.fldGrpCVw216, bi.fldGrpCVw217});
        rgLsnr(bi.w218, bi.w218b, new ViewGroup[]{bi.fldGrpCVw219});
        rgLsnr(bi.w221, bi.w22198, new ViewGroup[]{bi.fldGrpCVw222, bi.fldGrpCVw223});
        rgLsnr(bi.w224, bi.w224d, new ViewGroup[]{bi.fldGrpCVw225, bi.fldGrpCVw226});
        rgLsnr(bi.w225, bi.w225b, new ViewGroup[]{bi.fldGrpCVw226});

        bi.w206.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVw20601, i != bi.w20697.getId());
        });

*/

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SW2, form.sW2toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "updateDB: " + e.getMessage());
            Toast.makeText(this, "updateDB: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionW3Activity.class).putExtra("complete", true));
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    /*@Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }*/


}