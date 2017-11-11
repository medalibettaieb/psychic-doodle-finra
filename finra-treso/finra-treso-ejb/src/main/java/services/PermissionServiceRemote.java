package services;

import javax.ejb.Remote;

import entities.PermissionApp;
import services.utilities.IGenericDAO;

@Remote
public interface PermissionServiceRemote extends IGenericDAO<PermissionApp>{

}
