package edu.aku.hassannaqvi.tajik_anemia_study;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.AndroidDatabaseManager;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.IdentificationActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.SyncActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.lists.FormsReportCluster;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.lists.FormsReportDate;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.lists.FormsReportPending;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionC1Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionC2Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionC3Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH1Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH2aActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH2bActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH2cActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH2dActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH3aActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH3bActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH4Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH5Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH6Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH7Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionW1aActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionW1bActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionW2Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionW3Activity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionW4Activity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);
        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.app_icon);
        bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.toolbar.setSubtitle("Welcome, " + MainApp.user.getFullname() + (MainApp.admin ? " (Admin)" : "") + "!");
    }

    public void sectionPress(View view) {

        switch (view.getId()) {
            case R.id.openForm:
                MainApp.idType = 1;
                break;
            case R.id.openAnthro:
                MainApp.idType = 2;
                break;

            case R.id.updateBlood:
                MainApp.idType = 3;
                break;

            case R.id.updateStool:
                MainApp.idType = 4;
                break;
            default:
                MainApp.idType = 0;

        }


        switch (view.getId()) {

            case R.id.openForm:
            case R.id.openAnthro:
            case R.id.updateBlood:
            case R.id.updateStool:
                MainApp.form = new Form();
                startActivity(new Intent(this, IdentificationActivity.class));
                break;
            case R.id.sech1:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH1Activity.class));
                break;

            case R.id.sech2a:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH2aActivity.class));
                break;
            case R.id.sech2b:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH2bActivity.class));
                break;
            case R.id.sech2c:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH2cActivity.class));
                break;
            case R.id.sech2d:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH2dActivity.class));
                break;
            case R.id.sech3a:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH3aActivity.class));
                break;
            case R.id.sech3b:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH3bActivity.class));
                break;
            case R.id.sech4:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH4Activity.class));
                break;
            case R.id.sech5:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH5Activity.class));
                break;
            case R.id.sech6:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH6Activity.class));
                break;
            case R.id.sech7:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionH7Activity.class));
                break;
            case R.id.secw1a:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionW1aActivity.class));
                break;
            case R.id.secw1b:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionW1bActivity.class));
                break;
            case R.id.secw2:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionW2Activity.class));
                break;
            case R.id.secw3:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionW3Activity.class));
                break;
            case R.id.secw4:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionW4Activity.class));
                break;
            case R.id.secc1:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionC1Activity.class));
                break;
            case R.id.secc2:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionC2Activity.class));
                break;
            case R.id.secc3:
                MainApp.form = new Form();
                startActivity(new Intent(this, SectionC3Activity.class));
                break;
            case R.id.dbManager:
                startActivity(new Intent(this, AndroidDatabaseManager.class));
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_database:
                intent = new Intent(MainActivity.this, AndroidDatabaseManager.class);
                startActivity(intent);
                break;
            case R.id.onSync:
                intent = new Intent(MainActivity.this, SyncActivity.class);
                startActivity(intent);
                break;
            case R.id.checkPendingForms:
                intent = new Intent(MainActivity.this, FormsReportPending.class);
                startActivity(intent);
                break;
            case R.id.formsReportDate:
                intent = new Intent(MainActivity.this, FormsReportDate.class);
                startActivity(intent);
                break;
            case R.id.formsReportCluster:
                intent = new Intent(MainActivity.this, FormsReportCluster.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        MenuItem action_database = menu.findItem(R.id.action_database);

        action_database.setVisible(MainApp.admin);
        return super.onCreateOptionsMenu(menu);
    }

}