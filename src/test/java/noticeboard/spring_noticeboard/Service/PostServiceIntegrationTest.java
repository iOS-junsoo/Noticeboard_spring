package noticeboard.spring_noticeboard.Service;

import noticeboard.spring_noticeboard.domain.Comment;
import noticeboard.spring_noticeboard.domain.Post;
import noticeboard.spring_noticeboard.repository.PostRepository;
import noticeboard.spring_noticeboard.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //통합 테스트를 위한 어노테이션 (해당 어노테이션을 붙이면 실제 DB와 연결한다.)
@Transactional
public class PostServiceIntegrationTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Test
    @Commit
        //실제로 DB에 저장하고 싶을 때 사용
    void savePost_Test() {
        //given - 무엇인가 주어졌고
        Post savedPost = postService.savePost("test", "test", "test");
        //when - 그걸 받아서 실행했을 때

        //then - 어떤 결과가 나와야한다.
        assertEquals("test", savedPost.getTitle());
    }

    @Test
//    @Commit
    void getPost_Test() {
        //given - 무엇인가 주어졌고
        Post post1 = new Post(null, "안녕하세요1", "안녕 나는 김이이야", "김준수");
        Post post2 = new Post(null, "안녕하세요2", "안녕 나는 김이이야", "김준수");
        postRepository.save(post1);
        postRepository.save(post2);

        //when - 그걸 받아서 실행했을 때

        //then - 어떤 결과가 나와야한다.
        System.out.println(postService.getPost(post1.getId()));
        System.out.println(post1);

        assertEquals(postService.getPost(post1.getId()).get(), post1);
    }

    @Test
//    @Commit
    void getAllPosts_Test() {
        //given - 무엇인가 주어졌고
        Post post1 = new Post(null, "안녕하세요1", "안녕 나는 김이이야", "김준수");
        Post post2 = new Post(null, "안녕하세요2", "안녕 나는 김이이야", "김준수");
        postRepository.save(post1);
        postRepository.save(post2);

        //when - 그걸 받아서 실행했을 때

        //then - 어떤 결과가 나와야한다.
        assertThat(postService.getPosts().size()).isEqualTo(2);
    }



    @Test
//    @Commit
    void deletePost_Test() {
        //given - 무엇인가 주어졌고
        Post post1 = new Post(null, "안녕하세요1", "안녕 나는 김이이야", "김준수");
        postRepository.save(post1);

        //when - 그걸 받아서 실행했을 때

        postService.deletePost(post1.getId());

        //then - 어떤 결과가 나와야한다.
        assertThat(postService.getPosts().size()).isEqualTo(0);
    }

    @Test
//    @Commit
    void addComment_Test() {
        //given - 무엇인가 주어졌고
        Post post = new Post(null, "안녕하세요1", "안녕 나는 김이이야", "김준수");
        postRepository.save(post);

        Long postId = post.getId();
        Comment comment = new Comment(null,"test", "test");

        //when - 그걸 받아서 실행했을 때
        post.addComment(comment);

        //then - 어떤 결과가 나와야한다.
        Post updatePost = postRepository.findById(postId).get();
        assertThat(updatePost.getComments().size()).isEqualTo(1);
    }



}
