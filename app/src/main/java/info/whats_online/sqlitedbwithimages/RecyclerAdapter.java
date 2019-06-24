package info.whats_online.sqlitedbwithimages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by sg-0036936 on 08/09/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    Context context;
    ArrayList<Contact> mcontact;
   // private final OnItemClickListener listener;



    public RecyclerAdapter(Context context, ArrayList<Contact> contact) {
        this.context = context;
        this.mcontact = contact;
        //this.listener = listener;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listcontacts, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Contact contact = mcontact.get(position);
        holder.nameFV.setText(contact.getFName());
        Glide.with(context).load(contact.getImage()).into(holder.pic);


    }



    @Override
    public int getItemCount() {
        return  mcontact.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameFV;
        ImageView pic;
        private OnItemClickListener mListener;

        public RecyclerViewHolder(View v) {
            super(v);
            nameFV=(TextView)v.findViewById(R.id.txtViewer);
            pic=(ImageView) v.findViewById(R.id.imgView);

            // mListener = listener;
            //v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());

        }
    }

}