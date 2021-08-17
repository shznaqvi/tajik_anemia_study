package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.util.Calendar;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH2cBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.MWRA;

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
        if (mwra == null) mwra = new MWRA();
        bi.setMwra(MainApp.mwra);
    }

    public void ageInYears(CharSequence s, int i, int i1, int i2) {
        if (TextUtils.isEmpty(bi.h222y.getText())) return;
        bi.h223.setText("");
        bi.h223.setEnabled(true);
     /*   if (Integer.parseInt(bi.h222y.getText().toString()) >= 1972 && Integer.parseInt(bi.h222y.getText().toString()) <= 2006) {
            bi.h223.setText(String.valueOf(DateUtilsKt.getAgeInYears(Integer.parseInt(bi.h222y.getText().toString()))));
            bi.h223.setEnabled(false);
        }*/
        // Return VOID if zero length
        if (i == 0) return;

        int dobYear = Integer.parseInt(s.toString());
        int curYear = Calendar.getInstance().get(Calendar.YEAR);

        if (dobYear > (curYear - 99) && dobYear < curYear) {
            String ageInYears = String.valueOf(curYear - dobYear);
            bi.h223.setText(ageInYears);
            bi.h223.setEnabled(false);
        }
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
        mwra.setAppver(MainApp.versionName + "." + MainApp.versionCode);

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