package com.fieldbear.androidtutorial190826.T05_SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fieldbear.androidtutorial190826.R;

import java.util.List;

public class T05_AppListActivity extends AppCompatActivity {

    List<ApplicationInfo> infos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t05__app_list);

        ListView listView = findViewById(R.id.listViewAppList);

        PackageManager pm = getPackageManager();
        infos = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        AppListAdapter adapter = new AppListAdapter();
        listView.setAdapter(adapter);
    }

    class AppListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return infos.size();
        }

        @Override
        public Object getItem(int position) {
            return infos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inf = LayoutInflater.from(T05_AppListActivity.this);
                convertView = inf.inflate(R.layout.item_app_list, parent, false);
            }

            ApplicationInfo info = infos.get(position);
            ImageView imageViewAppIcon = convertView.findViewById(R.id.imageViewAppIcon);
            TextView textViewAppName = convertView.findViewById(R.id.textViewAppName);

            Drawable icon = info.loadIcon(getPackageManager());
            imageViewAppIcon.setImageDrawable(icon);

            CharSequence appName = info.loadLabel(getPackageManager());
            textViewAppName.setText(appName);

            return convertView;
        }
    }
}
