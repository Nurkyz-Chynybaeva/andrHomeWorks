package com.example.andrhomeworks;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.andrhomeworks.databinding.ActivityMainBinding;

public class Example extends AppCompatActivity {
    ActivityMainBinding binding;

    String sentence = "";
    int spaces, consonants, digits, words;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
