package com.example.studentcommunityapp.ui.publish;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studentcommunityapp.R;
import com.example.studentcommunityapp.util.WebHelper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VideoFragment extends Fragment {

    private View view;


    private Button submit;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==100){
                String status_meg;
                status_meg=(String)msg.obj;

                if(status_meg.equals("1")){
                    showSuc(getContext(),"成功提交");
                }
                else {
                    showFail(getContext(),"提交失败");
                }
            }
        }
    };

    public static void showSuc(Context context, String msg) {
        Toast toast = new Toast(context);
        //设置Toast显示位置，居中，向 X、Y轴偏移量均为0
        toast.setGravity(Gravity.CENTER, 0, 0);
        //获取自定义视图
        View view = LayoutInflater.from(context).inflate(R.layout.toast, null);
        TextView tvMessage = (TextView) view.findViewById(R.id.tv_toast);
        //设置文本
        tvMessage.setText(msg);
        //设置视图
        toast.setView(view);
        //设置显示时长
        toast.setDuration(Toast.LENGTH_LONG);
        //显示
        toast.show();
    }

    public static void showFail(Context context, String msg) {
        Toast toast = new Toast(context);
        //设置Toast显示位置，居中，向 X、Y轴偏移量均为0
        toast.setGravity(Gravity.CENTER, 0, 0);
        //获取自定义视图
        View view = LayoutInflater.from(context).inflate(R.layout.toast_fail, null);
        TextView tvMessage = (TextView) view.findViewById(R.id.tv_toast);
        //设置文本
        tvMessage.setText(msg);
        //设置视图
        toast.setView(view);
        //设置显示时长
        toast.setDuration(Toast.LENGTH_LONG);
        //显示
        toast.show();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View) inflater.inflate(R.layout.fragment_publish_1, container, false);


        //课程名称
        final EditText edtMsg1 = (EditText)view.findViewById(R.id.input_video_title);
        //周几
        final EditText edtMsg2 = (EditText)view.findViewById(R.id.input_video_introduction);
        //课程时间
        final EditText edtMsg3 = (EditText)view.findViewById(R.id.input_video_CoverMap);
        //课程地点
        final EditText edtMsg4 = (EditText)view.findViewById(R.id.input_video_title_1);

        submit=view.findViewById(R.id.video_add_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtMsg1.getText().toString().equals("")){
                    Toast.makeText(getContext(),"请输入标题再提交",Toast.LENGTH_SHORT).show();
                }
                else if(edtMsg2.getText().toString().equals("")){
                    Toast.makeText(getContext(),"请输入简介再提交",Toast.LENGTH_SHORT).show();
                }
                else if(edtMsg3.getText().toString().equals("")){
                    Toast.makeText(getContext(),"请输入上传资料再提交",Toast.LENGTH_SHORT).show();
                }
                else if(edtMsg4.getText().toString().equals("")){
                    Toast.makeText(getContext(),"请输入具体内容再提交",Toast.LENGTH_SHORT).show();
                }
                else {
                    String postMessage1;
                    String postMessage2;
                    String postMessage3;
                    String postMessage4;
                    postMessage1=edtMsg1.getText().toString();
                    postMessage2=edtMsg2.getText().toString();
                    postMessage3=edtMsg3.getText().toString();
                    postMessage4=edtMsg4.getText().toString();

                    Log.d("getComment","postmessage: "+postMessage1);
                    final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                    final OkHttpClient client = new OkHttpClient();
                    final String url="http://81.70.27.208:8000/api/string_publish";
                    HashMap<String,String> map=new HashMap<>();
                    map.put("title",postMessage1);
                    map.put("introduction",postMessage2);
                    map.put("picture",postMessage3);
                    map.put("content",postMessage4);

                    final String cookie;
                    cookie= WebHelper.getCookie(getActivity());
                    Gson gson=new Gson();
                    final String data=gson.toJson(map);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Log.d("PostComment","in");
                                RequestBody body = RequestBody.create(JSON,data);
                                Request request = new Request.Builder()
                                        .url(url)
                                        .header("cookie",cookie)
                                        .post(body)
                                        .build();
                                Response response = client.newCall(request).execute();
                                String response_string=response.body().string();
                                JSONObject jsonObject_data = new JSONObject(response_string);
                                String status=jsonObject_data.getString("status");
                                Log.d("PostComment",status);
                                Message message=new Message();
                                message.what=100;
                                message.obj=status;
                                handler.sendMessage(message);
                            }
                            catch (IOException e){
                                Log.d("PostComment",e.toString());
                            }
                            catch (JSONException e){
                                Log.d("PostComment",e.toString());
                            }
                        }
                    }).start();


                }
            }
        });

//        submit=view.findViewById(R.id.video_add_button);
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Message message=new Message();
//                message.what=100;
//                message.obj="1111";
//                handler.sendMessage(message);
//
//            }
//
//        });


        return view;
    }
}
