package com.example.webviewsession_test;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private WebView myWebView;
	private Handler mHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			System.out.println("Run In WebViewSession");
			
			WebViewSubView webViewSubView = new WebViewSubView();
			webViewSubView.setCallbackMethod(callbackMethod);
			myWebView = (WebView)findViewById(R.id.webview);
			myWebView.getSettings().setJavaScriptEnabled(true);
			myWebView.setWebViewClient(webViewSubView);
			myWebView.loadUrl("http://aoi.androidesk.com/personal");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public CallbackMethod callbackMethod = new CallbackMethod() {
		
		@Override
		public void showCookie() {
			// TODO Auto-generated method stub
			CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(MainActivity.this);
			cookieSyncManager.sync();
			CookieManager cookieManager = CookieManager.getInstance();
			System.out.println(cookieManager.getCookie("http://aoi.androidesk.com/personal"));
			cookieManager.removeSessionCookie();
		}
	};
	
	
}
