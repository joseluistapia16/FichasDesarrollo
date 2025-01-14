/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package impl;

import domain.GrupoSanguineo;
import java.util.List;

/**
 *
 * @author user
 */
public interface GrupoSanguineoDAO {
    boolean save(GrupoSanguineo obj);
    
    boolean update(GrupoSanguineo obj);
    
    boolean delete(Integer idGrupoSanguineo);
            
    GrupoSanguineo getOne(Integer idGrupooSanguineo);
    
    Integer getId(String name);
    
    List<GrupoSanguineo> getAll();
}
