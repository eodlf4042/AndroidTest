package com.example.registerloginexample;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag4 extends Fragment {

    private View view;
    private Button btn_play, btn_stop;
    private MediaPlayer mediaPlayerl;
    private TextView tv_status;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        btn_play = view.findViewById(R.id.btn_play);
        btn_stop = view.findViewById(R.id.btn_stop);
        tv_status = view.findViewById(R.id.tv_status);

        mediaPlayerl = MediaPlayer.create(getActivity(), R.raw.dixit); // 미리 MediaPlayer 객체를 생성합니다.

        // 재생버튼 눌렀을 때
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayerl.isPlaying()) {
                    mediaPlayerl.start(); // 음악 재생
                    tv_status.setText("재생중");

                }
            }
        });

        // 정지버튼 눌렀을 때
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerl.isPlaying()) {
                    mediaPlayerl.pause(); // 음악 일시정지 (다시 재생을 원하면 start()를 호출하면 됩니다)
                    mediaPlayerl.seekTo(0); // 재생 위치를 처음으로 되돌립니다.
                    tv_status.setText("정지");

                }
            }
        });

        return view;
    }

   @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayerl != null) {
            mediaPlayerl.release(); // MediaPlayer 리소스 해제
            mediaPlayerl = null;
        }
    }
}
