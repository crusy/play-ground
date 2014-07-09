package controllers;

import models.List;
import models.Task;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.about.about;
import views.html.common.notice;
import views.html.common.page;
import views.html.contact.contact;
import views.html.home.home;

public class Pages extends Controller {

	public static Result about() {
		return ok(page.render(Messages.get("common.title"), about.render()));
	}

	public static Result contact() {
		return ok(page.render(Messages.get("common.title"), contact.render()));
	}

	// "Play actions are asynchronous by default."
	// from: http://www.playframework.com/documentation/2.3.x/JavaAsync
	public static Result index() {
		Html renderedNotice = null;

		// read result from Interactions
		String message = flash("message");
		boolean success = "true".equals(flash("success"));
		if (message != null && message.trim().length() > 0) {
			renderedNotice = notice.render(success ? "success" : "error", message);
		}

		return ok(page.render(Messages.get("common.title"), home.render(List.all(), Task.all(), renderedNotice)));
	}
}