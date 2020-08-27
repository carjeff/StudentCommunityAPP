package com.example.studentcommunityapp.ui.publish;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.studentcommunityapp.R;
import com.example.studentcommunityapp.util.WebHelper;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PublishFragment extends Fragment {

    private PublishViewModel publishViewModel;
    private TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        publishViewModel =
                ViewModelProviders.of(this).get(PublishViewModel.class);
        View view = inflater.inflate(R.layout.fragment_publish, container, false);
//        startActivity(new Intent(getActivity(), PublishActivity.class));


        tabLayout = (TabLayout) view.findViewById(R.id.publish_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("文章"));
        tabLayout.addTab(tabLayout.newTab().setText("视频"));
        tabLayout.addTab(tabLayout.newTab().setText("音频"));
        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new ArticleFragment());
        fragments.add(new VideoFragment());
        fragments.add(new VfFragment());
        PublishAdapter adapter = new PublishAdapter(getChildFragmentManager(), fragments);

        final ViewPager viewPager=view.findViewById(R.id.publish_viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        return view;
    }
}
