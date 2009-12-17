package com.wooki.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.IncludeJavaScriptLibrary;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;

/**
 * CommentDialog create a nice modal window. Wooki classical use of this dialog
 * is to let users add comments to a block of some published content
 */
@IncludeJavaScriptLibrary("context:static/js/jquery-ui-1.7.2.custom.min.js")
public class Dialog implements ClientElement {

	@Inject
	private RenderSupport support;

	@Parameter(value = "prop:componentResources.id", defaultPrefix = BindingConstants.LITERAL)
	private String clientId;

	@BeginRender
	void startDiv(MarkupWriter writer) {
		writer.element("div", "id", getClientId(), "class", "dialog-container");
		writer.element("div", "class", "dialog-content radied-box");
	}

	@AfterRender
	void declareDialog(MarkupWriter writer) {
		writer.end();
		writer.end();

		// default wooki dialog settings
		JSONObject data = new JSONObject();
		data.put("elt", getClientId());
		JSONObject params = new JSONObject();
		params.put("modal", true);
		params.put("resizable", false);
		params.put("draggable", false);
		params.put("width", 780);
		params.put("minHeight", 30);
		params.put("autoOpen", false);
		params.put("position", "top");
		data.put("params", params);
		support.addInit("initJQueryDialog", data);
	}

	public String getClientId() {
		return this.clientId;
	}
}
