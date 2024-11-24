package studies.service;

import studies.client.Apod;
import studies.database.implementation.DatabaseImp;
import studies.model.dao.implementation.ApodDaoJDBC;
import studies.model.entity.ApodEntity;

import java.sql.Connection;

public class ApodService {
    Connection connection = DatabaseImp.getConnection();
    Apod apod = new Apod();
    ApodDaoJDBC apodJDBC = new ApodDaoJDBC(connection);

    public ApodEntity callApi(){
        return apod.getData();
    }

    public void create(ApodEntity entity){
        apodJDBC.insert(entity);
    }
}
