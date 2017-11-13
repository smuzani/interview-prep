package com.syedmuzani.interviewprep.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syedmuzani.interviewprep.models.MainMenuLink;

import java.util.List;

/**
 * Adapter for displaying the main page
 * Created by muz on 2017-11-13.
 */

public class MainPageListAdapter extends RecyclerView.Adapter<MainPageListAdapter.VHolder> {

    private List<MainMenuLink> items;

    public MainPageListAdapter(List<MainMenuLink> items) {
        this.items = items;
        for (int i = 0; i < items.size(); i++) {

            Log.v("test", items.get(i).title);
        }
    }


    @Override
    public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        holder.bindItems(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private Context context;

        VHolder(View view) {
            super(view);
            title = view.findViewById(android.R.id.text1);
            context = view.getContext();
        }

        void bindItems(final MainMenuLink link) {
            title.setText(link.title);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, link.activityClass);
                    context.startActivity(intent);
                }
            });
        }
    }

}




/*
* public class ContactsAdapter extends
    RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}*/
