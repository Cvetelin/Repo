package bg.ceco.demo.model;

public class Role {
	private long id;
	private String name;
	private String description;
	//private Permission permission ;

	public Role() {}
	
	public Role(int id, String name, String description/* .Permission permission*/) {
		this.id = id;
		this.name = name;
		this.description = description;
//		this.permission = permission;
	}
	
//	public Permission getPermission() {
//		return permission;
//	}
//
//	public void setPermission(Permission permission) {
//		this.permission = permission;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
