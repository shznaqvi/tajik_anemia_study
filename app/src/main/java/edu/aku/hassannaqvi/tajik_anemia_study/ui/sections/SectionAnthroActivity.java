package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionAnthroBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Anthro;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;


public class SectionAnthroActivity extends AppCompatActivity {
    private static final String TAG = "SectionAnthroActivity";
    ActivitySectionAnthroBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_anthro);
        bi.setCallback(this);

        db = MainApp.appInfo.getDbHelper();
        MainApp.anthro = new Anthro();

        bi.setCallback(this);
        bi.setAnthro(MainApp.anthro);

        MainApp.anthro.setUuid(MainApp.form.getUid());
        MainApp.anthro.setUserName(MainApp.user.getUserName());
        MainApp.anthro.setSysDate(MainApp.form.getSysDate());
        MainApp.anthro.setDeviceId(MainApp.deviceid);
        MainApp.anthro.setAppver(MainApp.versionName + "." + MainApp.versionCode);

        MainApp.anthro.setD102(MainApp.form.getH103());
        MainApp.anthro.setD103(MainApp.form.getH104());

        populateSpinner();
        setupSkips();
    }

    private void populateSpinner() {

        bi.d104.setAdapter(new ArrayAdapter(this, R.layout.custom_spinner, MainApp.subjectNames));

        bi.d104.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (bi.d104.getSelectedItemPosition() != 0) {
                    try {
                        Anthro tempAnthros = db.getAnthrosByUUIDNameType(MainApp.form.getUid(), bi.d104.getSelectedItem().toString());
                        if (!tempAnthros.getUid().equals("")) {

                            MainApp.anthro.s1Hydrate(tempAnthros.s1toString());

                            // uid is important because it will be checked in insertRecord() to check if this is new record or already exist
                            MainApp.anthro.setUid(tempAnthros.getUid());
                            MainApp.anthro.setId(tempAnthros.getId());
                        } else {
                            MainApp.anthro.setD104(bi.d104.getSelectedItem().toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d(TAG, getString(R.string.onitemselected) + e.getMessage());
                        Toast.makeText(SectionAnthroActivity.this, getString(R.string.onitemselected) + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void setupSkips() {

    }


    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.addAnthro(MainApp.anthro);
        MainApp.anthro.setId(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.anthro.setUid(MainApp.anthro.getDeviceId() + MainApp.anthro.getId());
            db.updatesFormColumn(TableContracts.FormsTable.COLUMN_UID, MainApp.anthro.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
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
            Toast.makeText(this, R.string.fail_db_upd, Toast.LENGTH_SHORT).show();
        }
    }


    private void saveDraft() {

        MainApp.anthro.setUuid(MainApp.form.getUid());
        MainApp.anthro.setUserName(MainApp.user.getUserName());
        MainApp.anthro.setSysDate(MainApp.form.getSysDate());
        MainApp.anthro.setDeviceId(MainApp.deviceid);
        MainApp.anthro.setAppver(MainApp.versionName + "." + MainApp.versionCode);

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
        Toast.makeText(this, R.string.backPress, Toast.LENGTH_SHORT).show();
    }


}