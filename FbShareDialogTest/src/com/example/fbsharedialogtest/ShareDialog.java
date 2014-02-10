package com.example.fbsharedialogtest;

import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.Session.StatusCallback;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.WebDialog;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.WebDialog.OnCompleteListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShareDialog extends Activity {
	// APP_ID="570667353017840";
	private UiLifecycleHelper uiHelper;
	Activity activity;
	Button btnLogin;
	Button btnShare;
	Bundle params;
	StatusCallback statusCallback = new StatusCallback() {
		
		@Override
		public void call(Session session, SessionState state, Exception exception) {
			// TODO Auto-generated method stub
			if(exception !=null){
				Log.d("Fb:","Error Occured");
				activity.finish();
			}
			
			Log.d("Fb",state.toString());
			
			if(state.equals(SessionState.OPENED))
				publishFeedDialog(params);
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_dialog);
		
		uiHelper = new UiLifecycleHelper(this, statusCallback);
		uiHelper.onCreate(savedInstanceState);
		
		activity = this;
		params = this.getIntent().getExtras();
		share();
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		
		uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
			
			@Override
			public void onError(PendingCall pendingCall, Exception error, Bundle data) {
				// TODO Auto-generated method stub
				Log.e("Fb","Error "+error.getMessage());
				activity.finish();
			}
			
			@Override
			public void onComplete(PendingCall pendingCall, Bundle data) {
				// TODO Auto-generated method stub
				Log.d("Fb","Success");
				activity.finish();
			}
		});
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		uiHelper.onResume();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		uiHelper.onPause();
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		uiHelper.onDestroy();
		activity.finish();
	}
	
	protected void loginAndShare(){
		Session session = Session.openActiveSession(activity, true, statusCallback);
		Session.setActiveSession(session);
		Log.d("Fb","After setActiveSession");
	}
	
	protected void share(){
	
	if(FacebookDialog.canPresentShareDialog(this, FacebookDialog.ShareDialogFeature.SHARE_DIALOG)){
		//pubish the post using share dialog
		FacebookDialog	shareDialog = new FacebookDialog.ShareDialogBuilder(activity)
			.setName(params.getString("name"))
			.setCaption(params.getString("caption"))
			.setDescription(params.getString("description"))
			.setPicture(params.getString("picture"))
			.setLink(params.getString("link"))
			.build();
		uiHelper.trackPendingDialogCall(shareDialog.present());
	} else {
		//publish the post using FeedDialog
//		publishFeedDialog();
		loginAndShare();
	}
	}
	
	private void publishFeedDialog(Bundle params){
	    WebDialog feedDialog = (new WebDialog.FeedDialogBuilder(activity,
	    		Session.getActiveSession(),
	    		params))
	    		.setOnCompleteListener(new OnCompleteListener() {
					
					@Override
					public void onComplete(Bundle values, FacebookException error) {
						// TODO Auto-generated method stub
						if( error == null){
						final String postId = values.getString("post_id");
						if(postId != null){
							//Successed
							Log.d("Fb","Posted successfully "+postId);
						} else {
							//User cancled
							Log.d("Fb","Post Cancled");
						}
						} else if (error instanceof FacebookOperationCanceledException){
							//User clicked  X button
							Log.d("Fb","Post Cancled as per users wish");
						} else {
							//general error like Network Failure
							Log.d("Fb","Post Failed");
						}
						activity.finish();
					}
				}).build();
	    feedDialog.show();
	  
	}
	
	
}
