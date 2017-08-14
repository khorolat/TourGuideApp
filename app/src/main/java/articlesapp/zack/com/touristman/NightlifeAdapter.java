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

public class NightlifeAdapter extends ArrayAdapter {


    private Activity context;
    private List<Nightlife> nightlifeList;


    public NightlifeAdapter(Activity context, List<Nightlife> nightlifeList) {
        super(context,R.layout.list_layout,nightlifeList);

        this.context = context;
        this.nightlifeList = nightlifeList;


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

        Nightlife nightlife = nightlifeList.get(position);


        titleTextView.setText(nightlife.getNightlifeName());
        descTextView.setText(nightlife.getNightlifeAddress());
        locTextView.setText(nightlife.getNightlifeId());

        String[] url = {"https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/lichaba.jpg?alt=media&token=ba93730a-207c-4e2e-94df-7bab534cbf64",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/Zone6%20venue.jpg?alt=media&token=9f1a3716-5f7f-4ec2-990f-cb133987c852",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/winebar.jpg?alt=media&token=6527b0bd-2e0b-4de2-bd2b-3e4e96589f3f",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/2c054acd5b161f658ad171de66333b8e_featured_v2.jpg?alt=media&token=8a827a1b-307d-4e8e-8321-7517ccab771f",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/cafe.jpg?alt=media&token=18584442-04f8-4685-9b51-f66a6de906ed",
        };
        Glide.with(context)
                .load(url[position])
                .into(imageView);



        return listViewItem;

    }
}