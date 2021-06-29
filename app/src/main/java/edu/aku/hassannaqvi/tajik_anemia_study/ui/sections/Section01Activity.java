package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySection01Binding;


public class Section01Activity extends AppCompatActivity {
    ActivitySection01Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section01);
        bi.setCallback(this);
    }


    private void setupSkips() {

    }


    private boolean updateDB() {
        return true;
    }


    public void btnContinue() {

    }


    private void saveDraft() {

    }


    public void btnEnd() {

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}