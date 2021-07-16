package edu.aku.hassannaqvi.tajik_anemia_study.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.models.MWRA;


public class MWRAAdapter extends RecyclerView.Adapter<MWRAAdapter.ViewHolder> {
    private static final String TAG = "MWRAAdapter";
    private final Context mContext;
    private final List<MWRA> mwra;
    private final int mExpandedPosition = -1;
    private final int completeCount;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param mwra List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public MWRAAdapter(Context mContext, List<MWRA> mwra) {
        this.mwra = mwra;
        this.mContext = mContext;
        completeCount = 0;
        MainApp.mwraComplete = false;


    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        MWRA mwra = this.mwra.get(position);        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView fName = viewHolder.fName;
        TextView fAge = viewHolder.fAge;
        TextView fMaritalStatus = viewHolder.fMatitalStatus;
        View indicator = viewHolder.indicator;
        View cloaked = viewHolder.cloaked;

        //String pregStatus = mwra.getRb07().equals("1") ? "Pregnant" : "Not Pregnant";

        MainApp.mwraComplete = completeCount == MainApp.mwraCount;

        fName.setText(mwra.getH221());
        fAge.setText(mwra.getH223());

    /*    String marStatus = "";
        switch (mwra.getRb06()) {
            case "2":
                marStatus = "Currently Married";
                break;
            case "3":
                marStatus = "Unmarried";
                break;
            default:
                marStatus = "Value Unknown";
                break;
        }



*/

        cloaked.setVisibility(mwra.getH227().equals("1") ? View.GONE : View.VISIBLE);
        indicator.setBackgroundColor(mwra.getIndexed().equals("1") ? mContext.getResources().getColor(R.color.greenLight) : mContext.getResources().getColor(R.color.gray));
        if (!MainApp.selectedFemale.equals("")) {
            cloaked.setVisibility(mwra.getIndexed().equals("1") ? View.GONE : View.VISIBLE);
        }
        fMaritalStatus.setText("Children: " + mwra.getH226m() + " boy(s), " + mwra.getH226f() + " girl(s)");
      /*  viewHolder.itemView.setOnClickListener(v -> {
            // Get the current state of the item

            MainApp.mwra = MainApp.mwra.get(position);
            Intent intent = new Intent(mContext, SectionBActivity.class);

            intent.putExtra("position", position);

            MainApp.selectedFemale = position;

            intent.putExtra("position", position);

            ((Activity) mContext).startActivityForResult(intent, 2);


        });*/

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mother_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mwra.size();
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView fName;
        private final TextView fAge;
        private final TextView fMatitalStatus;
        private final TextView secStatus;
        private final ImageView fmRow;
        private final View indicator;
        private final View cloaked;


        public ViewHolder(View v) {
            super(v);
            fName = v.findViewById(R.id.hh02);
            fAge = v.findViewById(R.id.hh05);
            fMatitalStatus = v.findViewById(R.id.hh06);
            secStatus = v.findViewById(R.id.secStatus);
            fmRow = v.findViewById(R.id.fmRow);
            indicator = v.findViewById(R.id.indicator);
            cloaked = v.findViewById(R.id.cloaked);

        }

        public TextView getTextView() {
            return fName;
        }
    }


}
