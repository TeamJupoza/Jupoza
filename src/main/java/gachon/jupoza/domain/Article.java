package gachon.jupoza.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
@Transactional
@AllArgsConstructor
public class Article extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false) private UserAccount userAccount; // 유저 정보 (ID)

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문



//    @ToString.Exclude
//    @OrderBy("createdAt DESC")
//    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
//    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    @JsonManagedReference
    @Setter
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ArticleStock> myStockList = new ArrayList<>();


    protected Article() {}

    private Article(UserAccount userAccount, String title, String content) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
    }

    public static Article of(UserAccount userAccount, String title, String content) {
        return new Article(userAccount, title, content);
    }

    public Article(UserAccount userAccount, String title, String content, List<ArticleStock> myStockList) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.myStockList = myStockList;
    }

    public static Article of(UserAccount userAccount, String title, String content, List<ArticleStock> articleStockList) {
        return new Article(userAccount, title, content, articleStockList);
    }


        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}