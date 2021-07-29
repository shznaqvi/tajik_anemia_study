package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.os.Bundle;
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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionW1bBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Pregnancy;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.preg;


public class SectionW1bActivity extends AppCompatActivity {
    ActivitySectionW1bBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_w1b);

        if (preg == null)
            preg = new Pregnancy(); // MUST and ONLY for every insertNewRecord() NOT with UpdateDB();
        bi.setPreg(preg);
        bi.setCallback(this);

        db = MainApp.appInfo.dbHelper;

        setupSkips();
    }


    private void setupSkips() {
        /*  rgLsnr(bi.w116, bi.w116b, new ViewGroup[]{bi.fldGrpCVw117t});*/
        /* rgLsnr(bi.w116, bi.w116b, new ViewGroup[]{bi.fldGrpCVh602});*/
    }


    private boolean insertNewRecord() {
        long rowId = 0;
        try {
            rowId = db.addPregnancy(MainApp.preg);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Database Exception... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.preg.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.preg.setUid(MainApp.preg.getDeviceId() + MainApp.preg.getId());
            db.updatesPregColumn(TableContracts.PregnancyTable.COLUMN_UID, MainApp.preg.getUid());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (insertNewRecord()) {

            setResult(RESULT_OK);
            finish();
            //startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {
        //preg = new Pregnancy();

        preg.setUserName(MainApp.user.getUserName());
        preg.setSysDate(MainApp.form.getSysDate());
        preg.setDeviceId(MainApp.deviceid);
        preg.setUid(MainApp.form.getUid());
        preg.setMuid(MainApp.mwra.getUid());
        preg.setAppver(MainApp.versionName + "." + MainApp.versionCode);

    }


    public void btnEnd(View view) {
        setResult(RESULT_CANCELED);
        finish();

        //startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
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