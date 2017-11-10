package services.utilities;

import java.util.List;
import java.util.Map;

public interface IGenericDAO<T> {
	public void save(T entity);

	public void delete(T entity);

	public T update(T entity);

	public T find(int entityID);

	public List<T> findAll();

	public T findOneResult(String namedQuery, Map<String, Object> parameters);

}
