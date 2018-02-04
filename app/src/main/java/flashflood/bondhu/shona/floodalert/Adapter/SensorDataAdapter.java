package flashflood.bondhu.shona.floodalert.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import flashflood.bondhu.shona.floodalert.Activity.SensorDataActivity;
import flashflood.bondhu.shona.floodalert.Constant;
import flashflood.bondhu.shona.floodalert.Model.DataItem;
import flashflood.bondhu.shona.floodalert.R;

/**
 * Created by Majedur Rahman on 10/18/2017.
 */

public class SensorDataAdapter extends RecyclerView.Adapter<SensorDataAdapter.DataFragmentHolder> {

    Context context;
    ArrayList<DataItem> dataItems;
    LayoutInflater layoutInflater;

    public SensorDataAdapter(Context context, ArrayList<DataItem> dataItemArrayList) {

        this.context = context;
        this.dataItems = dataItemArrayList;
        layoutInflater = LayoutInflater.from(context);


    }

    @Override
    public DataFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.data_item, parent, false);

        return new DataFragmentHolder(view, context);
    }

    @Override
    public void onBindViewHolder(DataFragmentHolder holder, int position) {
        if (dataItems.get(position).getTitle().contains("Water Level : ")) {
            String waterLevel = dataItems.get(position).getTitle().replaceAll("Water Level : ", "").trim();
            double level = Double.parseDouble(waterLevel);
            if (level > Constant.HIGH) {
                int backgroundColor = ContextCompat.getColor(context, R.color.pinkRed);
                holder.cardView.setCardBackgroundColor(backgroundColor);
            } else if (level <= Constant.HIGH && level >= Constant.Low) {
                int backgroundColor = ContextCompat.getColor(context, R.color.colorSun);
                holder.cardView.setCardBackgroundColor(backgroundColor);
            } else {
                int backgroundColor = ContextCompat.getColor(context, R.color.onGreen);
                holder.cardView.setCardBackgroundColor(backgroundColor);
            }
        }

        /*if (dataItems.get(position).getTitle().contains("5") && dataItems.get(position).getTitle().contains("Water Level")) {
            int backgroundColor = ContextCompat.getColor(context, R.color.onGreen);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
            holder.areaNameTV.setVisibility(View.GONE);

        } else if (dataItems.get(position).getTitle().contains("6") && dataItems.get(position).getTitle().contains("Water Level")) {
            int backgroundColor = ContextCompat.getColor(context, R.color.yellowgreen);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
            holder.areaNameTV.setVisibility(View.GONE);

        } else if (dataItems.get(position).getTitle().contains("7") && dataItems.get(position).getTitle().contains("Water Level")) {
            int backgroundColor = ContextCompat.getColor(context, R.color.colorSun);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
            holder.areaNameTV.setVisibility(View.GONE);

        } else if (dataItems.get(position).getTitle().contains("8") && dataItems.get(position).getTitle().contains("Water Level")) {
            int backgroundColor = ContextCompat.getColor(context, R.color.colorOrange);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
            holder.areaNameTV.setVisibility(View.GONE);

        } else if (dataItems.get(position).getTitle().contains("9") && dataItems.get(position).getTitle().contains("Water Level")) {
            int backgroundColor = ContextCompat.getColor(context, R.color.sweetPink);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.dataTV.setTextColor(Color.WHITE);
            holder.areaNameTV.setVisibility(View.GONE);

        } else {
            int backgroundColor = ContextCompat.getColor(context, R.color.colorAsphalt);
            holder.cardView.setCardBackgroundColor(backgroundColor);
            holder.areaNameTV.setVisibility(View.VISIBLE);
            holder.dataTV.setTextColor(Color.WHITE);
        }
*/
        holder.dataTV.setTextColor(Color.WHITE);
        holder.dataTV.setText(dataItems.get(position).getTitle());
        holder.timeTV.setText(dataItems.get(position).getTime());
        holder.dateTV.setText(dataItems.get(position).getDate());
        holder.onclickDeviceCard(dataItems.get(position));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public static class DataFragmentHolder extends RecyclerView.ViewHolder {


        TextView timeTV;
        TextView dateTV;
        TextView dataTV;
        CardView cardView;
        TextView areaNameTV;
        Context context;

        public DataFragmentHolder(View itemView, Context context) {
            super(itemView);
            cardView = itemView.findViewById(R.id.data_card);
            timeTV = itemView.findViewById(R.id.timeData);
            dataTV = itemView.findViewById(R.id.dataTitleTV);
            dateTV = itemView.findViewById(R.id.dateData);
            areaNameTV = itemView.findViewById(R.id.areaName);
            this.context = context;

        }

        public void onclickDeviceCard(final DataItem dataItem) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!dataItem.getTitle().contains("Water Level"))
                        context.startActivity(new Intent(context, SensorDataActivity.class).putExtra(Constant.Device, dataItem.getTitle().replaceAll(context.getString(R.string.deviceid_string), "").toString()));
                }
            });
        }
    }
}
