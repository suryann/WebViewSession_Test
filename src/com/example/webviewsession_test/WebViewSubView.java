package com.example.webviewsession_test;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewSubView extends WebViewClient {

	private CallbackMethod callbackMethod;
	
	@Override
	public void doUpdateVisitedHistory(WebView view, String url,
			boolean isReload) {
		// TODO Auto-generated method stub
		super.doUpdateVisitedHistory(view, url, isReload);
	}

	public CallbackMethod getCallbackMethod() {
		return callbackMethod;
	}

	public void setCallbackMethod(CallbackMethod callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	@Override
	public void onFormResubmission(WebView view, Message dontResend,
			Message resend) {
		// TODO Auto-generated method stub
		super.onFormResubmission(view, dontResend, resend);
	}

	@Override
	public void onLoadResource(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onLoadResource(view, url);
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onPageFinished(view, url);		
		System.out.println("Finished Load Page");
		callbackMethod.showCookie();
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		// TODO Auto-generated method stub
		super.onPageStarted(view, url, favicon);
	}

	@Override
	public void onReceivedError(WebView view, int errorCode,
			String description, String failingUrl) {
		// TODO Auto-generated method stub
		super.onReceivedError(view, errorCode, description, failingUrl);
	}

	@Override
	public void onReceivedHttpAuthRequest(WebView view,
			HttpAuthHandler handler, String host, String realm) {
		// TODO Auto-generated method stub
		super.onReceivedHttpAuthRequest(view, handler, host, realm);
	}

	@Override
	public void onReceivedLoginRequest(WebView view, String realm,
			String account, String args) {
		// TODO Auto-generated method stub
		super.onReceivedLoginRequest(view, realm, account, args);
	}

	@Override
	public void onReceivedSslError(WebView view, SslErrorHandler handler,
			SslError error) {
		// TODO Auto-generated method stub
		super.onReceivedSslError(view, handler, error);
	}

	@Override
	public void onScaleChanged(WebView view, float oldScale, float newScale) {
		// TODO Auto-generated method stub
		super.onScaleChanged(view, oldScale, newScale);  
		System.out.println("oldScale = " + oldScale + "," + "newScale" + newScale);
	}

	@Override
	public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
		// TODO Auto-generated method stub
		super.onUnhandledKeyEvent(view, event);
	}

	@Override
	public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
		// TODO Auto-generated method stub
		return super.shouldInterceptRequest(view, url);
	}

	@Override
	public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.shouldOverrideKeyEvent(view, event);
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		super.shouldOverrideUrlLoading(view, url);
		view.loadUrl(url);       
        return true;      
	}

	
}
