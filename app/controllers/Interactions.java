package controllers;

import java.util.Map;

import models.List;
import models.Task;
import play.Logger;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;

//TODO: e.g. Form.form(List.class).bindFromRequest().get().update() returns "[error] application - No value"
public class Interactions extends Controller {

	public static Result updateTask() {
		try {
			final Map<String, String[]> values = request().body().asFormUrlEncoded();

			Task t = Task.byId(Long.parseLong(values.get("id")[0]));

			String[] text = values.get("text");
			if(text != null && text[0] != null) {
				t.text = text[0];
			}

			String[] done = values.get("done");
			if(done != null && done[0] != null) {
				t.done = done[0].equals("on");
			}
			
			String[] listId = values.get("listId");
			if(listId != null && listId[0] != null) {
				t.list = List.byId(Long.parseLong(listId[0]));
			}

			t.save();

			return done(true, Messages.get("common.success.updated"));
		} catch (Exception e) {
			Logger.error(e.toString());
		}

		return done(false, Messages.get("common.error.updated"));
	}

	public static Result deleteTask() {
		try {
			final Map<String, String[]> values = request().body().asFormUrlEncoded();
			Task t = Task.byId(Long.parseLong(values.get("id")[0]));
			t.delete();
			return done(true, Messages.get("common.success.deleted"));
		} catch (Exception e) {
			Logger.error(e.toString());
		}

		return done(false, Messages.get("common.error.deleted"));
	}

	public static Result addTask() {
		try {
			final Map<String, String[]> values = request().body().asFormUrlEncoded();

			Task t = new Task();

			String[] text = values.get("text");
			if(text != null && text[0] != null) {
				t.text = text[0];
			}

			// should never happen here - but who knows, right?
			String[] done = values.get("done");
			if(done != null && done[0] != null) {
				t.done = done[0].equals("on");
			}
			
			String[] listId = values.get("listId");
			if(listId != null && listId[0] != null) {
				t.list = List.byId(Long.parseLong(listId[0]));
			}

			t.save();

			return done(true, Messages.get("common.success.added"));
		} catch (Exception e) {
			Logger.error(e.toString());
		}

		return done(false, Messages.get("common.error.added"));
	}

	public static Result updateList() {
		try {
			final Map<String, String[]> values = request().body().asFormUrlEncoded();
			List l = List.byId(Long.parseLong(values.get("id")[0]));
			l.name = values.get("name")[0];
			l.save();
			return done(true, Messages.get("common.success.updated"));
		} catch (Exception e) {
			Logger.error(e.toString());
		}

		return done(false, Messages.get("common.error.updated"));
	}

	public static Result deleteList() {
		try {
			final Map<String, String[]> values = request().body().asFormUrlEncoded();
			List l = List.byId(Long.parseLong(values.get("id")[0]));
			l.delete();
			return done(true, Messages.get("common.success.deleted"));
		} catch (Exception e) {
			Logger.error(e.toString());
		}

		return done(false, Messages.get("common.error.deleted"));
	}

	public static Result addList() {
		try {
			Form.form(List.class).bindFromRequest().get().save();
			return done(true, Messages.get("common.success.added"));
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}

		return done(false, Messages.get("common.error.added"));
	}

	private static Result done(boolean success, String message) {

		// store message to be shown in frontend
		flash("message", message);
		flash("success", success ? "true" : "false");
		return redirect(routes.Pages.index());
	}
}