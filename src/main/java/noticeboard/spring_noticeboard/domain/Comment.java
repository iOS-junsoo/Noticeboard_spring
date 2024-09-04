package noticeboard.spring_noticeboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String author;

    public Comment() {}

    public Comment(Long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @ManyToOne
    @JsonIgnore //양방향 관계에서 발생하는 순환 참조 문제인 JSON 직력화중 무한 루프를 방지하는 어노테이션
    @JoinColumn(name = "post_id")
    private Post post;
}
