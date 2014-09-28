package com.rss;

import com.utils.Variable;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends Activity{
	private WebView webview;
	private ProgressDialog dialog;
	private String link;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acticle);
		Bundle bd=getIntent().getExtras();
		link=bd.getString(Variable.LINKs);
		setTitle(R.string.app_name);
		webview=(WebView) findViewById(R.id.wv);
//		webview.getSettings().setSupportZoom(true);
//		webview.setInitialScale(1);
//		webview.getSettings().setLoadWithOverviewMode(true);
//		webview.getSettings().setUseWideViewPort(true);
//		webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
//		webview.setScrollbarFadingEnabled(false);
		webview.setWebViewClient(new  WebviewclientNews());
		dialog=ProgressDialog.show(this, "", "Loading...");
		new NewsTask().execute();
	}
	class NewsTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {
			webview.loadUrl(link);
			return null;
		}

	}
	class WebviewclientNews extends WebViewClient{
		  @Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			if(dialog!=null)
			{
				dialog.dismiss();
			}
		  }
	}
}
