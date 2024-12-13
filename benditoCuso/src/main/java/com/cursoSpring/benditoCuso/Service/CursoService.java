package com.cursoSpring.benditoCuso.Service;

import com.cursoSpring.benditoCuso.Model.Curso;
import com.cursoSpring.benditoCuso.Repository.ICursoRepository;
import com.cursoSpring.benditoCuso.dto.CursoTemaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepo;


    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public Curso findCurso(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }

    @Override
    public CursoTemaDTO temasPorCurso(Long id_curso) {
        CursoTemaDTO curTemDTO = new CursoTemaDTO ();
        Curso curso = this.findCurso(id_curso);
        curTemDTO.setNombreCurso(curso.getNombre());
        curTemDTO.setListaTemas(curso.getListaDeTemas());

        return curTemDTO;
    }

    @Override
    public List<Curso> getCursosJava() {
        String palabra = "Java";
        String textoComparar;

        List<Curso> listaCursos = this.getCursos();
        List<Curso> listaCursosJava = new ArrayList<Curso>();

        for (Curso cur : listaCursos) {
            textoComparar = cur.getNombre();
            boolean contieneJava = textoComparar.contains(palabra);
            if (contieneJava == true) {
                listaCursosJava.add(cur);
            }
        }
        return listaCursosJava;
    }
}
