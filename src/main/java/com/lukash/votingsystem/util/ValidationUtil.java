package com.lukash.votingsystem.util;

import com.lukash.votingsystem.exception.AlreadyExistException;
import com.lukash.votingsystem.model.AbstractBaseEntity;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static void checkNew(final AbstractBaseEntity entity) {
        if (!entity.isNew()) {
            throw new AlreadyExistException(entity + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(final AbstractBaseEntity entity, final int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new AlreadyExistException(entity + " must be with id=" + id);
        }
    }
}
