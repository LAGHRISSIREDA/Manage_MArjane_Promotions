package DAO;



import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> findById(long id);

    T save(T t);

    List<T> all();

    Boolean update(long id,T t);

    Boolean delete(long id);



}
