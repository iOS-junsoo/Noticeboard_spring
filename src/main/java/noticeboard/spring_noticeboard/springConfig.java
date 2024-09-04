package noticeboard.spring_noticeboard;


//import noticeboard.spring_noticeboard.repository.CommentRepository;
import noticeboard.spring_noticeboard.repository.PostRepository;
//import noticeboard.spring_noticeboard.service.CommentService;
import noticeboard.spring_noticeboard.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {

    private final PostRepository postRepository;

    public springConfig(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository);
    }




}
