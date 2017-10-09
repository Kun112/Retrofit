package com.example.anhquanha.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by anhquan.ha on 10/9/2017.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    Context context;
    List<Post> postArr;
    int layoutid;

    public PostAdapter(Context mcontext, int mlayoutid, List<Post> mPost){
        super(mcontext, mlayoutid, mPost);
        context = mcontext;
        layoutid = mlayoutid;
        postArr = mPost;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate( R.layout.post_list, parent, false);
        }

        TextView title = (TextView)convertView.findViewById(R.id.postName);
        title.setText(postArr.get(position).getTitle());
        return convertView;
    }
}
