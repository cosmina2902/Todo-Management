package net.javaspring.todomanagement_backend.repository;

import net.javaspring.todomanagement_backend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
