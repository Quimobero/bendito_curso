package com.cursoSpring.benditoCuso.Repository;

import com.cursoSpring.benditoCuso.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
