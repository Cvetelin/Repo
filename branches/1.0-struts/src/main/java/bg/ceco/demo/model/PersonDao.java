package bg.ceco.demo.model;

import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public interface PersonDao {
	
	public Person load(long id);
	
	public void save(Person person);
	
	public void update(Person person);
	
	public void delete(Person person);
	
	public Collection list();
}
