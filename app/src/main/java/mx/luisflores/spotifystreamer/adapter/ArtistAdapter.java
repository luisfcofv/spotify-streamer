package mx.luisflores.spotifystreamer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.Image;
import mx.luisflores.spotifystreamer.R;

public class ArtistAdapter extends BasicAdapter {

    public ArtistAdapter(Context context, ArrayList<?> list) {
        super(context, list);
    }

    @Override
    public View getView(int index, View convertView, ViewGroup viewGroup) {
        ArtistViewHolder viewHolder;

        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_artist, null);
            viewHolder = new ArtistViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ArtistViewHolder) convertView.getTag();
        }

        Artist artist = (Artist) mList.get(index);
        viewHolder.artistTextView.setText(artist.name);

        if (artist.images.size() > 0) {
            Image image = artist.images.get(0);
            Picasso.with(mContext).load(image.url).into(viewHolder.thumbnailImageView);
        }

        return convertView;
    }

    private class ArtistViewHolder {

        public TextView artistTextView;
        public ImageView thumbnailImageView;

        public ArtistViewHolder(View view) {
            thumbnailImageView = (ImageView) view.findViewById(R.id.list_item_artist_imageview);
            artistTextView = (TextView) view.findViewById(R.id.list_item_artist_textview);
        }
    }
}
