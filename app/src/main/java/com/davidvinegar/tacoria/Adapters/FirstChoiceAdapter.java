package com.davidvinegar.tacoria.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidvinegar.tacoria.R;
import com.davidvinegar.tacoria.events.BurritoEvent;
import com.davidvinegar.tacoria.events.TacoEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class FirstChoiceAdapter extends RecyclerView.Adapter<FirstChoiceAdapter.FirstChoiceHolder> {
    private ArrayList<FirstChoiceOption> mDataSet;
    private Context context;

    public static final int BURRITO = 0;


    public static class FirstChoiceHolder extends RecyclerView.ViewHolder {

        CardView burritoCard;
        CardView tacoCard;

        public FirstChoiceHolder(View v) {

            super(v);
            burritoCard = (CardView) v.findViewById(R.id.burritoCV);
            tacoCard = (CardView) v.findViewById(R.id.tacoCV);
        }
    }

    public class BurritoViewHolder extends FirstChoiceHolder {
        TextView name;
        ImageView photo;

        public BurritoViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.burrito_text);
            this.photo = (ImageView) v.findViewById(R.id.beautiful_burrito);

        }
    }

    public class TacoViewHolder extends FirstChoiceHolder {
        TextView name;
        ImageView photo;

        public TacoViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.taco_text);
            this.photo = (ImageView) v.findViewById(R.id.taco_photo);

        }
    }

    public FirstChoiceAdapter(ArrayList<FirstChoiceOption> firstChoiceOptionsList, Context context) {

        this.context = context;
        mDataSet = firstChoiceOptionsList;
    }

    @Override
    public FirstChoiceHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == BURRITO) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.firstchoice_burrito_card, viewGroup, false);
            return new BurritoViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.firstchoice_taco_card, viewGroup, false);
            return new TacoViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(FirstChoiceHolder viewHolder, int position) {

        if (viewHolder.getItemViewType() == BURRITO) {
            BurritoViewHolder holder = (BurritoViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
            holder.burritoCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new BurritoEvent());

                }
            });
        } else {
            TacoViewHolder holder = (TacoViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
            holder.tacoCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new TacoEvent());

                }
            });

        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        int[] mDataSetTypes = {0, 1};
        return mDataSetTypes[position];
    }
}
