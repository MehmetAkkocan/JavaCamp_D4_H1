package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
    List<Language> getAll();
    Language getById(int id);
    void add(Language language) throws Exception;
    void delete(int id);
    void update(int id, Language language) throws Exception;
    void isNameEmpty(Language language) throws Exception;
    void isNameExist(Language language) throws Exception;
}
