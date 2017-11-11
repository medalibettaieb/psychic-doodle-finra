package services;

import javax.ejb.Remote;

import entities.UserRoleDetail;
import services.utilities.IGenericDAO;

@Remote
public interface DetailsRemote extends IGenericDAO<UserRoleDetail> {

}
