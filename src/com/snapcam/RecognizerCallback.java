package com.snapcam;

import java.util.ArrayList;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.util.Log;

public class RecognizerCallback implements RecognitionListener {

	boolean listening = false;
	MainActivity activity;
	public final static String TAG = "RecognizerActivity";
	
	public RecognizerCallback(MainActivity activity)
	{
		this.activity = activity;
	}
	
	@Override
	public void onBeginningOfSpeech() {
		listening = true;
		// TODO Auto-generated method stub

	}

	@Override
	public void onBufferReceived(byte[] buffer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEndOfSpeech() {
		listening = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(int error) {
		Log.d(TAG, "onError: Call stopListening");
		listening = false;
		activity.onStopListening();
		// TODO Auto-generated method stub

	}

	@Override
	public void onEvent(int eventType, Bundle params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPartialResults(Bundle partialResults) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReadyForSpeech(Bundle params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResults(Bundle results) {
		// TODO Auto-generated method stub
		String str = new String();
        ArrayList<String> data = results.getStringArrayList(android.speech.SpeechRecognizer.RESULTS_RECOGNITION);
        
        activity.parseGoogleResults(data);
	}

	@Override
	public void onRmsChanged(float rmsdB) {
		// TODO Auto-generated method stub

	}

	public boolean isListening()
	{
		return listening;
	}
	
	public void setListening(boolean listening)
	{
		this.listening = listening;
	}
}
