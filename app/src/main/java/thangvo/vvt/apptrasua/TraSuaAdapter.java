package thangvo.vvt.apptrasua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static thangvo.vvt.apptrasua.R.anim.scale_item;

public class TraSuaAdapter extends RecyclerView.Adapter<TraSuaAdapter.ViewHolder> {
    ArrayList<TraSua> traSuas;
    Context context;

    public TraSuaAdapter(ArrayList<TraSua> traSuas, Context context) {
        this.traSuas = traSuas;
        this.context = context;
    }
    private  ItemClicklistener itemClicklistener;


    public void setItemClicklistener(ItemClicklistener itemClicklistener) {
        this.itemClicklistener = itemClicklistener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.item_trasua,null);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.scale_item);
        itemview.startAnimation(animation);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(traSuas.get(position).getHinh());
        holder.txtTen.setText(traSuas.get(position).getTen());
        holder.txtChiTiet.setText(traSuas.get(position).getChitet());
        holder.txtGia.setText(traSuas.get(position).getGia());

    }

    @Override
    public int getItemCount() {
        return traSuas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTen, txtChiTiet, txtGia;
        Button btnCapNhat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imgHinh);
            txtTen = (TextView)itemView.findViewById(R.id.txtTen);
            txtChiTiet = (TextView)itemView.findViewById(R.id.txtChitiet);
            txtGia = (TextView)itemView.findViewById(R.id.txtGia);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClicklistener.onClick(view , getLayoutPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemClicklistener.onLongClick(view ,getLayoutPosition());
                    return true;
                }
            });

        }


    }
}
