package rikkei.academy.service.singer;

import rikkei.academy.model.Singer;
import rikkei.academy.service.IGenericService;

import java.util.List;

public interface ISingerService extends IGenericService<Singer> {
    List<Singer> sortByNameAndByAge();
}