package edu.aku.hassannaqvi.tajik_anemia_study.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.tajik_anemia_study.R;
import edu.aku.hassannaqvi.tajik_anemia_study.core.MainApp;
import edu.aku.hassannaqvi.tajik_anemia_study.models.Pregnancy;


public class PregAdapter extends RecyclerView.Adapter<PregAdapter.ViewHolder> {
    private static final String TAG = "PregAdapter";
    private final Context mContext;
    private final List<Pregnancy> pregList;
    private final int mExpandedPosition = -1;
    private final int completeCount;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param pregList List<FemaleMembersModel> containing the data to populate views to be used by RecyclerView.
     */
    public PregAdapter(Context mContext, List<Pregnancy> pregList) {
        this.pregList = pregList;
        this.mContext = mContext;
        completeCount = 0;
        MainApp.pregComplete = false;


    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        Pregnancy preg = this.pregList.get(position);        // Get element from your dataset at this position and replace the contents of the view
        // with that element

        TextView w114 = viewHolder.w114;
        TextView w115 = viewHolder.w115;
        TextView w116 = viewHolder.w116;
        TextView w117 = viewHolder.w117;
        TableRow itemRow = viewHolder.itemRow;
 /*       TextView fAge = viewHolder.fAge;
        // LinearLayout subItem = viewHolder.subItem;
        ImageView fmRow = viewHolder.fmRow;
        ImageView mainIcon = viewHolder.mainIcon;
        // TextView addSec = viewHolder.addSec;
        TextView fMaritalStatus = viewHolder.fMatitalStatus;
        TextView secStatus = viewHolder.secStatus;
        View cloak = viewHolder.cloak;*/

        //int mStatus = Integer.parseInt(mwra.getHh06());
        // int age = Integer.parseInt(mwra.getH223());
        //int mCate = 0;  // 1 = MWRA : 2 = AdolFeMale : 3 = AdolMale
        //int gender = Integer.parseInt(preg.getH232());
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
        MainApp.pregComplete = completeCount == MainApp.pregCount;
       /* secStatus.setBackgroundColor(mwra.getStatus().equals("1") || mCate == 0 ? mContext.getResources().getColor(R.color.redDark) : mContext.getResources().getColor(R.color.green));
        addSec.setClickable((!mwra.getStatus().equals("1") || mCate == 0) && mPresent);*/

/*        if (mwra.getStatus().equals("1") || mCate == 0) {
            Toast.makeText(mContext, mwra.getStatus() + " | " + mCate +" | "+position, Toast.LENGTH_SHORT).show();
            fmRow.setImageResource(R.drawable.ic_check_circle_big);
        }*/

        String birthStatus = "";
        switch (preg.getW115()) {
            case "1":
                birthStatus = mContext.getString(R.string.w115a);
                break;
            case "2":
                birthStatus = mContext.getString(R.string.w115b);
                break;
            case "3":
                birthStatus = mContext.getString(R.string.w115c);
                break;
            case "4":
                birthStatus = mContext.getString(R.string.w115d);
                break;
            case "5":
                birthStatus = mContext.getString(R.string.w115e);
                break;
            case "6":
                birthStatus = mContext.getString(R.string.w115f);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + preg.getW115());
        }


        String curStatus = "";
        switch (preg.getW116()) {
            case "1":
                curStatus = "Alive";
                break;
            case "2":
                curStatus = "Died";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + preg.getW116());
        }

        w114.setText(preg.getW114d() + "-" + preg.getW114m() + "-" + preg.getW114y());
        w115.setText(birthStatus);
        w116.setText(curStatus);
        if ((preg.getW116().equals("1"))) {
            w117.setText((preg.getW117y() + "y / " + preg.getW117m() + "m / " + preg.getW117d() + "d"));
        } else {
            w117.setText("(at death)\r\n" + preg.getW118y() + "y / " + preg.getW118m() + "m / " + preg.getW118d() + "d");
        }
        itemRow.setBackgroundColor(position % 2 != 0 ? mContext.getColor(R.color.grayLight) : mContext.getColor(R.color.white));
/*        fAge.setText(preg.getH231y() + " | " + (preg.getH232().equals("1") ? "Boy" : "Girl"));
        mainIcon.setImageResource((preg.getH232().equals("1") ? R.drawable.ic_boy : R.drawable.ic_girl));
        mainIcon.setBackgroundColor(preg.getIndexed().equals("1") ? mContext.getResources().getColor(R.color.greenLight) : (preg.getH232().equals("1") ? mContext.getResources().getColor(R.color.boy_blue) : mContext.getResources().getColor(R.color.girl_pink)));
        cloak.setVisibility(View.GONE);
        if (!MainApp.selectedPreg.equals("")) {
            cloak.setVisibility(preg.getIndexed().equals("1") ? View.GONE : View.VISIBLE);
        }*/

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

        // fMaritalStatus.setText("Reported Pregren: " + mwra.getH226m() + " boy(s), " + mwra.getH226f() + "girl(s)");
        //addSec.setClickable(mCate != 0);
        // addSec.setText("+ Add Pregren");


        //  AtomicBoolean expanded = new AtomicBoolean(preg.isExpanded());
        // Set the visibility based on state
        //    subItem.setVisibility(expanded.get() ? View.VISIBLE : View.GONE);

        viewHolder.itemView.setOnClickListener(v -> {
/*
            expanded.set(preg.isExpanded());
            // Change the state
            preg.setExpanded(!expanded.get());
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
    public PregAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        // Context context = parent.getContext();
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.preg_row, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pregList.size();
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView w114;
        private final TextView w115;
        private final TextView w116;
        private final TextView w117;
        private final TableRow itemRow;
        //private final TextView addSec;
        //private final LinearLayout subItem;
 /*       private final ImageView fmRow;
        private final ImageView mainIcon;
        private final View cloak;*/


        public ViewHolder(View v) {
            super(v);
            w114 = v.findViewById(R.id.w114);
            w115 = v.findViewById(R.id.w115);
            w116 = v.findViewById(R.id.w116);
            w117 = v.findViewById(R.id.w117);
            itemRow = v.findViewById(R.id.itemRow);
            //  addSec = v.findViewById(R.id.cadd_section);
            //  subItem = v.findViewById(R.id.csubitem);
            /*fmRow = v.findViewById(R.id.cfmRow);
            mainIcon = v.findViewById(R.id.mainIcon);
            cloak = v.findViewById(R.id.cloaked);*/
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

   /*     public TextView getTextView() {
            return fName;
        }*/
    }


}
