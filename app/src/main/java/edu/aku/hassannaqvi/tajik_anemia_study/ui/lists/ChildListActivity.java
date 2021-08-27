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

import edu.aku.hassannaqvi.tajik_anemia_study.MainActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.adapters.ChildAdapter;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivityChildListBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Child;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH2dActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.sections.SectionH3aActivity;


public class ChildListActivity extends AppCompatActivity {


    private static final String TAG = "MwraActivity";
    ActivityChildListBinding bi;
    DatabaseHelper db;
    private ChildAdapter childAdapter;
    ActivityResultLauncher<Intent> MemberInfoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        //Intent data = result.getData();
                        // Intent data = result.getData();
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
                        MainApp.childList.add(MainApp.child);

                        MainApp.childCount++;
                        childAdapter.notifyItemInserted(MainApp.childList.size() - 1);
                        //  Collections.sort(MainApp.fm, new SortByStatus());
                        //fmAdapter.notifyDataSetChanged();

                        //        }

                     //   checkCompleteFm();
                    }
                    if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Toast.makeText(ChildListActivity.this, "No child added.", Toast.LENGTH_SHORT).show();
                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mwra);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_child_list);
        bi.setCallback(this);
        bi.setMwra(MainApp.mwra);

        db = MainApp.appInfo.dbHelper;
        MainApp.childList = new ArrayList<>();
        Log.d(TAG, "onCreate: childlist " + MainApp.childList.size());
        MainApp.childList = db.getChildBYMUID(MainApp.mwra.getUid());

        // Set Selected Child
        for (int i = 0; i < MainApp.childList.size(); i++) {
            if (MainApp.childList.get(i).getIndexed().equals("1")) {
                MainApp.selectedChild = String.valueOf(i);
                break;
            }
        }
        MainApp.childCount = Math.round(MainApp.childList.size());

        childAdapter = new ChildAdapter(this, MainApp.childList);
        bi.rvChild.setAdapter(childAdapter);
        bi.rvChild.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
            if (MainApp.form.getiStatus().equals("")) {
                //     Toast.makeText(MwraActivity.this, "Opening Mwra Form", Toast.LENGTH_LONG).show();
                MainApp.child = new Child();
                MainApp.child.setH228(String.valueOf(MainApp.childList.size() + 1));
                addChild();
            } else {
                Toast.makeText(ChildListActivity.this, "This form has been locked. You cannot add new children to locked forms", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity Resumed!", Toast.LENGTH_SHORT).show();

        //MainApp.mwra = new MWRA();
        //MainApp.child = new Child();
        if (MainApp.childList.size() > 0) {
            //MainApp.fm.get(Integer.parseInt(String.valueOf(MainApp.selectedFemale))).setStatus("1");
            bi.btnContinue.setVisibility(View.VISIBLE);
            bi.btnContinue.setEnabled(true);
            bi.btnRand.setVisibility(View.VISIBLE);

        }
        // checkCompleteFm();


        // bi.fab.setClickable(!MainApp.form.getiStatus().equals("1"));
      /* bi.completedmember.setText(mwra.size()+ " MWRAs added");
        bi.totalmember.setText(MainApp.mwraTotal+ " M completed");*/
    }

/*    private void checkCompleteFm() {
        //     if (!MainApp.form.getIStatus().equals("1")) {
        int compCount = MainApp.mwraList.size();

        MainApp.mwraCountComplete = compCount;
        //   bi.btnContinue.setVisibility(compCount == mwraCount && !form.getiStatus().equals("1")? View.VISIBLE : View.GONE);
     *//*   bi.btnContinue.setVisibility(compCount >= mwraCount ? View.VISIBLE : View.GONE);
        bi.btnContinue.setEnabled(bi.btnContinue.getVisibility()==View.VISIBLE);*//*

        //  } else {
        //       Toast.makeText(this, "Form has been completed or locked", Toast.LENGTH_LONG).show();
        //   }
    }*/

    public void addChild() {
        if (MainApp.childList.size() >= Integer.parseInt(MainApp.mwra.getH226t())) {
            displayAddMoreDialog();
        } else {
            addMoreChild();

        }
    }

    public void btnContinue(View view) {

        MainApp.child = db.getYoungestChildByMUID(MainApp.mwra.getUid());
        MainApp.childList = new ArrayList<>();
        finish();


        startActivity(new Intent(this, SectionH3aActivity.class).putExtra("complete", true));
        //startActivity(new Intent(this, PregnancyListActivity.class).putExtra("complete", true));

    }

    private void displayAddMoreDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_child_dialog)
                .setMessage(String.format(getString(R.string.message_child_dialog_addmore), MainApp.mwra.getH226t()))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(R.string.h111a, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        addMoreChild();
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
                .setMessage(String.format(getString(R.string.message_mwra_dialog_proceeed), MainApp.mwraList.size() + "", MainApp.mwra.getH226t()))

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


    private void addMoreChild() {
        Intent intent = new Intent(this, SectionH2dActivity.class);
        //   finish();
        MemberInfoLauncher.launch(intent);
    }

    private void proceedSelect() {

        int aCount = 0;

        String childUid = db.getYoungestChildByMUID(MainApp.mwra.getUid()).getUid();
        for (int i = 0; i < MainApp.childList.size(); i++) {

            MainApp.child = MainApp.childList.get(i);
            // Get Child from list
            String curChildUid = MainApp.child.getUid();

            // Unselect and Disable if MWRA has been previously selected and refused
            if (childUid.equals(curChildUid)) {
                MainApp.selectedChild = String.valueOf(i);
                MainApp.child.setIndexed("1");
                childAdapter.notifyDataSetChanged();

                // Updating database to mark indexed mother
                db.updatesChildListColumn(TableContracts.ChildListTable.COLUMN_INDEX, "1");

                // Updating adapter
                bi.btnRand.setVisibility(View.INVISIBLE);
                bi.btnContinue.setVisibility(View.VISIBLE);
                bi.btnContinue.setEnabled(true);
            }

        }

    }


    public void btnEnd(View view) {

        finish();
        startActivity(new Intent(this, MainActivity.class));
        /*   } else {
               Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
           }*/
    }


    public void btnRand(View view) {

        if (MainApp.childList.size() < Integer.parseInt(MainApp.mwra.getH226t())) {
            displayProceedDialog();
        } else {
            proceedSelect();
        }

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

}