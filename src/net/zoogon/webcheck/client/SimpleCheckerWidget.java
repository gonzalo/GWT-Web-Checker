package net.zoogon.webcheck.client;

import net.zoogon.webcheck.shared.SharedMethods;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SimpleCheckerWidget extends Composite implements HasText {

	private static SimpleCheckerWidgetUiBinder uiBinder = GWT
			.create(SimpleCheckerWidgetUiBinder.class);

	interface SimpleCheckerWidgetUiBinder extends
			UiBinder<Widget, SimpleCheckerWidget> {
	}

	public SimpleCheckerWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button BT_checkIt;
	
	@UiField
	TextBox TB_urlEntry;
	
	

	public SimpleCheckerWidget(String defaultUrl) {
		initWidget(uiBinder.createAndBindUi(this));
		TB_urlEntry.setText(defaultUrl);
		BT_checkIt.setText("Check it!");
	}

	@UiHandler("BT_checkIt")
	void onClick(ClickEvent e) {
		//validamos la url introducida
		if (SharedMethods.isWellFormed(TB_urlEntry.getText()))
			Window.alert("Valid Url\nUrl to check: " + TB_urlEntry.getText());
		else
			Window.alert("Input url is not valid\nCheck spelling: " + TB_urlEntry.getText());
	}

	public void setText(String text) {
		TB_urlEntry.setText(text);
	}

	public String getText() {
		return TB_urlEntry.getText();
	}

}
