/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author louay
 * @param <T>
 */
public interface IECOservice<T> {
      public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(int id);
    public T getOne(int id );
   public List<T> getAll() ;
   
   
   
}