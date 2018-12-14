package ver1.ver1.rapository;

import org.springframework.data.jpa.repository.JpaRepository;
import ver1.ver1.entity.Table1;
import ver1.ver1.entity.Table2;

import java.util.List;
import java.util.Optional;

public interface Table2Rapository extends JpaRepository<Table2,Integer> {
    Optional<Table2> findByName(String name);
    Optional<Table2>getAllByName(String name);
    void deleteById(Integer id);
    Optional<Table2>findById(Integer id);
    List<Table2> findAll();
    Optional<Table2>queryById(Integer id);
    Optional<Table2> queryByName(String name);
}
