package services;

import javax.ejb.Local;

import entities.RoleApp;
import services.utilities.IGenericDAO;

@Local
public interface RoleServiceLocal extends IGenericDAO<RoleApp>{

}
