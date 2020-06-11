/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.EstadoDao;
import model.Estado;

/**
 *
 * @author asus
 */
public class EstadoServiceImpl {
    private final EstadoDao estadoDao = new EstadoDao();
    
    public Estado obterPorId(Long id){
        return estadoDao.findById(id);
    }
    
}
