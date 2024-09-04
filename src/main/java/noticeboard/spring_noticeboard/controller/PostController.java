package noticeboard.spring_noticeboard.controller;

import noticeboard.spring_noticeboard.domain.Comment;
import noticeboard.spring_noticeboard.domain.Post;
import noticeboard.spring_noticeboard.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //앱과 연동하기에 RESTAPI
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post crateTodo(@RequestBody Post post){
        return postService.savePost(post.getTitle(), post.getContent(), post.getAuthor());
    }

    @GetMapping
    public List<Post> getAllTodos(){
        return postService.getPosts();
    }

    @PutMapping("/{postId}/addComment") //아이디도 변경 됨.
    public ResponseEntity<Void> addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        postService.addCommentToPost(postId, comment);
        return ResponseEntity.ok().build(); //반환 값은 없지만 통신 성공
    }

    @DeleteMapping("/{id}/delete")
    public  void deleteTodo(@PathVariable Long id) {
        postService.deletePost(id);
    }


}
