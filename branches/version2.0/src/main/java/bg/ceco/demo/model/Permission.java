package bg.ceco.demo.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author CecoEmployee
 *
 */
public class Permission {
	
	@Override
	public String toString() {
		return getType();
	}

	public static final String POWER_USER = "POWER";

	public static final String GUEST = "GUEST";

	public static final String ROOT = "ROOT";

	public static Collection<Permission> ALL_PERMISSION_TYPES = null;

	private boolean deleteAllowed ;
	
	private boolean createAllowed  ;
	
	private boolean readAllowed ;
	
	private boolean modifyAllowed ;
	
	private long id ;
	
	//private transient Enum<User> type = null;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String type = null ;
	
	public Permission() {
		super();
	}

	public Permission(String type) {
		super();
		this.type = type;
	}

	/**
	 * Has all privileges
	 */
//	public static Permission ROOT = null;
	
	public Permission(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	/**
	 * GUEST has only read permissions
	 */
//	public static Permission GUEST = null;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Has right to read, to create, to delete, can't modify
	 */
//	public static Permission POWER = null ;
	
	
//	public Enum<User> getType() {
//		return type;
//	}
//
//	public void setType(Enum<User> type) {
//		this.type = type;
//	}

	static {
		//ROOT = new Permission(true, true, true, true);
		//ROOT.setType(User.ROOT);
		//GUEST = new Permission(false, false , true, false);
		//GUEST.setType(User.GUEST);
		//POWER = new Permission(true, true, true, false);
		//POWER.setType(User.POWER);
		ALL_PERMISSION_TYPES = new ArrayList<Permission>(3);
		ALL_PERMISSION_TYPES.add(new Permission(ROOT));
		ALL_PERMISSION_TYPES.add(new Permission(GUEST));
		ALL_PERMISSION_TYPES.add(new Permission(POWER_USER));
	}

//	public enum User {
//		
//		ROOT(Permission.ROOT),
//		GUEST(Permission.GUEST),
//		POWER(Permission.POWER);
//		
//		private final Permission type ;
//		User (Permission type){
//			this.type = type; 
//		}
//		
//		public Permission getPermissionType(){
//			return type;
//		}
//	}
	
	public Permission(boolean deleteAllowed, boolean createAllowed,
			boolean readAllowed, boolean modifyAllowed) {
		this.deleteAllowed = deleteAllowed;
		this.createAllowed = createAllowed;
		this.readAllowed = readAllowed;
		this.modifyAllowed = modifyAllowed;
	}

	public boolean isDeleteAllowed() {
		return deleteAllowed;
	}

	public void setDeleteAllowed(boolean deleteAllowed) {
		this.deleteAllowed = deleteAllowed;
	}

	public boolean isCreateAllowed() {
		return createAllowed;
	}

	public void setCreateAllowed(boolean createAllowed) {
		this.createAllowed = createAllowed;
	}

	public boolean isReadAllowed() {
		return readAllowed;
	}

	public void setReadAllowed(boolean readAllowed) {
		this.readAllowed = readAllowed;
	}

	public boolean isModifyAllowed() {
		return modifyAllowed;
	}

	public void setModifyAllowed(boolean modifyAllowed) {
		this.modifyAllowed = modifyAllowed;
	}
	
//	@Override
//	public String toString() {
//		return this.getType().toString(); 
//	}
}
