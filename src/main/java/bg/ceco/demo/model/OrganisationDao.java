package bg.ceco.demo.model;

import java.util.Collection;

public interface OrganisationDao {
    public <T extends Organisation> T load(long id, Class<T> clazz);

    public void save(Organisation orgnisation);

    public void update(Organisation orgnisation);

    public void delete(Organisation orgnisation);

    public <T extends Organisation> Collection<T> list(final Class<T> clazz);
    
    public Collection<Departement> listDepsWithInactiveServices();
}
