package com.example.correctiontodolist.repository.impl;

import com.example.correctiontodolist.entity.Image;
import com.example.correctiontodolist.repository.BaseRepository;
import com.example.correctiontodolist.tool.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepository implements BaseRepository<Image> {

    private Session _session;
    private ServiceHibernate _serviceHibernate;

    public ImageRepository(ServiceHibernate serviceHibernate) {
        _serviceHibernate = serviceHibernate;
        _session = _serviceHibernate.getSession();
    }
    @Override
    public boolean create(Image element) {
        _session.beginTransaction();
        _session.persist(element);
        _session.getTransaction().commit();
        return element.getId() > 0;
    }

    @Override
    public boolean update(Image element) {
        return false;
    }

    @Override
    public boolean delete(Image element) {
        return false;
    }

    @Override
    public Image findById(int id) {
        return null;
    }
}
