package ver1.ver1.rapository;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import ver1.ver1.entity.Table1;

import java.util.List;
import java.util.Optional;

public interface Table1Repository extends JpaRepository<Table1,Integer> {
    Optional<Table1> findByName(String name);
    Optional<Table1>findById(Integer id);
    Optional<Table1>getAllByName(String name);
    Optional<Table1>getById(Integer id);
    List<Table1> findAll();
    Optional<Table1>queryById(Integer id);
    Optional<Table1>queryByName(String name);




}
