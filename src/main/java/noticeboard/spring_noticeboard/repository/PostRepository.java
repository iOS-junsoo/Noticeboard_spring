package noticeboard.spring_noticeboard.repository;

import noticeboard.spring_noticeboard.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
