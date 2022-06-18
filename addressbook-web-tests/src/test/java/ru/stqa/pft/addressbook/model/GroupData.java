package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XStreamAlias("groups")
@Entity
@Table(name = "group_list")
public class GroupData {

    @Column(name = "group_name")
    @Expose
    private String name;
    @Column(name = "group_header")
    @Expose
    @Type(type = "text")
    private String header;
    @Column(name = "group_footer")
    @Expose
    @Type(type = "text")
    private String footer;
    @Column(name = "group_id")
    @XStreamOmitField
    @Id
    private int id;
    @ManyToMany(mappedBy = "group",fetch = FetchType.EAGER)
    public Set<ContactData> contacts = new HashSet<>();

    public Contacts getContacts() {
        return new Contacts(contacts);
    }

    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public String getFooter() {
        return footer;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public GroupData withContacts(Set<ContactData> contacts) {
        this.contacts = contacts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, header, footer, id);
    }


    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
