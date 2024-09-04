package noticeboard.spring_noticeboard.service;

import noticeboard.spring_noticeboard.domain.Comment;
import noticeboard.spring_noticeboard.domain.Post;
import noticeboard.spring_noticeboard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public Post savePost(String title, String content, String author) {
        Post post = new Post(null, title, content, author);
        return postRepository.save(post);
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    // 댓글 추가하는 메소드
    public void addCommentToPost(Long postId, Comment comment) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post newPost = post.get();
            newPost.addComment(comment);
            postRepository.save(newPost);
        }
    }
}
