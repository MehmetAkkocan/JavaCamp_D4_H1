package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    @Override
    public void add(Language language) throws Exception {
        this.isNameEmpty(language);
        this.isNameExist(language);
        languageRepository.add(language);

    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(int id, Language language) throws Exception {
        this.isNameEmpty(language);
        this.isNameExist(language);
        languageRepository.update(id, language);
    }

    @Override
    public void isNameEmpty(Language language) throws Exception {
        if (language.getLangName().isEmpty()) {
            throw new Exception("Programlama dili boş olamaz!");
        }
    }

    @Override
    public void isNameExist(Language language) throws Exception {
        List<Language> languageList = languageRepository.getAll();
        for (Language elementLanguage : languageList) {
            if (language.getLangName().equals(elementLanguage.getLangName())) {
                throw new Exception("Zaten bu isimde bir programlama dili mevcut!");
            }
        }
    }

}
