package com.example.amadoucamara.payment.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.amadoucamara.payment.R;
import com.example.amadoucamara.payment.models.Services;

import java.util.List;


public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.VH> {
    private Activity context;
    private List<Services> services;
    private String name;


    public ServicesAdapter(Activity context, List<Services> services)
    {
        this.context = context;
        if (services == null)
        {
            throw new IllegalArgumentException("services must not be null");
        }
        this.services = services;
    }

    // Inflate the view based on the viewType provided.
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new VH(itemView, context);
    }

    // Display data at the specified position
    @Override
    public void onBindViewHolder(final VH holder, int position)
    {
        final Services service = services.get(position);
        holder.rootView.setTag(service);
        holder.tvService.setText(service.getName());
        Glide.with(context).load(service.getImage()).centerCrop().into(holder.ivServiceImage);
    }

    @Override
    public int getItemCount() {
        return services.size();
    }


    public class VH extends RecyclerView.ViewHolder {
        final View rootView;
        final ImageView ivServiceImage;
        final TextView tvService;


        public VH(final View itemView, final Context context) {
            super(itemView);
            itemView.setClickable(true);
            rootView = itemView;
            ivServiceImage = itemView.findViewById(R.id.ivServiceImage);
            ivServiceImage.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));

            tvService = itemView.findViewById(R.id.tvServiceName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (getAdapterPosition()) {
                        case (0):
                            Toast.makeText(context, "p2p", Toast.LENGTH_SHORT).show();
                            break;
                        case (1):
                            Toast.makeText(context, "send", Toast.LENGTH_SHORT).show();
                            break;
                        case (2):
                            Toast.makeText(context, "fx", Toast.LENGTH_SHORT).show();
                            break;
                        case (3):
                            Toast.makeText(context, "setting", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }
    }
}
