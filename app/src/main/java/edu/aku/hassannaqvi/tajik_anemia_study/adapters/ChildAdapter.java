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
import edu.aku.hassannaqvi.tajik_anemia_study.models.Child;


public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    private static final String TAG = "ChildAdapter";
    private final Context mContext;
    private final List<Child> childList;
    private final int mExpandedPosition = -1;
    private final int completeCount;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param childList List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public ChildAdapter(Context mContext, List<Child> childList) {
        this.childList = childList;
        this.mContext = mContext;
        completeCount = 0;
        MainApp.childComplete = false;


    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        Child child = this.childList.get(position);        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView fName = viewHolder.fName;
        TextView fAge = viewHolder.fAge;
        // LinearLayout subItem = viewHolder.subItem;
        ImageView fmRow = viewHolder.fmRow;
        // TextView addSec = viewHolder.addSec;
        TextView fMaritalStatus = viewHolder.fMatitalStatus;
        TextView secStatus = viewHolder.secStatus;
        // View indicator = viewHolder.indicator;

        //int mStatus = Integer.parseInt(mwra.getHh06());
        // int age = Integer.parseInt(mwra.getH223());
        //int mCate = 0;  // 1 = MWRA : 2 = AdolFeMale : 3 = AdolMale
        //int gender = Integer.parseInt(child.getH232());
        // Set MWRA
/*        if (mStatus != 2 && age >= MainApp.MIN_MWRA && age < MainApp.MAX_MWRA && gender == 2) {
            mCate = 1;
        }
        // Set Adol
        if (mStatus == 2 && age >= MainApp.MIN_ADOL && age < MainApp.MAX_ADOL) {
            if (gender == 2) {
                // Adol-Female
                mCate = 2;
            } else {
                // Adol-Male
                mCate = 3;
            }
        }
        boolean mPresent = mwra.getHh11().equals("2");
        Log.d(TAG, "onBindViewHolder: Memeber - " + mwra.getHh02() + " - " + mwra.getStatus());
        secStatus.setText(mwra.getStatus().equals("1") || mCate == 0 ? "< Complete >"
                : "< Pending! >");
        completeCount += (mwra.getStatus().equals("1") || mCate == 0 ? 1 : 0);
        //MainApp.fmCountComplete = completeCount;*/
        MainApp.childComplete = completeCount == MainApp.childCount.get(position);
       /* secStatus.setBackgroundColor(mwra.getStatus().equals("1") || mCate == 0 ? mContext.getResources().getColor(R.color.redDark) : mContext.getResources().getColor(R.color.green));
        addSec.setClickable((!mwra.getStatus().equals("1") || mCate == 0) && mPresent);*/

/*        if (mwra.getStatus().equals("1") || mCate == 0) {
            Toast.makeText(mContext, mwra.getStatus() + " | " + mCate +" | "+position, Toast.LENGTH_SHORT).show();
            fmRow.setImageResource(R.drawable.ic_check_circle_big);
        }*/

        fName.setText(child.getH229());
        fAge.setText(child.getH231y() + " | " + (child.getH232().equals("1") ? "Boy" : "Girl"));


        //  indicator.setBackgroundColor(mCate == 1 ? mContext.getResources().getColor(R.color.redDark) : mCate == 2 ? mContext.getResources().getColor(R.color.colorPink) : mCate == 3 ? mContext.getResources().getColor(R.color.colorPrimary) : mContext.getResources().getColor(R.color.gray));
        //   indicator.setBackgroundColor(mwra.getStatus().equals("1") || mCate == 0 ? mContext.getResources().getColor(R.color.gray):indicator.getDrawingCacheBackgroundColor());

 /*       String marStatus = "";
        switch (mwra.getHh06()) {
            case "1":
                marStatus = "Married";
                break;
            case "2":
                marStatus = "Unmarried";
                break;
            case "3":
                marStatus = "Widow";
                break;
            case "4":
                marStatus = "Divorced/Seperated";
                break;
            default:
                marStatus = "Value Unknown";
                break;
        }*/

        // fMaritalStatus.setText("Reported Children: " + mwra.getH226m() + " boy(s), " + mwra.getH226f() + "girl(s)");
        //addSec.setClickable(mCate != 0);
        // addSec.setText("+ Add Children");


        //  AtomicBoolean expanded = new AtomicBoolean(child.isExpanded());
        // Set the visibility based on state
        //    subItem.setVisibility(expanded.get() ? View.VISIBLE : View.GONE);

        viewHolder.itemView.setOnClickListener(v -> {
/*
            expanded.set(child.isExpanded());
            // Change the state
            child.setExpanded(!expanded.get());
            // Notify the adapter that item has changed
            notifyItemChanged(position);
            // Get the current state of the item
       *//*     if (!mwra.getStatus().equals("1")) {
                expanded.set(mwra.isExpanded());
                // Change the state
                mwra.setExpanded(!expanded.get());
                // Notify the adapter that item has changed
                notifyItemChanged(position);
            } else {
                Toast.makeText(mContext, "Form already filled for " + mwra.getHh02() + ".", Toast.LENGTH_SHORT).show();
            }*/
        });

        //int finalMCate = mCate;
/*        viewHolder.addSec.setOnClickListener(v -> {
            // Get the current state of the item
            Intent intent = null;
            intent = new Intent(mContext, SectionH2dActivity.class);
            intent.putExtra("position", position);
           *//* switch (finalMCate) {
                case 1: // MWRA

                    break;
                case 2: // Adol Female
                case 3: // Adol Male
                    intent = new Intent(mContext, SectionAdolActivity.class);
                    intent.putExtra("position", position);
                    break;

            }*//*
            MainApp.selectedFemale = position;
            if (intent != null) {
                //   ((Activity)mContext).finish();
                intent.putExtra("position", position);

                ((Activity) mContext).startActivityForResult(intent, 2);

            } else {
                Toast.makeText(mContext, "No Additional Information Required!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }


    // END_INCLUDE(recyclerViewSampleViewHolder)


    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        // Context context = parent.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mother_row, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return childList.size();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView fName;
        private final TextView fAge;
        private final TextView fMatitalStatus;
        private final TextView secStatus;
        //private final TextView addSec;
        //private final LinearLayout subItem;
        private final ImageView fmRow;
        // private final View indicator;


        public ViewHolder(View v) {
            super(v);
            fName = v.findViewById(R.id.chh02);
            fAge = v.findViewById(R.id.chh05);
            fMatitalStatus = v.findViewById(R.id.chh06);
            secStatus = v.findViewById(R.id.csecStatus);
            //  addSec = v.findViewById(R.id.cadd_section);
            //  subItem = v.findViewById(R.id.csubitem);
            fmRow = v.findViewById(R.id.cfmRow);
            // indicator = v.findViewById(R.id.cindicator);
            // Define click listener for the ViewHolder's View.

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d(TAG, "Element " + getBindingAdapterPosition() + " clicked.");
                  /*  if (subItem.getVisibility()==View.VISIBLE)
                        subItem.setVisibility(View.GONE);
                    else
                        subItem.setVisibility(View.VISIBLE);*/
                }
            });

/*            v.findViewById(R.id.cadd_section).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });*/

        }

        public TextView getTextView() {
            return fName;
        }
    }


}
