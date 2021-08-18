package com.andriod.egroweed.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.andriod.egroweed.R;

public class UserInformationFragmentDashboard extends Fragment {
    private String name;
    private String email;
    private Integer avatar;
    private View rootView;
    private TextView emailTextView;
    private ImageView avatarImageView;

    public UserInformationFragmentDashboard() {
        // Required empty public constructor
    }

    public static UserInformationFragmentDashboard newInstance(String name, Integer avatar) {
        UserInformationFragmentDashboard fragment = new UserInformationFragmentDashboard();
        fragment.setEmail(name);
        fragment.setName(name);
        fragment.setAvatar(avatar);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // name =  getArguments().getString("name");
        // avatar =  getArguments().getInt("avatar");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_user_information, container, false);
        emailTextView = rootView.findViewById(R.id.user_email_user_information_fragment);
        avatarImageView = rootView.findViewById(R.id.avatar_information_fragment);
        emailTextView.setText(name);

        switch (avatar){
            case 0:
                avatarImageView.setImageResource(R.drawable.ic_avatar_1);
                break;
            case 1:
                avatarImageView.setImageResource(R.drawable.ic_avatar_2);
                break;
            case 2:
                avatarImageView.setImageResource(R.drawable.ic_avatar_3);
                break;
            case 3:
                avatarImageView.setImageResource(R.drawable.ic_avatar_4);
                break;
            case 4:
                avatarImageView.setImageResource(R.drawable.ic_avatar_5);
                break;
        }
        return  rootView;
    }

    public String getName() {
        return name;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}