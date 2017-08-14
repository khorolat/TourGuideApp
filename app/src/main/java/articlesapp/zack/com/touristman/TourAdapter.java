package articlesapp.zack.com.touristman;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 7/31/2017.
 */

public class TourAdapter extends ArrayAdapter{


    private Activity context;
    private List<Malls> mallList;
    Button butmore;

    public TourAdapter(Activity context, List<Malls> mallList) {
        super(context,R.layout.list_layout,mallList);

        this.context = context;
        this.mallList = mallList;

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

        Malls mall = mallList.get(position);


        titleTextView.setText(mall.getMallName());
        descTextView.setText(mall.getMallAddress());
        locTextView.setText(mall.getMallId());



        String[] url = {"https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/jabulani.jpg?alt=media&token=86d01c3c-38dc-4467-abf9-22ed33f6e7c8",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/maponya.jpg?alt=media&token=21245b42-8bba-4082-894b-218e50e8df06",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/Dobsonville.jpg?alt=media&token=762c4ac1-8469-48a0-8db7-9b6ec0f43536",
        };

        
        Glide.with(context)
                .load(url[position])
                .into(imageView);





        return listViewItem;

    }

}




