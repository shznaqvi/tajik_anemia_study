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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH2cBinding;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.mwra;


public class SectionH2cActivity extends AppCompatActivity {
    ActivitySectionH2cBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2c);
        bi.setCallback(this);
        bi.setMwra(MainApp.mwra);

        setupSkips();
    }


    private void setupSkips() {

    }


    private boolean insertNewRecord() {
        db = MainApp.appInfo.getDbHelper();
        long rowID = 0;
        try {
            rowID = db.addMWRAList(mwra);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Database Exception... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
        mwra.setId(String.valueOf(rowID));
        if (rowID > 0) {
            mwra.setUid(mwra.getDeviceId() + mwra.getId());
            db.updatesMWRAListColumn(TableContracts.MWRAListTable.COLUMN_UID, mwra.getUid());
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
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {

        // After databinding this can be moved to onCreate() function.
        mwra.setUuid(MainApp.form.getUid());
        mwra.setCluster(MainApp.form.getCluster());
        mwra.setHhid(MainApp.form.getHhid());
        mwra.setUserName(MainApp.user.getUserName());
        mwra.setSysDate(form.getSysDate());
        mwra.setDeviceId(MainApp.deviceid);
        mwra.setiStatus("1");
        mwra.setAppver(MainApp.versionName + "." + MainApp.versionCode);

        // No need for this part after databinding
/*      mwra.setH221(bi.h221.getText().toString());
        mwra.setH222d(bi.h222d.getText().toString());
        mwra.setH222m(bi.h222m.getText().toString());
        mwra.setH222y(bi.h222y.getText().toString());
        mwra.setH223(bi.h223.getText().toString());
        .
        .
        .
        */


    }


    public void btnEnd(View view) {
        setResult(RESULT_CANCELED);

        finish();
        //    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }



    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }


}