package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
             joinColumns = @JoinColumn(name = "CATEGORY_ID"),//자신 조인
             inverseJoinColumns = @JoinColumn(name = "ITEM_ID")// 반대쪽 조인
    )//중간테이블
    private List<Item> items = new ArrayList<>();

}
