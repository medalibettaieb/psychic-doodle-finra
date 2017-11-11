package services;

import javax.ejb.Remote;

import entities.RoleApp;
import services.utilities.IGenericDAO;

@Remote
public interface RoleServiceRemote extends IGenericDAO<RoleApp> {

}
