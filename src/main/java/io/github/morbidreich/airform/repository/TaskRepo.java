package io.github.morbidreich.airform.repository;

import io.github.morbidreich.airform.entity.tasks.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
}
