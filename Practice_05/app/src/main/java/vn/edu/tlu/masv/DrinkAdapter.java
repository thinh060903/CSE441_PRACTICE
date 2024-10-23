package vn.edu.tlu.masv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private List<LoaiMon> monList;

    public DrinkAdapter(List<LoaiMon> monList) {
        this.monList = monList;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drink, parent, false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        LoaiMon mon = monList.get(position);
        holder.textDrinkName.setText(mon.TenMon);
        holder.textDrinkPrice.setText(mon.DonGia + " VND");

        // Sử dụng Picasso để tải ảnh từ URL
        Picasso.get().load("http://10.0.2.2/tlucoffee/images/" + mon.Hinh).into(holder.imageDrink);
    }

    @Override
    public int getItemCount() {
        return monList.size();
    }

    public static class DrinkViewHolder extends RecyclerView.ViewHolder {
        TextView textDrinkName, textDrinkPrice;
        ImageView imageDrink;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            textDrinkName = itemView.findViewById(R.id.textDrinkName);
            textDrinkPrice = itemView.findViewById(R.id.textDrinkPrice);
            imageDrink = itemView.findViewById(R.id.imageDrink);
        }
    }
}
