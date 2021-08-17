package edu.aku.hassannaqvi.tajik_anemia_study.ui.lists;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

import edu.aku.hassannaqvi.tajik_anemia_study.MainActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.adapters.MWRAAdapter;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivityMwraListBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.MWRA;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH2cActivity;


public class MwraListActivity extends AppCompatActivity {


    private static final String TAG = "MwraActivity";
    ActivityMwraListBinding bi;
    DatabaseHelper db;
    private MWRAAdapter mwraAdapter;
    ActivityResultLauncher<Intent> MemberInfoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        //Intent data = result.getData();
                        Intent data = result.getData();
                      /*  int age = Integer.parseInt(femalemembers.getHh05y());
                        boolean isFemale = femalemembers.getHh03().equals("2");
                        boolean notMarried = femalemembers.getHh06().equals("2");
                        if (
                            // Adolescent: Male + Female - 10 to 19
                                (age >= 10 && age < 20 && notMarried)
                                        ||
                                        // MWRA: Married females between 14 to 49
                                        (age >= 14 && age < 50 && !notMarried && isFemale )

                        ) {*/
                        MainApp.mwraList.add(MainApp.mwra);

                        MainApp.mwraCount++;
                        mwraAdapter.notifyItemInserted(MainApp.mwraList.size() - 1);
                        //  Collections.sort(MainApp.fm, new SortByStatus());
                        //fmAdapter.notifyDataSetChanged();

                        //        }

                        checkCompleteFm();
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Toast.makeText(MwraListActivity.this, "No mwra added.", Toast.LENGTH_SHORT).show();
                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mwra);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_mwra_list);
        bi.setCallback(this);

        db = MainApp.appInfo.dbHelper;
        MainApp.mwraList = new ArrayList<>();
        Log.d(TAG, "onCreate: mwralist " + MainApp.mwraList.size());
        MainApp.mwraList = db.getMWRABYUID(MainApp.form.getUid());

        // Set Selected MWRA
        for (int i = 0; i < MainApp.mwraList.size(); i++) {
            if (MainApp.mwraList.get(i).getIndexed().equals("1")) {
                MainApp.selectedFemale = String.valueOf(i);
                break;
            }
        }

        bi.btnContinue.setEnabled(!MainApp.selectedFemale.equals(""));
        bi.btnContinue.setVisibility(!MainApp.selectedFemale.equals("") ? View.VISIBLE : View.INVISIBLE);
        MainApp.mwraCount = Math.round(MainApp.mwraList.size());

        mwraAdapter = new MWRAAdapter(this, MainApp.mwraList);
        bi.rvMwra.setAdapter(mwraAdapter);
        bi.rvMwra.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainApp.form.getiStatus().equals("")) {
                    //     Toast.makeText(MwraActivity.this, "Opening Mwra Form", Toast.LENGTH_LONG).show();
                    MainApp.mwra = new MWRA();
                    addFemale();
                } else {
                    Toast.makeText(MwraListActivity.this, "This form has been locked. You cannot add new MWRA to locked forms", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed!", Toast.LENGTH_SHORT).show();

        //MainApp.mwra = new MWRA();
        //MainApp.child = new Child();
        if (MainApp.mwraList.size() > 0) {
            //MainApp.fm.get(Integer.parseInt(String.valueOf(MainApp.selectedFemale))).setStatus("1");
            bi.btnRand.setVisibility(View.VISIBLE);
        }
        checkCompleteFm();


        // bi.fab.setClickable(!MainApp.form.getiStatus().equals("1"));
      /* bi.completedmember.setText(mwra.size()+ " MWRAs added");
        bi.totalmember.setText(MainApp.mwraTotal+ " M completed");*/
    }

    private void checkCompleteFm() {
        //     if (!MainApp.form.getIStatus().equals("1")) {
        int compCount = MainApp.mwraList.size();

        MainApp.mwraCountComplete = compCount;
        //   bi.btnContinue.setVisibility(compCount == mwraCount && !form.getiStatus().equals("1")? View.VISIBLE : View.GONE);
     /*   bi.btnContinue.setVisibility(compCount >= mwraCount ? View.VISIBLE : View.GONE);
        bi.btnContinue.setEnabled(bi.btnContinue.getVisibility()==View.VISIBLE);*/

        //  } else {
        //       Toast.makeText(this, "Form has been completed or locked", Toast.LENGTH_LONG).show();
        //   }
    }

    public void addFemale() {
        if (MainApp.mwraList.size() >= Integer.parseInt(MainApp.form.getH220b())) {
            displayAddMoreDialog();
        } else {
            addMoreMWRA();

        }
    }

    public void btnContinue(View view) {

        MainApp.mwra = db.getSelectedMwraBYUID(MainApp.form.getUid());
        MainApp.mwraList = new ArrayList<>();
        finish();
        startActivity(new Intent(this, !MainApp.mwra.getIndexed().equals("1") ? EndingActivity.class : ChildListActivity.class).putExtra("complete", true));

        //MainApp.mwra = MainApp.mwraList.get(Integer.parseInt(MainApp.selectedFemale));

    /*    MainApp.mwra = db.getSelectedMwraBYUID(MainApp.form.getUid());
        MainApp.mwraList = new ArrayList<>();
        finish();
        startActivity(new Intent(this, !MainApp.mwra.getIndexed().equals("1") ? EndingActivity.class : ChildListActivity.class).putExtra("complete", true));
    */
        /*else if (MainApp.mwraList.size() < MainApp.mwraCount) {

            Snackbar snackbar = Snackbar
                    .make(bi.parentLayout, "www.journaldev.com", Snackbar.LENGTH_LONG);
            snackbar.show();
        }*/

    }

    private void proceedSelect() {


        int aCount = 0;
        for (int i = 0; i < MainApp.mwraList.size(); i++) {

            // Get MWRA from list
            MainApp.mwra = MainApp.mwraList.get(i);

            // Unselect and Disable if MWRA has been previously selected and refused
            if (MainApp.mwra.getIndexed().equals("1")) {
                db.updatesMWRAListColumn(TableContracts.MWRAListTable.COLUMN_INDEXED, "-1");
                MainApp.mwraList.get(i).setIndexed("-1");
                mwraAdapter.notifyItemChanged(i);
            }

            // Count not refused and available mwra
            if (MainApp.mwra.getIndexed().equals("") && MainApp.mwra.getH227().equals("1")) {
                aCount++;
            }
        }

        if (aCount < 1) {
            Toast.makeText(this, "No MWRA available for selection.", Toast.LENGTH_LONG).show();
            MainApp.selectedFemale = "";
            bi.btnRand.setVisibility(View.INVISIBLE);
            //bi.btnContinue.setVisibility(View.VISIBLE);
            return;

        }

        Random r = new Random();
        int indx = r.nextInt(MainApp.mwraCount);

        MainApp.mwra = MainApp.mwraList.get(indx);
        if (MainApp.mwra.getIndexed().equals("-1") || MainApp.mwra.getH227().equals("2")) {

            // No MWRA selected because randomised and refused is already indexed or not available.
            Toast.makeText(this, "No MWRA was selected.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, MainApp.mwra.getH221() + " has been selected. Please continue.", Toast.LENGTH_LONG).show();
            MainApp.selectedFemale = String.valueOf(indx);

            // Updating database to mark indexed mother
            db.updatesMWRAListColumn(TableContracts.MWRAListTable.COLUMN_INDEXED, "1");

            // Updating adapter
            MainApp.mwraList.get(indx).setIndexed("1");
            mwraAdapter.notifyItemChanged(indx);
            bi.btnRand.setVisibility(View.INVISIBLE);
            bi.btnContinue.setVisibility(View.VISIBLE);
            bi.btnContinue.setEnabled(true);
        }

    }


    private void displayAddMoreDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_mwra_dialog)
                .setMessage(String.format(getString(R.string.message_mwra_dialog_addmore), MainApp.form.getH220b()))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.h111a, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        addMoreMWRA();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.h111b, null)
                .setIcon(R.drawable.ic_alert_24)
                .show();

    }

    private void displayProceedDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_mwra_dialog)
                .setMessage(String.format(getString(R.string.message_mwra_dialog_proceeed), MainApp.mwraList.size(), MainApp.form.getH220b()))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.h111a, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        proceedSelect();
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(R.string.h111b, null)
                .setIcon(R.drawable.ic_alert_24)
                .show();

    }

    private void addMoreMWRA() {
        Intent intent = new Intent(this, SectionH2cActivity.class);
        //   finish();
        MemberInfoLauncher.launch(intent);
    }

    public void btnEnd(View view) {

        finish();
        startActivity(new Intent(this, MainActivity.class));
        /*   } else {
               Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
           }*/
    }

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                //   mwra.get(selectedFemale).setExpanded(false);
                checkCompleteFm();
                mwraAdapter.notifyItemChanged(selectedFemale);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                // Write your code if there's no result
                Toast.makeText(this, "Child for " + MainApp.mwraList.get(selectedFemale).getH221() + " was not added.", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    public void btnRand(View view) {
        if (MainApp.mwraList.size() < Integer.parseInt(MainApp.form.getH220b())) {
            displayProceedDialog();
        } else {
            proceedSelect();
        }
    }
}