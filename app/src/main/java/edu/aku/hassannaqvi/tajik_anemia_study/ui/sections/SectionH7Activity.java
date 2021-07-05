package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
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
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH7Binding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;
import static edu.aku.hassannaqvi.tajik_anemia_study.utils.DateUtilsKt.rgLsnr;


public class SectionH7Activity extends AppCompatActivity {
    ActivitySectionH7Binding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h7);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        rgLsnr(bi.h701, bi.h701b, new ViewGroup[]{bi.fldGrpCVh701t1, bi.fldGrpCVh701t2});
        rgLsnr(bi.h702, bi.h702b, new ViewGroup[]{bi.fldGrpCVh702t1, bi.fldGrpCVh702t2});
        rgLsnr(bi.h703, bi.h703b, new ViewGroup[]{bi.fldGrpCVh703t1, bi.fldGrpCVh703t2});
        rgLsnr(bi.h704, bi.h704b, new ViewGroup[]{bi.fldGrpCVh704t1, bi.fldGrpCVh704t2});
        rgLsnr(bi.h705, bi.h705b, new ViewGroup[]{bi.fldGrpCVh705t1, bi.fldGrpCVh705t2});
        rgLsnr(bi.h706, bi.h706b, new ViewGroup[]{bi.fldGrpCVh706t1, bi.fldGrpCVh706t2});
        rgLsnr(bi.h707, bi.h707b, new ViewGroup[]{bi.fldGrpCVh707t1, bi.fldGrpCVh707t2});
        rgLsnr(bi.h708, bi.h708b, new ViewGroup[]{bi.fldGrpCVh708t1, bi.fldGrpCVh708t2});
        rgLsnr(bi.h709, bi.h709b, new ViewGroup[]{bi.fldGrpCVh709t1, bi.fldGrpCVh709t2});
        rgLsnr(bi.h710, bi.h710b, new ViewGroup[]{bi.fldGrpCVh710t1, bi.fldGrpCVh710t2});
        rgLsnr(bi.h711, bi.h711b, new ViewGroup[]{bi.fldGrpCVh711t1, bi.fldGrpCVh711t2});
        rgLsnr(bi.h712, bi.h712b, new ViewGroup[]{bi.fldGrpCVh712t1, bi.fldGrpCVh712t2});
        rgLsnr(bi.h713a, bi.h713ab, new ViewGroup[]{bi.fldGrpCVh713bt, bi.fldGrpCVh713ct, bi.fldGrpCVh713dt});
        rgLsnr(bi.h714a, bi.h714ab, new ViewGroup[]{bi.fldGrpCVh714bt, bi.fldGrpCVh714ct, bi.fldGrpCVh714dt});

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

    }


    public void btnEnd() {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


 /*   @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/

}