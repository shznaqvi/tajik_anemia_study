package edu.aku.hassannaqvi.tajik_anemia_study.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.contracts.TableContracts.FormsTable;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.database.DatabaseHelper;
import edu.aku.hassannaqvi.tajik_anemia_study.databinding.ActivitySectionH2bBinding;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.EndingActivity;
import edu.aku.hassannaqvi.tajik_anemia_study.ui.lists.MwraListActivity;

import static edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp.form;

public class SectionH2bActivity extends AppCompatActivity {
    ActivitySectionH2bBinding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2b);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }

    private void setupSkips() {
     /*   rgLsnr(bi.h210, bi.h210b, new ViewGroup[]{bi.fldGrpCVh211});
        rgLsnr(bi.h212, bi.h212b, new ViewGroup[]{bi.fldGrpCVh213});
        rgLsnr(bi.h214, bi.h214b, new ViewGroup[]{bi.fldGrpCVh215});
        rgLsnr(bi.h216, bi.h216b, new ViewGroup[]{bi.fldGrpCVh217});
        rgLsnr(bi.h218, bi.h218b, new ViewGroup[]{bi.fldGrpCVh219});*/
    }

    public void setMaxValue(CharSequence s, int i, int i1, int i2) {
/*        if (TextUtils.isEmpty(bi.h209.getText())) return;
        bi.h211t.setMaxvalue(Float.parseFloat(bi.h209.getText().toString()));
        bi.h213t.setMaxvalue(Float.parseFloat(bi.h209.getText().toString()));
        bi.h215t.setMaxvalue(Float.parseFloat(bi.h209.getText().toString()));
        bi.h217t.setMaxvalue(Float.parseFloat(bi.h209.getText().toString()));
        bi.h219t.setMaxvalue(Float.parseFloat(bi.h209.getText().toString()));*/

    }

    private boolean updateDB() {
        db = MainApp.appInfo.getDbHelper();
        long updcount = db.updatesFormColumn(FormsTable.COLUMN_SH2B, form.sH2btoString());
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void btnContinue(View view) {
        if (!formValidation()) return;
        saveDraft();
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, MwraListActivity.class).putExtra("complete", true));
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }

    private void saveDraft() {

     /*   form.setH209(bi.h209.getText().toString().isEmpty() ? "-1" : bi.h209.getText().toString());

        form.setH210(bi.h210a.isChecked() ? "1"
                : bi.h210b.isChecked() ? "2"
                : "-1");

        form.setH211t(bi.h211t.getText().toString().isEmpty() ? "-1" : bi.h211t.getText().toString());
        form.setH211m(bi.h211m.getText().toString().isEmpty() ? "-1" : bi.h211m.getText().toString());
        form.setH211f(bi.h211f.getText().toString().isEmpty() ? "-1" : bi.h211f.getText().toString());

        form.setH212(bi.h212a.isChecked() ? "1"
                : bi.h212b.isChecked() ? "2"
                : "-1");

        form.setH213t(bi.h213t.getText().toString().isEmpty() ? "-1" : bi.h213t.getText().toString());
        form.setH213m(bi.h213m.getText().toString().isEmpty() ? "-1" : bi.h213m.getText().toString());
        form.setH213f(bi.h213f.getText().toString().isEmpty() ? "-1" : bi.h213f.getText().toString());

        form.setH214(bi.h214a.isChecked() ? "1"
                : bi.h214b.isChecked() ? "2"
                : "-1");

        form.setH215t(bi.h215t.getText().toString().isEmpty() ? "-1" : bi.h215t.getText().toString());
        form.setH215m(bi.h215m.getText().toString().isEmpty() ? "-1" : bi.h215m.getText().toString());
        form.setH215f(bi.h215f.getText().toString().isEmpty() ? "-1" : bi.h215f.getText().toString());

        form.setH216(bi.h216a.isChecked() ? "1"
                : bi.h216b.isChecked() ? "2"
                : "-1");

        form.setH217t(bi.h217t.getText().toString().isEmpty() ? "-1" : bi.h217t.getText().toString());
        form.setH217m(bi.h217m.getText().toString().isEmpty() ? "-1" : bi.h217m.getText().toString());
        form.setH217f(bi.h217f.getText().toString().isEmpty() ? "-1" : bi.h217f.getText().toString());

        form.setH218(bi.h218a.isChecked() ? "1"
                : bi.h218b.isChecked() ? "2"
                : "-1");

        form.setH219t(bi.h219t.getText().toString().isEmpty() ? "-1" : bi.h219t.getText().toString());
        form.setH219m(bi.h219m.getText().toString().isEmpty() ? "-1" : bi.h219m.getText().toString());
        form.setH219f(bi.h219f.getText().toString().isEmpty() ? "-1" : bi.h219f.getText().toString());
        form.setH220a(bi.h220a.getText().toString().isEmpty() ? "-1" : bi.h220a.getText().toString());
        form.setH220b(bi.h220b.getText().toString().isEmpty() ? "-1" : bi.h220b.getText().toString());
        form.setH220c(bi.h220c.getText().toString().isEmpty() ? "-1" : bi.h220c.getText().toString());*/

    }

    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

    private boolean formValidation() {
        String errMsg = "";
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false;

        if (Integer.parseInt(MainApp.form.getH220a()) < Integer.parseInt(MainApp.form.getH217f())
                || Integer.parseInt(MainApp.form.getH220a()) > (Integer.parseInt(MainApp.form.getH215f()) + Integer.parseInt(MainApp.form.getH217f()))
        )
            return Validator.emptyCustomTextBox(this, bi.h220a, "H220: WRA count does not match Females 20-49.");



     /*   // Internal Validation for Q H211 - H119 and H220 for Male + Female = Total
        if (!validateMembers(bi.h211t, bi.h211m, bi.h211f, "H211")) return false;
        if (!validateMembers(bi.h213t, bi.h213m, bi.h213f, "H213")) return false;
        if (!validateMembers(bi.h215t, bi.h215m, bi.h215f, "H215")) return false;
        if (!validateMembers(bi.h217t, bi.h217m, bi.h217f, "H217")) return false;
        if (!validateMembers(bi.h219t, bi.h219m, bi.h219f, "H219")) return false;
        if (!validateMembers(bi.h220a, bi.h220b, bi.h220c, "H220")) return false;

        // Cross Validation of Q H209 with Total sum of Q H211 - H219
        int totalMember =0;
        if(!bi.h211t.getText().toString().equals("")) totalMember += Integer.parseInt(MainApp.form.getH211t());
        if(!bi.h213t.getText().toString().equals("")) totalMember += Integer.parseInt(MainApp.form.getH213t());
        if(!bi.h215t.getText().toString().equals("")) totalMember += Integer.parseInt(MainApp.form.getH215t());
        if(!bi.h217t.getText().toString().equals("")) totalMember += Integer.parseInt(MainApp.form.getH217t());
        if(!bi.h219t.getText().toString().equals("")) totalMember += Integer.parseInt(MainApp.form.getH219t());
     *//*   if (Integer.parseInt(bi.h209.getText().toString()) != totalMember){
            errMsg = String.format(getResources().getString(R.string.error_member_count), "H209");
            return Validator.emptyCustomTextBox(this, bi.h209, errMsg);
        }*//*

        // Cross Validation of Q H220 with females in Q H217 (Condition: H220 >= females in H217)

        int H215f = Math.round(Float.parseFloat(MainApp.form.getH215f()));
*/
      /*  if (Integer.parseInt(bi.h217f.getText().toString()) != totalMember) {
            errMsg = String.format(getResources().getString(R.string.error_member_count_household), "H209");
            return Validator.emptyCustomTextBox(this, bi.h209, errMsg);
        }
*/
        return true;

    }

   /* private boolean validateMembers(EditTextPicker t, EditTextPicker m, EditTextPicker f, String q) {

    if (!t.getText().toString().isEmpty() && !m.getText().toString().isEmpty() && !f.getText().toString().isEmpty()) {
        int ct, cf, cm = 0;


        String errMsg = String.format(getResources().getString(R.string.error_member_count), q);

        ct = Integer.parseInt(t.getText().toString());
        cm = Integer.parseInt(m.getText().toString());
        cf = Integer.parseInt(f.getText().toString());
        if (ct != cm + cf) {
            return Validator.emptyCustomTextBox(this, t, errMsg);
        }
    }
        return true;
    }*/

/*

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
*/


}