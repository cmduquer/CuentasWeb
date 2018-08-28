/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cmduquer
 */
@Entity
@Table(name = "FILE_STORAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileStorage.findAll", query = "SELECT f FROM FileStorage f")
    , @NamedQuery(name = "FileStorage.findByFsPk", query = "SELECT f FROM FileStorage f WHERE f.fsPk = :fsPk")
    , @NamedQuery(name = "FileStorage.findByFileName", query = "SELECT f FROM FileStorage f WHERE f.fileName = :fileName")})
public class FileStorage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FS_PK")
    private Long fsPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FILE_NAME")
    private String fileName;
    @Lob
    @Column(name = "CONTENT")
    private byte[] content;

    public FileStorage() {
    }
    
    public FileStorage( String fileName, byte[] content )
    {
        this.fileName = fileName;
        this.content = content;
    }

    public FileStorage(Long fsPk) {
        this.fsPk = fsPk;
    }

    public FileStorage(Long fsPk, String fileName) {
        this.fsPk = fsPk;
        this.fileName = fileName;
    }

    public Long getFsPk() {
        return fsPk;
    }

    public void setFsPk(Long fsPk) {
        this.fsPk = fsPk;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fsPk != null ? fsPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileStorage)) {
            return false;
        }
        FileStorage other = (FileStorage) object;
        if ((this.fsPk == null && other.fsPk != null) || (this.fsPk != null && !this.fsPk.equals(other.fsPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.FileStorage[ fsPk=" + fsPk + " ]";
    }
    
}
