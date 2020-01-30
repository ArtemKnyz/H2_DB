package ent;

import java.util.Objects;

public class TRANSLATE {
    private int id;
    private String rus_word;
    private String eng_word;
    private String comment;

    public TRANSLATE() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRus_word() {
        return rus_word;
    }

    public void setRus_word(String rus_word) {
        this.rus_word = rus_word;
    }

    public String getEng_word() {
        return eng_word;
    }

    public void setEng_word(String eng_word) {
        this.eng_word = eng_word;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TRANSLATE translate = (TRANSLATE) o;
        return id == translate.id &&
                Objects.equals(rus_word, translate.rus_word) &&
                Objects.equals(eng_word, translate.eng_word) &&
                Objects.equals(comment, translate.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rus_word, eng_word, comment);
    }

    @Override
    public String toString() {
        return "TRANSLATE{" +
                "id=" + id +
                ", rus_word='" + rus_word + '\'' +
                ", eng_word='" + eng_word + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
