/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.DTOs;

import java.util.List;

/**
 *
 * @author JulianGanster
 */
public interface DAO<T> {
    public List<T> getList();
    public T get(Integer idx);
}
