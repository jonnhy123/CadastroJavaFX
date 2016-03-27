package ch.makery.address.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe auxiliar para envolver uma lista de pessoas. Esta é usada para salvar a
 * lista de pessoas em XML.
 * 
 * @author Marco Jakob
 */

//@XmlRootElement define o nome do elemento base.
@XmlRootElement(name = "persons")
public class PersonListWrapper {

    private List<Person> persons;

    //@XmlElement é um nome opcional nós podemos especificar para o elemento.
    @XmlElement(name = "person")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}