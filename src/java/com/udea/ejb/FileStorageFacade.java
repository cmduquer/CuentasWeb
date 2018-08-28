/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.FileStorage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cmduquer
 */
@Stateless
public class FileStorageFacade extends AbstractFacade<FileStorage> implements FileStorageFacadeLocal {

    @PersistenceContext(unitName = "CuentasWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FileStorageFacade() {
        super(FileStorage.class);
    }
    
}
