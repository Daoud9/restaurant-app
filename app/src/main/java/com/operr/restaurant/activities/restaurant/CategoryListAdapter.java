package com.operr.restaurant.activities.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.operr.restaurant.R;
import com.operr.restaurant.model.Category;

import java.util.List;

/**
 *
 */
public class CategoryListAdapter extends ArrayAdapter<Category> {
    private final Context context;
	private final List<Category> categories;

	public CategoryListAdapter(Context context, List<Category> categories) {
		super(context, R.layout.list_row, categories);
		this.context = context;
		this.categories = categories;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.list_row, parent, false);
		TextView aliasTextView = (TextView) rowView.findViewById(R.id.aliasTextView);
		TextView titleTextView = (TextView) rowView.findViewById(R.id.titleTextView);
		Category category = categories.get(position);
		aliasTextView.setText(category.getAlias());
		titleTextView.setText(category.getTitle());
		return rowView;
	}
	@Override
	public int getCount() {
		return categories.size();
	}
}