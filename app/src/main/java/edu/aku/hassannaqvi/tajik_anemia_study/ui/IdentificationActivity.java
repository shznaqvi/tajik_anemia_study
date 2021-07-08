package edu.aku.hassannaqvi.tajik_anemia_study.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivityIdentificationBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Anthro;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Clusters;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Random;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionAnthroActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH1Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionSamplesActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;

public class IdentificationActivity extends AppCompatActivity {

    private static final String TAG = "IdentificationActivity";
    ActivityIdentificationBinding bi;
    private DatabaseHelper db;
    private ArrayList<String> districtNames;
    private ArrayList<String> districtCodes;
    private ArrayList<String> cityNames;
    private ArrayList<String> cityCodes;
    private Intent openFormIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_identification);
        bi.setCallback(this);
        db = MainApp.appInfo.dbHelper;
        populateSpinner();

        openFormIntent = new Intent();
        switch (MainApp.idType) {
            case 1:
                bi.btnContinue.setText("Open Household Form");
                MainApp.form = new Form();
                openFormIntent = new Intent(this, SectionH1Activity.class);
                break;
            case 2:
                bi.btnContinue.setText("Open Anthro Form");
                MainApp.anthro = new Anthro();
                openFormIntent = new Intent(this, SectionAnthroActivity.class);
                break;
            case 3:
                bi.btnContinue.setText("Open Blood Form");
                //     MainApp.sample = new Sample();
                openFormIntent = new Intent(this, SectionSamplesActivity.class);
                openFormIntent.putExtra("type", "1"); // BLOOD - 1
                break;
            case 4:
                bi.btnContinue.setText("Open Stool Form");
                //    MainApp.sample = new Sample();
                openFormIntent = new Intent(this, SectionSamplesActivity.class);
                openFormIntent.putExtra("type", "2"); // STOOL - 2
                break;

        }

        bi.h103.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                bi.h104.setText(null);
                bi.hhhead.setText(null);
                bi.btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.gray));
                bi.btnContinue.setEnabled(false);
                bi.checkHousehold.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.colorAccent));
                bi.checkHousehold.setEnabled(true);
            }
        });

        bi.h104.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                bi.hhhead.setText(null);
                bi.btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.gray));
                bi.btnContinue.setEnabled(false);
                bi.checkHousehold.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.colorAccent));
                bi.checkHousehold.setEnabled(true);
            }
        });

    }

    private void populateSpinner() {

        Collection<Clusters> district = db.getAllDistricts();
        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("...");
        districtCodes.add("...");
        for (Clusters c : district) {
            districtNames.add(c.getDistrictName());
            districtCodes.add(c.getDistrictCode());
        }

        // Apply the adapter to the spinner
        bi.h101.setAdapter(new ArrayAdapter(IdentificationActivity.this, R.layout.custom_spinner, districtNames));

        bi.h101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bi.h102.setAdapter(null);
                bi.h103.setText(null);
                bi.h104.setText(null);
                bi.hhhead.setText(null);
                bi.h103.setEnabled(false);
                bi.h104.setEnabled(false);
                bi.btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.gray));
                bi.btnContinue.setEnabled(false);
                bi.checkHousehold.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.colorAccent));
                bi.checkHousehold.setEnabled(true);
                if (position == 0) return;
                Collection<Clusters> city = db.getCitiesByDistrict(districtCodes.get(position));
                cityNames = new ArrayList<>();
                cityCodes = new ArrayList<>();
                cityNames.add("...");
                cityCodes.add("...");
                for (Clusters c : city) {
                    cityNames.add(c.getCityName());
                    cityCodes.add(c.getCityCode());
                }

                // Apply the adapter to the spinner
                bi.h102.setAdapter(new ArrayAdapter(IdentificationActivity.this, R.layout.custom_spinner, cityNames));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        bi.h102.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bi.h103.setText(null);
                bi.h104.setText(null);
                bi.hhhead.setText(null);

                bi.btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.gray));
                bi.btnContinue.setEnabled(false);
                bi.checkHousehold.setBackgroundTintList(ContextCompat.getColorStateList(IdentificationActivity.this, R.color.colorAccent));
                bi.checkHousehold.setEnabled(true);
                bi.h103.setEnabled(false);
                bi.h104.setEnabled(false);
                if (position == 0) return;
                bi.h103.setEnabled(true);
                bi.h104.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        //  if (updateDB()) {
        finish();
        startActivity(openFormIntent);
        // } else {
        //     Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        // }
    }


    private void saveDraft() {
        MainApp.form = new Form();

        form.setUserName(MainApp.user.getUserName());
        form.setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        form.setDeviceId(MainApp.deviceid);
        form.setAppver(MainApp.versionName + "." + MainApp.versionCode);

    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void checkHousehold(View view) {
        Random hhFound = db.checkHousehold(bi.h103.getText().toString(), bi.h104.getText().toString());
        if (hhFound != null) {
            bi.hhhead.setTextColor(ContextCompat.getColor(this, android.R.color.black));
            bi.btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            bi.btnContinue.setEnabled(true);
            bi.checkHousehold.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.gray));
            bi.checkHousehold.setEnabled(false);

            bi.hhhead.setText(hhFound.getHeadhh());
            Toast.makeText(this, hhFound.getHeadhh(), Toast.LENGTH_SHORT).show();


        } else {
            bi.hhhead.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            bi.hhhead.setText("Household not Found");
            bi.btnContinue.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.gray));
            bi.btnContinue.setEnabled(false);


        }
    }
}