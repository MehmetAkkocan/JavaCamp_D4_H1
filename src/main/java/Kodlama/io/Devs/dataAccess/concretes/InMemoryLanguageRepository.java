package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    List<Language> languages;

    
    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"Python"));
        languages.add(new Language(2,"Java"));
        languages.add(new Language(3,"C#"));
    }

    @Override
    public void add(Language language) {
        languages.add(language);
        System.out.println(language.getLangName()+" programlama dili eklendi!");
    }

    @Override
    public void delete(int id) {
        for (Language element : languages) {
            if(element.getId() == id)
            {
                languages.remove(element);
                System.out.println(id+" numaralı programlama dili silindi!");
                break;
            }
        }
    }

    @Override
    public void update(int id, Language language) {
        for (Language element : languages) {
            if (element.getId()==id) {
                element.setLangName(language.getLangName());
                System.out.println(element.getLangName()+" ," + language.getLangName() + " olarak değiştirildi!");
            }
        }
    }

    @Override
    public Language getById(int id) {
       for (Language element : languages) {
            if (id == element.getId()) {
                return element;
            }
       }
       return null;
    }

    @Override
    public List<Language> getAll() {
       return languages;
    }
    
}
