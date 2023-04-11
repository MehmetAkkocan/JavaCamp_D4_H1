package Kodlama.io.Devs.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @GetMapping("/getall")
    public List<Language> getAll(){
        return languageService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public Language getById(@PathVariable("id") int id) {
        return languageService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() Language language) throws Exception{
        languageService.add(language);
    }

    @PutMapping("/update/{id}")
    public void update(int id , Language language) throws Exception{
        languageService.update(id, language);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") int id){
        languageService.delete(id);
    }

}
