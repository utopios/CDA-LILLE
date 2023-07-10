package com.example.post.utils;

import com.example.post.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoUtils {

    public <T, D> D convertToDto(T entity, D dto, Class<D> dtoClass) {
        return new ModelMapper().map(entity, dtoClass);
    }

    public <D, T> T convertToEntity(D dto, T entity, Class<T> entityClass) {
        return new ModelMapper().map(dto, entityClass);
    }
}
