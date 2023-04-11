package Kodlama.io.Devs.entities.concretes;

public class Language {
    private int id;
    private String langName;

    public Language() {
    }

    public Language(int id, String langName) {
        this.id = id;
        this.langName = langName;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the langName
     */
    public String getLangName() {
        return langName;
    }

    /**
     * @param langName the langName to set
     */
    public void setLangName(String langName) {
        this.langName = langName;
    }

}
