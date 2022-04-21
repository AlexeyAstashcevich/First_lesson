package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@XStreamAlias("groups")
@Entity
@Table(name = "group_list")
public class GroupData {

    @Column(name = "group_name")
    @Expose
    private String name;

    @Column(name = "group_header")
    @Expose
    private String header;


    @Column(name = "group_footer")
    @Expose
    @Type(type = "text")
    private String footer;

    @Column(name = "group_id")
    @XStreamOmitField
    @Id
    private int id;


    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id && Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
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

}
