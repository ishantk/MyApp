package com.auribises.myapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VoiceDemoActivity extends AppCompatActivity implements View.OnClickListener, RecognitionListener {


    @BindView(R.id.textViewData)
    TextView txtData;

    @BindView(R.id.buttonSpeak)
    Button btnSpeak;

    SpeechRecognizer speechRecognizer;

    ProgressDialog progressDialog;

    TextToSpeech tts;
    boolean isTTSSupported = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_demo);

        ButterKnife.bind(this);
        btnSpeak.setOnClickListener(this);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Listening...");
        progressDialog.setCancelable(false);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.SUCCESS){
                    Toast.makeText(VoiceDemoActivity.this,"Please enable TTS in Settings first..",Toast.LENGTH_LONG).show();
                    isTTSSupported = false;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        speechRecognizer.startListening(RecognizerIntent.getVoiceDetailsIntent(this));
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {
        progressDialog.show();
    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {
        progressDialog.dismiss();
    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle bundle) {
        ArrayList<String> results = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        if (results != null && results.size() > 0) {
            String text = results.get(0).toLowerCase();

            txtData.setText(text);

            if (text.contains("call") && text.contains("mom")) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+919915571177"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this,"Please grant permissions to make calls in settings",Toast.LENGTH_LONG).show();
                }else {
                    startActivity(intent);
                }
            }

            if(text.contains("about") && text.contains("delhi")){
                tts.speak("Delhi is the Capital of India",TextToSpeech.QUEUE_FLUSH,null);
            }

        }else{
            txtData.setText("No Data Found");
            Toast.makeText(this,"No Data Found",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
