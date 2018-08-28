/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.FileStorage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cmduquer
 */
@Local
public interface FileStorageFacadeLocal {

    void create(FileStorage fileStorage);

    void edit(FileStorage fileStorage);

    void remove(FileStorage fileStorage);

    FileStorage find(Object id);

    List<FileStorage> findAll();

    List<FileStorage> findRange(int[] range);

    int count();
    
}
