package edu.aku.hassannaqvi.tajik_anemia_study;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.Map;

import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.Section1Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.Section2Activity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);
        sp = getSharedPreferences("onhold", MODE_PRIVATE);
        bi.btnOnHold.setText("UPDATE ONHOLD FORM -- (" + sp.getAll().size() + ")");

        bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.username.setText("Welcome, " + MainApp.user.getFullname() + "!");
    }

    public void sectionPress(View view) {

        switch (view.getId()) {

            case R.id.openForm:
            case R.id.sec1:
                MainApp.form = new Form();
                startActivity(new Intent(this, Section1Activity.class));
                break;
            case R.id.sec2:
                MainApp.form = new Form();
                startActivity(new Intent(this, Section2Activity.class));
                break;
         /*   case R.id.sec3:
                MainApp.form = new Form();
                startActivity(new Intent(this, Section3Activity.class));
                break;
            case R.id.sec4:
                MainApp.form = new Form();
                startActivity(new Intent(this, Section4Activity.class));
                break;
            case R.id.sec5:
                MainApp.form = new Form();
                startActivity(new Intent(this, Section5Activity.class));
                break;*/
            case R.id.onhold:

                String holdmap = "";
                Map<String, ?> onhold = sp.getAll();
                for (Map.Entry<String, ?> entry : onhold.entrySet())
                    holdmap += "ID = " + entry.getKey() +
                            ", | Time = " + entry.getValue();
                Toast.makeText(this, sp.getAll().size() + " -- * -- " + onhold.toString(), Toast.LENGTH_SHORT).show();
                break;

        }
    }
}