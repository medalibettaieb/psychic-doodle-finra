package services;

import javax.ejb.Local;

import entities.PermissionApp;
import services.utilities.IGenericDAO;

@Local
public interface PermissionServiceLocal extends IGenericDAO<PermissionApp> {

}
