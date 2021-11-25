package edu.aku.hassannaqvi.tajik_anemia_study.ui.lists;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.adapters.FormsAdapter;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivityFormsReportBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Form;

public class FormsReportPending extends AppCompatActivity {
    DatabaseHelper db;
    Collection<Form> fc;
    String sysdateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    ActivityFormsReportBinding bi;
    private RecyclerView.Adapter formsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_forms_report);
        bi.setPendingReport(this);
        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setTitle("Pending Forms");
        getSupportActionBar().setSubtitle("Below forms need to be completed for uploading.");

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // bi.fcRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        bi.fcRecyclerView.setLayoutManager(layoutManager);
        bi.filter.setVisibility(View.GONE);
        db = MainApp.appInfo.dbHelper;
        try {
            fc = db.getPendingForms();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSONException(Forms)", Toast.LENGTH_SHORT).show();
        }

        // specify an adapter (see also next example)
        formsAdapter = new FormsAdapter((List<Form>) fc, this);
        bi.fcRecyclerView.setAdapter(formsAdapter);
    }

/*    public void filterForms(View view) {
        Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
        fc = db.getTodayForms(bi.dtFilter.getText().toString());
        formsAdapter = new FormsAdapter((List<Form>) fc, this);
        formsAdapter.notifyDataSetChanged();
        bi.fcRecyclerView.setAdapter(formsAdapter);

    }*/
}