package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.avaje.ebean.Ebean;

@Entity
public class Task extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Constraints.Min(10)
	public Long id;

	@Basic(optional = false)
	public String text;

	@ManyToOne
	public List list;

	public boolean done;

	private static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);

	public static java.util.List<Task> all() {
		// "eager fetching"; @ManyToOne(fetch=FetchType.EAGER) does not work,
		// see http://stackoverflow.com/a/13191908
		return Ebean.find(Task.class).fetch("list", "name").findList();
	}

	public static Task byId(Long id) {
		return find.byId(id);
	}

	@Override
	public String toString() {
		return text;
	}
}