package dao;

import models.AdmSedes;
import java.util.List;

public interface AdmSedesDao {
    void create(AdmSedes admSede);
    AdmSedes read(int id);
    List<AdmSedes> readAll();
    void update(AdmSedes admSede);
    void delete(int id);
}
