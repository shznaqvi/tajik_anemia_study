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

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionSamplesBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Samples;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.IdentificationActivity;


public class SectionSamplesActivity extends AppCompatActivity {
    private static final String TAG = "SectionSamplesActivity";
    ActivitySectionSamplesBinding bi;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_samples);

        db = MainApp.appInfo.getDbHelper();
        MainApp.samples = new Samples();

        bi.setCallback(this);
        bi.setSamples(MainApp.samples);

        MainApp.samples.setUuid(MainApp.form.getUid());
        MainApp.samples.setUserName(MainApp.user.getUserName());
        MainApp.samples.setSysDate(MainApp.form.getSysDate());
        MainApp.samples.setDeviceId(MainApp.deviceid);
        MainApp.samples.setAppver(MainApp.versionName + "." + MainApp.versionCode);

        MainApp.samples.setE102(MainApp.form.getH103());
        MainApp.samples.setE103(MainApp.form.getH104());

        populateSpinner();
        setupSkips();
        // new IntentIntegrator(this).initiateScan(); // `this` is the current Activity

    }

    private void populateSpinner() {

        bi.e104.setAdapter(new ArrayAdapter(this, R.layout.custom_spinner, MainApp.subjectNames));

        bi.e104.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (bi.e104.getSelectedItemPosition() != 0) {
                    try {
                        Samples tempSamples = db.getSamplesByUUIDNameType(MainApp.form.getUid(), bi.e104.getSelectedItem().toString(), MainApp.idType);
                        if (!tempSamples.getUid().equals("")) {

                            MainApp.samples.s1Hydrate(tempSamples.s1toString());

                            // uid is important because it will be checked in insertRecord() to check if this is new record or already exist
                            MainApp.samples.setUid(tempSamples.getUid());
                            MainApp.samples.setId(tempSamples.getId());
                        } else {
                            MainApp.samples.setE104(bi.e104.getSelectedItem().toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d(TAG, getString(R.string.onitemselected) + e.getMessage());
                        Toast.makeText(SectionSamplesActivity.this, getString(R.string.onitemselected) + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
               /* MainApp.samples.setE101("");
                MainApp.samples.setE104("");
                MainApp.samples.setE105("");
                MainApp.samples.setE106("");
                MainApp.samples.setE107("");
                MainApp.samples.setE108("");
                MainApp.samples.setE109("");
                */


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    private void setupSkips() {

        switch (MainApp.idType) {
            case 3:
                setTitle(R.string.modeatitle);
                bi.fldGrpBloodCheck.setVisibility(View.VISIBLE);
                bi.fldGrpCVe109.setVisibility(View.GONE);
                break;
            case 4:
                setTitle(R.string.modebtitle);
                bi.fldGrpBloodCheck.setVisibility(View.GONE);
                bi.fldGrpCVe109.setVisibility(View.VISIBLE);
                break;
        }
    }


    private boolean insertNewRecord() {
        if (!MainApp.samples.getUid().equals("")) return true;
        long rowId = 0;
        try {
            rowId = db.addSamples(MainApp.samples);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.db_excp_error), Toast.LENGTH_SHORT).show();
            Log.d(TAG, getString(R.string.upd_samples) + e.getMessage());
            Toast.makeText(this, getString(R.string.upd_samples) + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.samples.setId(String.valueOf(rowId));
        if (rowId > 0) {
            rowId = 0;
            MainApp.samples.setUid(MainApp.samples.getDeviceId() + MainApp.samples.getId());
            rowId = db.updatesSampColumn(TableContracts.SamplesTable.COLUMN_UID, MainApp.samples.getUid());
            if (rowId > 0) {
                return true;
            } else {
                Toast.makeText(this, "UID ERROR", Toast.LENGTH_SHORT).show();
            }
            return true;
        } else {
            Toast.makeText(this, getString(R.string.upd_db_error), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean updateDB() {
        long updcount = 0;
        try {
            updcount = db.updatesSampColumn(TableContracts.SamplesTable.COLUMN_S1, MainApp.samples.s1toString());
            if (updcount > 0) {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, getString(R.string.upd_samples) + e.getMessage());
            Toast.makeText(this, getString(R.string.upd_samples) + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        if (!insertNewRecord()) return;
        saveDraft();
        if (updateDB()) {
            MainApp.subjectNames.remove(bi.e104.getSelectedItemPosition());
            finish();
            if (MainApp.subjectNames.size() == 1)
                startActivity(new Intent(this, IdentificationActivity.class).putExtra("complete", true));
            else
                startActivity(new Intent(this, SectionSamplesActivity.class).putExtra("complete", true));

        } else Toast.makeText(this, getString(R.string.fail_db_upd), Toast.LENGTH_SHORT).show();
    }


    private void saveDraft() {

        MainApp.samples.setUserName(MainApp.user.getUserName());

 /*     MainApp.samples = new Samples();

        MainApp.samples.setUserName(MainApp.user.getUserName());
        MainApp.samples.setDeviceId(MainApp.deviceid);
        MainApp.samples.setAppver(MainApp.versionName + "." + MainApp.versionCode);*/

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
        Toast.makeText(this, getString(R.string.backPress), Toast.LENGTH_SHORT).show();
    }


    // https://github.com/journeyapps/zxing-android-embedded
    public void scanQR(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan a QR-Code");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }


    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                bi.e018.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}