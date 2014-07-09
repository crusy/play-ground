package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class List extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Constraints.Min(10)
	public Long id;

	@Constraints.Required
	@Basic(optional = false)
	public String name;

	private static Finder<Long, List> find = new Finder<Long, List>(Long.class, List.class);

	public static java.util.List<List> all() {
		return find.all();
	}

	public static List byId(Long id) {
		return find.byId(id);
	}

	@Override
	public String toString() {
		return name;
	}
}