package com.balmes.repository;

import com.balmes.model.Curs;
import com.balmes.model.Estudiant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class estudiantRepository implements crudRepository<Estudiant> {

    public List<Estudiant> findAll() {
        // TODO Auto-generated method stub
        List<Estudiant> estudiantList = new ArrayList<>();
        cursRepository cursRepository = new cursRepository();
        final List<Curs> allCursos = cursRepository.findAll();
        estudiantList.add(new Estudiant(1, "Luffy", "Monkey D.", allCursos.get(1)));
        estudiantList.add(new Estudiant(2, "Aranu", "OchosA", allCursos.get(1)));
        estudiantList.add(new Estudiant(2, "Alejandro", "Conejos", allCursos.get(1)));
        estudiantList.add(new Estudiant(2, "Christiano", "Ronaldo", allCursos.get(0)));
        estudiantList.add(new Estudiant(2, "Naruto", "Uzumaki", allCursos.get(0)));
        estudiantList.add(new Estudiant(2, "Noemi", "Villanueva", allCursos.get(0)));
        return estudiantList;
    }

    public List<Estudiant> getEstudiantsperCurs(int cursId) {
        List<Estudiant> estudiantList = findAll();
        List<Estudiant> estudiantsPerCurs = new ArrayList<>();

        for (Estudiant estudiant : estudiantList) {
            if (estudiant.getCurs().getCursId() == cursId) {
                estudiantsPerCurs.add(estudiant);
            }
        }

        return estudiantsPerCurs;

    }
}