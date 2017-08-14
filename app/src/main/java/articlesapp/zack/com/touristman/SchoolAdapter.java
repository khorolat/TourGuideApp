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

public class SchoolAdapter extends ArrayAdapter{


    private Activity context;
    private List<Schools> schoolsList;

    public SchoolAdapter(Activity context, List<Schools> schoolsList) {
        super(context,R.layout.list_layout,schoolsList);

        this.context = context;
        this.schoolsList = schoolsList;

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

        Schools schools = schoolsList.get(position);


        titleTextView.setText(schools.getSchoolName());
        descTextView.setText(schools.getSchoolAddress());
        locTextView.setText(schools.getSchoolId());

        String[] url = {"https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/credo.jpg?alt=media&token=3f5160bd-6264-4ec2-83c5-4af1385242ec",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/lb.jpg?alt=media&token=699fb8c1-c66e-4e5f-be6c-23e4ed4916a8",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/os.jpg?alt=media&token=8c4d2dcb-e8ad-47be-a2a5-fed3c6d33da4",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/ex.jpg?alt=media&token=41eb3023-5e46-46cd-93be-e16a77f081fe",
                "https://firebasestorage.googleapis.com/v0/b/touristman-fc182.appspot.com/o/pb-110427-nzima-da_photoblog900.jpg?alt=media&token=1fee5c68-fe2a-492c-876d-c3fd61918c6d",


        };
        Glide.with(context)
                .load(url[position])
                .into(imageView);



        return listViewItem;

    }
}

