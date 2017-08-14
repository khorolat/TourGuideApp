package articlesapp.zack.com.touristman;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 7/31/2017.
 */

public class RestaurantAdapter extends ArrayAdapter{


    private Activity context;
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(Activity context, List<Restaurant> restaurantList) {
        super(context,R.layout.list_layout,restaurantList);

        this.context = context;
        this.restaurantList = restaurantList;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.imageview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Restaurant restaurant = restaurantList.get(position);


        titleTextView.setText(restaurant.getRestaurantName());
        descTextView.setText(restaurant.getRestaurantAddress());
        locTextView.setText(restaurant.getRestaurantId());

        String[] url = {"https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/pic_-_chaf_pozi_sign__tower.jpg?alt=media&token=cc19060c-60f5-47f1-a1fb-484829cadde6",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/Jazz-Maniacs-Restaurant.jpg?alt=media&token=5a5ad45b-7aa8-471b-bf89-f4edb0f7d3ff",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/masakeng.jpg?alt=media&token=0003797b-130a-438e-830c-ec7be3d847f9",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/nambitha.jpg?alt=media&token=0295e94f-192f-4a36-8264-4033700b0214",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/nex-dor21.jpg?alt=media&token=ba879272-80e0-4533-828e-b7be63391bec",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/panyaza.jpg?alt=media&token=67d13d80-5fb9-4830-ba18-f7aa1f4d984d",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/restaurantvilakazinv_vilakazi_street_soweto21.jpg?alt=media&token=9f373aec-5b14-49d8-94b7-c7da4d36d409",
        };
        Glide.with(context)
                .load(url[position])
                .into(imageView);



        return listViewItem;

    }
}
