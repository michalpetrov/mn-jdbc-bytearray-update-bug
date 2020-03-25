package mn.jdbc.bytearray.update.bug;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface SignatureRepository extends CrudRepository<Signature, Long> {
    void update(@Id Long id, byte[] data);
}
