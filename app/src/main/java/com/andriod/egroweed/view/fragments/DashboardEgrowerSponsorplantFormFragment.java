package com.andriod.egroweed.view.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.andriod.egroweed.R;

import java.util.Locale;


public class DashboardEgrowerSponsorplantFormFragment extends Fragment {

    private View rootView;
    private SeekBar seekBar;
    private String name;
    private TextView textViewSeekBar;
    private TextView greenHouseName;
    private ImageView avatarImageView;
    private Button seekBarButtonRemove;
    private Button seekBarButtonAdd;
    private Button closeButton;
    private Integer avatarIndex;



    public DashboardEgrowerSponsorplantFormFragment() {
        // Required empty public constructor
    }

    public static DashboardEgrowerSponsorplantFormFragment newInstance(String name) {
        DashboardEgrowerSponsorplantFormFragment fragment = new DashboardEgrowerSponsorplantFormFragment();
        fragment.setName(name);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        avatarIndex = 1;
        rootView = inflater.inflate(R.layout.fragment_dashboard_egrower_sponsorplant_form, container, false);
        seekBar = rootView.findViewById(R.id.seekBar_sponsorplats_form);
        seekBarButtonRemove = rootView.findViewById(R.id.button_seekbar_remove);
        seekBarButtonAdd = rootView.findViewById(R.id.button_seekbar_add);
        textViewSeekBar = rootView.findViewById(R.id.textView_seekbar_sporsorplants_form);
        greenHouseName = rootView.findViewById(R.id.textView_greenhouse_name_sponsor_form);
        closeButton = rootView.findViewById(R.id.button_close_sponsor_form);
        avatarImageView = rootView.findViewById(R.id.imageView_plant_sponsor_form);
        greenHouseName.setText(getName().toUpperCase(Locale.ROOT));
        textViewSeekBar.setText(seekBar.getProgress()+ "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textViewSeekBar.setText(value + "/" + seekBar.getMax());
                if(value < 1){
                    avatarIndex = 0;
                    setAvatarImageView();
                }
                if(value < 10){
                    avatarIndex = 1;
                    setAvatarImageView();
                }
                if(value > 50){
                    avatarIndex = 2;
                    setAvatarImageView();
                }
                if(value > 100){
                    avatarIndex = 3;
                    setAvatarImageView();
                }
                if(value > 300){
                    avatarIndex = 4;
                    setAvatarImageView();
                }
                if(value > 750){
                    avatarIndex = 5;
                    setAvatarImageView();
                }
                if(value > 1200){
                    avatarIndex = 6;
                    setAvatarImageView();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewSeekBar.setText(value + "/" + seekBar.getMax());
            }
        });
        seekBarButtonRemove.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                seekBar.setProgress(seekBar.getProgress() - 1, true);
                textViewSeekBar.setText(seekBar.getProgress() + "/" + seekBar.getMax());
            }
        });
        seekBarButtonAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                seekBar.setProgress(seekBar.getProgress() + 1, true);
                textViewSeekBar.setText(seekBar.getProgress() + "/" + seekBar.getMax());
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.egrower_menu_linear_layout_vertical_scroll, DashboardEgrowerSponsoredplantsEmptyFragment.newInstance()).commit();
            }
        });
        return rootView;
    }
    public void setAvatarImageView(){
        switch (avatarIndex){
            case 0:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_sad);
                break;
            case 1:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_smile_1);
                break;
            case 2:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_smile_2);
                break;
            case 3:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_smile_3);
                break;
            case 4:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_smile_4);
                break;
            case 5:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_smile_5);
                break;
            case 6:
                avatarImageView.setImageResource(R.drawable.ic_cannabis_smile_6);
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}