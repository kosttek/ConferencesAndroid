package pl.edu.kosttek.adapters;

import java.util.List;

import pl.edu.kosttek.R;
import pl.edu.kosttek.entity.Conference;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ConferenceArrayAdapter extends ArrayAdapter<Conference>{
	private final Context context;
	private final List<Conference> conferenceList;
	
	public ConferenceArrayAdapter(Context context,
			List<Conference> objects) {
		super(context,R.layout.conference_row_layout , objects);
		conferenceList = objects;
		this.context = context;
		
		// TODO Auto-generated constructor stub
	}
	static class ViewHolder {
		public TextView tvConf;
		public TextView tvItemNumber;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		View rowView = convertView;
		if(rowView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.list_item, null, true);
			viewHolder = new ViewHolder();
			viewHolder.tvConf = (TextView) rowView.findViewById(R.id.tvConf);
			viewHolder.tvItemNumber = (TextView) rowView.findViewById(R.id.tvItemNumber);
			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) rowView.getTag();
		}
		viewHolder.tvItemNumber.setText(Integer.toString(position+1));
		viewHolder.tvConf.setText(conferenceList.get(position).getTitle());
		return rowView;
	}
	
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		LayoutInflater inflater = (LayoutInflater) context
//				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		View rowView = inflater.inflate(R.layout.conference_row_layout, parent, false);
//		TextView textView = (TextView) rowView.findViewById(R.id.conf_title);
//		textView.setText(conferenceList.get(position).getTitle());
//		textView = (TextView) rowView.findViewById(R.id.conf_desc);
//		textView.setText(conferenceList.get(position).getDescription());
//		textView = (TextView) rowView.findViewById(R.id.conf_start_date);
//		textView.setText(conferenceList.get(position).getStartDate().toGMTString());
//		textView = (TextView) rowView.findViewById(R.id.conf_end_date);
//		textView.setText(conferenceList.get(position).getEndDate().toGMTString());
//		return rowView;
//	}
//	@Override
//	public Conference getItem(int position) {
//		// TODO Auto-generated method stub
//		return super.getItem(position);
//		
//	}
	
}
