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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH7Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;


public class SectionH7Activity extends AppCompatActivity {
    private static final String TAG = "SectionH7Activity";

    ActivitySectionH7Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h7);
        bi.setCallback(this);
        bi.setForm(MainApp.form);
        setupSkips();
    }


    private void setupSkips() {
/*
        rgLsnr(bi.h701, bi.h701b, new ViewGroup[]{bi.fldGrpCVh701t});
        rgLsnr(bi.h702, bi.h702b, new ViewGroup[]{bi.fldGrpCVh702t});
        rgLsnr(bi.h703, bi.h703b, new ViewGroup[]{bi.fldGrpCVh703t});
        rgLsnr(bi.h704, bi.h704b, new ViewGroup[]{bi.fldGrpCVh704t});
        rgLsnr(bi.h705, bi.h705b, new ViewGroup[]{bi.fldGrpCVh705t});
        rgLsnr(bi.h706, bi.h706b, new ViewGroup[]{bi.fldGrpCVh706t});
        rgLsnr(bi.h707, bi.h707b, new ViewGroup[]{bi.fldGrpCVh707t});
        rgLsnr(bi.h708, bi.h708b, new ViewGroup[]{bi.fldGrpCVh708t});
        rgLsnr(bi.h709, bi.h709b, new ViewGroup[]{bi.fldGrpCVh709t});
        rgLsnr(bi.h710, bi.h710b, new ViewGroup[]{bi.fldGrpCVh710t});
        rgLsnr(bi.h711, bi.h711b, new ViewGroup[]{bi.fldGrpCVh711t});
        rgLsnr(bi.h712, bi.h712b, new ViewGroup[]{bi.fldGrpCVh712t});
        rgLsnr(bi.h713a, bi.h713ab, new ViewGroup[]{bi.fldGrpCVh713t});
        rgLsnr(bi.h714a, bi.h714ab, new ViewGroup[]{bi.fldGrpCVh714t});*/

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updatesFormColumn(TableContracts.FormsTable.COLUMN_SH7, MainApp.form.sH7toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, getString(R.string.upd_db) + e.getMessage());
            Toast.makeText(this, getString(R.string.upd_db) + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, getString(R.string.upd_db_error), Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionW1aActivity.class).putExtra("complete", true));
        } else Toast.makeText(this, getString(R.string.fail_db_upd), Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {
        // MainApp.form = new Form();
/*
        form.setUserName(MainApp.user.getUserName());
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setDeviceId(MainApp.deviceid);
        form.setAppver(MainApp.versionName + "." + MainApp.versionCode);*/

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
    }


 /*   @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/

}