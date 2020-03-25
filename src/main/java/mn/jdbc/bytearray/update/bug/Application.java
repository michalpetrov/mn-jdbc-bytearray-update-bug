package mn.jdbc.bytearray.update.bug;

import io.micronaut.context.annotation.Context;
import io.micronaut.runtime.Micronaut;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Context
public class Application {
    public static byte[] DATA = new byte[]{1, 2, 3, 4, 5};

    @Inject
    private SignatureRepository repository;

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }

    @PostConstruct
    public void start() {
        Long id = insert();
        update(id);
    }

    @Transactional
    public Long insert() {
        return repository.save(new Signature(DATA)).getId();
    }

    @Transactional
    public void update(Long id) {
        repository.update(id, DATA);
    }
}